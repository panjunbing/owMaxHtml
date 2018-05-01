package com.owmax.dao;

import java.util.List;

import com.owmax.model.AnswerBlanks;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * AnswerBlanks entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.owmax.model.AnswerBlanks
 * @author MyEclipse Persistence Tools
 */
@Repository
public class AnswerBlanksDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AnswerBlanksDAO.class);
	// property constants
	public static final String ANSWER_TEXT = "answerText";

	public void save(AnswerBlanks transientInstance) {
		log.debug("saving AnswerBlanks instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AnswerBlanks persistentInstance) {
		log.debug("deleting AnswerBlanks instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnswerBlanks findById(Integer id) {
		log.debug("getting AnswerBlanks instance with id: " + id);
		try {
			AnswerBlanks instance = (AnswerBlanks) getSession().get(
					"com.owmax.model.AnswerBlanks", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AnswerBlanks instance) {
		log.debug("finding AnswerBlanks instance by example");
		try {
			List results = getSession()
					.createCriteria("com.owmax.model.AnswerBlanks")
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
		log.debug("finding AnswerBlanks instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AnswerBlanks as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAnswerText(Object answerText) {
		return findByProperty(ANSWER_TEXT, answerText);
	}

	public List findAll() {
		log.debug("finding all AnswerBlanks instances");
		try {
			String queryString = "from AnswerBlanks";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AnswerBlanks merge(AnswerBlanks detachedInstance) {
		log.debug("merging AnswerBlanks instance");
		try {
			AnswerBlanks result = (AnswerBlanks) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AnswerBlanks instance) {
		log.debug("attaching dirty AnswerBlanks instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnswerBlanks instance) {
		log.debug("attaching clean AnswerBlanks instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}