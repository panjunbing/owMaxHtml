package com.owmax.dao;

import com.owmax.model.Selections;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 	* A data access object (DAO) providing persistence and search support for Selections entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.owmax.model.Selections
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class SelectionsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SelectionsDAO.class);
		//property constants
	public static final String SELECTION = "selection";
	public static final String SELECTION_TEXT = "selectionText";



    
    public void save(com.owmax.model.Selections transientInstance) {
        log.debug("saving Selections instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(com.owmax.model.Selections persistentInstance) {
        log.debug("deleting Selections instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public com.owmax.model.Selections findById(Integer id) {
        log.debug("getting Selections instance with id: " + id);
        try {
            com.owmax.model.Selections instance = (com.owmax.model.Selections) getSession()
                    .get("com.owmax.model.Selections", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(com.owmax.model.Selections instance) {
        log.debug("finding Selections instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.owmax.model.Selections")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Selections instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Selections as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findBySelection(Object selection
	) {
		return findByProperty(SELECTION, selection
		);
	}
	
	public List findBySelectionText(Object selectionText
	) {
		return findByProperty(SELECTION_TEXT, selectionText
		);
	}
	

	public List findAll() {
		log.debug("finding all Selections instances");
		try {
			String queryString = "from Selections";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public com.owmax.model.Selections merge(com.owmax.model.Selections detachedInstance) {
        log.debug("merging Selections instance");
        try {
            com.owmax.model.Selections result = (com.owmax.model.Selections) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(com.owmax.model.Selections instance) {
        log.debug("attaching dirty Selections instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Selections instance) {
        log.debug("attaching clean Selections instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}