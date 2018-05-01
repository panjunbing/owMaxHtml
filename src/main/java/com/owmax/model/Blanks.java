package com.owmax.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Blanks entity. @author MyEclipse Persistence Tools
 */

public class Blanks implements java.io.Serializable {

	// Fields

	private Integer id;
	private Questions questions;
	private String blankText;
	private Set answerBlankses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Blanks() {
	}

	/** minimal constructor */
	public Blanks(Questions questions) {
		this.questions = questions;
	}

	/** full constructor */
	public Blanks(Questions questions, String blankText, Set answerBlankses) {
		this.questions = questions;
		this.blankText = blankText;
		this.answerBlankses = answerBlankses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Questions getQuestions() {
		return this.questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public String getBlankText() {
		return this.blankText;
	}

	public void setBlankText(String blankText) {
		this.blankText = blankText;
	}

	public Set getAnswerBlankses() {
		return this.answerBlankses;
	}

	public void setAnswerBlankses(Set answerBlankses) {
		this.answerBlankses = answerBlankses;
	}

}