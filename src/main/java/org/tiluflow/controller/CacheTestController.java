package org.tiluflow.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tiluflow.domain.Employee;
import org.tiluflow.dto.EmployeeDTO;
import org.tiluflow.service.EmployeeService;
import org.tiluflow.service.RepositoryEmployeeService;
@Controller

public class CacheTestController {
	@Autowired
	EmployeeService employeeService;
	static final Logger LOG = LoggerFactory
			.getLogger(CacheTestController.class);
	 @RequestMapping(value = "/helloworld", method = RequestMethod.GET
			 )
	public String helloWorld() {
		return "hello world";
	}
	 @RequestMapping(value = "/cache/{id}/{username}", method = RequestMethod.GET
			 )
	 @ResponseBody
    public Employee listEmployees(@PathVariable String id, @PathVariable String username ) throws NotFoundException {
	//Check  http://www.codingpedia.org/ama/spring-caching-with-ehcache/
		 Employee emp;
		 	EmployeeDTO a= new EmployeeDTO(username, null, null, id);
			emp = employeeService.mockFindCacheable(a);
			LOG.debug("{}", emp);
		 
	return emp;
    }
}
