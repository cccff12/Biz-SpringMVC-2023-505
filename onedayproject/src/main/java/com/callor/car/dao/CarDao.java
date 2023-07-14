package com.callor.car.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.car.models.CarDto;

public interface CarDao {

	
	
	@Select("SELECT * FROM tbl_car ORDER BY c_seq")
	public List<CarDto> selectAll();
	
	
	public int insert(CarDto carDto);
	
	
	
}
