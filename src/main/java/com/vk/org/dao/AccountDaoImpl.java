package com.vk.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vk.org.entities.Account;
import com.vk.org.repositories.AccountRepository;

@Component
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAllAccount(){
		return (List<Account>) accountRepository.findAll();
	}


}
