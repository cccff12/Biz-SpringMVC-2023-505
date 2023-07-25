package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.RentBookDto;

public interface RentBookDao {

	public void create_rent_book_table(String dumy);
	
	@Select(" SELECT * FROM tbl_rent_book ORDER BY RENT_SEQ ")
	public List<RentBookDto> selectAll();
	public RentBookDto findById(long id);

	public List<RentBookDto> fineByBCode(String bcode);
	public List<RentBookDto> fineByMCode(String mcode);

	public int insert(RentBookDto dto);
	public int update(RentBookDto dto);

}
