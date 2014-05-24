package org.tiluflow.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import org.tiluflow.domain.Hotel;

public interface HotelService {

	/**
	 * 
	 * @return
	 */
	public List<Hotel> findAll();
	/**
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public Hotel findById(Integer id) throws NotFoundException;
	/**
	 * 
	 * @param searchTerm
	 * @return
	 */
	public List<Hotel>search (String searchTerm);
}
