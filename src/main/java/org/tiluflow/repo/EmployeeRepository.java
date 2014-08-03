package org.tiluflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import org.tiluflow.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>,
		QueryDslPredicateExecutor<Employee>, JpaSpecificationExecutor<Employee> {

}
