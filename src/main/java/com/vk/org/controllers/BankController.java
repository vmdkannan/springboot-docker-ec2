package com.vk.org.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.vk.org.entities.Bank;
import com.vk.org.exception.EntityExistsException;
import com.vk.org.exception.IdNotFoundException;
import com.vk.org.exception.ABCOrgException;
import com.vk.org.services.BankService;

@RestController
@RequestMapping("/api")
public class BankController {

	@Autowired
	private BankService bankService;

//	@PreAuthorize("hasAnyRole('USER')")
	@RequestMapping(method = RequestMethod.GET, value = "/banks", produces = "application/json")
	public ResponseEntity<Object> getAllBanks() throws ABCOrgException {

		List<Bank> lstBanks = bankService.getAllBanks();

		if (lstBanks.isEmpty()) {
			throw new ABCOrgException("There is no list of banks.");
		}
		return new ResponseEntity<>(lstBanks, HttpStatus.OK);
	}

//	@PreAuthorize("hasAnyRole('USER')")
	@RequestMapping(method = RequestMethod.GET, value ="/banks/{id}", produces = "application/json")
	public ResponseEntity<Object> getBankById(@PathVariable("id") int bId)
			throws IdNotFoundException, HttpMessageNotWritableException, MethodArgumentTypeMismatchException {

		try {
			if (bankService.findByBankId(bId).size() > 0) {
				Bank bnk = bankService.getBankById(bId);
				return new ResponseEntity<>(bnk, HttpStatus.OK);
			} else {
				throw new IdNotFoundException(bId);
			}

		} catch (HttpMessageNotWritableException e) {
			throw new HttpMessageNotWritableException(e.getMessage());
		} catch (MethodArgumentTypeMismatchException e) {
			throw new MethodArgumentTypeMismatchException(e.getValue(), e.getRequiredType(), e.getName(),
					e.getParameter(), e.getCause());
		} 
//		catch (Exception e) {
//			return new ResponseEntity<>("Request is not valid.", HttpStatus.BAD_REQUEST);
//		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/bank", consumes = "application/json")
	public ResponseEntity<Object> addBank(@RequestBody Bank bank)
			throws EntityExistsException, HttpMessageNotWritableException, MethodArgumentTypeMismatchException {

		try {
			if (bankService.findByBankCountry(bank.getBankCountry()).size() > 0
					&& bankService.findByBankName(bank.getBankName()).size() > 0
					|| bankService.findByBankId(bank.getBankId()).size() > 0) {

				throw new EntityExistsException("Bank is already exist in the list.");

			} else {
				bankService.addBank(bank);
				return new ResponseEntity<>("Bank is created.", HttpStatus.CREATED);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Bank is not created.", HttpStatus.BAD_REQUEST);
		}
	}

}
