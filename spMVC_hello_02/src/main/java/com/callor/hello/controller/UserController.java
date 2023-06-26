package com.callor.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

@Controller
public class UserController {
//	리스트를 추가하기 위해 @Autowired를 추가함
//	이걸 하기 전 impl class에 @service추가 해주면 나머지는 spring 에서는 알아서 해줌
	@Autowired
	protected UserService userService;

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public String userList(Model model) {
		List<UserDto> userList = userService.selectAll();
		model.addAttribute("USERS", userList);
		return "user/list";

	}

	@RequestMapping(value = "/user/input", method = RequestMethod.GET)
	public String userinput() {
		return "user/input";
	}

	
	
	
	
}
