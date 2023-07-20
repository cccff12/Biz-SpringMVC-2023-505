package com.callor.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.car.model.UserDto;
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

	/*
	 * 회원가입 절차 1. user table에 현재 입력된 user가 있는가 검사 true: 있다면 현재 추가할 사용자의 ROLE =
	 * "USER" false: 현재 추가할 사용자의 ROLE = "ADMIN"
	 * 
	 * 2. 입력한 비밀번호를 암호화 하기 3. Dao.insert() 하기
	 */
	@Override
	public int join(UserDto userDto) {
		int userCount = userDao.userCount();
		if (userCount > 0) {
			userDto.setU_role("USER");
		} else {
			userDto.setU_role("ADMIN");
		}
		return userDao.insert(userDto);

	}

	/*
	 * 
	 * 
	 * login을 요청받았을 때 username 이 없는경우, username은 있는데 password가 틀린경우 username 도 있고
	 * password도 맞는데 아직 로그인이 승인되지 않은 경우
	 * 
	 * 
	 * 
	 */
//	throws Exception 를 컨트롤러에게 전달
	@Override
	public UserDto login(UserDto userDto) throws Exception {
		
		
		if(userDto.getUsername().isBlank()) {
			 throw new Exception("USER_EMPTY");
		}else if(userDto.getPassword().isBlank()) {
			throw new Exception("PASSWORD_EMPTY");
		}
		
		UserDto resultDto = userDao.findById(userDto.getUsername());

		// username이 없는경우
		if (resultDto == null) {
		/*
		 * throw : 나를 호출 한 곳으로 Exception 을 되돌린다.
		 * 		Exception 던진다. toss한다
		 * 	new Exception() : 새로운 Exception
		 * 		강제로 Exception 을 만들어서 Controller 에게 보내버리기
		 */
			
			throw new Exception("USERNAME");
		}
//		username은 있는데 비밀번호가 다를 경우
		else if (resultDto != null && !userDto.getPassword().equals(resultDto.getPassword())) {
			throw new Exception("PASSWORD");
		}

		return resultDto;
	}
}
