package com.callor.file.dao;

import java.util.List;

import com.callor.file.model.FileDto;

public interface FileDao extends GenericDao<FileDto, Long> {

	
//	BBS Table과 연계될 SELECT문
	public List<FileDto> findByBSeq(long seq);
	
	public void create_file_table(String dumy);
	
}
