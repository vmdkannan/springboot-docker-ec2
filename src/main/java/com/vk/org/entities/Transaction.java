package com.vk.org.entities;


import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trans_id")
	private Integer transactionId;
	
	@Column(name="trans_type")
	private String transactionType;
	
	@Column(name="trans_account_no")
	private String transactionAccountNo;
	
	@Column(name="amount")
	private Double amount;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bank_id")
	private Bank transactionByBank;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	public Transaction() {
		super();
	}

	public Transaction(Integer transactionId, String transactionType, String transactionAccountNo, Double amount,
			Bank transactionByBank, Employee employee) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionAccountNo = transactionAccountNo;
		this.amount = amount;
		this.transactionByBank = transactionByBank;
		this.employee = employee;
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
	
	public Bank getTransactionByBank() {
		return transactionByBank;
	}

	public void setTransactionByBank(Bank transactionByBank) {
		this.transactionByBank = transactionByBank;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}








}
