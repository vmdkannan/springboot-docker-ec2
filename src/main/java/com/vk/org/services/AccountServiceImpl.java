package com.vk.org.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.org.dao.AccountDao;
import com.vk.org.entities.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	public List<Account> getAllAccount(){
		return (List<Account>) accountDao.getAllAccount();
	}

}
