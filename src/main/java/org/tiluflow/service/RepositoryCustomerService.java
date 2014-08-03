package org.tiluflow.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.Customer;
import org.tiluflow.repo.CustomerRepository;
@Service
public class RepositoryCustomerService implements CustomerService {


	private CustomerRepository customerRepository;
	
	@Inject
	 public void setUserRepository(CustomerRepository userRepository) {
		this.customerRepository = userRepository;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	 @Transactional(readOnly=true)
	@Override
	public Customer findById(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return customerRepository.findOne(id);
	}

}
