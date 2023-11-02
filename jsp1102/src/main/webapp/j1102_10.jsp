<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
	</head>
	<body>
		<%
			out.println("서버이름 :"+request.getServerName()+"<br>"); //서버ip
			out.println("포트번호 :"+request.getServerPort()+"<br>");
			out.println("프로젝트명 :"+request.getContextPath()+"<br>");
			out.println("get,post :"+request.getMethod()+"<br>");
			out.println("프로토콜 :"+request.getProtocol()+"<br>");
			out.println("url 전체주소 :"+request.getRequestURL()+"<br>");
			out.println("uri 주소 :"+request.getRequestURI()+"<br>");
			out.println("접속자ip :"+request.getRemoteAddr()+"<br>"); //user ip 
			
			//파일명을 출력하시오.
			String file_uri = request.getRequestURI();
			out.println("프로젝트명 길이:"+request.getContextPath().length()+"<br>");
			String fileName = file_uri.substring(request.getContextPath().length());
			out.println("파일이름:"+ fileName) ;
;		
		%>
	
	</body>
</html>