package com.amazonpremium.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;

public class ShoppingCart {
	private HashMap<Good, Integer> map;
	private int totalNumber;
	private BigDecimal totalPrice;
	
	public ShoppingCart(){
		map = new HashMap<Good, Integer>();
		this.totalNumber = 0;
		this.totalPrice = new BigDecimal(0).setScale(2, BigDecimal.ROUND_DOWN);
	}
	
	public HashMap<Good, Integer> getCart(){
		return map;
	}
	
	public void setCart(HashMap<Good, Integer> map){
		this.map = map;
	}
	
	public int getTotalNumberOfGoods(){
		return totalNumber;
	}
	
	public void setTotalNumberOfGoods(int totalNumber){
		this.totalNumber = totalNumber;
	}
	
	public BigDecimal getTotalPrice(){
		return totalPrice;
	}
	
	public void setTotalPrice(BigDecimal totalPrice){
		this.totalPrice = totalPrice;
	}
}
