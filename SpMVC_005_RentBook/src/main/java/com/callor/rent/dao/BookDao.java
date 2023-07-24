package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.BookDto;

public interface BookDao {
	
	@Select(" SELECT * FROM tbl_books ORDER BY b_name ")
	public List<BookDto> selectAll();
	
	@Select(" SELECT * FROM tbl_books WHERE b_code = #{id} ")
	public BookDto findById(String id);

	
	public int insert(BookDto bookDto);
	public int update(BookDto bookDto);

//	WHERE b_name LIKE '%' || #{name} || '%'
//	mysql 에서는 문자열 연결시 CONCAT을 쓴다
	@Select(" SELECT * FROM tbl_books WHERE b_name LIKE CONCAT('%'#{name},'%') ORDER BY b_name")	
	public List<BookDto> findByBName(String name);
	
	@Select(" SELECT * FROM tbl_books WHERE b_comp LIKE CONCAT('%'#{comp},'%') ORDER BY b_comp")
	public List<BookDto> findByBComp(String comp);
	
	@Select(" SELECT * FROM tbl_books WHERE b_auther LIKE CONCAT('%'#{auther},'%') ORDER BY b_auther ")
	public List<BookDto> findByBAuther(String auther);

	// mapper의 테이블 생성, mapper를 먼저 만든다
	public void creat_book_table(String dumy);

}