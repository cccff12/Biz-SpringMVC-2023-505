package com.callor.rent.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//controll + shift +y : 모두 소문자로 바꾸기
//controll + shift +x : 모두 대문자로 바꾸기
//controll + z : undo, 명령 취소하기

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
	
private String	b_code;
private String	b_name;
private String	b_auther;
private String	b_comp;
private int	b_year;
private int b_iprice;
private int b_rprice;
}
