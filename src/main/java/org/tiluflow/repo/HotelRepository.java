package org.tiluflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tiluflow.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
