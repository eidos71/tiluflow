package org.tiluflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.tiluflow.domain.Account;
import org.tiluflow.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer>,
	QueryDslPredicateExecutor<Hotel>{

}
