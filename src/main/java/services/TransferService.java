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
	
	public TransferService(AccountRepository repo) {
		this.repo = repo;
	}
	
	
	
}
