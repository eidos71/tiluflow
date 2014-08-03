package org.tiluflow.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.tiluflow.domain.Customer;
import org.tiluflow.domain.Employee;
import org.tiluflow.dto.EmployeeDTO;

public interface EmployeeService {

	
	/**
	 * 
	 * @return
	 */
	public List<Employee> findAll();
	/**
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public Employee findById(Integer id) throws NotFoundException;
	/**
	 * 
	 * @param employeeDTO
	 * @return
	 */
	Employee create(EmployeeDTO employeeDTO);
}
