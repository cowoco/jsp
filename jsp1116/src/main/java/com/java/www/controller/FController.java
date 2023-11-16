package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.BListService;
import com.java.www.service.DoBInsertService;
import com.java.www.service.MDoLoginService;
import com.java.www.service.Service;
import com.java.www.service.bViewService;
import com.java.www.service.doBUpdateService;

@WebServlet("*.do")
public class FController extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		//파일이름 찾기
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName =uri.substring(cPath.length());
		System.out.println("파일이름 : "+fileName);
		
		Service service = null;
		String url=null;
		switch (fileName) {
		case "/index.do": 
			response.sendRedirect("index.jsp");
			break;
		case "/memInsert.do":
			response.sendRedirect("memInsert.jsp");
			break;
		case "/login.do":
			response.sendRedirect("login.jsp");
			break;
		case "/doLogin.do":
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
		case "/bInsert.do":
			response.sendRedirect("bInsert.jsp");
			break;
		case "/doBInsert.do":
			service = new DoBInsertService();
			service.execute(request, response);
			url="doBInsert.jsp";
			break;
		case "/bView.do":
			service = new bViewService();
			service.execute(request, response);
			url="bView.jsp";
			break;
		case "/bUpdate.do":
			service = new bViewService();
			service.execute(request, response);
			url="bUpdate.jsp";
			break;
		case "/doBUpdate.do":
			service = new doBUpdateService();
			service.execute(request, response);
			url="doBUpdate.jsp";
			break;
			
			
			
		}//sw
		// url이 있을때만,dispatcher사용
		if(url!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);//
		}//if
		
		
	}
	//---------------------------------
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

}
