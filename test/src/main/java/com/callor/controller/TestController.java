package com.callor.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class TestController {

	
//	value 값은 view 폴더 안에 있으니 /로 시작한다.
	
	
	@RequestMapping(value = "/test", method=RequestMethod.GET )
	public String test( Model model) {
		
		
		
		
		return "test";
	}
	
	
	
	
	
	
	
	
	
}
