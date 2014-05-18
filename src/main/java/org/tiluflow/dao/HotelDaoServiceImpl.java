package org.tiluflow.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.Hotel;
@Component("hotelDaoServiceImpl")
public class HotelDaoServiceImpl extends AbstractJpaDao<Integer, Hotel> implements
		HotelDaoService {

public HotelDaoServiceImpl(){
	super();
}
@Transactional(readOnly = true)
@Override
public List<Hotel> getAll() {
    final  CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Hotel> cq = criteriaBuilder.createQuery(entityClass);
    Root<Hotel> root = cq.from(entityClass);
    cq.select(root);
    TypedQuery<Hotel> q = em.createQuery(cq);
    LOG.debug("{} ", cq );
    return q.getResultList();
}

@Override
public List<Hotel> getAll(String columnNameForOrderBy) {
	// TODO Auto-generated method stub
	
	return null;
}

}
