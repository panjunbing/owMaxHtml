package com.owmax.dao;

import com.owmax.model.Blanks;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * Blanks entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.owmax.model.Blanks
 * @author MyEclipse Persistence Tools
 */
@Repository
public class BlanksDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BlanksDAO.class);
	// property constants
	public static final String BLANK_TEXT = "blankText";

	public void save(Blanks transientInstance) {
		log.debug("saving Blanks instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Blanks persistentInstance) {
		log.debug("deleting Blanks instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Blanks findById(Short id) {
		log.debug("getting Blanks instance with id: " + id);
		try {
			Blanks instance = (Blanks) getSession().get(
					"com.owmax.model.Blanks", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Blanks instance) {
		log.debug("finding Blanks instance by example");
		try {
			List results = getSession()
					.createCriteria("com.owmax.model.Blanks")
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
		log.debug("finding Blanks instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Blanks as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBlankText(Object blankText) {
		return findByProperty(BLANK_TEXT, blankText);
	}

	public List findAll() {
		log.debug("finding all Blanks instances");
		try {
			String queryString = "from Blanks";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Blanks merge(Blanks detachedInstance) {
		log.debug("merging Blanks instance");
		try {
			Blanks result = (Blanks) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Blanks instance) {
		log.debug("attaching dirty Blanks instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Blanks instance) {
		log.debug("attaching clean Blanks instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}