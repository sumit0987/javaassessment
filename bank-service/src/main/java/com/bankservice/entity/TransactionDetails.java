package com.bankservice.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transaction_details")
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	
	@Temporal(TemporalType.DATE)
    private Date transactionDate;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "accountNumber",nullable = false)
//	private AccountDetails accountDetails;
	
	private long accountNumber;
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	private String transactionType;
	private double transactionAmount;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid",nullable = false)
//	private Customer payee;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

//	public AccountDetails getAccountDetails() {
//		return accountDetails;
//	}
//
//	public void setAccountDetails(AccountDetails accountDetails) {
//		this.accountDetails = accountDetails;
//	}

//	public Customer getPayee() {
//		return payee;
//	}
//
//	public void setPayee(Customer payee) {
//		this.payee = payee;
//	}
	
	
}
