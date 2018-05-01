package com.owmax.dao;

import java.util.List;
import java.util.Set;

import com.owmax.model.Questions;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * A data access object (DAO) providing persistence and search support for
 * Questions entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.owmax.model.Questions
 * @author MyEclipse Persistence Tools
 */
@Repository
public class QuestionsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(QuestionsDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String TYPE = "type";
	public static final String MAX_SELECTION = "maxSelection";

	public void save(Questions transientInstance) {
		log.debug("saving Questions instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Questions persistentInstance) {
		log.debug("deleting Questions instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Questions findById(Integer id) {
		log.debug("getting Questions instance with id: " + id);
		try {
			Questions instance = (Questions) getSession().get(
					"com.owmax.model.Questions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Questions instance) {
		log.debug("finding Questions instance by example");
		try {
			List results = getSession()
					.createCriteria("com.owmax.model.Questions")
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
		log.debug("finding Questions instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Questions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByMaxSelection(Object maxSelection) {
		return findByProperty(MAX_SELECTION, maxSelection);
	}

	public List findAll() {
		log.debug("finding all Questions instances");
		try {
			String queryString = "from Questions";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Questions merge(Questions detachedInstance) {
		log.debug("merging Questions instance");
		try {
			Questions result = (Questions) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Questions instance) {
		log.debug("attaching dirty Questions instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Questions instance) {
		log.debug("attaching clean Questions instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}