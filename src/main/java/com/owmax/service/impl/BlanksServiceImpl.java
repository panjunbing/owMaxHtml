package com.owmax.service.impl;

import com.owmax.model.Blanks;
import com.owmax.service.BlanksService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("blanksService")
public class BlanksServiceImpl extends BaseServiceImpl implements BlanksService {
    @Override
    public void save(Blanks t) {
        // TODO 自动生成的方法存根
        blanksDAO.save(t);
    }

    @Override
    public void update(Blanks t) {
        // TODO 自动生成的方法存根
        blanksDAO.getSession().update(t);
    }

    @Override
    public void merge(Blanks t) {
        // TODO 自动生成的方法存根
        blanksDAO.merge(t);
    }

    @Override
    public void delete(int id) {
        // TODO 自动生成的方法存根
        blanksDAO.delete(get(id));
    }

    @Override
    public Blanks get(int id) {
        // TODO 自动生成的方法存根
        return blanksDAO.findById((short) id);
    }

    @Override
    public List<Blanks> queryALL() {
        // TODO 自动生成的方法存根
        return blanksDAO.findAll();
    }
}
