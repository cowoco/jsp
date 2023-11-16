package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	//인터페이스는 미완성 메소드를 가져야함
	//그래서 중괄호 쓰면 안됨
	public void execute(HttpServletRequest request,HttpServletResponse response);
	

}
