package org.tiluflow.dao;

import java.util.List;

import org.tiluflow.domain.Account;
import org.tiluflow.domain.Hotel;
import org.tiluflow.domain.User;

public interface HotelDaoService extends  GenericDao<Integer,Hotel> {

	  List<Hotel> getAll();
}
