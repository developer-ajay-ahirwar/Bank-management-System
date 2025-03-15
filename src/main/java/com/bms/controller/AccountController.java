package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.entity.AccountHolder;
import com.bms.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService service;
	
	@PostMapping("/create")
	public AccountHolder creAccountHolder(@RequestBody AccountHolder accountHolder) {
		AccountHolder createAccount = service.creAccountHolder(accountHolder);
		return createAccount;
	}
	
	@GetMapping("/{accountNum}")
	public AccountHolder getAccountHolderDetailsByNum(@PathVariable Long accountNum) {
		AccountHolder acDetails = service.getAcDetailsByAcNum(accountNum);
		return acDetails;
	}
	
	@GetMapping("getallaccount")
	public List<AccountHolder> getAllAccountDetails(){
		List<AccountHolder> allAccountHolders = service.getAccountHoldersDetails();
		return allAccountHolders;
	}
	
	@PutMapping("deposite/{accountNumber}/{amount}")
	public AccountHolder depositeAccount(@PathVariable Long accountNumber ,@PathVariable Double amount) {
		AccountHolder depositeAmount =service.depositAmount(accountNumber, amount);
		return depositeAmount;
	}
	
	
	@PutMapping("/withdrwa/{accountNumber}/{amount}")
	public AccountHolder withdrwaAccount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		AccountHolder withdrwaAmount = service.withdrwaAmount(accountNumber, amount);
		return withdrwaAmount;
	}
	
	
}
