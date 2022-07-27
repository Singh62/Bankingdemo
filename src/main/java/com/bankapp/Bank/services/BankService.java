package com.bankapp.Bank.services;

import java.util.*;


import com.bankapp.Bank.entity.BankAc;


public interface BankService {
	public List<BankAc> getListBankAc();
	public void addAc(BankAc b);
	public BankAc getBankAc(int accNo);
	public int balCheck(int accNo);
	public void withdrawalAc(int accNo,int bal);
	public void depositAc(int accNo,int amt);
}
