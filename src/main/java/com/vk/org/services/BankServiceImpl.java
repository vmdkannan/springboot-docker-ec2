package com.vk.org.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.org.dao.BankDao;
import com.vk.org.entities.Bank;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDao bankDao;
	
	public List<Bank> getAllBanks(){
		return (List<Bank>) bankDao.getAllBanks();
	}

	@Override
	public Bank getBankById(int bId) {
		return bankDao.getBankById(bId);
	}

	@Override
	public Bank addBank(Bank bank) {
			return bankDao.addBank(bank);
	}

	@Override
	public List<Bank> findByBankCountry(String bankcountry) {
		
		return bankDao.findByBankCountry(bankcountry);
	}

	@Override
	public List<Bank> findByBankName(String bankcountry) {
		return bankDao.findByBankName(bankcountry);
	}

	@Override
	public List<Bank> findByBankId(Integer bankid) {
		return bankDao.findByBankId(bankid);
	}

}
