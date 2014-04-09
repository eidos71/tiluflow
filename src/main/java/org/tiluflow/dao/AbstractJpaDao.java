package org.tiluflow.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.controller.TiluController;
import org.tiluflow.domain.BaseEntity;




public abstract class AbstractJpaDao<K, E extends BaseEntity> implements
		GenericDao<K, E> {
	protected Class<E> entityClass;
	static final Logger LOG = LoggerFactory.getLogger(TiluController.class);
	@PersistenceContext
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@SuppressWarnings("unchecked")
	public AbstractJpaDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	public AbstractJpaDao(Class<E> type) {
		this.entityClass = type;
	}

	@Override
	@Transactional
	public void save(E entity) {
		LOG.info("Entity coming is:{} ", entity);
		if (entity.getId()==null || entity.getId() == 0) {
			em.persist(entity);
		} else {
			em.merge(entity);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public void refresh(E entity) {
		if (em.contains(entity)) {
			em.refresh(entity);
		}
		entity.setInitialized(false);
		entity.initialize();
	}
	  @Override
	  @Transactional(readOnly = true)
	  public List<E> getAll() {
	    return getAll(null);
	  }
	public void remove(E entity) {
		em.remove(entity);
	}
	  @Override
	  @Transactional(readOnly = true)
	  public E get(int id) {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<E> cq = cb.createQuery(entityClass);
	    Root<E> root = cq.from(entityClass);
	    cq.select(root);
	    cq.where(cb.equal(root.get( org.tiluflow.domain.BaseEntity_.id), id));
	    TypedQuery<E> q = em.createQuery(cq);
	    E entity = q.getSingleResult();
	    entity.initialize();
	    return entity;
	  }
	public E findById(K id) {
		return em.find(entityClass, id);
	}
}