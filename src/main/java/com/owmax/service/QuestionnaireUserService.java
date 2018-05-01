package com.owmax.service;

import com.owmax.model.QuestionnaireUser;

public interface QuestionnaireUserService extends BaseService<QuestionnaireUser>{

    QuestionnaireUser queryQuestionnaireUserByUserName(String userName);
}
