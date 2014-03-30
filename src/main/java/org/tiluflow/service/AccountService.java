package org.tiluflow.service;

import java.util.List;

import org.tiluflow.domain.Account;
import org.tiluflow.dao.AccountDaoService;


/**
 * @author eidos71
 *
 */
public interface AccountService extends BaseEntityService<Account, AccountDaoService,Integer> {

  /**
   * Get all the accounts enabled or not
   * 
   * @param isEnabled
   * @return
   */
  List<Account> getAll(boolean isEnabled);

  /**
   * Add a new address to the account
   * 
   * @param entity
   */
  void addNewAddress(Account entity);

  /**
   * Delete an address to the account by the index of addresses
   * 
   * @param entity
   * @param addressIdx
   */
  void deleteAddress(Account entity, String addressIdx);
}
