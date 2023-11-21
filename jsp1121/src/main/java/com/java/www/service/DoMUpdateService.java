package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;

public class DoMUpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int result=0;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby="";
		for(int i=0; i<hobbys.length; i++) {
			if(i==0) hobby = hobbys[i];
			else hobby +=","+hobbys[i];
		}
		MemberDto mdto = new MemberDto(id, pw, name, phone, gender, hobby);
		
		//dao접근
		MemberDao mdao = new MemberDao();
		
		//----패스워드를 비교해서 일치하면 업데이트, 불일치하면 업데이트 중단
		//회원정보 1개 가져오기
		MemberDto chDto = mdao.selectOne(id);
		System.out.println("pw"+pw);
		System.out.println("chDto.getPw()"+chDto.getPw());
		//입력된 pw 와 기존pw가 같은지 비교
		if(pw.equals(chDto.getPw())) {
			System.out.println("패스워드 일치,업데이트 진행");
			result= mdao.mUpdate(mdto);
		}else {
			System.out.println("패스워드 불일치,업데이트 중단");
		}
		//----------		
		
		System.out.println("DoMUpdateService result "+result);
		
		//req
		request.setAttribute("result", result);
		
		

	}

}
