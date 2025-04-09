package com.vk.org.services;

import java.util.List;

import com.vk.org.entities.Transaction;
import com.vk.org.entities.TransactionByAccount;

public interface TransactionService {
	
	public List<Transaction> getAllTransaction();

	public Transaction getTransactionById(Integer tId);

	public Transaction addTransaction(Transaction transaction);
	
	public List<TransactionByAccount> findByTransactionAccountNo(String transactionaccountno);
	
	public List<Transaction> findByTransactionId(Integer transactionid);

}
