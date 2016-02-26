package com.amazonpremium.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.amazonpremium.model.Good;

public interface CategoryDAO {
	
	public HashMap<Integer, String> listCategories();
	public ArrayList<Good> listGoodsOfCategory(int id);
	
}
