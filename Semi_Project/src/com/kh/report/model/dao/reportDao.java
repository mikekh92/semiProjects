package com.kh.report.model.dao;

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
import com.kh.memManage.model.dao.memManageDao;
import com.kh.report.model.vo.Report;

public class reportDao {
	private Properties prop = new Properties();
	public reportDao() {
		String fileName = memManageDao.class.getResource("/db/report/report-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int selectReport(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReport");
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
	public ArrayList<Report> selectRepList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Report> rList = new ArrayList<>();
		String sql = prop.getProperty("selectRepList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pi.getCurrentPage()-1)*pi.getBoardLimit()+1);
			pstmt.setInt(2, pi.getCurrentPage()*pi.getBoardLimit());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				rList.add(new Report(rset.getInt("REP_NO"),
						rset.getDate("REP_ENTERDATE"),
						rset.getString("REP_TITLE"),
						rset.getString("REP_CONTENT"),
						rset.getString("REP_USER_ID"),
						rset.getString("REP_REPOTER"),
						rset.getString("REP_STATUS")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return rList;
	}
	public Report ajaxSelectReport(Connection conn, int reportNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReportt");
		Report r = new Report();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reportNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				r = new Report(rset.getInt("REP_NO"),
						rset.getDate("REP_ENTERDATE"),
						rset.getString("REP_TITLE"),
						rset.getString("REP_CONTENT"),
						rset.getString("REP_USER_ID"),
						rset.getString("REP_REPOTER"),
						rset.getString("REP_STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}
	public int ajaxIncreaseRPC(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("increaseRPC");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int completeReport(Connection conn, int rno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("completeReport");
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int selectRPC(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRPC");
		int RPC=-1;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				RPC = rset.getInt("USER_RPC");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		
		return RPC;
	}
	public int banUpdate(Connection conn, String userId, int RPC) {
		PreparedStatement pstmt = null;
		int result = 0;
		int banDay=0;
		
		String sql = prop.getProperty("banUpdate");
		
		switch(RPC) {
		case 1:
		case 2: banDay=RPC*7; break;
		case 3:
		case 4: banDay=RPC*30; break;
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, banDay);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int banUser(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("banUser");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int ajaxDeleteReport(Connection conn, int[] rnoArr) {
		PreparedStatement pstmt = null;
		int result = 1;
		String sql = prop.getProperty("ajaxDeleteReport");
		try {
			for(int i=0;i<rnoArr.length;i++) {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, rnoArr[i]);
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
	public ArrayList<Report> searchReport(Connection conn, String reportCate, String searchUser, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Report> rList = new ArrayList<>();
		String sql = "";
		switch(reportCate) {
		case "userId" : sql = prop.getProperty("searchReportId"); break;
		case "repoterId" :  sql = prop.getProperty("searchReporterId"); break;
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchUser);
			pstmt.setInt(2, (pi.getCurrentPage()-1)*pi.getBoardLimit()+1);
			pstmt.setInt(3, pi.getCurrentPage()*pi.getBoardLimit());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				rList.add(new Report(rset.getInt("REP_NO"),
						rset.getDate("REP_ENTERDATE"),
						rset.getString("REP_TITLE"),
						rset.getString("REP_CONTENT"),
						rset.getString("REP_USER_ID"),
						rset.getString("REP_REPOTER"),
						rset.getString("REP_STATUS")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rList;
	}
	public int searchReportCount(Connection conn, String reportCate, String searchUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = "";
		switch(reportCate) {
		case "userId" : sql = prop.getProperty("searchReportCountId"); break;
		case "repoterId" :  sql = prop.getProperty("searchReporterCountId"); break;
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
	public int ajaxReportUuser(Connection conn, String userId, String repoter) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("ajaxReportUuser");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, repoter);
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
