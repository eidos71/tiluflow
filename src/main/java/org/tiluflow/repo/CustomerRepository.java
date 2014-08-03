package org.tiluflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.tiluflow.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> ,
	QueryDslPredicateExecutor<Customer>, JpaSpecificationExecutor<Customer>{

}
