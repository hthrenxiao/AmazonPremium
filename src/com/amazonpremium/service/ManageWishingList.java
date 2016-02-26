package com.amazonpremium.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amazonpremium.dao.WishingListDAO;
import com.amazonpremium.model.Good;

public class ManageWishingList implements WishingListDAO{

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public ArrayList<Good> getWishingList(String username) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<Good> wishingList = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Good.class, "good");
//			cr.createAlias(arg0, arg1, FetchMode.JOIN);
			//join table users with good and wishing list and set restriction eq(username), and set projection(gid, gname, gdesc, gstocks, cid, gprice)
			//Convert to List of Goods and do adding operation. (existence needs to be checked.)
			tx.commit();
		} catch (HibernateException he) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
		return wishingList;
	}

	@Override
	public void addGood(String username, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGood(String username, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dumpList(String username) {
		// TODO Auto-generated method stub
		
	}
	
}
