package com.vk.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vk.org.entities.Transaction;
import java.lang.String;
import java.util.List;
import java.lang.Integer;


	@RepositoryRestResource(collectionResourceRel = "transaction", path = "transaction")
	public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

		
		public List<Transaction> findByTransactionAccountNo(String transactionaccountno);
		
		public List<Transaction> findByTransactionId(Integer transactionid);

	}

