package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class BListService implements Service {
	
	//dao접근 -인스턴스변수
	BoardDao bdao = new BoardDao();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//-----하단 넘버링 --------
		//1.현재페이지
		int page = 1;
		if(request.getParameter("page")!=null){
			page =Integer.parseInt(request.getParameter("page"));
			System.out.println("request.getParameter page : "+page);
		}
		System.out.println("현재 페이지 : "+page);
		String bcategory = request.getParameter("bcategory");
		String bsearch =request.getParameter("bsearch");
		
		
		
		//--> numbering메소드 호출
		Map<String, Object> map =  numbering(page,bcategory,bsearch);
		int listCount =(int)map.get("listCount");
		int maxPage =(int)map.get("maxPage");
		int startPage =(int)map.get("startPage");
		int endPage =(int)map.get("endPage");
		int startRow =(int)map.get("startRow");
		int endRow =(int)map.get("endRow");
		
		
		//*** 전체 게시글 가져오기*** -10개씩 가져오기 ***
		ArrayList<BoardDto> list= bdao.bList(bcategory,bsearch,startRow,endRow);
				
		//확인
		System.out.println("BListService list : "+list.get(0).getBno());
		
		//request추가
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("listCount", listCount);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		//검색부분
		request.setAttribute("bcategory", bcategory);
		request.setAttribute("bsearch", bsearch);
		

	}//execute
	
	//메소드 리턴타입 메소드명(매개변수){  }  
	public Map<String, Object> numbering(int page, String bcategory, String bsearch){
		Map<String, Object> map = new HashMap();
		//-------
		int rowPage = 10; //1페이지당 10개의 게시글 표시 --몇개씩
		int bottomPage = 10;//하단넘버링 개수
	
		
		//1.전체개수
		int listCount = bdao.listCount(bcategory,bsearch);
		//2.최대하단넘버링페이지 41/10 =4.1 -> 5.0 -> 5
		int maxPage = (int)Math.ceil((double)listCount/rowPage);
		//3.startPage : 하단넘버링 시작번호  (int)(7-1/10)*10+1 = 1
		int startPage = (int)((page-1)/bottomPage)* bottomPage +1;
		//4. endpage : 하단 넘버링 끝번호 1+10-1 = 10    
		int endPage = startPage+bottomPage-1;
		if(endPage>maxPage) endPage = maxPage; //101-110 104
		
		
		//5. startRow -oracle에서 가져오는 시작번호(3-1)*10+1 =21
		int startRow =(page-1)*rowPage+1;
		//6. endRow - oracle에서 가져오는 끝번호 21+10-1 =30
		int endRow = startRow+rowPage-1;
		
		//map listCount,maxPage,startPage,endPage,startRow,endRow
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		//------
		return map;
	}//numbering
	

}
