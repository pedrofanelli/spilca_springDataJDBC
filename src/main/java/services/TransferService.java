package services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.Account;
import repositories.AccountRepository;

@Service
public class TransferService {

	private final AccountRepository repo;
	
	// aunque sea una interfaz, Spring Data la implementará y se agregará al contexto
	public TransferService(AccountRepository repo) {
		this.repo = repo;
	}
	
	/*
	 * Tanto .findById() como .findAll() se implementan solos por Spring Data
	 */
	@Transactional(rollbackFor= {SQLException.class,Exception.class})
	public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws SQLException {

		Account sender = repo.findById(idSender).orElseThrow(()->new RuntimeException());
		Account receiver = repo.findById(idReceiver).orElseThrow(()->new RuntimeException());
		
		BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
		BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
		
		repo.changeAmount(idSender, senderNewAmount);
		repo.changeAmount(idReceiver, receiverNewAmount);
		
		//throw new RuntimeException("OH NO! UNA RUNTIME EXCEPTION! ROLLBACK!!!");
		
	}
	
	public Iterable<Account> getAllAccounts() {
		return repo.findAll();
	}
	
	//usamos la búsqueda custom que armamos; otra custom es .changeAmount()
	public List<Account> findAccountsByName(String name) {
		return repo.findAccountsByName(name);
	}
	
}
