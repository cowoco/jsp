package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoMInsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		String name =request.getParameter("name");
		String phone =request.getParameter("phone");
		String gender =request.getParameter("gender");
		String[] hobbys =request.getParameterValues("hobby");
		String hobby="";
		for(int 
				
				i=0; i<hobbys.length; i++) {
			
		}
		
		

	}

}
