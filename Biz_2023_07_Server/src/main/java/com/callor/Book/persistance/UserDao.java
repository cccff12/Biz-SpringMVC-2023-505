package com.callor.Book.persistance;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

	
	@Select(" SELECT COUNT(*) FROM TBL_USERS ")
	public int userCount();
	
	
	@Delete("DELETE FROM TBL_USERS WHERE U_CODE = #{U_CODE}")
	public int delete(String U_CODE);
	
}
