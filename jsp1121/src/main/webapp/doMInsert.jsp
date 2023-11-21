<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입  -doMInsert페이지</title>
	</head>
	<body>
		<c:if test="${result ==1 }">
			<script>
				alert("회원가입이 완료되었습니다.");
				location.href="index.do";
			</script>
		</c:if>
		<c:if test="${result !=1 }">
			<script>
				alert("회원가입이 되지 않았습니다. 다시 가입해주세요");
				location.href="mInsert.do";
			</script>
		</c:if>
	
	</body>
</html>