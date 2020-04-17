package com.cho.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.cho.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{

	// 자바 프로젝트는 Bean을 주입받지 못하니까 생성자로 주입
	
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if(loginUserBean.isUserLogin() == false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/user/not_login");
			return false; // false이면 다음단계로 넘어가지않는다
		}
		return true;
	}
	
}
