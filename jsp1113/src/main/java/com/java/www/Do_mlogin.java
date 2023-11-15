package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;


@WebServlet("/Do_mlogin")
public class Do_mlogin extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");//한글처리
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id);
		
		
		MemberDao mdao = new MemberDao();
		//id,pw를 보내서- 있으면 1개의 회원정보를 받음, 없으면 null 받음
		MemberDto mdto = mdao.loginCheck(id,pw);
		String msg= "";
		String url= "";
		
		if(mdto==null) {
			msg ="아이디또는 패스워드가 일치하지 않습니다.";
			url ="mlogin.jsp";
		}else {
			HttpSession session = request.getSession();
			System.out.println("login 아이디 : "+mdto.getId());
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
			msg ="로그인 되었습니다.";
			url ="index.jsp";
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>로그인</title></head>");
		writer.println("<body>");
		writer.println("<script>");
		writer.println("alert('"+msg+"')");
		writer.println("location.href='"+url+"';");
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
