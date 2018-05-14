package com.owmax.dao;

import com.owmax.model.Jump;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for Jump
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.owmax.model.Jump
 * @author MyEclipse Persistence Tools
 */
@Repository
public class JumpDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(JumpDAO.class);

	// property constants

	public void save(Jump transientInstance) {
		log.debug("saving Jump instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jump persistentInstance) {
		log.debug("deleting Jump instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jump findById(Short id) {
		log.debug("getting Jump instance with id: " + id);
		try {
			Jump instance = (Jump) getSession().get("com.owmax.model.Jump", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Jump instance) {
		log.debug("finding Jump instance by example");
		try {
			List results = getSession().createCriteria("com.owmax.model.Jump")
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
		log.debug("finding Jump instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jump as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Jump instances");
		try {
			String queryString = "from Jump";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jump merge(Jump detachedInstance) {
		log.debug("merging Jump instance");
		try {
			Jump result = (Jump) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jump instance) {
		log.debug("attaching dirty Jump instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jump instance) {
		log.debug("attaching clean Jump instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}