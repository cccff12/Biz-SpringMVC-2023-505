package com.callor.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user") // 여기의 모든 value값에 /user 를 넣음 
public class UserController {
//	리스트를 추가하기 위해 @Autowired를 추가함
//	이걸 하기 전 impl class에 @service추가 해주면 나머지는 spring 에서는 알아서 해줌

	@Autowired
	protected UserService userService;
// localhost:8080/hello/user/list 이렇게 도메인을 입력하게 됨
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String userList(Model model) {
		List<UserDto> userList = userService.selectAll();
		model.addAttribute("USERS", userList);
		return "user/list";

	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String userinput() {
		return "user/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String userInput( UserDto userDto, Model model) {		
		model.addAttribute("USER", userDto);
		return "user/view";
	}

}
