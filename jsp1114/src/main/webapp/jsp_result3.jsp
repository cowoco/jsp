<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>아이디: ${param.id }</h2>
		<h2>이름: ${param.name }</h2>
		
		<%-- <%response.sendRedirect("jsp_result4.jsp?result=1"); %> --%>
		<%
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp_result4.jsp?result=1");
			dispatcher.forward(request, response);
		
		%>
		
	</body>
</html>