package com.callor.file.dao;

import java.util.List;

/*
 * generic type 인터페이스
 * <DTO, PK>을 generic type이라고 부른다.
 * 
 * 이 인터페이스는 다른 Dao를 만들때 부모 인터페이스 역할을 수행한다.
 * <DTO, PK> : 제네릭 타입의 변수 선언
 * 이 인터페이스를 상속 받을 때 자신이 사용할 DTO클래스와 PK변수를 
 * 제네릭에 설정해주면
 */
public interface GenericDao<DTO, PK> {

	
	public List<DTO> selectAll();
	public DTO findById(Long id);
	
	public int insert(DTO Dto);
	public int update(DTO Dto);
	
	public int delete(PK id);
}
