package com.bms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entity.AccountHolder;
import com.bms.entity.GenerateAccountNum;
import com.bms.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	AccountRepository repo;
	GenerateAccountNum generateAccountNum = new GenerateAccountNum();
	
	@Override
	public AccountHolder creAccountHolder(AccountHolder accountHolder) {

		while(true) {
			Long genAccNum = Long.parseLong(generateAccountNum.genAccountNum());
			Optional<AccountHolder> getDetails = repo.findById(genAccNum);
			if(getDetails.isEmpty()) {
				accountHolder.setAcNumber(genAccNum);
				accountHolder.setAccount_Balance(0d);
				AccountHolder accountSaved =  repo.save(accountHolder);
				return accountSaved;
			}
			else {
				throw new RuntimeException("Account is present");
			}
		}
	
	}

	@Override
	public AccountHolder getAcDetailsByAcNum(Long acNumber) {
		 Optional<AccountHolder> getDetails = repo.findById(acNumber);
		 if(getDetails.isEmpty()) {
			 throw new RuntimeException("Account is not present");
		 }
		 AccountHolder account_Found  =getDetails.get();
		return account_Found;
	}

	@Override
	public List<AccountHolder> getAccountHoldersDetails() {
		List<AccountHolder> listOfAccountHolders = repo.findAll();
		return listOfAccountHolders;
	}

	@Override
	public AccountHolder depositAmount(Long acNumberLong, Double amount) {
		Optional<AccountHolder> account =repo.findById(acNumberLong);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not preset");
		}
		AccountHolder accountPresent = account.get();
		Double totalBalance =  accountPresent.getAccount_Balance() + amount;
		accountPresent.setAccount_Balance(totalBalance); 
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public AccountHolder withdrwaAmount(Long acNumberLong, Double amount) {
		Optional<AccountHolder> account =repo.findById(acNumberLong);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not preset");
		}
		AccountHolder accountPresent = account.get();
		Double totalBalance =  accountPresent.getAccount_Balance() - amount;
		accountPresent.setAccount_Balance(totalBalance); 
		repo.save(accountPresent);
		return accountPresent;
	}

}
