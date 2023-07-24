package com.callor.Book.service;

import com.callor.Book.model.UsersDto;

public interface UserService {
	
	public int join(UsersDto userDto);

	public UsersDto login(UsersDto userDto)throws Exception;
}
