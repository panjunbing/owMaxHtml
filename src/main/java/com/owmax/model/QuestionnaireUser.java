package com.owmax.model;

import java.util.HashSet;
import java.util.Set;

/**
 * QuestionnaireUser entity. @author MyEclipse Persistence Tools
 */

public class QuestionnaireUser implements java.io.Serializable {

	// Fields

	private Short id;
	private String username;
	private String password;
	private Boolean isAnswer;
	private Set answerBlankses = new HashSet(0);
	private Set answerSelectionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public QuestionnaireUser() {
	}

	/** minimal constructor */
	public QuestionnaireUser(String username, String password, Boolean isAnswer) {
		this.username = username;
		this.password = password;
		this.isAnswer = isAnswer;
	}

	/** full constructor */
	public QuestionnaireUser(String username, String password,
			Boolean isAnswer, Set answerBlankses, Set answerSelectionses) {
		this.username = username;
		this.password = password;
		this.isAnswer = isAnswer;
		this.answerBlankses = answerBlankses;
		this.answerSelectionses = answerSelectionses;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAnswer() {
		return this.isAnswer;
	}

	public void setIsAnswer(Boolean isAnswer) {
		this.isAnswer = isAnswer;
	}

	public Set getAnswerBlankses() {
		return this.answerBlankses;
	}

	public void setAnswerBlankses(Set answerBlankses) {
		this.answerBlankses = answerBlankses;
	}

	public Set getAnswerSelectionses() {
		return this.answerSelectionses;
	}

	public void setAnswerSelectionses(Set answerSelectionses) {
		this.answerSelectionses = answerSelectionses;
	}

}