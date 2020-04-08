package com.cho.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.cho.beans.DataBean1;
import com.cho.validator.DataBean1Validator;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data(DataBean1 dataBean1) {
		
		return "input_data";
	}
	
	@PostMapping("input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		if(result.hasErrors()) {
			return "input_data";
		}
		
		return "input_success";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DataBean1Validator validator1 = new DataBean1Validator();
		// 한개일때
		//binder.setValidator(validator1);
		// 여러개일 때
		binder.addValidators(validator1);
	}
}
