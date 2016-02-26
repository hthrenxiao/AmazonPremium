package com.amazonpremium.dao;

import java.math.BigDecimal;

public class Good {
	private int id;
	private String name;
	private String desc;
	private int stock;
	private BigDecimal price;
	
	/**
	 * 
	 */
	public Good() {
	}

	/**
	 * @param id
	 * @param name
	 * @param desc
	 * @param stock
	 * @param price
	 */
	public Good(int id, String name, String desc, int stock, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.stock = stock;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
