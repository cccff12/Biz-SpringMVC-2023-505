package com.callor.Book.service;

import java.util.List;

import com.callor.Book.model.BooksDto;

public interface BookService {
	
	public BooksDto findNum(String booknum);

	public int insert(BooksDto booksDto);

	public List<BooksDto> selectAll();
}
