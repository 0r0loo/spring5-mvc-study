package com.cho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	// MessageSource를 주입 받는다
	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	
	
	@GetMapping("/test1")
	public String test1() {
		String a1 = res.getMessage("aaa.a1", null, null);
		String b1 = res.getMessage("bbb.b1", null, null);
		
		System.out.println(a1);
		System.out.println(b1);
		return "test1";
	}
}
