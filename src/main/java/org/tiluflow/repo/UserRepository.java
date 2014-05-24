package org.tiluflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tiluflow.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
