package com.callor.car.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.car.model.CarDto;
import com.callor.car.service.CarService;

import lombok.extern.slf4j.Slf4j;

// log.debug쓰기 위한 annotation
@Slf4j
@Controller
public class HomeController {

	protected final CarService carService;

//	필드생성자 만든 후 service와 연결하기
	public HomeController(CarService carService) {
		super();
		this.carService = carService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(
//			모델 attribute를 쓰지 않아도 알아서 잘 담아준다
			@ModelAttribute("CAR") CarDto carDto) {
		log.debug("나는 홈 콘트롤러");
		return "home";
	}

//	입력창은 이미 home에서 보여주고 있으니 get을 안만들고 바로 post생성
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute("CAR") CarDto carDto) {
		return "redirect:/";
	}

	/*
	 * 문자열을 return 히여 views 폴더의 JSP와 Rndering 하는 절차를 생략하고 데이터를 있는 그대로 Client에게 보내라
	 * 
	 * json으로 보내는 방법
	 * 
	 * CarDto 객체에 담긴 데이터를 JSON 객체로 변환하여 Client 로 전송하라 pom.xml 에 jackson-bind 를 설치해
	 * 두어야 한다.
	 */

	@ResponseBody
	@RequestMapping(value = "/car_check", method = RequestMethod.GET)
	public CarDto findTachoByCarNum(String carnum) {
		log.debug("차량번호 : {} ", carnum);
		CarDto carDto = carService.findTachoByCarNum(carnum);

		if (carDto == null) {
			carDto = CarDto.builder().c_carnum("NOT").build();
		}
		log.debug("차량정보 : {} ", carDto);
		return carDto;
	}

	@ModelAttribute("CAR")
	public CarDto carDto() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		String strDate = dateFormat.format(date);
		String strTime = timeFormat.format(date);

		CarDto carDto = CarDto.builder().c_sdate(strDate).c_stime(strTime).c_username("callor").c_qty("시작")
				.c_carnum("111가1234").build();

		return carDto;
	}

}
