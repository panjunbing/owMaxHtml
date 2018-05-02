package com.owmax.service.impl;

import com.owmax.model.Jump;
import com.owmax.service.JumpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("jumpService")
public class JumpServiceImpl extends BaseServiceImpl implements JumpService {
    @Override
    public void save(Jump t) {
        // TODO 自动生成的方法存根
        jumpDAO.save(t);
    }

    @Override
    public void update(Jump t) {
        // TODO 自动生成的方法存根
        jumpDAO.getSession().update(t);
    }

    @Override
    public void merge(Jump t) {
        // TODO 自动生成的方法存根
        jumpDAO.merge(t);
    }

    @Override
    public void delete(int id) {
        // TODO 自动生成的方法存根
        jumpDAO.delete(get(id));
    }

    @Override
    public Jump get(int id) {
        // TODO 自动生成的方法存根
        return jumpDAO.findById(id);
    }

    @Override
    public List<Jump> queryALL() {
        // TODO 自动生成的方法存根
        return jumpDAO.findAll();
    }
}
