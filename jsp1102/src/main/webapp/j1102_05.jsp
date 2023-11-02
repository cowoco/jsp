<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jsp-스크릿트립</title>
	</head>
	<body>
	<%
	
		
		for(int i=1;i<=9; i++){
			out.println("2 *"+i+" = "+(2*i)+"<br>");
		
	%>
			
	-----------<br>
	<%
		}
	%>
	
	<%
		int a=1;
		if(a%2!=0){ //로그인 버튼을 클릭했을때 아이디, 패스워드가 일치하면1, 일치하지 않으면 0
			
	%>	
		<h2>홍길동님 환영합니다.</h2>
	<% 
		}else{
	%>
		<h2>아이디 또는 패스워드가 일치 하지 않습니다. 다시 확인하세요.</h2>
					
	<%	
		}
	%>
	
	</body>
</html>