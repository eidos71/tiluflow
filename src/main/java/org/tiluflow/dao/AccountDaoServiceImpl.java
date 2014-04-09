package org.tiluflow.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.Account;
import org.tiluflow.domain.Account_;



/**
 * 
 * @author eidos71
 *
 */
@Component("accountDaoService")
public class AccountDaoServiceImpl extends AbstractJpaDao<Integer,Account> implements AccountDaoService {

  public AccountDaoServiceImpl() {
    super(Account.class);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ippon.account.dao.AccountDaoService#getAll(boolean)
   */
  @Transactional(readOnly = true)
  @Override
  public List<Account> getAll(boolean isEnabled) {
    final  CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Account> cq = criteriaBuilder.createQuery(entityClass);
    Root<Account> root = cq.from(entityClass);
    cq.select(root);
    cq.where(criteriaBuilder.equal(root.get(Account_.enabled), isEnabled));
    TypedQuery<Account> q = em.createQuery(cq);
    return q.getResultList();
  }

@Override
@Transactional(readOnly = true)
public List<Account> getAll(String columnNameForOrderBy) {
	// TODO Auto-generated method stub
	return null;
}
}
