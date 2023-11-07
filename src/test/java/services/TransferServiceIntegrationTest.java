package services;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import models.Account;
import repositories.AccountRepository;

/*
 * Because we want to test functionalities with different parts of the app
 * we will use the actual objects, not the mocks, thats why we use MockBean, we 
 * actually generate the bean. Because we want to test that it actually all works
 */
@SpringBootTest(classes=com.example.demo.SpilcaSpringDataJdbcApplication.class)
public class TransferServiceIntegrationTest {

	@MockBean
	private AccountRepository accountRepository;
	
	@Autowired
	private TransferService transferService;
	
	@Test
	@DisplayName("Testeo de la transferencia de dinero de forma integral")
	public void transferServiceTransferAmountIntegrationTest() throws SQLException {
		Account sender = new Account();
	    sender.setId(3);
	    sender.setAmount(new BigDecimal(1000));
	    Account destination = new Account();
	    destination.setId(4);
	    destination.setAmount(new BigDecimal(1000));
	    
	    given(accountRepository.findById(3L)).willReturn(Optional.of(sender));
	    given(accountRepository.findById(4L)).willReturn(Optional.of(destination));
	    
	    transferService.transferMoney(sender.getId(), destination.getId(), new BigDecimal(100));
	    
	    verify(accountRepository).changeAmount(3, new BigDecimal(900));
	    verify(accountRepository).changeAmount(4, new BigDecimal(1100));
	}
}
