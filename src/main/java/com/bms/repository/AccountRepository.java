package com.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.entity.AccountHolder;


public interface AccountRepository extends JpaRepository<AccountHolder, Long> {
	
}
