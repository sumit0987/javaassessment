package com.bankservice.service;

import java.util.List;

import com.bankservice.dto.CustomerDto;
import com.bankservice.dto.FundsTransferDto;
import com.bankservice.entity.TransactionDetails;

public interface BankService {
	public String registerCustomer(CustomerDto customerDto);
	public int transferFunds(FundsTransferDto fundsTransferDto);
	public List<TransactionDetails> getMiniStatement(long accountNumber);
	public List<TransactionDetails> getMonthlyStatement(long accountNumber,String month,String year);
}
