package com.cho.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.cho.beans.ContentBean;

public interface BoardMapper {
	
	// 게시글 작성에 content_idx 넣기용
	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx", before = true, resultType = int.class)

	// 게시글 작성
	@Insert("insert into content_table(content_idx, content_subject, content_text, " +
			"content_file, content_writer_idx, content_board_idx, content_date) " +
			"values (#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " +
			"#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);
	
	
	// 게시판 이름 가져오기
	@Select("SELECT BOARD_INFO_NAME\r\n" + 
			"	FROM BOARD_INFO_TABLE\r\n" + 
			"	WHERE BOARD_INFO_IDX = #{BOARD_INFO_IDX}")
	String getBoardInfoName(int board_info_idx);
	
	
	// 게시글 뿌리기
	@Select("SELECT A1.CONTENT_IDX, A1.CONTENT_SUBJECT, A2.USER_NAME AS content_writer_name, TO_CHAR(A1.CONTENT_DATE, 'YYYY-MM-DD') AS content_date\r\n" + 
			"	FROM CONTENT_TABLE A1, USER_TABLE A2\r\n" + 
			"	WHERE A1.CONTENT_WRITER_IDX = A2.USER_IDX\r\n" + 
			"		AND A1.CONTENT_BOARD_IDX = #{BOARD_INFO_IDX}\r\n" + 
			"			ORDER BY A1.CONTENT_IDX DESC")
	List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds);
	
	
	// 게시글 보기
	@Select("SELECT A2.USER_NAME AS CONTENT_WRITER_NAME, TO_CHAR(A1.CONTENT_DATE, 'YYYY-MM-DD') AS CONTENT_DATE,\r\n" + 
			"		A1.CONTENT_SUBJECT, A1.CONTENT_TEXT, A1.CONTENT_FILE, A1.CONTENT_WRITER_IDX \r\n" + 
			"	FROM CONTENT_TABLE A1, USER_TABLE A2\r\n" + 
			"	WHERE A1.CONTENT_WRITER_IDX = A2.USER_IDX\r\n" + 
			"	AND CONTENT_IDX = #{content_idx}")
	ContentBean getContentInfo(int content_idx);
	
	// 글 수정 업데이트
	@Update("update content_table "+
			"set content_subject = #{content_subject}, content_text = #{content_text}, "+
			"content_file = #{content_file, jdbcType=VARCHAR} "+
			"where content_idx = #{content_idx}")
	void modifyContentInfo(ContentBean modifyContentBean);

	// 게시글 삭제하기
	@Delete("delete from content_table where content_idx = #{content_idx}")
	void deleteContentInfo(int content_idx);
	
	
	// 페이징을 위한
	@Select("select count(*) from content_table where content_board_idx = #{content_board_idx}")
	int getContentCnt(int content_board_idx);
	
}







