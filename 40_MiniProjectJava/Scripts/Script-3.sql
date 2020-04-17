create sequence user_seq
start with 0
increment by 1
minvalue 0;

create sequence content_seq
start with 0
increment by 1
minvalue 0;

create table board_info_table(
	board_info_idx number constraint BOARD_INFO_PK primary key,
	board_info_name varchar2(500) not null
);

insert into board_info_table(board_info_idx, board_info_name) values (1, '자유게시판');
insert into board_info_table(board_info_idx, board_info_name) values (2, '유머게시판');
insert into board_info_table(board_info_idx, board_info_name) values (3, '정치게시판');
insert into board_info_table(board_info_idx, board_info_name) values (4, '스포츠게시판');

commit;

create table user_table(
	user_idx number constraint USER_PK primary key,
	user_name varchar2(50) not null,
	user_id varchar2(100) not null,
	user_pw varchar2(100) not null
);

create table content_table(
	content_idx number constraint CONTENT_PK primary key,
	content_subject varchar2(500) not null,
	content_text long not null,
	content_file varchar2(500),
	content_writer_idx number not null
	                   constraint CONTENT_FK1 references user_table(user_idx),
	content_board_idx number not null
	                  constraint CONTENT_FK2 references board_info_table(board_info_idx),
	content_date date not null
);







insert into content_table(content_idx, content_subject, content_text,
			content_file, content_writer_idx, content_board_idx, content_date) 
			values(content_seq.nextval, #{content_subject}, #{content_text}, 
			#{content_file}, #{content_writer_idx}, #{content_board_idx}, sysdate)
			
			
SELECT BOARD_INFO_NAME
	FROM BOARD_INFO_TABLE
	WHERE BOARD_INFO_IDX = 1;
	

SELECT *
	FROM CONTENT_TABLE;
	
-- 게시판에 뿌릴 
SELECT A1.CONTENT_IDX, A1.CONTENT_SUBJECT, A2.USER_NAME AS content_writer_name, TO_CHAR(A1.CONTENT_DATE, 'YYYY-MM-DD') AS content_date
	FROM CONTENT_TABLE A1, USER_TABLE A2
	WHERE A1.CONTENT_WRITER_IDX = A2.USER_IDX
		AND A1.CONTENT_BOARD_IDX = 1
			ORDER BY A1.CONTENT_IDX DESC;

SELECT A2.USER_NAME AS CONTENT_WRITER_NAME, TO_CHAR(A1.CONTENT_DATE, 'YYYY-MM-DD') AS CONTENT_DATE,
		A1.CONTENT_SUBJECT, A1.CONTENT_TEXT, A1.CONTENT_FILE
	FROM CONTENT_TABLE A1, USER_TABLE A2
	WHERE A1.CONTENT_WRITER_IDX = A2.USER_IDX
	AND CONTENT_IDX = 1;






