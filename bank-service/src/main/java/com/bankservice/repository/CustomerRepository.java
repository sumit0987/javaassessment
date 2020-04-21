package com.bankservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bankservice.entity.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}