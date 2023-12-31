package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;

public class MInsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse repsonse) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw1");
		String name = request.getParameter("name");
		String f_tell = request.getParameter("f_tell");
		String m_tell = request.getParameter("m_tell");
		String l_tell = request.getParameter("l_tell");
		String phone = f_tell+"-"+m_tell+"-"+l_tell; //010-1111-1111
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby="";
		for(int i=0; i<hobbys.length; i++) {
			if(i==0) hobby = hobbys[i];
			else hobby += ","+hobbys[i];
		}
		
		MemberDto mdto = new MemberDto(id, pw, name, phone, gender, hobby);
		
		//dao접근 -insert
		MemberDao mdao = new MemberDao();
		int result = mdao.mInsert(mdto);
		
		//request
		request.setAttribute("result", result);
		

	}

}
