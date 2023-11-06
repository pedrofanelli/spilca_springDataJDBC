package services;

import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import models.Account;
import repositories.AccountRepository;

/*
 * We eliminate all the dependencies and isolate one piece of logic
 * Dependencies are the methods parameters and object instances with an external origin
 * The external objects are represented with "mocks"
 */
public class TransferServiceUnitTests {

	/*
	 * Each test represents a single unit of logic being tested, in this case the happy flow!
	 */
	@Test
	@DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
	public void moneyTransferHappyFlow() throws SQLException {
		// we create a mock to manipulate
		AccountRepository accountRepository = mock(AccountRepository.class);           
	 
		// we create a new instance of the object which contains the method we want to test
		// passing our mock!
	    TransferService transferService = new TransferService(accountRepository);
	    
	    //we use the .given() method to tell how to behave a method from a mock object
	    // remember in the service we used the repository to find 2 accounts
	    Account sender = new Account();
	    sender.setId(1);
	    sender.setAmount(new BigDecimal(1000));
	    Account destination = new Account();
	    destination.setId(2);
	    destination.setAmount(new BigDecimal(1000));
	    
	    given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
	    given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

	    // we call the method we want with all the data
	    transferService.transferMoney(sender.getId(), destination.getId(), new BigDecimal(100));
	    
	}
	
}
