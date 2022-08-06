package com.kh.memManage.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.PageInfo;
import com.kh.memManage.model.vo.Member;

public class memManageDao {
	private Properties prop = new Properties();
	public memManageDao() {
		String fileName = memManageDao.class.getResource("/db/memManage/memManage-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int selectMemManage(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemManage");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next())
			listCount = rset.getInt("COUNT");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return listCount;
	}
	public ArrayList<Member> selectMemList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> mList = new ArrayList<>();
		String sql = prop.getProperty("selectMemList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pi.getCurrentPage()-1)*pi.getBoardLimit()+1);
			pstmt.setInt(2, pi.getCurrentPage()*pi.getBoardLimit());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				mList.add(new Member(rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_NAME"),
						rset.getDate("USER_BIRTH"),
						rset.getString("GENDER"),
						rset.getString("EMAIL"),
						rset.getString("PHONE"),
						rset.getDate("ENTERDATE"),
						rset.getString("U_STATUS"),
						rset.getInt("USER_RPC")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mList;
	}
	public Member ajaxSelectMember(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMember");
		Member m = new Member();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member(rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_NAME"),
						rset.getDate("USER_BIRTH"),
						rset.getString("GENDER"),
						rset.getString("EMAIL"),
						rset.getString("PHONE"),
						rset.getDate("ENTERDATE"),
						rset.getString("U_STATUS"),
						rset.getInt("USER_RPC"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	public int ajaxDeleteUser(Connection conn, int[] mnoArr) {
		PreparedStatement pstmt = null;
		int result = 1;
		String sql = prop.getProperty("ajaxDeleteUser");
		try {
			for(int i=0;i<mnoArr.length;i++) {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, mnoArr[i]);
				result = result * pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Member> searchUser(Connection conn, String userCate, String searchUser, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> mList = new ArrayList<>();
		String sql = "";
		switch(userCate) {
		case "userId" : sql = prop.getProperty("searchUserId"); break;
		case "userName" :  sql = prop.getProperty("searchUserName"); break;
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchUser);
			pstmt.setInt(2, (pi.getCurrentPage()-1)*pi.getBoardLimit()+1);
			pstmt.setInt(3, pi.getCurrentPage()*pi.getBoardLimit());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				mList.add(new Member(rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_NAME"),
						rset.getDate("USER_BIRTH"),
						rset.getString("GENDER"),
						rset.getString("EMAIL"),
						rset.getString("PHONE"),
						rset.getDate("ENTERDATE"),
						rset.getString("U_STATUS"),
						rset.getInt("USER_RPC")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mList;
	}
	public int searchUserCount(Connection conn, String userCate, String searchUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = "";
		switch(userCate) {
		case "userId" : sql = prop.getProperty("searchUserCountId"); break;
		case "userName" :  sql = prop.getProperty("searchUserCountName"); break;
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchUser);
			rset = pstmt.executeQuery();
			if(rset.next())
			listCount = rset.getInt("COUNT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

}
