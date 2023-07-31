package com.callor.file.dao;

import com.callor.file.model.BBsDto;
// <BBsDto, Long>는 genericDao의  <DTO, PK> 이 부분에 해당한다
public interface BBsDao extends GenericDao<BBsDto, Long> {

	public void create_bbs_table(String dumy);
}
