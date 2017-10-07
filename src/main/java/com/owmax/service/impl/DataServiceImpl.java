package com.owmax.service.impl;

import com.owmax.model.Data;
import com.owmax.model.User;
import com.owmax.service.DataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional(propagation=Propagation.REQUIRED)
@Service("dataService")
@SuppressWarnings("unchecked")
public class DataServiceImpl extends BaseServiceImpl implements DataService {


	@Override
	public void save(Data t) {
		// TODO 自动生成的方法存根
		dataDAO.save(t);
	}

	@Override
	public void update(Data t) {
		// TODO 自动生成的方法存根
		dataDAO.getSession().update(t);
	}

	@Override
	public void merge(Data t) {
		// TODO 自动生成的方法存根
		dataDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		dataDAO.delete(get(id));
	}

	@Override
	public Data get(int id) {
		// TODO 自动生成的方法存根
		return dataDAO.findById(id);
	}

	@Override
	public List<Data> queryALL() {
		// TODO 自动生成的方法存根
		return dataDAO.findAll();
	}

	@Override
	public List<Data> queryDataByUserID(int userID) {
		User user = userDAO.findById(userID);
		return dataDAO.findByProperty("user",user);
	}

	@Override
	public Data queryHeroDataByUserID(int userID,String hero) {
		User user = userDAO.findById(userID);
		Data heroData = new Data();
		List<Data> list =  dataDAO.findByProperty("user",user);
		for (int i = 0;i<list.size();i++){
			Data data = list.get(i);
			if(Objects.equals(data.getHero(), hero))
				return data;
		}
		return null;
	}
}
