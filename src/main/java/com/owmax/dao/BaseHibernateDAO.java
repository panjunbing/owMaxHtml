package com.owmax.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
@Repository("baseHibernateDAO")
public class BaseHibernateDAO implements IBaseHibernateDAO {

	@Resource
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}