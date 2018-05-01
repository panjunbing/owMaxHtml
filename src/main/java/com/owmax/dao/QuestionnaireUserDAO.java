package com.owmax.dao;

import java.util.List;

import com.owmax.model.QuestionnaireUser;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * A data access object (DAO) providing persistence and search support for
 * QuestionnaireUser entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see QuestionnaireUser
 * @author MyEclipse Persistence Tools
 */
@Repository
public class QuestionnaireUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(QuestionnaireUserDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String IS_ANSWER = "isAnswer";

	public void save(QuestionnaireUser transientInstance) {
		log.debug("saving QuestionnaireUser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(QuestionnaireUser persistentInstance) {
		log.debug("deleting QuestionnaireUser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QuestionnaireUser findById(Integer id) {
		log.debug("getting QuestionnaireUser instance with id: " + id);
		try {
			QuestionnaireUser instance = (QuestionnaireUser) getSession().get(
					"com.owmax.model.QuestionnaireUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(QuestionnaireUser instance) {
		log.debug("finding QuestionnaireUser instance by example");
		try {
			List results = getSession()
					.createCriteria("com.owmax.model.QuestionnaireUser")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding QuestionnaireUser instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from QuestionnaireUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByIsAnswer(Object isAnswer) {
		return findByProperty(IS_ANSWER, isAnswer);
	}

	public List findAll() {
		log.debug("finding all QuestionnaireUser instances");
		try {
			String queryString = "from QuestionnaireUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public QuestionnaireUser merge(QuestionnaireUser detachedInstance) {
		log.debug("merging QuestionnaireUser instance");
		try {
			QuestionnaireUser result = (QuestionnaireUser) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(QuestionnaireUser instance) {
		log.debug("attaching dirty QuestionnaireUser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QuestionnaireUser instance) {
		log.debug("attaching clean QuestionnaireUser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}