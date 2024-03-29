package com.owmax.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Selections entity. @author MyEclipse Persistence Tools
 */

public class Selections implements java.io.Serializable {

	// Fields

	private Short id;
	private Questions questions;
	private String selection;
	private String selectionText;
	private Set jumps = new HashSet(0);
	private Set answerSelectionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Selections() {
	}

	/** minimal constructor */
	public Selections(Questions questions, String selection) {
		this.questions = questions;
		this.selection = selection;
	}

	/** full constructor */
	public Selections(Questions questions, String selection,
			String selectionText, Set jumps, Set answerSelectionses) {
		this.questions = questions;
		this.selection = selection;
		this.selectionText = selectionText;
		this.jumps = jumps;
		this.answerSelectionses = answerSelectionses;
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

	public String getSelection() {
		return this.selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public String getSelectionText() {
		return this.selectionText;
	}

	public void setSelectionText(String selectionText) {
		this.selectionText = selectionText;
	}

	public Set getJumps() {
		return this.jumps;
	}

	public void setJumps(Set jumps) {
		this.jumps = jumps;
	}

	public Set getAnswerSelectionses() {
		return this.answerSelectionses;
	}

	public void setAnswerSelectionses(Set answerSelectionses) {
		this.answerSelectionses = answerSelectionses;
	}

}