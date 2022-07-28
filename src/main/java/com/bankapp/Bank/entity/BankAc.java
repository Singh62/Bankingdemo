package com.bankapp.Bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bankdb")
public class BankAc {
	@Id
	private int acctId;
	private int balance;
	private int pin;
	private String accHolder;
	public BankAc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAc(int acctId, int balance, int pin, String accHolder) {
		super();
		this.acctId = acctId;
		this.balance = balance;
		this.pin = pin;
		this.accHolder = accHolder;
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
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}
	
}
