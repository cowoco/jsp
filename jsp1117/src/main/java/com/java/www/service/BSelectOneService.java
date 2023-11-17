package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class BSelectOneService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//dao
		int bno =Integer.parseInt(request.getParameter("bno"));
		BoardDao bdao = new BoardDao();
		BoardDto bdto = bdao.selectOne(bno);
		
		//request 추가
		request.setAttribute("bdto", bdto);
	}

}
