package com.callor.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.bbs.models.FileDto;

public interface FileDao {
//	파일이 여러개라 리스트를 매개변수로 갖는다
//	여러개 파일을 insert하는 방법
	
//	insert를 여러개 하는 방법은 보통 for문을 쓰지만 mybatis에 다른 방법이 있다.
	public int insert(
			@Param("list")List<FileDto> files, 
			@Param("b_seq") long b_seq);

	public List<FileDto> selectAll();

	@Select("SELECT * FROM tbl_images WHERE i_seq = #{id}")
	public FileDto findByid(long id);
	
//	게시판과 연결할때 사용할 method
	@Select("SELECT * FROM tbl_images WHERE i_bseq = #{b_seq}")
	public List<FileDto> findByBseq(long b_seq);

	@Delete("DELETE FROM tbl_images WHERE i_seq = #{seqNum}")
	public int delete(long seqNum);

	
}
