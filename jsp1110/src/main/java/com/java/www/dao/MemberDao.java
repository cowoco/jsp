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
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String query = "", id = "", pw = "", name = "", phone = "", gender = "", hobby = "";
	Timestamp mdate = null;
	String[] hobbys = null;
	MemberDto mdto = null;

	// 1명 회원정보 수정 메소드
	public int memberUpdate(String id2, String phone2, String gender2, String hobby2) {
		int result = -1;
		
		try {
			conn = getConnection();
			query ="update member set phone=?,gender=?,hobby=? where id=?";
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, phone2);
			pstmt.setString(2, gender2);
			pstmt.setString(3, hobby2);
			pstmt.setString(4, id2);
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		return result;
	}

	// 회원정보입력 메소드
	public int memberInsert(MemberDto mdto) {
		int result = 0;

		try {
			conn = getConnection();
			query = "insert into member values(?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPw());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getGender());
			pstmt.setString(6, mdto.getHobby());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}// memverInert

	// 1명 회원리스트 메소드
	public MemberDto memberOne(String uid) {
		MemberDto mdto = null;
		try {
			conn = getConnection();
			query = "select * from member where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				name = rs.getString("name");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				hobby = rs.getString("hobby");
				mdate = rs.getTimestamp("mdate");

				mdto = new MemberDto(id, pw, name, phone, gender, hobby, mdate);

			} //

			// <!--복사시작-->
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return mdto;
	}// <!--복사끝 -->

	// 전체회원리스트 메소드
	public ArrayList<MemberDto> memberAll() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		try {
			conn = getConnection();
			query = "select * from member";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				id = rs.getString("id");
				pw = rs.getString("pw");
				name = rs.getString("name");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				hobby = rs.getString("hobby");
				mdate = rs.getTimestamp("mdate");

				list.add(new MemberDto(id, pw, name, phone, gender, hobby, mdate));

			}
			// <!--복사시작-->
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

	// 로그인체크 메소드
	public MemberDto mloginCheck(String uid, String upw) {

		try {
			conn = getConnection();
			query = "select * from member where id=? and pw=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				name = rs.getString("name");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				hobby = rs.getString("hobby");
				mdate = rs.getTimestamp("mdate");
				mdto = new MemberDto(id, pw, name, phone, gender, hobby, mdate);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return mdto;

	}// mloginCheck

	// ▼커넥션 풀 가져오는 메소드
	public Connection getConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();// 커넥션 풀객체 생성
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle18");
			connection = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}// Connection getConnection()

}// CLASS(DAO)