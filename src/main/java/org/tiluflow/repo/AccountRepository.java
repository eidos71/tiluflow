package org.tiluflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tiluflow.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
