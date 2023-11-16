package com.java.www.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dao.MemberDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class DoBInsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String btitle="", id="",bcontent="",bfile="";
		
		
		String upload ="c:/upload";
		int size =10*1024*1024; //10Mb /1000b =>1MB
		try {
			MultipartRequest multi = new MultipartRequest(request, upload, size,"utf-8",new DefaultFileRenamePolicy());
			
			btitle = multi.getParameter("btitle");
			System.out.println("execute btitle : "+btitle);
			id= multi.getParameter("id");
			bcontent = multi.getParameter("bcontent");
			
			//파일이름 form에서 input type="file" name
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String f = (String) files.nextElement();
				bfile = multi.getFilesystemName(f);
				
			}
			//dto 객체를 담음
			BoardDto bdto = new BoardDto(btitle, bcontent, id, bfile);
			
			//dao연결
			BoardDao bdao = new BoardDao();
			int result =bdao.bInsert(bdto);
			System.out.println("execute result : "+result);
			
			
		} catch (Exception e) {e.printStackTrace();}
		
		
		

	}

}
