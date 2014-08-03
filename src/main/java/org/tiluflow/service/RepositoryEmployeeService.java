package org.tiluflow.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.Employee;
import org.tiluflow.dto.EmployeeDTO;
import org.tiluflow.repo.EmployeeRepository;

@Service
public class RepositoryEmployeeService implements EmployeeService {

	static final Logger LOG = LoggerFactory
			.getLogger(RepositoryEmployeeService.class);
	private EmployeeRepository repository;

	@Inject
	public void setUserRepository(EmployeeRepository userRepository) {
		this.repository = userRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Employee findById(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public Employee create(EmployeeDTO employeeDTO) {
		LOG.debug("Creating a new person with information: " + employeeDTO);

		Employee employee = Employee.getBuilder(
					employeeDTO.getUserName(),
					employeeDTO.getPassword(), 
					employeeDTO.getName(),
					employeeDTO.getEmployeeCode())
				.build();
		repository.save(employee);
		return employee;
	}
}
