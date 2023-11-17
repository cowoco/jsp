<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h1>아이디: ${param.id }</h1>
		<h1>아이디: ${id }</h1>
		<h1>두수를 더하기: ${param.num1+param.num2 }</h1>
		<c:if test="${param.num3%2==0 }">
			<h1>짝수 입니다.</h1>
		</c:if>
		<c:if test="${param.num3%2!=0 }">
			<h1>홀수 입니다.</h1>
		</c:if>
	</body>
</html>