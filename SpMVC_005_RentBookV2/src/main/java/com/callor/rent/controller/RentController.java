package com.callor.rent.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.rent.models.RentBookVO;
import com.callor.rent.service.RentBookService;

import lombok.extern.slf4j.Slf4j;

/*
 * localhost:8080/rent/rent 또는 localhost:8080/rent/rent/* 로 요청이 들어왔을 때
 * Browser 에 주소를 입력하거나 nav 항목을 클릭했을 때 
 * 서비스를 제공할 시작점이다. 
 */

//	여기 controller는  입력화면을 여러페이지로 나눠 나중에 한 번에 보여주고 싶을 때 쓸 수 있다.

/*
 * Spring 에서 사용할 수 있는 Session 은 2가지 종류가 있다
 * HttpSession: Servlet 차원에서 Http Protocol 상에 구현하는 Session 
 * 		로그인과 관련된 Session 은 이클래스를 사용한다
 * SessionAttributes : Spring Framework 차원에서 구현하는 Session 일반적인
 * 		객체 등을 Session 에 저장하여 
 * 		다양한 기능을 구현하는 목적
 * 
 * Session Server 의 메모리 영역을 일정부분 차지한다
 * 접속자가 많아지면 접속자 만큼 메모리 소모가 일어난다
 * 이때문에 Session 은 꼭 필요한 요소에서만 제한적으로 사용하는 것이 좋다
 * Session을 남발하면 메모리 누수와 보안에 치명적인 문제를 야기할 수 있다.
 */

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

//	  2가지의 접근 방식 GET/ context/rent/ GET/ context/rent
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<RentBookVO> rBooks = rentBookService.selectAll();
		model.addAttribute("RBOOKS",rBooks);
		return "rent/home";
	}

//	밑의 3개 메서드를 거쳐 제일 밑의 rent_work에 보관된다
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String work_book(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_book";
	}

	@RequestMapping(value = "/go/member", method = RequestMethod.POST)
	public String work_member(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO, Model model) {
//		@modelattribute를 사용하지 않을 떄는 데이터 객체를 Model객체에 담아서 
//		view로 전달을 해야한다. 
//		하지만
//		@ModelAttribute 을 사용하면 자동으로 model 객체에 
//		필요한 Attribute 를 자동으로 담아준다
		// model.addAttribute("RENT_WORK",rentBookVO);
		return "rent/work_member";
	}

	@RequestMapping(value = "/go/complete", method = RequestMethod.POST)
	public String work_complete(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_complete";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String work_insert(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO, SessionStatus session) {

		int result = rentBookService.insert(rentBookVO);

		log.debug("전달된 데이터 {}", rentBookVO);
//	SessionAttributes 에 데이터는 계속 남아있기 때문에 
//		사용이 완료된 이후에는 데이터를 clear하는 절차가 필요하다
//		이때 매개변수에서(SessionStatus session) session.setComplete을 실행해주면 된다
		session.setComplete();
		return "redirect:/rent";
	}

//	input에서 입력한 값은 원래대로라면 사라지지만 위의 SessionAttributes 에 설정한 덕분에 사라지지 않는다
//	method에 @modelattribute("객체")가 부착되면 어디선가 객체가 필요할때 자동으로 
//	method가 실행되고 객체가 생성되어 주입된다.
	@ModelAttribute("RENT_WORK")
	public RentBookVO newRentBook() {
//		java 1.8이후의 날짜 시간 관련 클래스 - java는 1.8을 기준으로 다른 세대로 취급한다 . 1.8부터 8로 표기
//		java 1.8이후에서는 Date, Calendar(이전버전) 클래스보다는 Local** 클래스를 적극 사용하기를 권장
//		LocalDate-날짜관련 , LocalTime- 시간관련, LocalDateTime-날짜와 시간관련

//		현재 시간을 저장
		LocalDateTime localDateTime = LocalDateTime.now();
//		현재 날짜의 10일 이후를 저장
		LocalDateTime returnDate = localDateTime.plusDays(10);

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return RentBookVO.builder().rent_date(localDateTime.format(dateFormat))
				.rent_return_date(returnDate.format(dateFormat)).build();
	}

}
