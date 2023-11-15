package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/Do_bwrite")
public class Do_bwrite extends HttpServlet {
	
	protected void doAtcion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAtcion");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		//파일첨부선언
		//String uPath = request.getRealPath("fupload");
		String uPath = "c:/upload";//절대경로
		int size = 10*1024*1024; //10Mb = 10m*1024kb*1024b
		
		//request,파일저장경로,크기,인코딩,같은이름변경정책 1.jpg -> 1(0).jpg
		//객체선언할때 파일을 업로드 시킴
		MultipartRequest multi = new MultipartRequest(request,uPath,size,"utf-8",new DefaultFileRenamePolicy());
		String btitle = multi.getParameter("btitle");
		String id = multi.getParameter("id");
		String bcontent = multi.getParameter("bcontent");
		System.out.println("bwrite id : "+id);
		Enumeration files = multi.getFileNames();

		//파일1개 업로드
		String file1 = (String)files.nextElement();//input name 가져오기
		String bfile = multi.getFilesystemName(file1);//실제파일업로드이름
		
		BoardDto bdto = new BoardDto(btitle,bcontent,id,bfile);
		BoardDao bdao = new BoardDao();
		int result = bdao.insertOne(bdto);
		
		//페이지
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>게시글저장</title></head>");
		writer.println("<body>");
		writer.println("<script>");
		writer.println("alert('게시글을 저장 완료.')");
		writer.println("location.href='blist.jsp';");
		writer.println("</script>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		
		
		System.out.println("btitle");
		System.out.println("id");
		System.out.println("bcontent");
		//1개일때
		System.out.println("input name :"+file1); // input name
		System.out.println("변경된 파일이름"+bfile); //1(0).jpg
		
		/*
		 * //파일 3개 업로드 String[] file_arr = new String[3]; String[] bfile = new
		 * String[3]; int i=0; while(files.hasMoreElements()) {
		 * 
		 * file_arr[i] = (String) files.nextElement();//bfile,bfile2,bfile3 bfile[i] =
		 * multi.getFilesystemName(file_arr[i]);// 1.jpg, 2.jpg, 3.jpg i++; }
		 */
		//3개일때
		//for(i=0; i<file_arr.length; i++) {
		//System.out.println("input name : "+file_arr[i]); // input name
		//System.out.println("변경된 파일이름 : "+bfile[i]); //1(0).jpg
		//}
		//파일이 2개 이상일때
		//while (files.hasMoreElements()) {
		//	String file = (String) files.nextElement();
		//	}
		
		
		
	


	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doGet");
	doAtcion(request, response);
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doPost");
	doAtcion(request, response);
}

}
