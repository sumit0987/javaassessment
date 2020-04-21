package com.bankservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account_details")
public class AccountDetails {
	@Id
	private long accountNumber;
	private Double balanceAmount;
	private String accountType;
	private String status;
	private long cardNumber;
	private long cvvNumber;
	
//	@OneToMany(mappedBy="accountDetails")
//	private List<TransactionDetails> transactionList;
	
//	public List<TransactionDetails> getTransactionList() {
//		return transactionList;
//	}
//
//	public void setTransactionList(List<TransactionDetails> transactionList) {
//		this.transactionList = transactionList;
//	}

	@OneToOne(mappedBy="accountDetails")
	private Customer customer;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public long getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(long cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	
	
	
	
}
