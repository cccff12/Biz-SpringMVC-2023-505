package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

// impl class에 @Service추가함 
@Service
public class UserServiceImplV1 implements UserService {

	protected Scanner scan;

	/*
	 * List<UserDto> userList 객체를 생성하고 임의로 생성한 3명의 User 정보를 추가하기 UserList를 return 하기
	 * 
	 */

	public UserServiceImplV1() {

		scan = new Scanner(System.in);
	}

	@Override
	public List<UserDto> selectAll() {
		List<UserDto> userlist = new ArrayList();
//		userlist.add(new UserDto(null, null, null, null, null, 0));

		
		//  	setter 를 사용해 데이터 추가
		UserDto dto = new UserDto();
		dto.setUsername("홍길동");
		dto.setPassword("password");
		dto.setTel("010-111-1111");
		dto.setName("홍길동");
		dto.setAddr("서울");
		dto.setAge(17);
		userlist.add(dto);

		dto = new UserDto();
		
		dto.setUsername("이몽룡");
		dto.setPassword("password");
		dto.setTel("010-222-2222");
		dto.setName("이몽룡");
		dto.setAddr("서울");
		dto.setAge(17);
		userlist.add(dto);
		
		dto = new UserDto();
		
		dto.setUsername("성춘향");
		dto.setPassword("password");
		dto.setTel("010-333-3333");
		dto.setName("성춘향");
		dto.setAddr("서울");
		dto.setAge(33);
		userlist.add(dto);

		
//		field 생성자를 사용해 데이터를 추가하기
//		field 생성자를 사용하는 경우 원하는 변수에 값이 
//		정확하게 저장되는지 확인하기 어렵다
//		그러므로 사용 안하는게 좋음
		dto= new UserDto("ddd","12345","임꺽정","010-444-4444","함경도",20);
		userlist.add(dto);
		
		
		
		
		return userlist;

	}

	@Override
	public UserDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int input(UserDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
