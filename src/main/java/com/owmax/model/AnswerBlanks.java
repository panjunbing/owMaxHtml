package com.owmax.model;

/**
 * AnswerBlanks entity. @author MyEclipse Persistence Tools
 */

public class AnswerBlanks implements java.io.Serializable {

	// Fields

	private Integer id;
	private QuestionnaireUser questionnaireUser;
	private Blanks blanks;
	private String answerText;

	// Constructors

	/** default constructor */
	public AnswerBlanks() {
	}

	/** full constructor */
	public AnswerBlanks(QuestionnaireUser questionnaireUser, Blanks blanks,
			String answerText) {
		this.questionnaireUser = questionnaireUser;
		this.blanks = blanks;
		this.answerText = answerText;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QuestionnaireUser getQuestionnaireUser() {
		return this.questionnaireUser;
	}

	public void setQuestionnaireUser(QuestionnaireUser questionnaireUser) {
		this.questionnaireUser = questionnaireUser;
	}

	public Blanks getBlanks() {
		return this.blanks;
	}

	public void setBlanks(Blanks blanks) {
		this.blanks = blanks;
	}

	public String getAnswerText() {
		return this.answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

}