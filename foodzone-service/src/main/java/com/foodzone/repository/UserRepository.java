package com.foodzone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodzone.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
