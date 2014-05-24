package org.tiluflow.domain.predicates;

import org.tiluflow.domain.QHotel;

import com.mysema.query.types.Predicate;

public class HotelPredicates {
	public static Predicate addressIsLike (final String searchTerm){
		QHotel hotel= QHotel.hotel;
		return hotel.address.startsWithIgnoreCase(searchTerm);
	}
	public static Predicate nameIsLike (final String searchTerm){
		QHotel hotel= QHotel.hotel;
		return hotel.name.startsWithIgnoreCase(searchTerm);
	}
}
