package com.amazonpremium.dao;

import java.util.ArrayList;

import com.amazonpremium.model.Good;

public interface WishingListDAO {
	
	public ArrayList<Good> getWishingList(String username);
	public void addGood(String username, int id);
	public void deleteGood(String username, int id);
	public void dumpList(String username);
	
}
