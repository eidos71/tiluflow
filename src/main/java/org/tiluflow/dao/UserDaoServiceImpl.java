package org.tiluflow.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.User;
@Component("userDaoServiceImpl")
public class UserDaoServiceImpl extends AbstractJpaDao<Integer, User> implements
		UserDaoService {

public UserDaoServiceImpl(){
	super();
}
@Transactional(readOnly = true)
@Override
public List<User> getAll() {
    final  CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<User> cq = criteriaBuilder.createQuery(entityClass);
    Root<User> root = cq.from(entityClass);
    cq.select(root);
    TypedQuery<User> q = em.createQuery(cq);
    LOG.debug("{} ", cq );
    return q.getResultList();
}

@Override
public List<User> getAll(String columnNameForOrderBy) {
	// TODO Auto-generated method stub
	
	return null;
}

}
