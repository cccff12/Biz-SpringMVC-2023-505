package com.callor.address.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.address.models.AddrDto;
import com.callor.address.models.UserDto;
import com.callor.address.service.AddrService;

import lombok.extern.slf4j.Slf4j;

/*
 * controller class 
 * @controller annotation 이 부착된 class
 * client 로 부터 request(요청) 이 다다르면, 어디로 요청을 전달할지
 * Routing 역할을 하는 class
 */
@Slf4j
@Controller
public class HomeController {

	protected final AddrService addrService;

	public HomeController(AddrService addrService) {
		this.addrService = addrService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(String message, Model model) {

		model.addAttribute("MSG", message);
		List<AddrDto> addrList = addrService.selectAll();
		model.addAttribute("ADDRS", addrList);
		return "home";

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<AddrDto> list() {
		List<AddrDto> addrList = addrService.selectAll();
		return addrList;
	}

	/*
	 * localhost:8080/address/inset로 요청이 오면 addr/input.jsp 파일을 열어서 Response 하도록
	 * method 생성
	 */
//	처음 화면에서 주소추가 버튼을 클릭했을 때 
//	추가 화면을 보여주는 method
	/*
	 * method의 매개변수로 HttpSession 객체를 설정하는 순간 이 method에서 Session 에 저장된 데이터를 참조 할 수
	 * 있다.
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model, HttpSession httpSession) {

//		Session 으로부터 USER Attribute 를 getter 하고 
//		그 데이터를 UserDto type로 변환하여 userDto 객체에 저장
//		로그인이 되어 있으면 userDto는 실제 로그인한 user의 정보
//		로그인이 되어있지 않으면 userDto는 null값이다.
		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto == null) {
			return "redirect:/user/login?error=LOGIN";
		}

		model.addAttribute("BODY", "INPUT");
		/*
		 * Controller 의 method에서 문자열을 return하면 "/views/ 문자열.jsp" 파일을 redering 하여 Client
		 * 로 Response를 하라는 의미
		 */
		return "home";
	}

//produce= controller 에서 만든 한글이 안깨지게 하기 위한 것. (input에서 입력한 한글과는 다름. 그건 web.xml에서 filter를 설정해야함)
//	produce: server 가 browser에 데이터를 응답할때 한글이 포함되어 있으면 encoding을 하여 보내라
//	view에 rendering 을 할때는 의미가 없다
//	@ResponseBody가 설정되어 있을때

	/*
	 * ResponsBody: controller 의 method에 @ResponseBody Annotation이 부가되면 문자열을
	 * 그래로(direct) Client로 Response 하라는 의미
	 */

//	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String insert(@ModelAttribute AddrDto addrDto, Model model, HttpSession httpSession) {

		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto == null) {
			return "redirect:/user/login?error=LOGIN";
		}
		
		addrService.insert(addrDto);
//		데이터를 만들고 view를 생성해 client 에게 response하는 URL이 이미 있으니
//		client 야 한 번 더 요청해라
		return "redirect:/";

	}

	@RequestMapping(value = "/insert/test", method = RequestMethod.GET)
	public String insert() {
		return "addr/input";
	}

//	id가 있는지 확인하는 메서드
	@RequestMapping(value = "/id_check", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(String id) {

		return addrService.idCheck(id);
	}

	/*
	 * localhost:8080/addr/detail?id=A0001 형식으로 request가 오면 id = A0001에 설정된 A0001값을
	 * id 매개변수로 받는다 queryString : ? id=A0001
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(String id, Model model) {
//		request 에 설정된 id값으로 DB table 에서 주소 정보를 SELECT
		AddrDto addrDto = addrService.findById(id);
//		SELECT 된 주소를 model에 담아서 view로 전달		
		model.addAttribute("ADDR", addrDto);
		// home.jsp에 include되어 보여질 화면(변수) 세팅
		model.addAttribute("BODY", "DETAIL");
		return "home";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {

		int result = addrService.delete(id);
		if (result > 0) {
			return "redirect:/";
		} else {
//			삭제에 실패했을 경우 
//			현재 id에 detail화면으로 되돌아가라
			return "redirect:/detail?id=" + id;
		}
	}

//	데이터 update할 화면 보여주기
//	spring 에서는 requestmapping을 참조해 update getter method이라 부른다.
// 값을 넣기 위해 model 사용
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String 메소드이름은안중요함편의상update로쓸뿐(String id, Model model) {
//		BODY 값에 UPDATE값을 저장한다.

//		변경할 주소 데이터 SELECT하여 model에 담기
		AddrDto addrDto = addrService.findById(id);
		model.addAttribute("ADDR", addrDto);
		model.addAttribute("BODY", "UPDATE");
		return "home";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String 메소드이름은구별용(@ModelAttribute AddrDto dto) {

		log.debug(dto.toString());
		int result = addrService.update(dto);
		String id = dto.getA_id();

//		update가 성공하면 detail 화면을 보여서 변경 된 것을 확인
		if (result > 0) {
			return "redirect:/detail?id=" + id;
//		update가 실패하면 다시 update화면으로 보내서 다시 변경하기
		} else {
			return "redirect:/update?id=" + id;
		}

	}

}
