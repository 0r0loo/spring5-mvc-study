package com.cho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import com.cho.beans.DataBean1;
import com.cho.beans.DataBean2;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {

	
	// 타입을 통한 주입
	@Bean
	@ApplicationScope // 서버가  가동될 때 주입됨
	public DataBean1 applicationBean1() {
		return new DataBean1();
	}
	// 이름을 통한 주입
	@Bean("applicationBean2")
	@ApplicationScope
	public DataBean2 applicationBean2() {
		return new DataBean2();
	}
}
