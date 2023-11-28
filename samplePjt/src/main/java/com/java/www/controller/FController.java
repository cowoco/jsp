package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.DoLoginService;
import com.java.www.service.MInsertService;
import com.java.www.service.MSelectOneService;
import com.java.www.service.MUpdateService;
import com.java.www.service.N_DeleteService;
import com.java.www.service.N_ReplyInertService;
import com.java.www.service.N_SelectOneService;
import com.java.www.service.N_UpdateService;
import com.java.www.service.N_insertService;
import com.java.www.service.N_listSelectService;
import com.java.www.service.Service;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("*.do")
public class FController extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		String url =null;
		
		//파일이름 추출
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		//파일호출 이름
		System.out.println("FController 파일호출 이름 : "+fileName);
		Service service = null;
		 
		//switch
		switch (fileName) {
		case "/main.do": 
			response.sendRedirect("main.jsp");
			break;
		case "/join01_terms.do": 
			response.sendRedirect("join01_terms.jsp");
			break;
		case "/join02_info_input.do": 
			url="join02_info_input.jsp";
			break;
		case "/join03_success.do": 
			service = new MInsertService();
			service.execute(request, response);
			url="join03_success.jsp";
			break;
		case "/m_info_input.do": //회원정보 수정 페이지 - 회원정보 1명 가져오기
			service = new MSelectOneService();
			service.execute(request, response);
			url="m_info_input.jsp";
			break;
		case "/doM_info_input.do": //회원정보 수정
			service = new MUpdateService();
			service.execute(request, response);
			url="doM_info_input.jsp";
			break;
		case "/login.do": 
			response.sendRedirect("login.jsp");
			break;
		case "/logout.do": 
			response.sendRedirect("logout.jsp");
			break;
		case "/doLogin.do": 
			service = new DoLoginService();
			service.execute(request, response);
			url="doLogin.jsp";
			break;
		case "/n_list.do": 
			service = new N_listSelectService();
			service.execute(request, response);
			url="n_list.jsp";
			break;
		case "/n_view.do": 
			service = new N_SelectOneService();
			service.execute(request, response);
			url="n_view.jsp";
			break;
		case "/n_insert.do": 
			response.sendRedirect("n_insert.jsp");
			break;
		case "/doN_insert.do": 
			service = new N_insertService();
			service.execute(request, response);
			url="doN_insert.jsp";
			break;
		case "/n_reply.do": 
			service = new N_SelectOneService();
			service.execute(request, response);
			url="n_reply.jsp";
			break;
		case "/doN_reply.do": 
			service = new N_ReplyInertService();
			service.execute(request, response);
			url="doN_reply.jsp";
			break;
		case "/n_update.do": 
			service = new N_SelectOneService();
			service.execute(request, response);
			url="n_update.jsp";
			break;
		case "/doN_update.do": 
			service = new N_UpdateService();
			service.execute(request, response);
			url="doN_update.jsp";
			break;
		case "/n_delete.do": 
			service = new N_DeleteService();
			service.execute(request, response);
			url="n_delete.jsp";
			break;
		
		default:
			break;
	
	}//sw
	
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
