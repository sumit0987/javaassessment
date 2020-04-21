package com.foodzone.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodzone.dto.UserDto;
import com.foodzone.entity.User;
import com.foodzone.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		if(Objects.isNull(userDto)) {
			throw new RuntimeException("User not created");
		}
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setAddress(userDto.getAddress());
		user.setPhoneNumber(userDto.getPhoneNumber());
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}
