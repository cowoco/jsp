package com.java.www.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class doBUpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//bno,id,btitle,bcontent,bfile,oldBfile
		
		String upload="c:/upload";
		int size = 10*1024*1024; //10mb
		int bno=0;
		String id="",btitle="",bcontent="",bfile="",oldBfile="";
		
		try {
			MultipartRequest multi = new MultipartRequest(request,upload,size,"utf-8",new DefaultFileRenamePolicy());
			bno = Integer.parseInt(multi.getParameter("bno"));
			id = multi.getParameter("id");
			btitle = multi.getParameter("btitle");
			bcontent = multi.getParameter("bcontent");
			oldBfile = multi.getParameter("oldBfile");
			System.out.println("doBUpdateService oldBfile : "+oldBfile);
			
			//파일이름
			Enumeration files = multi.getFileNames();
			
			//1개의 input type=file 있기때문에 무조건 실행됨.
			if(files.hasMoreElements()) {
				String f = (String)files.nextElement();
				bfile = multi.getFilesystemName(f); //파일첨부가 없으면 null, 있으면 파일이름을 넣어줌
			}
			
			//bfile 파일첨부가 안되어 있으면 oldBfile이름으로 변경
			if(bfile==null) {
				System.out.println("파일없음");
				bfile = oldBfile; //새로운 파일첨부가 없으면 이전파일 저장
			}
			
			System.out.println("bfile : "+bfile);
			BoardDto bdto = new BoardDto(bno,btitle,bcontent,id,bfile);
			
			//dao접근
			BoardDao bdao = new BoardDao();
			int result = bdao.doBUpdate(bdto);
			
			//request객체 추가
			request.setAttribute("result", result);
			request.setAttribute("bno", bno);
			
		} catch (IOException e) {e.printStackTrace();}

	}

}