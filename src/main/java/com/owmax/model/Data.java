package com.owmax.model;

/**
 * Data entity. @author MyEclipse Persistence Tools
 */

public class Data implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String hero;
	private String gameTime;
	private String gameWinning;
	private String averageHitRate;
	private String averageCritRate;
	private String averageTime;
	private String averageDamage;
	private String averageKill;
	private String averageSingleKill;
	private String averageDefenseKill;
	private String averageLastKill;
	private String averageDead;
	private String averageTreatment;
	private String averageDamageDefense;
	private String bestHitRate;
	private String bestTime;
	private String bestDamage;
	private String bestKill;
	private String bestTreatment;

	// Constructors

	/** default constructor */
	public Data() {
	}

	/** minimal constructor */
	public Data(Integer id, User user, String hero) {
		this.id = id;
		this.user = user;
		this.hero = hero;
	}

	/** full constructor */
	public Data(Integer id, User user, String hero, String gameTime,
			String gameWinning, String averageHitRate, String averageCritRate,
			String averageTime, String averageDamage, String averageKill,
			String averageSingleKill, String averageDefenseKill,
			String averageLastKill, String averageDead,
			String averageTreatment, String averageDamageDefense,
			String bestHitRate, String bestTime, String bestDamage,
			String bestKill, String bestTreatment) {
		this.id = id;
		this.user = user;
		this.hero = hero;
		this.gameTime = gameTime;
		this.gameWinning = gameWinning;
		this.averageHitRate = averageHitRate;
		this.averageCritRate = averageCritRate;
		this.averageTime = averageTime;
		this.averageDamage = averageDamage;
		this.averageKill = averageKill;
		this.averageSingleKill = averageSingleKill;
		this.averageDefenseKill = averageDefenseKill;
		this.averageLastKill = averageLastKill;
		this.averageDead = averageDead;
		this.averageTreatment = averageTreatment;
		this.averageDamageDefense = averageDamageDefense;
		this.bestHitRate = bestHitRate;
		this.bestTime = bestTime;
		this.bestDamage = bestDamage;
		this.bestKill = bestKill;
		this.bestTreatment = bestTreatment;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHero() {
		return this.hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getGameTime() {
		return this.gameTime;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	public String getGameWinning() {
		return this.gameWinning;
	}

	public void setGameWinning(String gameWinning) {
		this.gameWinning = gameWinning;
	}

	public String getAverageHitRate() {
		return this.averageHitRate;
	}

	public void setAverageHitRate(String averageHitRate) {
		this.averageHitRate = averageHitRate;
	}

	public String getAverageCritRate() {
		return this.averageCritRate;
	}

	public void setAverageCritRate(String averageCritRate) {
		this.averageCritRate = averageCritRate;
	}

	public String getAverageTime() {
		return this.averageTime;
	}

	public void setAverageTime(String averageTime) {
		this.averageTime = averageTime;
	}

	public String getAverageDamage() {
		return this.averageDamage;
	}

	public void setAverageDamage(String averageDamage) {
		this.averageDamage = averageDamage;
	}

	public String getAverageKill() {
		return this.averageKill;
	}

	public void setAverageKill(String averageKill) {
		this.averageKill = averageKill;
	}

	public String getAverageSingleKill() {
		return this.averageSingleKill;
	}

	public void setAverageSingleKill(String averageSingleKill) {
		this.averageSingleKill = averageSingleKill;
	}

	public String getAverageDefenseKill() {
		return this.averageDefenseKill;
	}

	public void setAverageDefenseKill(String averageDefenseKill) {
		this.averageDefenseKill = averageDefenseKill;
	}

	public String getAverageLastKill() {
		return this.averageLastKill;
	}

	public void setAverageLastKill(String averageLastKill) {
		this.averageLastKill = averageLastKill;
	}

	public String getAverageDead() {
		return this.averageDead;
	}

	public void setAverageDead(String averageDead) {
		this.averageDead = averageDead;
	}

	public String getAverageTreatment() {
		return this.averageTreatment;
	}

	public void setAverageTreatment(String averageTreatment) {
		this.averageTreatment = averageTreatment;
	}

	public String getAverageDamageDefense() {
		return this.averageDamageDefense;
	}

	public void setAverageDamageDefense(String averageDamageDefense) {
		this.averageDamageDefense = averageDamageDefense;
	}

	public String getBestHitRate() {
		return this.bestHitRate;
	}

	public void setBestHitRate(String bestHitRate) {
		this.bestHitRate = bestHitRate;
	}

	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	public String getBestDamage() {
		return this.bestDamage;
	}

	public void setBestDamage(String bestDamage) {
		this.bestDamage = bestDamage;
	}

	public String getBestKill() {
		return this.bestKill;
	}

	public void setBestKill(String bestKill) {
		this.bestKill = bestKill;
	}

	public String getBestTreatment() {
		return this.bestTreatment;
	}

	public void setBestTreatment(String bestTreatment) {
		this.bestTreatment = bestTreatment;
	}

}