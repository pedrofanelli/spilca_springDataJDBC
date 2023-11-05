package repositories;

import org.springframework.data.repository.CrudRepository;

import models.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	
}
