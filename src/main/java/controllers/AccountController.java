package controllers;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.Account;
import models.TransferRequest;
import services.TransferService;

@RestController
public class AccountController {

	private final TransferService service;
	
	public AccountController(TransferService service) {
		this.service = service;
	}
	
	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferRequest request) throws SQLException {

		service.transferMoney(request.getSenderId(), request.getReceiverId(), request.getAmount());
		
	}
	
	@GetMapping("/accounts") // Iterable is a super interface of List
	public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
		
		if (name == null) {
			return service.getAllAccounts();
		} else {
			return service.findAccountsByName(name);
		}
	}
}
