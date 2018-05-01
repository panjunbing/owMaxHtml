package com.owmax.model;

/**
 * AnswerSelections entity. @author MyEclipse Persistence Tools
 */

public class AnswerSelections implements java.io.Serializable {

	// Fields

	private Integer id;
	private QuestionnaireUser questionnaireUser;
	private Selections selections;
	private String selectionOther;

	// Constructors

	/** default constructor */
	public AnswerSelections() {
	}

	/** full constructor */
	public AnswerSelections(QuestionnaireUser questionnaireUser,
			Selections selections, String selectionOther) {
		this.questionnaireUser = questionnaireUser;
		this.selections = selections;
		this.selectionOther = selectionOther;
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

	public Selections getSelections() {
		return this.selections;
	}

	public void setSelections(Selections selections) {
		this.selections = selections;
	}

	public String getSelectionOther() {
		return this.selectionOther;
	}

	public void setSelectionOther(String selectionOther) {
		this.selectionOther = selectionOther;
	}

}