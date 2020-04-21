package com.foodzone.service;

import com.foodzone.dto.UserDto;
import com.foodzone.entity.User;

public interface UserService {
	public User saveUser(UserDto userDto);
}
