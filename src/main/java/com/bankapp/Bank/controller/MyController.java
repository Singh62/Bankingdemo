package com.bankapp.Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.Bank.entity.BankAc;
import com.bankapp.Bank.services.BankService;

import java.util.*;
@RestController
public class MyController {
	
	@Autowired
	private BankService t;
	
	@RequestMapping({"/", "/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/account")
	public List<BankAc> getListBankAc(){
		return this.t.getListBankAc();
	}
	@GetMapping("/account/{accNo}")
	public BankAc getAc(@PathVariable int accNo){
		return this.t.getBankAc(accNo);
	}
	@PostMapping("/account")
	public void addBankAc(@RequestBody BankAc b) {
		 this.t.addAc(b);
	}
	@GetMapping("/account/{accNo}/balance")
	public int balanceCheck(@PathVariable int accNo) {
		return this.t.balCheck(accNo);
	}
	@PutMapping("/account/{accNo}/withdraw/{amt}")
	public void withdrawals(@PathVariable int accNo,@PathVariable int amt) {
		this.t.withdrawalAc(accNo,amt);
	}
	@PutMapping("/account/{accNo}/deposit/{amt}")
	public void deposit(@PathVariable int accNo,@PathVariable int amt) {
		this.t.depositAc(accNo,amt);
	}
	// opening an account --create
	// check balance --search  --done
	// withdrawals --update
	// deposit     --update
	
}
