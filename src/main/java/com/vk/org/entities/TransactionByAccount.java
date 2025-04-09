package com.vk.org.entities;

public class TransactionByAccount {
	
	private Integer transactionId;
	
	private String transactionType;
	
	private String transactionAccountNo;
	
	private Double amount;
	
	private String transactionByBank;

	private String employeeName;

	public TransactionByAccount() {
		super();
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionAccountNo() {
		return transactionAccountNo;
	}

	public void setTransactionAccountNo(String transactionAccountNo) {
		this.transactionAccountNo = transactionAccountNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionByBank() {
		return transactionByBank;
	}

	public void setTransactionByBank(String transactionByBank) {
		this.transactionByBank = transactionByBank;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
