package org.tiluflow.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.tiluflow.domain.HotelNotFoundException;
import org.tiluflow.domain.Hotel;
import org.tiluflow.dto.HotelDTO;

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
	/**
	 * 
	 * @param hotel
	 * @return
	 */
	public Hotel create(HotelDTO hotel);
	/**
	 * 
	 * @param hotel
	 * @return
	 */
	Hotel update(HotelDTO hotel) throws HotelNotFoundException;
}
