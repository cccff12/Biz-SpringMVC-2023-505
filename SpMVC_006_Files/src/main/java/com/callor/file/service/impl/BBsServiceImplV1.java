package com.callor.file.service.impl;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.callor.file.dao.BBsDao;
import com.callor.file.model.BBsDto;
import com.callor.file.service.BBsService;

public class BBsServiceImplV1 implements BBsService {

	protected final BBsDao bbsDao;

	public BBsServiceImplV1(BBsDao bbsDao) {
		super();
		this.bbsDao = bbsDao;
	}

	@Override
	public List<BBsDto> selecAll() {

		return null;
	}

	@Bean
	public void create_table() {
		bbsDao.create_bbs_table(null);
	}

}
