package com.bankapp.Bank.services;

import java.util.*;


import com.bankapp.Bank.entity.BankAc;


public interface BankService {
	public List<BankAc> getListBankAc();
	public List<BankAc> getListBankAc(int accNo);
	public void addAc(BankAc b);
	public BankAc getBankAc(int accNo);
	public int balCheck(int accNo);
	public BankAc withdrawalAc(int accNo,int bal);
	public void depositAc(int accNo,int amt);
}
