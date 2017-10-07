package com.owmax.model;

/**
 * All entity. @author MyEclipse Persistence Tools
 */

public class All implements java.io.Serializable {

	// Fields

	private Integer id;
	private String hero;
	private String appearance;
	private String winRate;
	private String kd;

	// Constructors

	/** default constructor */
	public All() {
	}

	/** minimal constructor */
	public All(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public All(Integer id, String hero, String appearance, String winRate,
			String kd) {
		this.id = id;
		this.hero = hero;
		this.appearance = appearance;
		this.winRate = winRate;
		this.kd = kd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHero() {
		return this.hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getAppearance() {
		return this.appearance;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	public String getWinRate() {
		return this.winRate;
	}

	public void setWinRate(String winRate) {
		this.winRate = winRate;
	}

	public String getKd() {
		return this.kd;
	}

	public void setKd(String kd) {
		this.kd = kd;
	}

}