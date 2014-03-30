package org.tiluflow.dao;

import java.util.List;

import org.tiluflow.domain.Account;



/**
 * DAO Layer interface to manage accounts
 * 
 * @author eidos71
 * 
 */
public interface AccountDaoService extends GenericDao<Integer,Account> {

  /**
   * Get all the accounts enabled or not
   * 
   * @param isEnabled
   * @return
   */
  List<Account> getAll(boolean isEnabled);

}
