package com.amazonpremium.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amazonpremium.dao.CategoryDAO;
import com.amazonpremium.model.Category;
import com.amazonpremium.model.Good;


public class ManageCategory implements CategoryDAO{

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public HashMap<Integer, String> listCategories() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Category.class);
			List categories = cr.list();
			for(Object cur : categories){
				Category curCategory = (Category) cur;
				map.put(curCategory.getId(), curCategory.getName());
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
		return map;
	}

	@Override
	public ArrayList<Good> listGoodsOfCategory(int id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<Good> list = new ArrayList<Good>();
		try {
			tx = session.beginTransaction();
			Category target = session.get(Category.class, id);
			Set goods = target.getGoods();
			Iterator it = goods.iterator();
			while(it.hasNext()){
				Good cur = (Good) it.next();
				list.add(cur);
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
		return list;
	}

}
