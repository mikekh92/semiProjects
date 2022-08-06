package com.kh.member_2.model.dao;
import static com.kh.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.memManage.model.dao.memManageDao;
import com.kh.member_2.model.vo.Address;
import com.kh.member_2.model.vo.MemberUser;

public class MemberUserDao {
	private Properties prop = new Properties();
	public MemberUserDao() {
		String fileName = memManageDao.class.getResource("/db/memberUser/memberUser-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public MemberUser loginUser(Connection conn, String userId, String userPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberUser mu = null;
		String sql = prop.getProperty("loginMemberUser");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mu = new MemberUser(rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_NAME"),
						rset.getString("EMAIL"),
						rset.getString("PHONE"),
						rset.getString("U_STATUS"),
						rset.getDate("BAN_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mu;
	}


	public int updateConnect(Connection conn, String userId, String userPw) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateConnect");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int ajaxConfirmSign(Connection conn, String userId, String email, String phone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = prop.getProperty("ajaxConfirmSign");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) result = rset.getInt("COUNT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}


	public int insertMemberUser(Connection conn, MemberUser mu) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertMemberUser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mu.getUserId());
			pstmt.setString(2, mu.getUserPw());
			pstmt.setString(3,mu.getUserName());
			pstmt.setDate(4, mu.getUserBirth());
			pstmt.setString(5, mu.getGender());
			pstmt.setString(6, mu.getEmail());
			pstmt.setString(7, mu.getPhone());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int insertAddress(Connection conn, Address ar) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertAddress");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ar.getUserId());
			pstmt.setInt(2, ar.getPostCode());
			pstmt.setString(3, ar.getRoadAddress());
			pstmt.setString(4, ar.getJibunAddress());
			pstmt.setString(5, ar.getDetailAddress());
			pstmt.setString(6, ar.getExtraAddress());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int returnMember(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("returnMember");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int banManage(Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("banManage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int dormancyManage(Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("dormancyManage");
		
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
