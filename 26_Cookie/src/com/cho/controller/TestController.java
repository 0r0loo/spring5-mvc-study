package com.cho.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/save_cookie")
	public String save_cookie(HttpServletResponse response) {
		
		try {
			String data1 = URLEncoder.encode("문자열1","utf-8");
			String data2 = URLEncoder.encode("문자열2","utf-8");
			
			Cookie cookie1 = new Cookie("cookie1", data1);
			Cookie cookie2 = new Cookie("cookie2", data2);
			
			// 쿠키 수명
			cookie1.setMaxAge(365*24*60*60);
			cookie2.setMaxAge(365*24*60*60);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return "save_cookie";
	}
	
	// Servlet 방법
	@GetMapping("/load_cookie")
	public String load_cookie(HttpServletRequest request) {
		
		// servlet 방법
		try {
			Cookie [] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				String str = URLDecoder.decode(cookie.getValue(),"utf-8");
				if(cookie.getName().equals("cookie1")) {
					System.out.println("cookie1 : "+ str);
				}else if(cookie.getName().equals("cookie2")) {
					System.out.println("cookie2 : "+ str);
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "load_cookie";
	}
	
	// Spring MVC 방법
	@GetMapping("/load_cookie2")
	public String load_cookie2(@CookieValue("cookie1") String cookie1,
								@CookieValue("cookie2") String cookie2) {
		
		System.out.println("cookie1 : " + cookie1);
		System.out.println("cookie2 : " + cookie2);
		return "load_cookie2";
	}
	
}
