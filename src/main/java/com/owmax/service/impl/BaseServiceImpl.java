package com.owmax.service.impl;

import com.owmax.dao.AllDAO;
import com.owmax.dao.DataDAO;
import com.owmax.dao.UserDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("baseService")
public class BaseServiceImpl {


	@Resource
	protected UserDAO userDAO;

	@Resource
	protected DataDAO dataDAO;

	@Resource
	protected AllDAO allDAO;


}
