package com.callor.file.dao;

import com.callor.file.model.BBsDto;
// <BBsDto, Long>는 genericDao의  <DTO, PK> 이 부분에 해당한다

/*
 * GenericDao를 상속받으면서 DTO대신 BBSDto를 부착하고
 * pk대신 Long 을 부착하여 메서드를 모두 생성하라
 */
public interface BBsDao extends GenericDao<BBsDto, Long> {

	public void create_bbs_table(String dumy);
}
