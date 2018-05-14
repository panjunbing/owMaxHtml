package com.owmax.model;

/**
 * Jump entity. @author MyEclipse Persistence Tools
 */

public class Jump implements java.io.Serializable {

	// Fields

	private Short id;
	private Questions questions;
	private Selections selections;

	// Constructors

	/** default constructor */
	public Jump() {
	}

	/** full constructor */
	public Jump(Questions questions, Selections selections) {
		this.questions = questions;
		this.selections = selections;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Questions getQuestions() {
		return this.questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public Selections getSelections() {
		return this.selections;
	}

	public void setSelections(Selections selections) {
		this.selections = selections;
	}

}