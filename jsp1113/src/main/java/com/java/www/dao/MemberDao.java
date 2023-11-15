package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.dto.MemberDto;

public class MemberDao {
	
	//인스턴스 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Timestamp mdate=null;
	String id,pw,name,phone,gender,hobby,query;
	MemberDto mdto = null;
	
	
	
	//id,pw 받아서 1개의 회원정보를 리턴
	public MemberDto loginCheck(String uid, String upw) {
		 mdto = null;
		//db접근해서 id,pw를 가지고 select 있으면 1개 회원가져옴, 없으면 null 
		try {
			conn = getConnection();
			query = "select * from member where id =? and pw=? ";
			pstmt = conn.prepareStatement(query);
			pstmt .setString(1, uid);
			pstmt .setString(2, upw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("id");//컬럼명을 찾아오는것 
				pw = rs.getString("pw");
				name = rs.getString("name");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				hobby = rs.getString("hobby");
				mdate = rs.getTimestamp("mdate");
				mdto = new MemberDto(id, pw, name, phone, gender, hobby, mdate); //객체선언
				
			}
			
		}catch(Exception e) {e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e2) {e2.printStackTrace();}
		}//finally
		return mdto;
	}//loginCheck
	
	
	//커넥션 풀에서 connection 객체가져옴
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:comp/env/jdbc/Oracle18");
			connection = ds.getConnection();
			
			
		}catch(Exception e){e.printStackTrace();}
		
		return connection;
	}//getConnection



}
