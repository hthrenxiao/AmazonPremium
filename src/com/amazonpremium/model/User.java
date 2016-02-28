package com.amazonpremium.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class User {
	
	private int id;
	private String username;
	private String password;
	private Date birthday;
	private Date rdate;
	private BigDecimal balance;
	private Set wishingList;
	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param username
	 * @param password
	 * @param birthday
	 * @param rdate
	 * @param balance
	 */
	public User(String username, String password, Date birthday, Date rdate, BigDecimal balance) {
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.rdate = rdate;
		this.balance = balance;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the rdate
	 */
	public Date getRdate() {
		return rdate;
	}

	/**
	 * @param rdate the rdate to set
	 */
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * @return the wishingList
	 */
	public Set getWishingList() {
		return wishingList;
	}

	/**
	 * @param wishingList the wishingList to set
	 */
	public void setWishingList(Set wishingList) {
		this.wishingList = wishingList;
	}
	
	
}
