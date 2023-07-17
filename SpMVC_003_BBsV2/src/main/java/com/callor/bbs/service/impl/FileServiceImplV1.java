package com.callor.bbs.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.bbs.config.QualifierConfig;
import com.callor.bbs.models.FileDto;
import com.callor.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Service("fileServiceV1")
@Service(QualifierConfig.SERVICE.FILE_V1)
public class FileServiceImplV1 implements FileService {

//	서버의 폴더 등 자원(resource)에 접근할때 사용할 객체
	protected final ResourceLoader resourceLoader;
	protected final String filePath;

	public FileServiceImplV1(ResourceLoader resource) {
		super();
		this.resourceLoader = resource;
		this.filePath = "/files";
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
//		filePath: /files
//		/webapp/files 폴더에 대한 정보를 가지고 있는 객체가 된다.
//		/webapp 폴더는 단순한 방법으로 정보를 가져올 수 없다.
//		그래서 ResourceLoader 라는 객체를 사용하여 
//		관련 정보를 가져온다
//		resourceLoader로 가져온 파일은 서버를 클린하면 사라진다@@@@@@@@
		Resource res = resourceLoader.getResource(filePath);

		// Tomcat / Project 서버의 files라는 폴더 정보
		// 파일을 업로드 할 폴더이름을 savePath 변수에 저장하기
		String savePath = res.getURI().getPath();

		// 업로드 할 파일 이름
		String originalFileName = file.getOriginalFilename();

		// Tomcat / Project 서버의 files 폴더와 파일이름을 사용하여
		// File(upLoadFile) 이라는 객체를 생성한다.
		File upLoadFile = new File(savePath, originalFileName);

		log.debug(upLoadFile.getAbsolutePath());

//		MultipartFile 아 upLoadFile 정보를 참조하여 
//		서버로 파일을 전송하라
		file.transferTo(upLoadFile);

		return originalFileName;
	}

//	멀티파일 업로드 메서드
	@Override
	public List<FileDto> filesUp(MultipartHttpServletRequest files) throws Exception {

		List<MultipartFile> fileList = files.getFiles("b_image");
		/*
		 * 멀티파일을 각 파일로 분리하여 fileUp() 에게 파일을 업로드하도록
		 * 요청하고, 원본이름과 변경된 이름을 받아서 returnFiles 를 만들기
		 */
		List<FileDto> returnFiles = new ArrayList<FileDto>();		
				for(MultipartFile file : fileList) {
					FileDto fileDto = new FileDto();
//					원본파일 이름을 매개변수로
					fileDto.setI_originalName(file.getOriginalFilename());
					fileDto.setI_uploadName(this.fileUp(file));
					returnFiles.add(fileDto);
				}

				return returnFiles; 
			
	
	}

	@Override
	public String delete(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
