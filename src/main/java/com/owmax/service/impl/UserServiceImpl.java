package com.owmax.service.impl;

import com.owmax.model.Data;
import com.owmax.model.User;
import com.owmax.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED)
@Service("userService")
@SuppressWarnings("unchecked")
public class UserServiceImpl extends BaseServiceImpl implements UserService {


	@Override
	public void save(User t) {
		// TODO 自动生成的方法存根
		userDAO.save(t);
	}

	@Override
	public void update(User t) {
		// TODO 自动生成的方法存根
		userDAO.getSession().update(t);
	}

	@Override
	public void merge(User t) {
		// TODO 自动生成的方法存根
		userDAO.merge(t);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		userDAO.delete(get(id));
	}

	@Override
	public User get(int id) {
		// TODO 自动生成的方法存根
		return userDAO.findById(id);
	}

	@Override
	public List<User> queryALL() {
		// TODO 自动生成的方法存根
		return userDAO.findAll();
	}

	/**
	 * 插入用户，如果已存在则先把data数据删除
	 * @param newUser  用户
	 * @return
	 */
	@Override
	public User scrapyUser(User newUser) {
		List<User> userList = userDAO.findByProperty("userName",newUser.getUserName());
		if (userList.size() > 0) {
			User user = userList.get(0);
			user.setState(0);
			userDAO.getSession().update(user);
			//将之前的数据删除（之后将爬取新的数据）
			List<Data> data = dataDAO.findByProperty("user",user);
			for (int i = 0;i<data.size();i++)
				dataDAO.delete(data.get(i));
			return user;
		}
		else {
			userDAO.save(newUser);
			return newUser;
		}
	}

	@Override
	public void setState1(String userName) {
		User user = (User) userDAO.findByProperty("userName",userName).get(0);
		user.setState(1);
		userDAO.getSession().update(user);
	}
}
