package com.kh.report.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.memManage.model.dao.memManageDao;
import com.kh.memManage.model.vo.Member;
import com.kh.report.model.dao.reportDao;
import com.kh.report.model.vo.Report;
public class reportService {

	public int selectReport() {
		Connection conn = getConnection();
		
		int listCount = new reportDao().selectReport(conn);
		
		close(conn);
		return listCount;
		
	}

	public ArrayList<Report> selectRepList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Report> rList= new reportDao().selectRepList(conn, pi);
		
		close(conn);
		return rList;
	}

	public Report ajaxSelectReport(int reportNo) {
		Connection conn = getConnection();
		
		Report r = new reportDao().ajaxSelectReport(conn, reportNo);
		
		close(conn);
		return r;
	}

	public int ajaxIncreaseRPC(String userId) {
		Connection conn = getConnection();
		
		int result = new reportDao().ajaxIncreaseRPC(conn,userId);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int completeReport(int rno) {
		Connection conn = getConnection();
		
		int result = new reportDao().completeReport(conn, rno);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int selectRPC(String userId) {
		Connection conn = getConnection();
		
		int RPC = new reportDao().selectRPC(conn,userId);
		
		close(conn);
		
		return RPC;
	}
	
	public void banUpdate(String userId, int RPC) {
		Connection conn = getConnection();
		
		int result = new reportDao().banUpdate(conn, userId,RPC);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		
	}



	public void banUser(String userId) {
		Connection conn = getConnection();
		
		int result = new reportDao().banUser(conn,userId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		
	}

	public void ajaxDeleteReport(int[] rnoArr) {
		Connection conn = getConnection();
		
		int result = new reportDao().ajaxDeleteReport(conn, rnoArr);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
	}

	public ArrayList<Report> searchReport(String reportCate, String searchUser, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Report> rList = new reportDao().searchReport(conn, reportCate, searchUser, pi);
		
		close(conn);
		
		return rList;
	}

	public int searchReportCount(String reportCate, String searchUser) {
		Connection conn = getConnection();
		
		int listCount = new reportDao().searchReportCount(conn, reportCate, searchUser);
		
		close(conn);
		
		return listCount;
	}

	public void ajaxReportUuser(String userId, String repoter) {
		Connection conn = getConnection();
		
		int result = new reportDao().ajaxReportUuser(conn, userId, repoter);
		
		if(result>0) commit(conn);
		else rollback(conn);

		close(conn);
		
	}

}
