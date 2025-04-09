
package com.vk.org.dao;

import java.util.List;

import com.vk.org.entities.Bank;


public interface BankDao {
	 
	public List<Bank> getAllBanks();

	public Bank getBankById(int bId);

	public Bank addBank(Bank bank);
	
	public List<Bank> findByBankCountry(String bankcountry);
	
	public List<Bank> findByBankName(String bankcountry);
	
	public List<Bank> findByBankId(Integer bankid);

}
