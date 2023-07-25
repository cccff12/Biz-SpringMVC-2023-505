package com.callor.rent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.RentBookDao;
import com.callor.rent.service.RentBookService;

@Service(QualifierConfig.SERVICE.RENT_BOOK_V1)
public class RentBookServiceImplV1 implements RentBookService{

	protected final RentBookDao rentbookDao;

	public RentBookServiceImplV1(RentBookDao rentbookDao) {
		super();
		this.rentbookDao = rentbookDao;
	}

	
	
	
	
	
	@Autowired
	public void createrent() {
		rentbookDao.create_rent_book_table(null);
	}

	
	
	
	
	
	
	
	
	
}
