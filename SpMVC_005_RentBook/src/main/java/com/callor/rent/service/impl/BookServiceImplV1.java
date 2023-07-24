package com.callor.rent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.BookDao;
import com.callor.rent.service.BookService;

// 여기 따로 설정함
@Service(QualifierConfig.SERVICE.BOOK_V1)
public class BookServiceImplV1 implements BookService {

	protected final BookDao bookDao;

	public BookServiceImplV1(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	// 이걸 하면 자동으로 테이블 생성
//	book controller에서 가져옴
	@Autowired
	public void create_table() {
		try {
			bookDao.creat_book_table(null);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
