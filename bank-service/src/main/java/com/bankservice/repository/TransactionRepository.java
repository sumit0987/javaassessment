package com.bankservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bankservice.entity.TransactionDetails;


public interface TransactionRepository extends CrudRepository<TransactionDetails, Integer> {
	
//	@Query(value="select * from TRANSACTION_DETAILS where ACCOUNT_NUMBER=?1 ORDER BY TRANSACTION_ID DESC LIMIT 5",nativeQuery=true)
//	public List<TransactionDetails> findHistory(Long accountNumber);
	
	List<TransactionDetails> findTop5ByAccountNumberOrderByTransactionIdDesc(long accountNumber);
}
