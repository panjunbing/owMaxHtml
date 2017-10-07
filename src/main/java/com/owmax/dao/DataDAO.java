package com.owmax.dao;

import com.owmax.model.Data;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for Data
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.owmax.model.Data
 * @author MyEclipse Persistence Tools
 */
@Repository
public class DataDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DataDAO.class);
	// property constants
	public static final String HERO = "hero";
	public static final String GAME_TIME = "gameTime";
	public static final String GAME_WINNING = "gameWinning";
	public static final String AVERAGE_HIT_RATE = "averageHitRate";
	public static final String AVERAGE_CRIT_RATE = "averageCritRate";
	public static final String AVERAGE_TIME = "averageTime";
	public static final String AVERAGE_DAMAGE = "averageDamage";
	public static final String AVERAGE_KILL = "averageKill";
	public static final String AVERAGE_SINGLE_KILL = "averageSingleKill";
	public static final String AVERAGE_DEFENSE_KILL = "averageDefenseKill";
	public static final String AVERAGE_LAST_KILL = "averageLastKill";
	public static final String AVERAGE_DEAD = "averageDead";
	public static final String AVERAGE_TREATMENT = "averageTreatment";
	public static final String AVERAGE_DAMAGE_DEFENSE = "averageDamageDefense";
	public static final String BEST_HIT_RATE = "bestHitRate";
	public static final String BEST_TIME = "bestTime";
	public static final String BEST_DAMAGE = "bestDamage";
	public static final String BEST_KILL = "bestKill";
	public static final String BEST_TREATMENT = "bestTreatment";

	public void save(Data transientInstance) {
		log.debug("saving Data instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Data persistentInstance) {
		log.debug("deleting Data instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Data findById(Integer id) {
		log.debug("getting Data instance with id: " + id);
		try {
			Data instance = (Data) getSession().get("com.owmax.model.Data", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Data instance) {
		log.debug("finding Data instance by example");
		try {
			List results = getSession().createCriteria("com.owmax.model.Data")
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
		log.debug("finding Data instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Data as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHero(Object hero) {
		return findByProperty(HERO, hero);
	}

	public List findByGameTime(Object gameTime) {
		return findByProperty(GAME_TIME, gameTime);
	}

	public List findByGameWinning(Object gameWinning) {
		return findByProperty(GAME_WINNING, gameWinning);
	}

	public List findByAverageHitRate(Object averageHitRate) {
		return findByProperty(AVERAGE_HIT_RATE, averageHitRate);
	}

	public List findByAverageCritRate(Object averageCritRate) {
		return findByProperty(AVERAGE_CRIT_RATE, averageCritRate);
	}

	public List findByAverageTime(Object averageTime) {
		return findByProperty(AVERAGE_TIME, averageTime);
	}

	public List findByAverageDamage(Object averageDamage) {
		return findByProperty(AVERAGE_DAMAGE, averageDamage);
	}

	public List findByAverageKill(Object averageKill) {
		return findByProperty(AVERAGE_KILL, averageKill);
	}

	public List findByAverageSingleKill(Object averageSingleKill) {
		return findByProperty(AVERAGE_SINGLE_KILL, averageSingleKill);
	}

	public List findByAverageDefenseKill(Object averageDefenseKill) {
		return findByProperty(AVERAGE_DEFENSE_KILL, averageDefenseKill);
	}

	public List findByAverageLastKill(Object averageLastKill) {
		return findByProperty(AVERAGE_LAST_KILL, averageLastKill);
	}

	public List findByAverageDead(Object averageDead) {
		return findByProperty(AVERAGE_DEAD, averageDead);
	}

	public List findByAverageTreatment(Object averageTreatment) {
		return findByProperty(AVERAGE_TREATMENT, averageTreatment);
	}

	public List findByAverageDamageDefense(Object averageDamageDefense) {
		return findByProperty(AVERAGE_DAMAGE_DEFENSE, averageDamageDefense);
	}

	public List findByBestHitRate(Object bestHitRate) {
		return findByProperty(BEST_HIT_RATE, bestHitRate);
	}

	public List findByBestTime(Object bestTime) {
		return findByProperty(BEST_TIME, bestTime);
	}

	public List findByBestDamage(Object bestDamage) {
		return findByProperty(BEST_DAMAGE, bestDamage);
	}

	public List findByBestKill(Object bestKill) {
		return findByProperty(BEST_KILL, bestKill);
	}

	public List findByBestTreatment(Object bestTreatment) {
		return findByProperty(BEST_TREATMENT, bestTreatment);
	}

	public List findAll() {
		log.debug("finding all Data instances");
		try {
			String queryString = "from Data";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Data merge(Data detachedInstance) {
		log.debug("merging Data instance");
		try {
			Data result = (Data) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Data instance) {
		log.debug("attaching dirty Data instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Data instance) {
		log.debug("attaching clean Data instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}