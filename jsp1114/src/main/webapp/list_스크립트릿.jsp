<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.java.www.dto.BoardDto"%>
<%@page import="com.java.www.dao.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.www.dto.MemberDto"%>
<%@page import="com.java.www.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%
			BoardDao mdao = new BoardDao();
			ArrayList<BoardDto> list = mdao.selectAll();
		%>
		<meta charset="UTF-8">
		<title>게시판</title>
		<style>
		   *{margin:0; padding:0;}
		   div{width:1000px; margin:30px auto; text-align: center;}
		   h1{margin-bottom:30px; }
		   table,th,td{border:1px solid black; border-collapse: collapse;
		   font-size: 16px; }
		   th,td{width:200px; height:40px; }
		   button{width:200px; height:60px; margin-top:30px; }
		</style>
	</head>
	<body>
	 <div>
	   <h1>게시판</h1>
	   <form name="m_frm" method="post" action="DoWrite">
		   <table>
		     <colgroup>
		       <col width="12%">
		       <col width="40%">
		       <col width="18%">
		       <col width="18%">
		       <col width="12%">
		     </colgroup>
		     <tr>
		       <th>번호</th>
		       <th>제목</th>
		       <th>작성자</th>
		       <th>작성일</th>
		       <th>조회수</th>
		      </tr>
		      <% 	
		      	for(int i=0; i<list.size(); i++){
		      		BoardDto bdto = list.get(i);
		      		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		      %>
		      <tr>
		       <td><%= bdto.getBno() %></td>
		       <td><a href="view.jsp?bno=<%=bdto.getBno()%>"><%= bdto.getBtitle() %></a></td>
		       <td><%= bdto.getId() %></td>
		       <td><%= bdto.getBdate() %></td>
		       <td><%= bdto.getBhit() %></td>
		      </tr>
		    <%} %>
		   </table>
		   <a href="write.jsp"><button type="button">글쓰기</button></a>
		   <a href="index.jsp"><button type="button">홈으로</button></a>
	   </form>
	  </div>
	
	</body>
</html>






