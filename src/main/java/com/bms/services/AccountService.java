package com.bms.services;

import java.util.List;

import com.bms.entity.AccountHolder;

public interface AccountService {

	public AccountHolder creAccountHolder(AccountHolder accountHolder);
	public AccountHolder getAcDetailsByAcNum(Long acNumber);
	public List<AccountHolder> getAccountHoldersDetails();
	public AccountHolder depositAmount(Long acNumberLong , Double amount);
	public AccountHolder withdrwaAmount(Long acNumberLong , Double amount);
}
