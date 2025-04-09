package com.vk.org.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {
	
	@Id
	@GeneratedValue
	@Column(name="bank_id")
	private Integer bankId;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_country")
	private String bankCountry;

	
	public Bank() {
		super();
	}



	public Bank(String bName, String bankCountry) {
		super();
		this.bankName = bName;
		this.bankCountry = bankCountry;
	}


	public String getBankCountry() {
		return bankCountry;
	}

	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}

	public Integer getBankId() {
		return bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
