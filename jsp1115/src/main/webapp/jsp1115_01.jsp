<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>form</title>
	</head>
	<body>
		<h1>form</h1>
		<form name="frm" method="get" action="result1.jsp">
		<label>아이디</label>
		<input type="text" name="id">
		<br>
		<label>숫자1</label>
		<input type="text" name="num1">
		<br>
		<label>숫자2</label>
		<input type="text" name="num2">
		<br>
		<label>홀수짝수</label>
		<input type="text" name="num3">
		<br>
		<input type="submit" value="전송">
		</form>
	
	</body>
</html>