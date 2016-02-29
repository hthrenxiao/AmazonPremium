package com.amazonpremium.model;

import java.util.Set;

/**
 * @author Administrator
 *
 */
public class Category {
	
	private int cid;
	private String cname;
	private int id;
	private String name;
	
	
	private Set<Good> goods;


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", id=" + id + ", name=" + name + ", goods=" + goods + "]";
	}


	public Category(int cid, String cname, int id, String name, Set<Good> goods) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.id = id;
		this.name = name;
		this.goods = goods;
	}


	public Category() {
		super();
	}


	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}


	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}


	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}


	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
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
	public Set<Good> getGoods() {
		return goods;
	}


	/**
	 * @param goods the goods to set
	 */
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}

	
	
}
