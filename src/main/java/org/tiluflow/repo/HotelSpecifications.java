package org.tiluflow.repo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;



import org.springframework.data.jpa.domain.Specification;
import org.tiluflow.domain.Hotel;
import org.tiluflow.domain.Hotel_;

public class HotelSpecifications {

	public static Specification<Hotel> lastAddressIsLike(final String searchTerm){
		return new Specification<Hotel>(){

			@Override
			public Predicate toPredicate(Root<Hotel> hotelRoot,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
			    String likePattern = getLikePattern(searchTerm);
			    return cb.like(cb.lower(hotelRoot.get(Hotel_.address)), likePattern);
				
			}

			private String getLikePattern(final String searchTerm) {
                StringBuilder pattern = new StringBuilder();
                pattern.append(searchTerm.toLowerCase());
                pattern.append("%");
                return pattern.toString();
			}
			
		};
	}
}
