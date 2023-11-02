<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jsp-시크릿트립</title>
		
	</head>
	<body>
	<!-- html주석: jsp프로그래밍 입니다. random 함수를 사용했습니다. 노출가능 -->
	<%--jsp주석 : String.format함수를 사용 5자리 결과값 도출 노출안돼--%>
	<%
		//랜덤으로 숫자 :0~ 9999
		//자리수는 5자리가 되어야 함 
		int num =(int)(Math.random()*100000);
		String str_num = String.format("%05d",num);
		out.println(str_num+"<br>");
			

		
		//5자리의 개별숫자의 합을 출력하시오 02487 ->21
		
		int num2 =(int)(Math.random()*100000);
		out.println(str_num.charAt(0)-'0'+"<br>");/*type int  */
		out.println(str_num.charAt(1)-'0'+"<br>");
		out.println(str_num.charAt(2)-'0'+"<br>");
		out.println(str_num.charAt(3)-'0'+"<br>");
		out.println(str_num.charAt(4)-'0'+"<br>");
		
		out.println("합계:"+(
			(str_num.charAt(0)-'0')+(str_num.charAt(1)-'0')+
			(str_num.charAt(2)-'0')+(str_num.charAt(3)-'0')+
			(str_num.charAt(4)-'0')
				));
		//소문자  a -> A a:97, A:65, 32차이 0:48, 1:49
		//대소문자 변경 +-32
		//'1' -'0'= 1 , -> 49 -48 = 1 50-48 =2
		
		 
	
	
	%>
	</body>
</html>