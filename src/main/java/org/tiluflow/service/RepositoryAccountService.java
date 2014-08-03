package org.tiluflow.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.Account;
import org.tiluflow.repo.AccountRepository;

@Service
public class RepositoryAccountService  implements AccountService{


	private AccountRepository accountRepository;
	@Inject
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	 @Transactional(readOnly=true)
	@Override
	public List<Account> findAll() {
		 return accountRepository.findAll();
	}
	 @Transactional(readOnly=true)
	@Override
	public Account findById(Integer id) throws NotFoundException {
	
		return accountRepository.findOne(id );
	}

}
