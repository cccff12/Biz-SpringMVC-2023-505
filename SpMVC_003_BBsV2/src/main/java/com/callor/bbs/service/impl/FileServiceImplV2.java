package com.callor.bbs.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.bbs.config.QualifierConfig;

import lombok.extern.slf4j.Slf4j;

/*
 * V1 클래스에는 fileup(), filesUp(), delete() method가 있다.
 * 이 method들을 기본적으로 상속받아서 사용하겠다.
 * 
 * V1 클래스에 protected 로 선언된 2개의 변수를 여기에서 상속받아서 사용하겠다.
 * 
 * 클래스를 상속받으때 V1 클래스의 생성자는 상속받지 않는다.
 * 
 * 
 */

@Slf4j
//	spring project에서 Qualifire: Bean 의 id, 이름
@Service(QualifierConfig.SERVICE.FILE_V2)
public class FileServiceImplV2 extends FileServiceImplV1 {

//  fileup-context.xml 에 선언된 2개의 String bean 값을
//	사용할 수 있도록 주입해달라
	protected final String windowsPath;
	protected final String winPath;
	protected final String macHome;
	protected final String macPath;

	public FileServiceImplV2(ResourceLoader resource, String winPath, String macPath, String macHome, String windowsPath) {

		/*
		 * super() : 상속받은 클래스의 생성자에게 무언가를 전달할때 사용하는 method 이자 일종의 전달자 V1 클래스의 생성자에게
		 * resource 객체를 전달하여 final로 선언된 2개의 변수를 초기화 해달라고 요청
		 */

		super(resource);
		this.winPath = winPath;
		this.macHome = macHome;
		this.macPath = macPath;
		this.windowsPath=windowsPath;
	}

	/*
	 * v1의 fileup method를 다시 정의 하겠다
	 */
	@Override
	public String fileUp(MultipartFile file) throws Exception {

		log.debug("win Path : {}", winPath);
		log.debug("mac Path : {}", macPath);

//		String fileUpPath = winPath;
//		File path = new File(macHome);
////		macHome 폴더가 있느냐 묻는 코드		
//		if (path.exists()) {
//			fileUpPath = macHome + macPath;
//		}
//		
//		
		
		String fileUpPath = macHome+macPath;
		File path = new File(windowsPath);
		if(path.exists()) {
			fileUpPath= winPath;
		}
		
		
//		만약 System에 Upload할 path가 없으면 생성하라
		path= new File(fileUpPath);
		if(!path.exists()) {
//		폴더를 만들어라
			path.mkdirs();	
		}
//		실제 업로드 될 파일 이름
		String fileName= file.getOriginalFilename();
		
//		JAVA 에서 제공하는 UUID 생성하는 코드
		String strUUID= UUID.randomUUID().toString();
//		image.jpg0000-0000-0000
		
//		UUID 키 값을 파일이름 앞에 부착하여 새로운 이름으로 변경
		fileName= String.format("%s-%s", strUUID,fileName);
		
		File upLoadFile = new File(fileUpPath,fileName);
		
		file.transferTo(upLoadFile);
		
		return fileName;
	}

}
