package com.kh.member.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.management.medel.vo.management;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dao.managementDao;
import com.kh.member.model.vo.Member;

public class managementService {
	
	/*
	 bank_Name
	 acount_Num
	*/
	//로그인 요청 서비스
		public management loginMember(String bank_Name, String acount_Num) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			management m = new managementDao().loginmanagement(conn,bank_Name,acount_Num);
			
			JDBCTemplate.close(conn);
			
			return m;
			
		}	
		
		//회원가입 서비스
		public int insertmanagement(management m) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new managementDao().insertmanagement(conn,m);
			
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		}
		
		
		//회원 정보 수정용 메소드
		public Member updateMember(Member m) {
			Connection conn = JDBCTemplate.getConnection();
			//갱신된 회원 정보 객체 담을 변수
			Member updateMem = null;
			int result = new MemberDao().updateMember(conn,m);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
				//db에는 데이터가 변경 되었지만 session에 담겨있는 loginUser 객체정보는
				//갱신 되지 않았기 때문에 해당 처리를 해줘야 한다.
				updateMem =new MemberDao().selectMember(conn,m.getUserId());
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return updateMem;
			
			
			
		}
		//비밀번호 변경 메소드
		public Member updatePwdMember(String userId, String userPwd, String updatePwd) {
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new MemberDao().updatePwdMember(conn,userId,userPwd,updatePwd);
			Member updateMem = null;
			
			if(result>0) {
				JDBCTemplate.commit(conn);
				
				//갱신된 회원정보 조회해오기
				updateMem=new MemberDao().selectMember(conn, userId);
				
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return updateMem;
		}

		public int deleteMember(String userId, String userPwd) {
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new MemberDao().deleteMember(conn,userId,userPwd);
			//탈퇴한 회원 처리이기때문에 로그아웃까지 진행 (회원정보 갱신 필요없음)
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		}

		public int idCheck(String checkId) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int count = new MemberDao().idCheck(conn,checkId);
			
			JDBCTemplate.close(conn);
			
			return count;
			
		}

	}
