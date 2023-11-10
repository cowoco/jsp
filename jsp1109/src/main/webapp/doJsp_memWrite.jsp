<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보 저장</title>
	</head>
	<body>
		<%	
			request.setCharacterEncoding("utf-8");
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String id,pw,name,phone,gender,hobby="";
			String[] hobbys =null;
			
			id= request.getParameter("id");
			pw= request.getParameter("pw");
			name= request.getParameter("name");
			phone= request.getParameter("phone");
			gender= request.getParameter("gender");
			hobbys = request.getParameterValues("hobby");
			
			for(int i=0; i<hobbys.length; i++){
				if(i==0) hobby = hobbys[i];
				else hobby += "," + hobbys[i]; 
			}
			
			
			
			try{
				
				Context context = new InitialContext();
				DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18");
				conn = ds.getConnection();
				String query ="insert into member values(?,?,?,?,?,?,sysdate)";
				
				pstmt =conn.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.setString(4, phone);
				pstmt.setString(5, gender);
				pstmt.setString(6, hobby);
				//insert,update,delete excuteupdate
				int result = pstmt.executeUpdate();
				if(result==1){//성공시
				%>	
					<script>
						alert("회원정보가 저장되었습니다.");
						location.href="jsp_main.jsp";
					</script>
				<%}else{%>
					<script>
						alert("회원정보가 저장 에러가 발생 하였습니다. 다시입력하세요.");
						histoty.back();
					</script>
				<%}%>
				
				<%			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
					
					
				}catch(Exception e2){
					e2.printStackTrace();
					
				}
			}
		
		%>
	
	</body>
</html>