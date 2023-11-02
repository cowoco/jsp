<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jsp-표현식</title>
		<style>
				table,th,td{border:1px solid black; border-collaspe:collapse}
				table{width:400px; margin:50px auto;}
				th,td{with:80px; height:50px;}
		</style>
	</head>
	<body>
		<table>
			<tr>
				<th>단</th>
				<th>*</th>
				<th>숫자</th>
				<th>=</th>
				<th>곰셈</th>
			</tr>
			<%for(int i=2; i<=9; i++){
				for(int j=1; j<=9; j++){
			%>		
			<tr>
				<th><%=i %></th>
				<th>*</th>
				<th><%=j %></th>
				<th                                                                                                                                                                                               >=</th>
				<th><%=(i*j) %></th>
			</tr>
				
			<%}}%>
		</table>

	</body>
</html>