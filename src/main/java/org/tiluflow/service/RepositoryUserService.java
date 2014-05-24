package org.tiluflow.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.User;
import org.tiluflow.repo.UserRepository;
@Service
public class RepositoryUserService implements UserService {


	private UserRepository userRepository;
	
	@Inject
	 public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	 @Transactional(readOnly=true)
	@Override
	public User findById(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
