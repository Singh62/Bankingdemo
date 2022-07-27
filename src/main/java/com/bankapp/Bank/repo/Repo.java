package com.bankapp.Bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.Bank.entity.BankAc;

public interface Repo extends JpaRepository<BankAc,Integer> {

}
