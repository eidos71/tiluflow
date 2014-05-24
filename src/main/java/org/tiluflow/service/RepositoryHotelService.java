package org.tiluflow.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.Account;
import org.tiluflow.domain.Hotel;
import org.tiluflow.repo.AccountRepository;
import org.tiluflow.repo.HotelRepository;

@Service

public class RepositoryHotelService  implements HotelService{


	private HotelRepository hotelRepository;
	@Inject
	public void setAccountRepository(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	 @Transactional(readOnly=true)
	@Override
	public List<Hotel> findAll() {
		 return hotelRepository.findAll();
	}
	 @Transactional(readOnly=true)
	@Override
	public Hotel findById(Integer id) throws NotFoundException {
	
		return hotelRepository.findOne(id );
	}

}
