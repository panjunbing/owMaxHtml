package com.owmax.service.impl;

import com.owmax.model.Questions;
import com.owmax.service.QuestionsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("questionsService")
public class QuestionsServiceImpl extends BaseServiceImpl implements QuestionsService {
    @Override
    public void save(Questions t) {
        // TODO 自动生成的方法存根
        questionsDAO.save(t);
    }

    @Override
    public void update(Questions t) {
        // TODO 自动生成的方法存根
        questionsDAO.getSession().update(t);
    }

    @Override
    public void merge(Questions t) {
        // TODO 自动生成的方法存根
        questionsDAO.merge(t);
    }

    @Override
    public void delete(int id) {
        // TODO 自动生成的方法存根
        questionsDAO.delete(get(id));
    }

    @Override
    public Questions get(int id) {
        // TODO 自动生成的方法存根
        return questionsDAO.findById(id);
    }

    @Override
    public List<Questions> queryALL() {
        // TODO 自动生成的方法存根
        return questionsDAO.findAll();
    }
}
