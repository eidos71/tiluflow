package org.tiluflow.dao;

import java.util.List;

import org.tiluflow.domain.Account;
import org.tiluflow.domain.User;

public interface UserDaoService extends  GenericDao<Integer,User> {

	  List<User> getAll();
}
