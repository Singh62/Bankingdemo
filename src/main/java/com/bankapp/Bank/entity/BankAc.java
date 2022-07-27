package com.bankapp.Bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAc {
	@Id
	private int acctId;
	private int balance;
	private String acctStatus;
	public BankAc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAc(int acctId, int balance, String acctStatus) {
		super();
		this.acctId = acctId;
		this.balance = balance;
		this.acctStatus = acctStatus;
	}
	public int getAcctId() {
		return acctId;
	}
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAcctStatus() {
		return acctStatus;
	}
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}
	
	
}
