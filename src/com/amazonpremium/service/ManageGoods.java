package com.amazonpremium.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.amazonpremium.dao.GoodDAO;
import com.amazonpremium.model.Good;
@Service
public class ManageGoods implements GoodDAO{

	@Resource(name="factory")
	private SessionFactory factory ;
	
	@Override
	public ArrayList<Good> listAllGoods() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<Good> result = new ArrayList<Good>();
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Good.class);
			List goods = cr.list();
			for(Object cur : goods){
				result.add((Good) cur);
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

}
