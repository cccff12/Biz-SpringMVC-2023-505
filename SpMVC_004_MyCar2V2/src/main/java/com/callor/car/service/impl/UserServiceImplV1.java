package com.callor.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.car.persistance.UserDao;
import com.callor.car.service.UserService;

@Service
public class UserServiceImplV1 implements UserService {

	protected final UserDao userDao;

	public UserServiceImplV1(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	
//	logback 과 mapper, Dao에서 설정하면 자동으로 테이블 생성 가능
//	이때 interface 나 클래스의 method 에서 dao의 메서드를 실행한다. (dao이름은 mapper 의 tag id와 같다)
	@Autowired
	public void create_table() {
		
		try {
			userDao.create_user_table();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
