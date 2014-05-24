package org.tiluflow.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import org.tiluflow.domain.User;

public interface UserService {

	
	/**
	 * 
	 * @return
	 */
	public List<User> findAll();
	/**
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public User findById(Integer id) throws NotFoundException;
}
