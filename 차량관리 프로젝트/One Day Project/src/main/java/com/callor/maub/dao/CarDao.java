package com.callor.maub.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.maub.models.CarDto;

public interface CarDao {

	
	@Select("SELECET * FROM tbl_car ORDER BY c_seq DESC")
	public List<CarDto> selectAll();
	
	
	
	public List<CarDto> findUserSelectLimit();
	
	
	@Select(" SELECT * "
			+ " FROM tbl_car")
	public CarDto findById(String seq);
	
}
