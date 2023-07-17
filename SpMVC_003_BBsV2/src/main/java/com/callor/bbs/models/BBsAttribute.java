package com.callor.bbs.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.web.bind.annotation.ModelAttribute;

/*
 * 날짜 클래스
 * Java에서는 전통적으로 Date, Calender 와 같은 날짜(시간) 관련 
 * 클래스를 가지고 있다. 이 클래스들은 날짜 값에서 여러가지 이슈들이 많이 발견되었다.
 * 또한 java가 업그레이드 되는 동안에 날짜와 관련된 여러가지 문제를
 * 해결하지 모하는 단점이 있었다.
 * 그래서 java 1.8이후에는 LocalDate , LocalTime, LocalDateTime 이라는
 * 새로운 날짜 관련 클래스가 새롭게 만들어졌다,
 * 현재 최신의 java에서는 가급적 
 * Local** 클래스를 사용하여 날짜 관련 문제를 해결하도록 권장하고 있다.
 * 
 * DB와 연동되는 프로젝트에서 날짜 시간 관련된 데이터를 취급하는데 있어서
 * java와 DB 서버간에 데이터 교환에 문제를 일으키기도 한다
 * 보통 DB와 연동을 할때 날짜 형식의 데이터를 사용하지 않고 
 * 문자열로 변환하여 사용한다.
 * 
 */

public class BBsAttribute {

//	원래대로라면 되야 하는데 여기서는 안되고있다 그래서 여기 메서드만 controller의 가장 아래로 그대로 옮겼다.
	
	@ModelAttribute("BBsDto")
	public BBsDto getBBsDto() {
		BBsDto bbsDto = new BBsDto();

		Date date = new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();

//		현재날자와 시간 getter 하기
		LocalDateTime localDateTime = LocalDateTime.now();
		
//		날자를 문자열로 변환하기 위한 pattern 생성
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		시간을 문자열로 변환하기 위한 pattern 생성
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

//		날짜 형식의 데이터를 문자열로 바꾸기
		String strDate = localDateTime.format(dateFormatter);
//		시간형식의 데이터를 문자열로 변환
		String strTime = localDateTime.format(timeFormatter);

		
		bbsDto.setB_date(strDate);
		bbsDto.setB_time(strTime);
		
		return bbsDto;
	}

}
