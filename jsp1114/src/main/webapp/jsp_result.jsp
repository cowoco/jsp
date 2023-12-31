<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			span{font-size: 50px; font-weight:700; color:red; padding: 10px;}
			span:after {color:blue; content:",";}
		</style>
	</head>
	<body>
		<h2>섹션: <%=session.getAttribute("session_nicName") %></h2>
		<h2>배열취미: <%= Arrays.toString(request.getParameterValues("hobby")) %></h2>
		<h2>아이디: <%=request.getParameter("id") %></h2>
		<h2>이름: <%=request.getParameter("name") %></h2>
		<h2>숫자1: <%=request.getParameter("num1") %></h2>
		<h2>숫자2: <%=request.getParameter("num2") %></h2>
		<h2>결과값1: <%=request.getParameter("num1")+request.getParameter("num2") %></h2>
		<h2>결과값2: <%=Integer.parseInt(request.getParameter("num1"))+Integer.parseInt(request.getParameter("num2")) %></h2>
		<hr>
		<h2>섹션1 : ${sessionScope.session_nicName }</h2>
		<h2>섹션2 : ${session_nicName }</h2> <!--약식도 가능  -->
		<h2>배열취미 : ${paramValues.hobby }</h2>
		<c:forEach var="hobby" items="${paramValues.hobby }">
			<span>${hobby }</span>
		</c:forEach>
		
		
		
		<h2>아이디 : ${param.id }</h2>
		<h2>이름 : ${param.name }</h2>
		<h2>결과값 : ${param.num1+param.num2 }</h2>
	</body>
</html>