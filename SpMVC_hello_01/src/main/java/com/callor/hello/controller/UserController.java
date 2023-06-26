package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.UserDto;

import lombok.extern.slf4j.Slf4j;

/*
 * class를 만들고 @Controller 라는 annotation 을 부착하면
 * spring framwork에서 자동으로 이 클래스에 controller 기능을 부여한다.
 * 
 * controller class 는 web applcation에서 Request를 가장 먼저 수신하는 객체이다.
 * 
 * 이 클래스에 method를 선언하고 method에 @Request Annotation을
 *  부착하면 Web의 URL(URI)를 처리하는 method가 된다.
 */
@Slf4j
@Controller
public class UserController {

//	http://localhost:8080//hello/user/login 으로 Request를 하면 
//	처리할 method이다 라는 선언
//	method =GET => 브라우저의 주소창에 URL을 입력해 요청 또는 a tag의 href에 주소를 연결하여 요청
//	일반적인 (결과)화면을 요청하거나 할때 
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

// method= POST=> form으로 감싼 input data를 보낼 때 주로 사용
//	form tag의 method 속성을 반드시 POST로 지정해야 한다
//	데이터를 서버로 보낼때 사용하는 Request
//	클라이언트에서 보낸 username변수, password변수에 담긴
//	데이터를 보낼 때는 method의 매개변수를 설정해 주면된다.
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String login(String username, String password, Model model) {
		model.addAttribute("name", username);
		model.addAttribute("password", password);
		return "login_ok";

	}
	
// join.jsp의 form을 열기 위한 메서드
	@RequestMapping(value = "/user/join", method = RequestMethod.GET)
	public String join() {
//		method에서 String 값을 return하면
//		views 폴더에서 해당 String 의 jsp 파일을 찾아
//		rendering을 실행한다.
//		method에서 null값을 return하면
//		views폴더에서 requestmapping 과 같은 path위치에서
//		jsp파일을 찾는다
//		/views/user/join.jsp를 찾는다.
		
		return null;
	}
	/*
	 * Spring에서 web에서 여러가지 데이터를 받을 경우 
	 * 모든 변수를 매개변수로 선언하지 않고 
	 * Dto 클래스를 선언하고 DTO클래스, 객체를 매개변수로 선언한다.
	 * @ModelAttribute 속성을 지정한다
	 *  
	 * Spring framework의 도구들이 
	 * form 에서 전달된 데이터를 Dto 객체에 자동으로 담아준다
	 * "java 코딩에서 method 에 전달할 데이터가 2개를 초과하면 무조건 Dto를 만들자"
	 * 
	 * @ModelAttribute속성은 현재 Spring Framework 에서는 선택사항이지만 오래된 
	 * springframework 에서는 필수 항목이다.
	 * 그래서 선택사항이지만 부착하는 습관을 들이자
	 */
	
	@RequestMapping(value = "/user/join", method = RequestMethod.POST)
	public String join(@ModelAttribute UserDto user, Model model) {
	model.addAttribute("USER", user);
//		web project에서 console에 출력하여 확인하고자 할 때
//	 절대 아래 코드 금지
System.out.println(user.toString());

//	Spring Project 에서는 Console에 출력을 이렇게 함
//	logback을 사용해 console에 확인 메세지 출력하기
	log.debug(user.toString());
	
	return "user/join_ok";
	}

}
