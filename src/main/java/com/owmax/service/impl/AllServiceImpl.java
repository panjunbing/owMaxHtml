package com.owmax.service.impl;

import com.owmax.model.All;
import com.owmax.service.AllService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("allService")
public class AllServiceImpl extends BaseServiceImpl implements AllService {


	@Override
	public void save(All t) {
		// TODO 自动生成的方法存根
		allDAO.save(t);
	}

	@Override
	public void update(All t) {
		// TODO 自动生成的方法存根
		allDAO.getSession().update(t);
	}

	@Override
	public void merge(All t) {
		// TODO 自动生成的方法存根
		allDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		allDAO.delete(get(id));
	}

	@Override
	public All get(int id) {
		// TODO 自动生成的方法存根
		return allDAO.findById(id);
	}

	@Override
	public List<All> queryALL() {
		// TODO 自动生成的方法存根
		return allDAO.findAll();
	}
}
