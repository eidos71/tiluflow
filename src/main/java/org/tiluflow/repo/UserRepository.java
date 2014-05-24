package org.tiluflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.tiluflow.domain.Hotel;
import org.tiluflow.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> ,
	QueryDslPredicateExecutor<User>{

}
