package com.kh.memManage.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.memManage.model.dao.memManageDao;
import com.kh.memManage.model.vo.Member;
public class memManageService {

	public int selectMemManage() {
		Connection conn = getConnection();
		
		int listCount = new memManageDao().selectMemManage(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Member> selectMemList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Member> mList = new memManageDao().selectMemList(conn, pi);
		
		close(conn);
		return mList;
	}

	public Member ajaxSelectMember(int memberNo) {
		Connection conn = getConnection();
		
		Member m = new memManageDao().ajaxSelectMember(conn, memberNo);
		
		close(conn);
		return m;
	}

	public void ajaxDeleteUser(int[] mnoArr) {
		Connection conn = getConnection();
		
		int result = new memManageDao().ajaxDeleteUser(conn, mnoArr);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}

	public ArrayList<Member> searchUser(String userCate, String searchUser, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Member> mList = new memManageDao().searchUser(conn, userCate, searchUser, pi);
		
		close(conn);
		
		return mList;
	}

	public int searchUserCount(String userCate, String searchUser) {
		Connection conn = getConnection();
		
		int listCount = new memManageDao().searchUserCount(conn, userCate, searchUser);
		
		close(conn);
		
		return listCount;
	}

}
