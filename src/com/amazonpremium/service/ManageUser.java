package com.amazonpremium.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.amazonpremium.dao.UserDAO;
import com.amazonpremium.model.User;

public class ManageUser implements UserDAO{

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	private static final boolean SUCCESS = true;
	private static final boolean FAIL = false;
	
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		boolean status = FAIL;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("username", username));
			List users = cr.list();
			if(users != null && users.size() != 0){
				User user = (User) users.get(0);
				if(user.getPassword().equals(password))
					status = SUCCESS;
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
		return status;
	}

	@Override
	public boolean registration(User newUser) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		boolean status = FAIL;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("username", newUser.getUsername()));
			List users = cr.list();
			if(users == null || users.size() == 0){
				session.save(newUser);
				status = SUCCESS;
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
		return status;
	}

}
