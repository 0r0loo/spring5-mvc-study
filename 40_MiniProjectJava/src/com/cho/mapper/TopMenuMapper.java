package com.cho.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cho.beans.BoardInfoBean;

public interface TopMenuMapper {

	@Select("SELECT BOARD_INFO_IDX, BOARD_INFO_NAME\r\n" + 
			"	FROM BOARD_INFO_TABLE\r\n" + 
			"	ORDER BY BOARD_INFO_IDX")
	List<BoardInfoBean> getTopMenuList();
	
	
}
