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
	/**
	 * Looks for Query param
	 * @param city
	 * @return
	 */
	List<Hotel> findByCity(String city);
	/**
	 *  looks for criteria
	 * @param state
	 * @return
	 */
	List<Hotel> findBystate(String state);
	/**
	 * 
	 * @param searchTerm
	 * @return
	 */
	List<Hotel> findCriteriaByStreet(String searchTerm);
}
