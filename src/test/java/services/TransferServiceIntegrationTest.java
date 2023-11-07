package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import repositories.AccountRepository;

/*
 * Because we want to test functionalities with different parts of the app
 * we will use the actual objects, not the mocks, thats why we use MockBean, we 
 * actually generate the bean. Because we want to test that it actually all works
 */
@SpringBootTest
public class TransferServiceIntegrationTest {

	@MockBean
	private AccountRepository accountRepository;
	
	@Autowired
	private TransferService transferService;
}
