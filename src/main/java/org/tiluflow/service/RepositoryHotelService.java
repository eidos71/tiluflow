package org.tiluflow.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tiluflow.domain.Hotel;
import org.tiluflow.domain.predicates.HotelPredicates;
import org.tiluflow.dto.HotelDTO;
import org.tiluflow.repo.HotelRepository;

@Service

public class RepositoryHotelService  implements HotelService{

	static final Logger LOG = LoggerFactory.getLogger(RepositoryHotelService.class);

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

	 
	@Override
	public List<Hotel> search(String searchTerm) {
		 Iterable<Hotel> hotelIterable = hotelRepository.findAll(HotelPredicates.nameIsLike(searchTerm) );
	        return constructList(hotelIterable);
	}


	private List<Hotel> constructList(Iterable<Hotel> hotels) {
	        List<Hotel> list = new ArrayList<Hotel>();
	        for (Hotel hotel: hotels) {
	            list.add(hotel);
	        }
	        return list;
	    }
	@Transactional
	@Override
	public Hotel create(HotelDTO hotelDto) {
		  LOG.debug("Creating a new person with information: " + hotelDto);
		Hotel hotel=  Hotel.getBuilder(hotelDto.getAddress(),
				hotelDto.getCity(), hotelDto.getCountry(), hotelDto.getName(), hotelDto.getPrice(),
				hotelDto.getState(), hotelDto.getZip() ).build();
			hotelRepository.save(hotel);
		return hotel;
	}
	@Transactional(rollbackFor=EntityNotFoundException.class)
	@Override
	public Hotel update (HotelDTO updated){
		 LOG.debug("Updating person with information: {}", updated);
	        
	        Hotel hotel = hotelRepository.findOne(updated.getId());
	        
	        if (hotel == null) {
	            LOG.debug("No person found with id:{} ", updated.getId());
	            throw new EntityNotFoundException();
	        }
	        
	        hotel.update(
	        		 updated.getAddress(), updated.getCity(), updated.getCountry(),
	        		 updated.getPrice()
	        		);
	        hotelRepository.save(hotel);
	        return hotel;
	}
}
