package com.cho.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.cho.beans.DataBean;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map,
						@RequestParam List<String> data3) {
		
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data33 = map.get("data3");

		
		System.out.println("data1 : " +data1 );
		System.out.println("data2 : " +data2 );
		System.out.println("data33 : " +data33 );
		
		for(String str : data3) {
			System.out.println("data3 : "+str);
		}
		
		return "result";
	}
	
	@GetMapping("/test2")
	public String test2(@ModelAttribute DataBean bean1) {

		System.out.println("data1 : " + bean1.getData1());
		System.out.println("data2 : " + bean1.getData2());
		for(int num : bean1.getData3()) {
			System.out.println("data3 : "+num);
		}
		return "result";
		
	}
}
