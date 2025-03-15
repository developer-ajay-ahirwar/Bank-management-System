package com.bms.entity;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "AccountHolder")
public class AccountHolder {
	
//	GenerateAccountNum generateAccountNum = new GenerateAccountNum();
	@Id
	@PrimaryKeyJoinColumn
	@Column(name ="acNumber")
	private Long acNumber;
	
	@Column(name ="acHolderName")
	private String acHolderName;
	
	@Column(name ="acHolderFatherName")
	private String acHolderFatherName;
	
	@Column(name ="acHolderDOB")
	private String acHolderDOB;
	
	@Column(name = "account_Balance")
	private Double account_Balance;
	

	public Double getAccount_Balance() {
		return account_Balance;
	}

	public void setAccount_Balance(Double account_Balance) {
		this.account_Balance = account_Balance;
	}

	public AccountHolder(Long acNumber, String acHolderName, String acHolderFatherName, String acHolderDOB,
			Double account_Balance) {
		super();
		this.acNumber = acNumber;
		this.acHolderName = acHolderName;
		this.acHolderFatherName = acHolderFatherName;
		this.acHolderDOB = acHolderDOB;
		this.account_Balance = account_Balance;
	}

	public AccountHolder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(Long acNumber) {
		this.acNumber = acNumber;
	}

	public String getAcHolderName() {
		return acHolderName;
	}

	public void setAcHolderName(String acHolderName) {
		this.acHolderName = acHolderName;
	}

	public String getAcHolderFatherName() {
		return acHolderFatherName;
	}

	public void setAcHolderFatherName(String acHolderFatherName) {
		this.acHolderFatherName = acHolderFatherName;
	}

	public String getAcHolderDOB() {
		return acHolderDOB;
	}

	public void setAcHolderDOB(String acHolderDOB) {
		this.acHolderDOB = acHolderDOB;
	}
	
	@Override
	public String toString() {
		return "AccountHolder [acNumber=" + acNumber + ", acHolderName=" + acHolderName + ", acHolderFatherName="
				+ acHolderFatherName + ", acHolderDOB=" + acHolderDOB + ", account_Balance=" + account_Balance + "]";
	}
	
	
	

}
