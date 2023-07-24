package com.callor.Book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
	private String u_code;//	VARCHAR(6)
	private String u_name;//	VARCHAR(125)
	private String u_tel;//	VARCHAR(125)
	private String u_addr;//	VARCHAR(125)

}
