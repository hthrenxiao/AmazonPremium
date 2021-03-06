package com.amazonpremium.model;

import java.util.Set;

/**
 * @author Administrator
 *
 */
public class Category {
	
	private int id;
	private String name;
	private Set goods;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return "Category [cid=" + cid + ", cname=" + cname + ", id=" + id + ", name=" + name + ", goods=" + goods + "]";
//	}

	/**
	 * 
	 */
	public Category() {
	}
	
	/**
	 * @param name
	 */
	public Category(String name) {
		this.name = name;
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
	 * @return the goods
	 */
	public Set getGoods() {
		return goods;
	}

	/**
	 * @param goods the goods to set
	 */
	public void setGoods(Set goods) {
		this.goods = goods;
	}

}
