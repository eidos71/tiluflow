package org.tiluflow.repo;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.tiluflow.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer>,
	QueryDslPredicateExecutor<Hotel>, JpaSpecificationExecutor<Hotel>{

    @Query("SELECT h FROM Hotel h WHERE LOWER(h.city) = LOWER(:city)")
    public List<Hotel> findByCity(@Param("city") String city);
    
    public List<Hotel> findByState(String state);
}
