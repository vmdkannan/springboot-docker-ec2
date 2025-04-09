package com.vk.org.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vk.org.entities.Account;
import com.vk.org.exception.ABCOrgException;
import com.vk.org.services.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET, value = "/accounts", produces = "application/json")
	public ResponseEntity<Object> getAllAccounts() throws ABCOrgException {

		List<Account> lstAccounts = accountService.getAllAccount();

		if (lstAccounts.isEmpty()) {
			throw new ABCOrgException("There is no list of Accounts.");
		}

		return new ResponseEntity<>(lstAccounts, HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}", produces = "application/json")
//	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int eId)
//			throws IdNotFoundException, HttpMessageNotWritableException, MethodArgumentTypeMismatchException {
//
//		try {
//			if (employeeService.findByEmployeeId(eId).size() > 0) {
//				Employee emp = employeeService.getEmployeeById(eId);
//				return new ResponseEntity<>(emp, HttpStatus.OK);
//			} else {
//				throw new IdNotFoundException(eId);
//			}
//
//		} catch (HttpMessageNotWritableException e) {
//			throw new HttpMessageNotWritableException(e.getMessage());
//		} catch (MethodArgumentTypeMismatchException e) {
//			throw new MethodArgumentTypeMismatchException(e.getValue(), e.getRequiredType(), e.getName(),
//					e.getParameter(), e.getCause());
//		} 
////		catch (Exception e) {
////			return new ResponseEntity<>("Request is not valid.", HttpStatus.BAD_REQUEST);
////		}
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/employeesByBank/{id}", produces = "application/json")
//	public ResponseEntity<Object> findEmployeesByBankId(@PathVariable("id") int bId)
//			throws IdNotFoundException, HttpMessageNotWritableException, MethodArgumentTypeMismatchException {
//
//		try {
//			if (employeeService.findEmployeesByBankId(bId).size() > 0) {
//				List<Employee> lstEmployees = employeeService.findEmployeesByBankId(bId);
//				return new ResponseEntity<>(lstEmployees, HttpStatus.OK);
//			} else {
//				throw new IdNotFoundException(bId);
//			}
//
//		} catch (HttpMessageNotWritableException e) {
//			throw new HttpMessageNotWritableException(e.getMessage());
//		} catch (MethodArgumentTypeMismatchException e) {
//			throw new MethodArgumentTypeMismatchException(e.getValue(), e.getRequiredType(), e.getName(),
//					e.getParameter(), e.getCause());
//		} 
////		catch (Exception e) {
////			return new ResponseEntity<>("Request is not valid.", HttpStatus.BAD_REQUEST);
////		}
//	}
//
//	@RequestMapping(value = "/employees", method = RequestMethod.PUT)
//	public ResponseEntity<Object> updateProduct(@RequestBody Employee empUp) {
//
//		try {
//			if (employeeService.findByEmployeeId(empUp.getEmployeeId()).size()>0) {
//				employeeService.updateEmployee(empUp);
//				return new ResponseEntity<>("Employee is updated successfully", HttpStatus.OK);
//			}else {
//					throw new IdNotFoundException(empUp.getEmployeeId());
//			}
//
//		} catch (HttpMessageNotWritableException e) {
//			throw new HttpMessageNotWritableException(e.getMessage());
//		} catch (MethodArgumentTypeMismatchException e) {
//			throw new MethodArgumentTypeMismatchException(e.getValue(), e.getRequiredType(), e.getName(),
//					e.getParameter(), e.getCause());
//		} 
////		catch (Exception e) {
////			return new ResponseEntity<>("Employee is not found!", HttpStatus.BAD_REQUEST);
////		}
//
//	}
}
