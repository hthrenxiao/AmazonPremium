package com.amazonpremium.dao;

import com.amazonpremium.model.ShoppingCart;

public interface ShoppingCartDAO {
	
	public void addGood(ShoppingCart cart, int id, int number);
	
	public void deleteGood(ShoppingCart cart, int id, int number);
	
	public void dumpCart(ShoppingCart cart);
	
}
