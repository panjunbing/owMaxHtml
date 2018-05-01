package com.owmax.service.impl;

import com.owmax.model.AnswerBlanks;
import com.owmax.service.AnswerBlanksService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("answerBlanksService")
public class AnswerBlanksServiceImpl extends BaseServiceImpl implements AnswerBlanksService {
    @Override
    public void save(AnswerBlanks t) {
        // TODO 自动生成的方法存根
        answerBlanksDAO.save(t);
    }

    @Override
    public void update(AnswerBlanks t) {
        // TODO 自动生成的方法存根
        questionnaireUserDAO.getSession().update(t);
    }

    @Override
    public void merge(AnswerBlanks t) {
        // TODO 自动生成的方法存根
        answerBlanksDAO.merge(t);
    }

    @Override
    public void delete(int id) {
        // TODO 自动生成的方法存根
        answerBlanksDAO.delete(get(id));
    }

    @Override
    public AnswerBlanks get(int id) {
        // TODO 自动生成的方法存根
        return answerBlanksDAO.findById(id);
    }

    @Override
    public List<AnswerBlanks> queryALL() {
        // TODO 自动生成的方法存根
        return answerBlanksDAO.findAll();
    }
}
