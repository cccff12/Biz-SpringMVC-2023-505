package com.callor.Book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.Book.model.BooksDto;
import com.callor.Book.persistance.BookDao;
import com.callor.Book.service.BookService;


@Service
public class BookServiceImplV1 implements BookService {

	protected final BookDao bookDao;

	public BookServiceImplV1(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	@Override
	public BooksDto findNum(String booknum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BooksDto booksDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public List<BooksDto> selectAll() {
		return bookDao.selectAll();
	}

}
