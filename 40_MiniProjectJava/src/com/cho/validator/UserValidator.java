package com.cho.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cho.beans.UserBean;

public class UserValidator implements Validator{

	// UserBean값들 유효성검사할꺼임
	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean)target;
		
		String beanName = errors.getObjectName();
		System.out.println(beanName);
		
		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
			
			
			
			// 가입할때
			if(beanName.equals("joinUserBean")) {
				if(userBean.isUserIdExist() == false) {
					errors.rejectValue("user_id", "DontCheckUserIdExist");
				}
			}
		}
	}

	
}
