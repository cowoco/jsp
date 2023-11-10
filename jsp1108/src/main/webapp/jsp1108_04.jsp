<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판</title>
		<style>
			*{margin:0; padding:0;}
			div{width:1400px; margin:30px auto;}
			h1{text-align:center; margin-bottom:20px; }
			table,th,td{border:1px solid black; border-collapse: collapse; font-size:16px;
			text-align:center; }
			th,td{width: 200px; height:40px;}
			
		</style>
	</head>
	<body>
		<%
			Connection conn =null;
			Statement stmt =null;
		    ResultSet rs =null;
			int bno;
			String btitle, bcontent,id,bdate;
			int bhit;
		
			try{
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(rs!=null) rs.close();
					if(rs!=null) rs.close();
					if(rs!=null) rs.close();
					
					
					
				}catch(Exception e2){ e2.printStackTrace();
					
				}
			}
		%>
	<div>
		<h1>직원정보</h1>
			<table>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
	
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			
				
			</table>
		</div>
	
	</body>
</html>