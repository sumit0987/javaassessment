package com.bankservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bankservice.entity.TransactionDetails;


public interface TransactionRepository extends CrudRepository<TransactionDetails, Integer> {
	
	@Query(value="select * from TRANSACTION_DETAILS where ACCOUNT_NUMBER=?1  and ROWNUM <=5 order by TRANSACTION_DATE ",nativeQuery=true)
	public List<TransactionDetails> findHistory(Long accountNumber);
}
