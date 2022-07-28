package com.bankapp.Bank.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.Bank.entity.BankAc;
import com.bankapp.Bank.repo.Repo;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private Repo r;
	
	public BankServiceImpl() {
		 
	}	
		
	@Override
	public List<BankAc> getListBankAc() {
		return r.findAll();
	}
	@Override
	public List<BankAc> getListBankAc(int accNo) {
		return r.findAll();
	}
	@Override
	public BankAc getBankAc(int accNo) {
		return r.findById(accNo).get();
	}
	@Override
	public void addAc(BankAc b) {
		r.save(b);
	}
	@Override
	public int balCheck(int accNo) {
		return r.findById(accNo).get().getBalance();
	}
	@Override
	public BankAc withdrawalAc(int accNo,int amt) {
		BankAc x=r.findById(accNo).get();
		if(x.getBalance()>amt) {
			int bal=x.getBalance()-amt;
			x.setBalance(bal);
		}
		r.save(x);
		return r.findById(accNo).get();
	}
	@Override
	public void depositAc(int accNo,int amt) {
		BankAc x=r.findById(accNo).get();
		
			int bal=x.getBalance()+amt;
			x.setBalance(bal);

			r.save(x);
	}
	@Override
	public boolean valid(int accNo,int pin) {
		boolean flag = false;
		int p = r.findById(accNo).get().getPin();
		if(p==pin)
			return true; 
		return flag;
	}
}
