package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.BInsertService;
import com.java.www.service.BListService;
import com.java.www.service.BSelectOneService;
import com.java.www.service.MDoLoginService;
import com.java.www.service.Service;



//1107_02
@WebServlet("*.do")
public class FController extends HttpServlet {
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		//파일이름 찾기
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		System.out.println("파일이름 : "+fileName);
		
		Service service =null;
		String url=null;
		switch (fileName) {
		case "/index.do":
			response.sendRedirect("index.jsp");
			break;
		case "/mInsert.do":
			response.sendRedirect("mInsert.jsp");
			break;
		case "/login.do":
			response.sendRedirect("login.jsp");
			break;
		case "/doLogin.do":// mDoLogin 로그인
			service = new MDoLoginService();
			service.execute(request, response);
			url="doLogin.jsp";
			break;
		case "/logout.do":
			response.sendRedirect("logout.jsp");
			break;
		case "/bList.do":
			service = new BListService();
			service.execute(request, response);
			url="bList.jsp";
			break;
		case "/bView.do": //2.게시글 1개 가져오기 -select
			service = new BSelectOneService();
			service.execute(request, response);
			//확인용
			System.out.println("FController: bView.jsp");
			url="bView.jsp";
			break;
		case "/bInsert.do": //3.게시글 쓰기 화면 
			response.sendRedirect("bInsert.jsp");
			break;
		case "/doBInsert.do"://3.게시글 쓰기 -insert
			service = new BInsertService();
			service.execute(request, response);
			url="doBInsert.jsp";
			break;
			
			
			
			
			
			
			
		}//switch

		
		if(url!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
	
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}


}
