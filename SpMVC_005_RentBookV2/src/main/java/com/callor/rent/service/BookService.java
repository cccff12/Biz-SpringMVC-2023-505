package com.callor.rent.service;

import java.util.List;

import org.springframework.ui.Model;

import com.callor.rent.models.BookDto;

public interface BookService {

	public List<BookDto> selectAll();
	public List<BookDto> selectPage(String page);
	public void selectPage(String page, Model model);

	public int insert(BookDto bookDto);
	public int update(BookDto bookDto);


	public BookDto findById(String bcode);
	public List<BookDto> findByBName(String bname);
	public void selectPage(String page, Model model, String search);

	
	
}
