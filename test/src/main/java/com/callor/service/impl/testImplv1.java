package com.callor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.dto.testDto;
import com.callor.service.testservice;
@Service
public class testImplv1 implements testservice {

	@Override
	public List<testDto> test(String str) {
		List<testDto> list = new ArrayList<>();
		testDto testDto = new testDto();

		testDto.setString1("김");
		testDto.setString2("나");
		testDto.setString3("박");
		list.add(testDto);
		
		
		
		testDto testDto2 = new testDto();

		testDto2.setString1("김");
		testDto2.setString2("나");
		testDto2.setString3("박");
		list.add(testDto);

		testDto testDto3 = new testDto();

		testDto3.setString1("김");
		testDto3.setString2("나");
		testDto3.setString3("박");
		list.add(testDto);
		
		return null;
	}

}
