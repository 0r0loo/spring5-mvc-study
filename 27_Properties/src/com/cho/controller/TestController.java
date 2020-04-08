package com.cho.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@PropertySource("/WEB-INF/properties/data1.properties")
//@PropertySource("/WEB-INF/properties/data2.properties")
/*@PropertySource(value = {
		"/WEB-INF/properties/data1.properties",
		"/WEB-INF/properties/data2.properties"
})*/
@PropertySources({
	@PropertySource("/WEB-INF/properties/data1.properties"),
	@PropertySource("/WEB-INF/properties/data2.properties")
})
public class TestController {

	@Value("${aaa.a1}")
	private int a1;
	
	@Value("${aaa.a2}")
	private String a2;
	
	@Value("${bbb.b1}")
	private int b1;
	
	@Value("${bbb.b2}")
	private String b2;
	
	@Value("${ccc.c1}")
	private int c1;
	
	@Value("${ccc.c2}")
	private String c2;
	
	@Value("${ddd.d1}")
	private int d1;
	
	@Value("${ddd.d2}")
	private String d2;
	
	
	
	@GetMapping("/test1")
	public String test1() {
		
		
		System.out.println("a1");
		System.out.println("a2");
		System.out.println("b1");
		System.out.println("b2");
		System.out.println("c1");
		System.out.println("c2");
		System.out.println("d1");
		System.out.println("d2");
		
		
		return "test1";
	}
}
