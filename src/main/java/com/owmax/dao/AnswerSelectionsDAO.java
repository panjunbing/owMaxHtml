package com.owmax.dao;

import com.owmax.model.AnswerSelections;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * AnswerSelections entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.owmax.model.AnswerSelections
 * @author MyEclipse Persistence Tools
 */
@Repository
public class AnswerSelectionsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AnswerSelectionsDAO.class);
	// property constants
	public static final String SELECTION_OTHER = "selectionOther";

	public void save(AnswerSelections transientInstance) {
		log.debug("saving AnswerSelections instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AnswerSelections persistentInstance) {
		log.debug("deleting AnswerSelections instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnswerSelections findById(Integer id) {
		log.debug("getting AnswerSelections instance with id: " + id);
		try {
			AnswerSelections instance = (AnswerSelections) getSession().get(
					"com.owmax.model.AnswerSelections", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AnswerSelections instance) {
		log.debug("finding AnswerSelections instance by example");
		try {
			List results = getSession()
					.createCriteria("com.owmax.model.AnswerSelections")
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
		log.debug("finding AnswerSelections instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AnswerSelections as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySelectionOther(Object selectionOther) {
		return findByProperty(SELECTION_OTHER, selectionOther);
	}

	public List findAll() {
		log.debug("finding all AnswerSelections instances");
		try {
			String queryString = "from AnswerSelections";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AnswerSelections merge(AnswerSelections detachedInstance) {
		log.debug("merging AnswerSelections instance");
		try {
			AnswerSelections result = (AnswerSelections) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AnswerSelections instance) {
		log.debug("attaching dirty AnswerSelections instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnswerSelections instance) {
		log.debug("attaching clean AnswerSelections instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}