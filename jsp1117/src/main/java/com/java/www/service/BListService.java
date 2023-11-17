package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//dao접근
		BoardDao bdao = new BoardDao();
		ArrayList<BoardDto> list= bdao.bList();
		
		//확인
		System.out.println("BListService list : "+list.get(0).getBno());
		
		
		
		//req
		request.setAttribute("list", list);
		

	}

}
