<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			$(function(){
				$("#fbtn").click(function(){
					alert($("#id").val());	
					//alert($("#pw").val());	
					frm.submit();
				});
			});
		
		</script>
		
	</head>
	<body>
		<form name="frm" method="post" action="doJsp_login.jsp"><br>
		<label>아이디</label><br>
		<input type="text"  name="id" id="id"><br>
		<label>패스워드</label><br>
		<input type="password"  name="pw" id="pw"><br>
		<input type="button" id="fbtn" value="로그인">
		<input type="button"  onclick="javascript:history.back()" value="취소">
		</form>
	</body>
</html>