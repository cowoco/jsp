package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.DoMInsertService;
import com.java.www.service.DoMUpdateService;
import com.java.www.service.MDoLoginService;
import com.java.www.service.MUpdateService;
import com.java.www.service.Service;
//1121
@WebServlet("*.do")
public class FController extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		//변수선언 
		request.setCharacterEncoding("utf-8");
		String url=null;
		Service service = null;
		
		
		//호출한 파일이름
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		System.out.println("호출한 파일이름 : "+fileName);
		
		switch (fileName) {
		case "/index.do"://db연결 필요없음
			response.sendRedirect("index.jsp");
			break;
		case "/mInsert.do"://db연결 필요없음
			response.sendRedirect("mInsert.jsp");
			break;
		case "/doMInsert.do"://db연결 
			service = new DoMInsertService();
			service.execute(request, response);
			url="doMInsert.jsp";
			break;
		case "/login.do"://db연결 필요없음
			response.sendRedirect("login.jsp");
			break;
		case "/logout.do"://db연결 필요없음
			response.sendRedirect("logout.jsp");
			break;
		case "/doLogin.do":
			//MDologinService접근
			service = new MDoLoginService();
			service.execute(request, response);
			url="doLogin.jsp";
			break;
		case "/mUpdate.do":
			//MUpdateService접근
			service = new MUpdateService();
			service.execute(request, response);
			url="mUpdate.jsp";
			break;
		case "/doMUpdate.do":
			//DoMUpdateService접근
			service = new DoMUpdateService();
			service.execute(request, response);
			url="doMUpdate.jsp";
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
