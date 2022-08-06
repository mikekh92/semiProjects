package com.kh.member.model.dao;

import java.io.FileInputStream; 
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.management.medel.vo.management;
import com.kh.member.model.vo.Member;

public class managementDao {
	
	private Properties prop = new Properties();
	
	public managementDao() {
		String fileName = managementDao.class.getResource("/db/member/member-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public management loginmanagement(Connection conn, String bank_Name, String acount_Num) {
			
		//SELECT 문 -> 결과행이 1개 또는 0개 왜? userId가 unique이기 때문에 (중복불가) 
		//결과값인 resultset을 member객체에 담아서 응답하기
		management m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bank_Name);
			pstmt.setString(2, acount_Num);
			
			rset=pstmt.executeQuery();
		
			
			if(rset.next()) {//조회결과가 있으면
				m = new management(rset.getString("bank_Name")
							   ,rset.getString("acount_Num"));
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

	
	
	
	
	public int insertmanagement(Connection conn, management m) {
		//insert문 진행
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertmanagement");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getBank_Name());
			pstmt.setString(2, m.getAcount_Num());
			
			result =pstmt.executeUpdate();
		
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
		
		//select문 - ResultSet 객체를 불러와서 Member 객체에 담아서 반환 
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
						   	,rset.getString("USER_PWD")
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

	public int updatePwdMember(Connection conn, String userId, String userPwd, String updatePwd) {
		
		
		
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
		
			result = pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
		
	}

	public int deleteMember(Connection conn, String userId, String userPwd) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int idCheck(Connection conn, String checkId) {
		
		//select로 Member테이블에 userId중에 checkId가 있는지 없는지 확인 
		int count = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
		
	}

}







