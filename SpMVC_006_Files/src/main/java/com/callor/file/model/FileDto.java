package com.callor.file.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDto {

	private long f_seq;// BIGINT PRIMARY key AUTO_INCREMENT,
	private long f_bseq;// BIGINT,
	private String f_image;// VARCHAR(255),
	private String f_origin_image;// VARCHAR(255)
	
	
}
