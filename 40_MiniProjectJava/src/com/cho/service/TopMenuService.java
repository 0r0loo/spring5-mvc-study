package com.cho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cho.beans.BoardInfoBean;
import com.cho.dao.TopMenuDao;

@Service
public class TopMenuService {

	@Autowired
	private TopMenuDao topMenuDao;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList =  topMenuDao.getTopMenuList();
		return topMenuList;
	}
}
