package com.bankservice.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankservice.dto.CustomerDto;
import com.bankservice.dto.FundsTransferDto;
import com.bankservice.entity.TransactionDetails;
import com.bankservice.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	
	@PostMapping("/payment")
	public int transferFunds(@RequestBody FundsTransferDto fundsTransferDto) {
		return bankService.transferFunds(fundsTransferDto);
	}
	
	@PostMapping("/accounts")
	public String openAccount(@RequestBody CustomerDto customerDto) {
		String accountNumber=null;
		accountNumber = bankService.registerCustomer(customerDto);
		if(Objects.isNull(accountNumber)) {
			throw new RuntimeException("Customer not registered");
		}
		return accountNumber;
	}
	
	@GetMapping("/ministatement/{accountNumber}")
	public List<TransactionDetails> getMiniStatement(@PathVariable Long accountNumber) {
		List<TransactionDetails> transactionList = bankService.getMiniStatement(accountNumber);
		if(Objects.isNull(transactionList)||transactionList.size()==0) {
			throw new RuntimeException("Record not found");
		}
		return transactionList;
	}
	
	@GetMapping("/statement/{accountNumber}/{month}/{year}")
	public List<TransactionDetails> getMonthlyStatement(@PathVariable Long accountNumber, @PathVariable String month,@PathVariable String year) {
		List<TransactionDetails> transactionList = bankService.getMonthlyStatement(accountNumber,month,year);
		if(Objects.isNull(transactionList)||transactionList.size()==0) {
			throw new RuntimeException("Record not found");
		}
		return transactionList;
	}
}
