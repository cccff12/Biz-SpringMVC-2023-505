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
public class RentDto {

	private long r_seq;//	BIGINT
	private String r_date;//	VARCHAR(30)
	private String r_return_date;//	VARCHAR(10)
	private String r_bcode;//	VARCHAR(6)
	private String r_ucode;//	VARCHAR(6)
	private String r_retur_yn;//	VARCHAR(1)
	private int r_point;//	INT

	
	
	
}
