package com.owmax.service.impl;

import com.owmax.model.AnswerSelections;
import com.owmax.service.AnswerSelectionsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("answerSelectionsService")
public class AnswerSelectionsServiceImpl extends BaseServiceImpl implements AnswerSelectionsService {
    @Override
    public void save(AnswerSelections t) {
        // TODO 自动生成的方法存根
        answerSelectionsDAO.save(t);
    }

    @Override
    public void update(AnswerSelections t) {
        // TODO 自动生成的方法存根
        answerSelectionsDAO.getSession().update(t);
    }

    @Override
    public void merge(AnswerSelections t) {
        // TODO 自动生成的方法存根
        answerSelectionsDAO.merge(t);
    }

    @Override
    public void delete(int id) {
        // TODO 自动生成的方法存根
        answerSelectionsDAO.delete(get(id));
    }

    @Override
    public AnswerSelections get(int id) {
        // TODO 自动生成的方法存根
        return answerSelectionsDAO.findById(id);
    }

    @Override
    public List<AnswerSelections> queryALL() {
        // TODO 自动生成的方法存根
        return answerSelectionsDAO.findAll();
    }
}
