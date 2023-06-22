package com.callor.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.AddressDto;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("나이", 33);
		model.addAttribute("tel", "010-111-1111");
		return "home";
	}

	@RequestMapping(value = "/hello")
	public String hello(Model model) {
		AddressDto addressDto = new AddressDto();
		addressDto.setName("성춘향");
		addressDto.setTel("010-222-2222");
		addressDto.setAge(16);
		addressDto.setAddress("전라북도 남원시");

		model.addAttribute("ADDR", addressDto);
//		WEV=INF/views/hello.jsp를 찾아서 rendering 해 달라
		return "hello";
	}

	@RequestMapping(value = "/user")
	public String user(Model model) {
		List<AddressDto> addrList = new ArrayList<AddressDto>();
		AddressDto addressDto = new AddressDto();
		addressDto.setName("홍길동");
		addressDto.setAge(29);
		addressDto.setAddress("서울");
		addressDto.setTel("010-1111-1111");
		addrList.add(addressDto);

		AddressDto addressDto1 = new AddressDto();
		addressDto1.setName("성춘향");
		addressDto1.setAge(26);
		addressDto1.setAddress("서울");
		addressDto1.setTel("010-1111-1111");
		addrList.add(addressDto1);
		
		AddressDto addressDto2 = new AddressDto();
		addressDto2.setName("옹길동");
		addressDto2.setAge(20);
		addressDto2.setAddress("평양");
		addressDto2.setTel("010-1111-1111");
		addrList.add(addressDto2);
		
		
		
		
		for(AddressDto dto:addrList) {
			System.out.println(dto.toString());
		}
		model.addAttribute("ADDRS",addrList);
		
		return "user2";
	}

}
