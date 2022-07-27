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
	
	List<BankAc> list;
	
	 public BankServiceImpl() {
		// TODO Auto-generated constructor stub
		 list = new ArrayList<>();
		 list.add(new BankAc(111,10000,"Saving"));
	}	
		
	
	@Override
	public List<BankAc> getListBankAc() {
		// TODO Auto-generated method stub
		
		//return list;
		return r.findAll();
	}
	@Override
	public BankAc getBankAc(int accNo) {
		for(BankAc l: list) {
			if(l.getAcctId()==accNo) {
				return l;
			}
		}
		return null;
	}
	@Override
	public void addAc(BankAc b) {
		list.add(b);
		r.save(b);
	}
	@Override
	public int balCheck(int accNo) {
		int bal=-1;
		for(BankAc l: list) {
			if(l.getAcctId()==accNo) {
				bal=l.getBalance();
			}
		}
		return bal;
	}
	@Override
	public void withdrawalAc(int accNo,int amt) {
		int bal=-1;
		if(balCheck(accNo)<amt) return ;
		for(BankAc l: list) {
			if(l.getAcctId()==accNo) {
				bal=l.getBalance();
				bal-=amt;
				l.setBalance(bal);
			}
		}
	}
	@Override
	public void depositAc(int accNo,int amt) {
		int bal=-1;
		
		for(BankAc l: list) {
			if(l.getAcctId()==accNo) {
				bal=l.getBalance();
				bal+=amt;
				l.setBalance(bal);
			}
		}
	}
}
