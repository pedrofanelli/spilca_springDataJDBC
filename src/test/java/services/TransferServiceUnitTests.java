package services;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
	public void moneyTransferHappyFlow() {
		// we create a mock to manipulate
		AccountRepository accountRepository = mock(AccountRepository.class);           
	 
		// we create a new instance of the object which contains the method we want to test
		// passing our mock!
	    TransferService transferService = new TransferService(accountRepository);
	}
	
}
