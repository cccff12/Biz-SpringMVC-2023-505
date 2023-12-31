package com.callor.address.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.address.models.AddrDto;

public interface AddrDao {

	@Select("SELECT * FROM tbl_address ORDER BY a_id")
	public List<AddrDto> selectAll();

	@Select("SELECT * FROM tbl_address WHERE a_id = #{id}")
	public AddrDto findById(String id);

	/*
	 * Dto를 return 할 때와 List 를 return 할 때 만약 찾는 값이 없으면
	 * 
	 * Dto return 할 떈 null 값 List를 return 할때는 empty 값 값이 있는지 없는지 검사할 때는 Dto return
	 * if(dto==null) List return if(list.isEmpty())
	 * 
	 */

	
	public List<AddrDto> findByName(String name);

	public int insert(AddrDto addrDto);

	public int update(AddrDto addrDto);

	@Delete("DELETE FROM tbl_address WHERE a_id = #{id}")
	public int delete(String id);

}
