package com.vk.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vk.org.entities.Bank;
import com.vk.org.repositories.BankRepository;

@Component
public class BankDaoImpl implements BankDao {
	
	@Autowired
	private BankRepository bankRepository;
	
	public List<Bank> getAllBanks(){
		return (List<Bank>) bankRepository.findAll();
	}

	@Override
	public Bank getBankById(int bId) {
		return bankRepository.getOne(bId);
		
	}

	@Override
	public Bank addBank(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public List<Bank> findByBankCountry(String bankcountry) {
		
		return bankRepository.findByBankCountry(bankcountry);
	}

	@Override
	public List<Bank> findByBankName(String bankcountry) {
		return bankRepository.findByBankName(bankcountry);
	}

	@Override
	public List<Bank> findByBankId(Integer bankid) {
		return bankRepository.findByBankId(bankid);
	}
	
	
	
	
	


}
