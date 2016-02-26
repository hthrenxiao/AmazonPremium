package com.amazonpremium.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amazonpremium.dao.ShoppingCartDAO;
import com.amazonpremium.model.Good;
import com.amazonpremium.model.ShoppingCart;
@Service
public class ManageShoppingCart implements ShoppingCartDAO{

	//Next stage factory will automatically inject by using spring framework.
	@Autowired
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void addGood(ShoppingCart cart, int id, int number) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		boolean existed = false;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Good.class);
			cr.add(Restrictions.eq("id", id));
			List goods = cr.list();
			Good target = (Good) goods.get(0);
			cart.setTotalNumberOfGoods(cart.getTotalNumberOfGoods()+number);
			cart.setTotalPrice(cart.getTotalPrice().add(target.getPrice().multiply(new BigDecimal(number))));
			HashMap<Good, Integer> map = cart.getCart();
			Iterator<Good> it = map.keySet().iterator();
			while(it.hasNext()){
				Good cur = it.next();
				if(cur.getId() == target.getId()){
					map.put(cur, map.get(cur) + number);
					existed = true;
				}
			}
			if(!existed)
				map.put(target, number);
			cart.setCart(map);
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
	public void deleteGood(ShoppingCart cart, int id, int number) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Criteria cr = session.createCriteria(Good.class);
			cr.add(Restrictions.eq("id", id));
			List goods = cr.list();
			Good target = (Good) goods.get(0);
			cart.setTotalNumberOfGoods(cart.getTotalNumberOfGoods()-number);
			cart.setTotalPrice(cart.getTotalPrice().subtract(target.getPrice().multiply(new BigDecimal(number))));
			HashMap<Good, Integer> map = cart.getCart();
			Iterator<Good> it = map.keySet().iterator();
			while(it.hasNext()){
				Good cur = it.next();
				if(cur.getId() == target.getId()){
					if(map.get(cur) > number)
						map.put(cur, map.get(cur) - number);
					else
						it.remove();
				}
			}
			cart.setCart(map);
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
	public void dumpCart(ShoppingCart cart) {
		// TODO Auto-generated method stub
		cart.setCart(new HashMap<Good, Integer>());
	}

}
