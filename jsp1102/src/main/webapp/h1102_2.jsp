<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<title>jsp-표현식</title>
		<style>
				table,th,td{border:1px solid black; border-collapse:collapse; font-size:20px; text-align:center;}
				table{width:200px; margin:50px auto;}
				th,td{with:100px; height:50px;}
		</style>
	</head>
	<body>
	<%-- 1부터 10까지의 합을 출력하시오 --%>
		<table>
			<tr>
				<th>순서</th>
				<th>합계</th>
			</tr>
			<%	
				int sum= 0;
				for(int i=1; i<=10; i++){
					
					sum = sum+ i ;
					
				%>
					<tr>
						<td><%=i%></td>
						<td><%=sum %></td>
					</tr>
				
				<% 
				}
			
				%>
			
			
		</table>
	
	</body>
</html>