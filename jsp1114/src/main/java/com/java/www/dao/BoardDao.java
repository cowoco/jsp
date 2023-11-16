package com.java.www.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;
public class BoardDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BoardDto bdto = null;
	int bno,bgroup,bstep,bindent,bhit;
	String btitle,bcontent,id,bfile,query="";
	Timestamp bdate;
	ArrayList<BoardDto> list = new ArrayList();
	
	//2.listSelectAll()
		public ArrayList<BoardDto> listSelectAll() {
			try {
				conn = getConnection();
				query="select * from board";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					bno = rs.getInt("bno");
					System.out.println("listSelectAll bno : "+bno);
					btitle = rs.getString("btitle");
					bcontent = rs.getString("bcontent");
					bdate = rs.getTimestamp("bdate");
					id = rs.getString("id");
					bgroup = rs.getInt("bgroup");
					bstep = rs.getInt("bstep");
					bindent = rs.getInt("bindent");
					bhit = rs.getInt("bhit");
					bfile = rs.getString("bfile");
					list.add(new BoardDto(bno, btitle, bcontent, bdate, id, bgroup, bstep, bindent, bhit, bfile));
				}
			} catch (Exception e) {e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {e2.printStackTrace();}
			}
			return list;
		}//listSelectAll
	
	
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
	
}//public