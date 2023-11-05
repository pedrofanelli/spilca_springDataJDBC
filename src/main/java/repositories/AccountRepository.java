package repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import models.Account;

/*
 * The types represent the Model (Entity) and the type of it's primary key
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

	/*
	 * Spring Data knows to interpret the method’s names based on some naming definition rules 
	 * and creates the SQL query behind the scenes for you.
	 * I could have even named the method findByName. It would still know what to select just 
	 * because the method is in the AccountRepository interface.
	 * Although, I always recommend developers explicitly specify the query instead of relying 
	 * on Spring Data to translate the method’s name.
	 */
	@Query("SELECT * FROM account WHERE name = :name") //the parameter’s name in the query should be the same as the method parameter’s name. There shouldn’t be any spaces between the colon (:) and the parameter’s name.
	List<Account> findAccountsByName(String name);
	
	/*
	 * We annotate the methods that define operations that change data with the @Modifying annotation.
	 */
	@Modifying
	@Query("UPDATE account SET amount = :amount WHERE id = :id")
	void changeAmount(long id, BigDecimal amount);
}
