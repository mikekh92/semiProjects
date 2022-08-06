package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Address;
import com.kh.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/db/member/member-mapper.xml").getPath();
		//
		try {
			
			prop.loadFromXML(new FileInputStream(fileName));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

	public Member loginMember(Connection conn, String userId, String userPw) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("USER_NO")
							   ,rset.getString("USER_ID")
							   ,rset.getString("USER_PW")
							   ,rset.getString("USER_NAME")
							   ,rset.getString("PHONE")
							   ,rset.getString("EMAIL")
							   ,rset.getString("ADDRESS")
							   ,rset.getString("INTEREST")
							   ,rset.getDate("ENROLL_DATE")
							   ,rset.getDate("MODIFY_DATE")
							   ,rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
		
	}
	
	
	
	

	public int insertMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPw());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getInterest());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("USER_NO")
						   	,rset.getString("USER_ID")
						   	,rset.getString("USER_PW")
						   	,rset.getString("USER_NAME")
						   	,rset.getString("PHONE")
						   	,rset.getString("EMAIL")
						   	,rset.getString("ADDRESS")
						   	,rset.getString("INTEREST")
						   	,rset.getDate("ENROLL_DATE")
						   	,rset.getDate("MODIFY_DATE")
						   	,rset.getString("STATUS"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int updatePwMember(Connection conn, String userId, String userPw, String updatePw) {
		
		
		
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, updatePw);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPw);
		
			result = pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
		
	}

	public int deleteMember(Connection conn, String userId, String userPw) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	
	
	
	
	
	
	
	public Address SelectAddress(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;//
		
		ResultSet rset = null;
		
		Address a = null;
		
		String sql = prop.getProperty("MemberAddress");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				a = new Address(rset.getInt("POST_CODE")
								,rset.getString("ROAD_ADDRESS")
								,rset.getString("JIBUN_ADDRESS")
								,rset.getString("DETAIL_ADDRESS")
								,rset.getString("EXTRA_ADDRESS"));
			}
			
			System.out.println(a);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return a;
	}
	
	
	
	
	
	
	

}







