package com.callor.address.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.address.models.UserDto;
import com.callor.address.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	protected final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home() {
		/*
		 * method의 response 결과를 view 이름을 찾아 return 하면 /WEB-INF/views/폴더에서 파일을 찾아
		 * rendering 한 후 응답을 한다. 그런데 null을 return하면 이 method가 호출된 requestmapping 주소가
		 * view 파일 이름을 대신하게 된다.
		 */
		return null;
	}

	/*
	 * error 매개변수 POST/ user/login 에서 username과 password가 틀릴경우 redirect를 하면서 전달하는
	 * error값을 받기 위한 매개변수 메뉴에서 login 을 실행하면 이 데이터는 null이다. error 매개변수 값은 그대로 model에
	 * 담아서 login.jsp에 보낸다
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("ERROR", error);
		model.addAttribute("BODY", "LOGIN");
		return "home";
	}
//	httpSession :Servlet Session 
//	Java 기반 MVC 프로젝트에서 가장 많이 사용하는 Session 관리 객체
//	method의 매개변수에 HttpSession 객체를 설정하면
//	Spring 에서는 DespatcherServlet이 httpSession 객체를 생성하여
//	method의 매개변수로 전달해 준다.
//	httpSession 객체가 생성되는 순간, 이 프로젝트에는 Session 관리자가 생성된다.

//	Session 은 http 프로토콜에서 Client 와 Server 간에 암묵적으로 
//	데이터를 공유하는 통로가 만들어진다고 보면 된다.

//	이 Session 에 데이터를 저장하면 그 데이터는 model에 데이터를 담는 것과 같이 똑같이 사용이 가능하며 
//	일정 조건 하에서 데이터는 계속해서 유지된다.
//	model에 데이터를 담는것과 차이는 model 데이터는 한 번 view와 rendering 을 수행 한 후 소멸
//	Session 데이터는 특별한 조건하에서는 계속 유지된다.
//	또한 Session 데이터가 필요없을 경우 이 데이터를 강제 소멸시켜야 한다.

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserDto userDto, HttpSession httpSession) {
//		서비스에 dto를 보냄
		String result = userService.userLogin(userDto);
		if (result.equals("OK")) {
			/*
			 * add(): 무한히 데이터를 추가 가능 set(): 제한적으로 데이터를 추가하는 것이 좋다라는 의미(대신 메모리 많이 잡아먹음)
			 * httpsession에 추가한 Attribute는 model에 add한 Attribute와 view 에서 사용하는 것은 거의 동일하다
			 */
			httpSession.setAttribute("USER", userDto);
			return "redirect:/";
		} else {
//			result: FUSERNAME이나 FPASSWORD둘 중 하나
			return "redirect:/user/login?error=" + result;
		}
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return null;
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage() {
		return null;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
//	session 에 저장된 데이터를 clear
		httpSession.setAttribute("USER", null);
//	Session 자체를 모두 소멸
		httpSession.removeAttribute("USER");
		return "redirect:/?message=LOGOUT";

	}

}
