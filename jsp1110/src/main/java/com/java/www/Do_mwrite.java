package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;

@WebServlet("/Do_mwrite")
public class Do_mwrite extends HttpServlet {
	
 
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby="";
		for(int i=0; i<hobbys.length; i++) {
			if(i==0) hobby = hobbys[i];
			else hobby += ","+hobbys[i];
		}//for
		
		//class
		MemberDto mdto = new MemberDto(id, pw ,name, phone, gender, hobby);
		
		//회원정보입력메소드 호출
		MemberDao mdao = new MemberDao();
		int result = mdao.memberInsert(mdto);
		//페이지 이동
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head<title>회원가입</title></head>");
		writer.println("<body>");
		writer.println("<script>");
		writer.println("alert('회원정보가 저장되었습니다.');");
		writer.println("location.href='mindex.jsp';");
		writer.println("</script>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		
		
		
		
		
		
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
