package com.kh.member_2.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.member_2.model.dao.MemberUserDao;
import com.kh.member_2.model.vo.Address;
import com.kh.member_2.model.vo.MemberUser;
public class MemberUserService {

	public MemberUser loginUser(String userId, String userPw) {
		Connection conn = getConnection();
		
		MemberUser mu = new MemberUserDao().loginUser(conn,userId,userPw);
		int result = new MemberUserDao().updateConnect(conn, userId, userPw);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return mu;
	}

	public int ajaxConfirmSign(String userId, String email, String phone) {
		Connection conn = getConnection();
		
		int result = new MemberUserDao().ajaxConfirmSign(conn, userId, email, phone);
		
		close(conn);
		return result;
	}

	public int insertMemberUser(MemberUser mu) {
		Connection conn = getConnection();
		
		int result = new MemberUserDao().insertMemberUser(conn, mu);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public int insertAddress(Address ar) {
		Connection conn = getConnection();
		
		int result = new MemberUserDao().insertAddress(conn, ar);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public int returnMember(int userNo) {
		Connection conn = getConnection();
		
		int result = new MemberUserDao().returnMember(conn, userNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public void banManage() {
		Connection conn = getConnection();
		
		int result = new MemberUserDao().banManage(conn);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		
	}

	public void dormancyManage() {
		Connection conn = getConnection();
		
		int result = new MemberUserDao().dormancyManage(conn);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
	}

}
