package com.callor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.service.testservice;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class TestController {

//	value 값은 view 폴더 안에 있으니 /로 시작한다.

	@Autowired
	testservice testservice;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	public String test2(Model model) {
//
//		model.addAttribute("test", model);
//
//		return "test2";
//
//	}

}
