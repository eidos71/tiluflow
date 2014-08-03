package org.tiluflow.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import org.tiluflow.domain.Customer;

public interface CustomerService {

	
	/**
	 * 
	 * @return
	 */
	public List<Customer> findAll();
	/**
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public Customer findById(Integer id) throws NotFoundException;
}
