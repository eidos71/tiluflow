package org.tiluflow.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.tiluflow.domain.Account;

public interface AccountService {

	/**
	 * 
	 * @return
	 */
	public List<Account> findAll();
	/**
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public Account findById(Integer id) throws NotFoundException;
}
