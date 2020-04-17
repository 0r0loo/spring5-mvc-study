package com.cho.service;


import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cho.beans.ContentBean;
import com.cho.beans.PageBean;
import com.cho.beans.UserBean;
import com.cho.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;
	
	@Value("${page.listcnt}")
	private int page_listcnt;
	
	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
	
	@Autowired
	private BoardDao boardDao;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	// 파일을 저장하는 메소드
	private String saveUploadFile(MultipartFile upload_file) {
		// 중복파일이 오면 덮어씀 그래서 시간 앞에 붙혀서 구별해주기
		String file_name = System.currentTimeMillis()+"_"+upload_file.getOriginalFilename();
		
		try {
			upload_file.transferTo(new File(path_upload+"/"+file_name));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return file_name;
	}
	
	public void addContentInfo(ContentBean writeContentBean) {
		System.out.println(writeContentBean.getContent_subject());
		System.out.println(writeContentBean.getContent_text());
		System.out.println(writeContentBean.getUpload_file().getSize());

		MultipartFile upload_file = writeContentBean.getUpload_file();
		
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			System.out.println(file_name);
			writeContentBean.setContent_file(file_name);
			
		}
		
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		
		boardDao.addContentInfo(writeContentBean);
	}
	
	public String getBoardInfoName(int board_info_idx) {
		return boardDao.getBoardInfoName(board_info_idx);
	}
	
	
	public List<ContentBean> getContentList(int board_info_idx, int page){
		
		// 1page -> 0
		// 2page -> 10
		// 3page -> 20
		int start = (page-1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, 10);// (시작, 페이지 하나당 게시글 갯수)
		
		return boardDao.getContentList(board_info_idx, rowBounds);
	}
	
	public ContentBean getContentInfo(int content_idx) {
		return boardDao.getContentInfo(content_idx);
	}
	
	public void modifyContentInfo(ContentBean modifyContentBean) {
		MultipartFile upload_file = modifyContentBean.getUpload_file();
		
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			modifyContentBean.setContent_file(file_name);
		}
		boardDao.modifyContentInfo(modifyContentBean);
	}
	
	public void deleteContentInfo(int content_idx) {
		boardDao.deleteContentInfo(content_idx);
	}
	
	
	public 	PageBean getContentCnt(int content_board_idx, int currentPage) {
		int content_cnt = boardDao.getContentCnt(content_board_idx);
		
		PageBean pageBean = new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		
		return pageBean;
	}
	
}
