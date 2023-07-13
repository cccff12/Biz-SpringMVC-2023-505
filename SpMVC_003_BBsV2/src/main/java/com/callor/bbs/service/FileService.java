package com.callor.bbs.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/*
 * File Upload를 수행할 Service클래스의 prototype
 * 파일만 서버에 업로드 하기 위한 클래스
 * 
 * 단일 파일 업로드
 * 		1개의 파일을 Request 정보에서 추출하고 
 * 		서버의 폴더에 저장 한 후 파일의 이름을 Return 
 * 
 * 멀티 파일 업로드
 * 		여러개의 파일을 Request 정보에서 추출하고 
 * 		for 반복문을 사용하여 단일 파일 업로드 method에게 보내고 
 * 		단일 파일 업로드 method 가 return한 파일 이름들을 
 * 		List<String>데이터로 만들어 Return하는 method
 * 
 * 파일 삭제 
 * 		서버에 저장된 파일을 삭제하고
 * 		삭제된 파일 이름을 Return
 * 
 * 
 * 파일을 완전 clear
 * 		DB에서 정보가 삭제 되었는데도 불구하고 서버에는 
 * 		실제 파일이 삭제되지 않은 경우가 발생한다.
 * 		이때는 DB정보를 확인하고 파일을 삭제 해 주어야 한다. 
 * 
 */


public interface FileService {

	
	public String 
		fileUp(MultipartFile file) throws Exception;
	
	public List<String>
		filesUp(MultipartHttpServletRequest files) throws Exception;
	
	public String delete(String fileName);
	
	
	
	
	
}
