package com.java.www.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class N_insertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse repsonse) {
		//dao접근
		BoardDao bdao = new BoardDao();
		
		//변수선언
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("session_id");
		String btitle="",bcontent="",bfile="";
		int page =1;
		
		
		//form 데이터 Multipart
		String upload ="c:/upload";
		int size = 10*1024*1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, upload,size, "utf-8",new DefaultFileRenamePolicy());
			page = Integer.parseInt(multi.getParameter("page"));
			btitle = multi.getParameter("btitle");
			bcontent = multi.getParameter("bcontent");
			//input type=file 인것 이름 모두를 가져옴
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String f = (String) files.nextElement(); // enum 형변환 
				bfile = multi.getFilesystemName(f);//똑같은 파일이 있을경우 이름을 변경해서 저장
			}
			BoardDto bdto = new BoardDto(btitle, bcontent, id, bfile);
			
			//dao접근 - 게시글 저장메소드 호출
			int result =bdao.insert(bdto);
			
			
			//request 추가
			request.setAttribute("result", result);
			request.setAttribute("page", page);
			
			
			
		} catch (IOException e) {e.printStackTrace();}
		
		
		
		

	}

}