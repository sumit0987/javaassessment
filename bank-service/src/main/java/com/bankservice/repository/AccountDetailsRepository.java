package com.bankservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bankservice.entity.AccountDetails;

@Repository
public interface AccountDetailsRepository extends CrudRepository<AccountDetails, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE account_details SET balance_amount = ?2 where account_number=?1",nativeQuery = true)
    public int updateAccountDetails(long accountNumber, double balance);
	
	@Query(value="select * from account_details where userid=?",nativeQuery = true)
	public AccountDetails findAccountDetails(int customeerId);
	
	public AccountDetails findAccountDetailsBycardNumber(long cardNumber);
	
	public AccountDetails findByAccountNumber(long accountNumber);
	
}
