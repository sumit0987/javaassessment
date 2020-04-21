package com.bankservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankservice.dto.CustomerDto;
import com.bankservice.dto.FundsTransferDto;
import com.bankservice.entity.AccountDetails;
import com.bankservice.entity.Customer;
import com.bankservice.entity.TransactionDetails;
import com.bankservice.exceptionhandler.ParameterInvalidException;
import com.bankservice.repository.AccountDetailsRepository;
import com.bankservice.repository.CustomerRepository;
import com.bankservice.repository.TransactionRepository;
import com.bankservice.utils.BankServiceUtility;

@Service
public class BankServiceImpl implements BankService {

	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AccountDetailsRepository accountDetailsRepo;
	
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	BankServiceUtility fundsUtil;
	
	@Override
	@Transactional
	public String registerCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		System.out.println("Inside registerCustomer");
		Customer customer = new Customer();
		if(Objects.isNull(customerDto)) {
			throw new ParameterInvalidException("Incoming request not valid...");
		}
		customer.setAadharno(customerDto.getAadharno());
		customer.setAge(customerDto.getAge());
		customer.setGender(customerDto.getGender());
		customer.setName(customerDto.getName());
		customer.setPanno(customerDto.getPanno());
		
		// cust= customerRepo.save(customer);
		
//		if(Objects.isNull(cust)) {
//			throw new RuntimeException("Customer not registered");
//		}
		Long accountNumber=(long) 0;
		Long cardNumber=(long) 0;
		long cvvNumber=0;
		accountNumber=fundsUtil.generateRandom(12);
		cardNumber=fundsUtil.generateRandom(16);
		cvvNumber=fundsUtil.generateRandom(3);
		if(Objects.isNull(accountNumber)||Objects.isNull(cardNumber)||Objects.isNull(cvvNumber)) {
			throw new RuntimeException("Account Number not genearted, pls try again");
		}
		System.out.println("Account Number :"+accountNumber);
		AccountDetails accntDetails = new AccountDetails();
		accntDetails.setAccountNumber(accountNumber);
		accntDetails.setStatus("created");
		accntDetails.setBalanceAmount(10000.00);
		accntDetails.setCardNumber(cardNumber);
		accntDetails.setCvvNumber(cvvNumber);
		customer.setAccountDetails(accntDetails);
		Customer cust = customerRepo.save(customer);
		//AccountDetails acc = accountDetailsRepo.save(accntDetails);
		if(Objects.isNull(cust)) {
			throw new RuntimeException("Account not created, pls try again");
		}
		return String.valueOf(cust.getAccountDetails().getAccountNumber());
	}

	@Override
	@Transactional
	public String transferFunds(FundsTransferDto fundsTransferDto) {
		// TODO Auto-generated method stub
		int customerId=0;
		int payeeId=0;
		double amount=0.00;
		double accountBalance=0.00;
		if(Objects.isNull(fundsTransferDto)) {
			throw new RuntimeException("Bad request......");
		}
		
		amount = fundsTransferDto.getTransferAmount();
		AccountDetails payeeAccount = accountDetailsRepo.findAccountDetailsBycardNumber(fundsTransferDto.getCardNumber());
		if(Objects.isNull(payeeAccount)) {
			throw new RuntimeException("Invalid payment details");
		}
		if(payeeAccount.getCvvNumber()!=fundsTransferDto.getCvvNumber() || payeeAccount.getBalanceAmount()<fundsTransferDto.getTransferAmount()) {
			throw new RuntimeException("Invalid payment details");
		}
		
		accountBalance = payeeAccount.getBalanceAmount();
		accountDetailsRepo.updateAccountDetails(payeeAccount.getAccountNumber(),payeeAccount.getBalanceAmount()-amount);
		
		TransactionDetails fundsTransaction = new TransactionDetails();
		fundsTransaction.setTransactionDate(new Date());
		fundsTransaction.setAccountNumber(payeeAccount.getAccountNumber());
		fundsTransaction.setTransactionAmount(amount);
		fundsTransaction.setTransactionType("debit");
		transactionRepo.save(fundsTransaction);
		
		return "Funds transferred";
	}
	
	@Override
	public List<TransactionDetails> getMiniStatement(long accountNumber) {
		// TODO Auto-generated method stub
		AccountDetails account = accountDetailsRepo.findByAccountNumber(accountNumber);
		if(Objects.isNull(account)) {
			throw new RuntimeException("Transaction history does not exxist");
		}
		return transactionRepo.findHistory(accountNumber);
	}
	
	@Override
	public List<TransactionDetails> getMonthlyStatement(long accountNumber, String month, String year){
		List<TransactionDetails> transactionList = new ArrayList<TransactionDetails>();
		return transactionList;
	}

}
