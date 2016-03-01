package com.amazonpremium.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonpremium.dao.WishingListDAO;
import com.amazonpremium.model.Good;
import com.amazonpremium.model.User;

@Service
public class ManageWishingList implements WishingListDAO{

	@Resource(name="factory")
	private SessionFactory factory ;
	
	@Override
	public ArrayList<Good> getWishingList(String username) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<Good> result = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("username", username));
			List users = cr.list();
			User curUser = (User) users.get(0);
			Set wishingList = curUser.getWishinglist();
			if(wishingList != null && wishingList.size() != 0){
				result = new ArrayList<Good>();
				Iterator it = wishingList.iterator();
				while(it.hasNext()){
					Good curGood = (Good) it.next();
					result.add(curGood);
				}
			}
			tx.commit();
		} catch (HibernateException he) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void addGood(String username, int id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("username", username));
			List users = cr.list();
			User tmp = (User) users.get(0);
			int uid = tmp.getId();
			User curUser = session.get(User.class, uid);
			Good target = session.get(Good.class, id);
			curUser.getWishinglist().add(target);
			session.update(curUser);
			tx.commit();
		} catch (HibernateException he) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteGood(String username, int id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("username", username));
			List users = cr.list();
			User tmp = (User) users.get(0);
			int uid = tmp.getId();
			User curUser = session.get(User.class, uid);
			Iterator it = curUser.getWishinglist().iterator();
			while(it.hasNext()){
				Good cur = (Good) it.next();
				if(cur.getId() == id){
					it.remove();
					break;
				}
			}
			session.update(curUser);
			tx.commit();
		} catch (HibernateException he) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void dumpList(String username) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("username", username));
			List users = cr.list();
			User tmp = (User) users.get(0);
			int uid = tmp.getId();
			User curUser = session.get(User.class, uid);
			curUser.setWishinglist(new HashSet());
			session.update(curUser);
			tx.commit();
		} catch (HibernateException he) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}
