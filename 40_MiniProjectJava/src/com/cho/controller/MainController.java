package com.cho.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cho.beans.BoardInfoBean;
import com.cho.beans.ContentBean;
import com.cho.service.MainService;
import com.cho.service.TopMenuService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;
	
	@Autowired
	private TopMenuService topMenuService;
	
	@GetMapping("/main")
	public String main(Model model) {

		ArrayList<List<ContentBean>> lists = new ArrayList<List<ContentBean>>();
		
		for(int i = 1; i <= 4; i++) {
			List<ContentBean> list = mainService.getMainList(i);
			lists.add(list);
		}
		
		model.addAttribute("lists", lists);
		
		List<BoardInfoBean> board_list = topMenuService.getTopMenuList();
		model.addAttribute("board_list", board_list);
		
		return "main";
	}
	
	
	
	
	
}
