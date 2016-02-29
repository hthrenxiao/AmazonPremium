package com.amazonpremium.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.amazonpremium.model.Good;

@Controller
@Transactional
public class CategoryDaoImpl implements CategoryDAO {
	
    @Resource(name="factory")
	private SessionFactory factory; 


	@Override
	public HashMap<Integer, String> listCategories() {
		Session se = factory.openSession();
		String hql = "From com.amazonpremium.model.Category";
		Query query = se.createQuery(hql);
		List list = query.list();
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	public List listC(){	
		Session se = factory.openSession();
		System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		Transaction t= se.beginTransaction();
		String hql = "From com.amazonpremium.model.Category";
		Query query = se.createQuery(hql);
		List list = query.list();
		t.commit();
		se.close();
		return list; 
	}
	
	
	@Override
	public ArrayList<Good> listGoodsOfCategory(int id) {
		// TODO Auto-generated method stub
		Session se = factory.openSession();
		String hql = "From com.amazonpremium.model.Category C Where C.id=:id";
		Query query = se.createQuery(hql);
		query.setInteger(0, id);
		List list = query.list();
		
		return null;
	}

}
