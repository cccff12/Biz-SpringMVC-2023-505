package com.callor.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.callor.rent.models.RentBookVO;
import com.callor.rent.service.RentBookService;

import lombok.extern.slf4j.Slf4j;

/*
 * localhost:8080/rent/rent 또는 localhost:8080/rent/rent/* 로 요청이 들어왔을 때
 * Browser 에 주소를 입력하거나 nav 항목을 클릭했을 때 
 * 서비스를 제공할 시작점이다. 
 */

//	여기 controller는  입력화면을 여러페이지로 나눠 나중에 한 번에 보여주고 싶을 때 쓸 수 있다.

//	SessionAttributes: 지금부터 별도 지시가 있을 때까지 RENT_WORK 객체는 지우지 마라
//	서버의 Session 영역에 영구 보관하라
@SessionAttributes("RENT_WORK")
@Slf4j
@Controller
@RequestMapping(value = "/rent")
public class RentController {

	protected final RentBookService rentBookService;

	public RentController(RentBookService rentBookService) {
		super();
		this.rentBookService = rentBookService;
	}

	/*
	 * 2가지의 접근 방식 GET/ context/rent/ GET/ context/rent
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home() {

		return "rent/home";
	}

//	밑의 3개 메서드를 거쳐 제일 밑의 rent_work에 보관된다
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_book";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String work_book(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_member";
	}

	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String work_member(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_complete";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String work_complete(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		log.debug("전달된 데이터", rentBookVO);
		return "redirect:/rent";
	}

//	원래대로라면 사라지지만 위의 SessionAttributes 에 설정한 덕분에 사라지지 않는다
	@ModelAttribute("RENT_WORK")
	public RentBookVO newRentBook() {
		return new RentBookVO();
	}

}
