package com.java.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.www.dto.MemberDto;

public class MemberDao {
	//변수선언
	Connection conn =null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	MemberDto mdto =null;
	ArrayList<MemberDto> list = new ArrayList<MemberDto>();
	String id,pw,name,phone,gender,hobby,query="";
	Timestamp mdate;
	
	//mDoLogin메소드 생성
	public MemberDto mDoLogin(String id2, String pw2) {
		try {
			conn = getConnection();
			query = "select * from member where id=? and pw=?";
			pstmt = conn.prepareStatement(query);
			//1 id값,2 pw값
			pstmt.setString(1, id2);
			pstmt.setString(2, pw2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				name = rs.getString("name");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				hobby = rs.getString("hobby");
				mdate = rs.getTimestamp("mdate");
				mdto = new MemberDto(id, pw, name, phone, gender, hobby, mdate);
				
			}
			

			}catch (Exception e) {e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {e2.printStackTrace();}
		}//finally
		return mdto;
	}//mDoLogin



	
	
	
	
	
	
	
	
	
	//1.커넥션풀에서 Connection객체 가져오기
	public Connection getConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18");
			connection = ds.getConnection();
		} catch (Exception e) {e.printStackTrace();}
		return connection;
	}//getconnection





}
