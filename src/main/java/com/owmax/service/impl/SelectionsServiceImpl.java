package com.owmax.service.impl;

import com.owmax.model.Selections;
import com.owmax.service.SelectionsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("selectionsService")
public class SelectionsServiceImpl extends BaseServiceImpl implements SelectionsService {
    @Override
    public void save(Selections t) {
        // TODO 自动生成的方法存根
        selectionsDAO.save(t);
    }

    @Override
    public void update(Selections t) {
        // TODO 自动生成的方法存根
        selectionsDAO.getSession().update(t);
    }

    @Override
    public void merge(Selections t) {
        // TODO 自动生成的方法存根
        selectionsDAO.merge(t);
    }

    @Override
    public void delete(int id) {
        // TODO 自动生成的方法存根
        selectionsDAO.delete(get(id));
    }

    @Override
    public Selections get(int id) {
        // TODO 自动生成的方法存根
        return selectionsDAO.findById(id);
    }

    @Override
    public List<Selections> queryALL() {
        // TODO 自动生成的方法存根
        return selectionsDAO.findAll();
    }
}
