package com.callor.Book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooksDto {
	private String b_code;//	VARCHAR(6)
	private String b_name;//	VARCHAR(125)
	private String b_auther;//	VARCHAR(125)
	private String b_comp;//	VARCHAR(125)
	private int b_year;//	INT
	private int b_iprice;//	INT
	private int b_rprice;//	INT

}
