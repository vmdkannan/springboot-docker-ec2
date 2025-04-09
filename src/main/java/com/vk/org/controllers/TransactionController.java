package com.vk.org.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import com.vk.org.entities.Transaction;
import com.vk.org.entities.TransactionByAccount;
import com.vk.org.exception.IdNotFoundException;
import com.vk.org.exception.ABCOrgException;
import com.vk.org.services.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(method=RequestMethod.GET, value="/transactions", produces="application/json")
	public ResponseEntity<Object> getAllEmployee() throws ABCOrgException{
		
		List<Transaction> lsttransactions = transactionService.getAllTransaction();

		if (lsttransactions.isEmpty()) {
			throw new ABCOrgException("There is no list of Transactions.");
		}

		return new ResponseEntity<>(lsttransactions, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/transactions/{id}", produces="application/json")
	public ResponseEntity<Object> getTransactionById(@PathVariable("id") int tId) throws IdNotFoundException, HttpMessageNotWritableException, MethodArgumentTypeMismatchException{
		
		Transaction trs = new Transaction();
		
		try {
			if (transactionService.findByTransactionId(tId).size()>0) {
				trs = transactionService.getTransactionById(tId);
				return new ResponseEntity<>(trs, HttpStatus.OK);
			} else {
					throw new IdNotFoundException(tId);
			}
			
		} catch (HttpMessageNotWritableException e) {
			throw new HttpMessageNotWritableException(e.getMessage());
		}
		catch (MethodArgumentTypeMismatchException e) {
			throw new MethodArgumentTypeMismatchException(e.getValue(), e.getRequiredType(), e.getName(), e.getParameter(), e.getCause());
		}
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/transaction", consumes="application/json")
	public ResponseEntity<Object> addTransaction (@RequestBody Transaction transaction) throws ABCOrgException{
		try {
			transactionService.addTransaction(transaction);
			return new ResponseEntity<>("Transaction is done.", HttpStatus.CREATED);
			
		} catch (Exception e) {
			throw new ABCOrgException("Transaction is not done.");
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/transactionsbyaccount/{acct}", produces="application/json")
	public ResponseEntity<Object> getTransactionsByAccountNo(@PathVariable("acct") String acct) throws ABCOrgException{
		try {
			List<TransactionByAccount> lstTrns = transactionService.findByTransactionAccountNo(acct);
			return new ResponseEntity<>(lstTrns, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ABCOrgException("Account Number is not Found.");
		}
		
	}

}
