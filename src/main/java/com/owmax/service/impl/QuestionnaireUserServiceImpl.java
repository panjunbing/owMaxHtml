package com.owmax.service.impl;

import com.owmax.model.QuestionnaireUser;
import com.owmax.service.QuestionnaireUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(propagation=Propagation.REQUIRED)
@Service("questionnaireUserService")
public class QuestionnaireUserServiceImpl extends BaseServiceImpl implements QuestionnaireUserService {


	@Override
	public void save(QuestionnaireUser t) {
		// TODO 自动生成的方法存根
		questionnaireUserDAO.save(t);
	}

	@Override
	public void update(QuestionnaireUser t) {
		// TODO 自动生成的方法存根
		questionnaireUserDAO.getSession().update(t);
	}

	@Override
	public void merge(QuestionnaireUser t) {
		// TODO 自动生成的方法存根
		questionnaireUserDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		questionnaireUserDAO.delete(get(id));
	}

	@Override
	public QuestionnaireUser get(int id) {
		// TODO 自动生成的方法存根
		return questionnaireUserDAO.findById((short) id);
	}

	@Override
	public List<QuestionnaireUser> queryALL() {
		// TODO 自动生成的方法存根
		return questionnaireUserDAO.findAll();
	}

	/**
	 *	通过用户查询用户，如果不存在则返回空
	 * @param username  用户名
	 * @return questionnaireUser
	 */
    @Override
    public QuestionnaireUser queryQuestionnaireUserByUserName(String username) {
		List userList = questionnaireUserDAO.findByUsername(username);
		if (userList.size() == 0){
			return null;
		}
		else {
			return (QuestionnaireUser) userList.get(0);
		}
    }
}
