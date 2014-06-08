package org.tiluflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.tiluflow.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>, 
	QueryDslPredicateExecutor<Account>,JpaSpecificationExecutor<Account>
	{

}
