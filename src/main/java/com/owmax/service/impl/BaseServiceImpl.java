package com.owmax.service.impl;

import com.owmax.dao.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("baseService")
public class BaseServiceImpl {


	@Resource
	protected UserDAO userDAO;

	@Resource
	protected DataDAO dataDAO;

	@Resource
	protected AllDAO allDAO;

	@Resource
	protected QuestionnaireUserDAO questionnaireUserDAO;

	@Resource
	protected SelectionsDAO selectionsDAO;

	@Resource
	protected BlanksDAO blanksDAO;

	@Resource
	protected AnswerBlanksDAO answerBlanksDAO;

	@Resource
	protected AnswerSelectionsDAO answerSelectionsDAO;

	@Resource
	protected QuestionsDAO questionsDAO;

	@Resource
	protected JumpDAO jumpDAO;

}
