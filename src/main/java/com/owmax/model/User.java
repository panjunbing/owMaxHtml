package com.owmax.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private Integer state;
	private Set datas = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id, String userName, Integer state) {
		this.id = id;
		this.userName = userName;
		this.state = state;
	}

	/** full constructor */
	public User(Integer id, String userName, Integer state, Set datas) {
		this.id = id;
		this.userName = userName;
		this.state = state;
		this.datas = datas;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set getDatas() {
		return this.datas;
	}

	public void setDatas(Set datas) {
		this.datas = datas;
	}

}