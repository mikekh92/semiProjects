package com.kh.notice.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {

public int insertNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result=new NoticeDao().insertNotice(conn,n);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		
		Connection conn =getConnection();
		
		ArrayList <Notice> list=new NoticeDao().selectNoticeList(conn,pi);
		
		close(conn);
		return list;
		
	}

	public int increaseCount(int noticeNo) {
		Connection conn = getConnection();
		
		int result=new NoticeDao().increaseCount(conn,noticeNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Notice selectNotice(int noticeNo) {
		
		Connection conn = getConnection();
		
		Notice n =new NoticeDao().selectNotice(conn,noticeNo);
		
		close(conn);
		return n;
	}

	public int updateNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn,n);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result ;
	}

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new NoticeDao().selectListCount(conn);
		
		close(conn);
		return listCount;
	}

	public int selectDelete(int[] noticeNoForDelete) {
		
		Connection conn = getConnection();
		
		int result=new NoticeDao().selectDelete(conn,noticeNoForDelete);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList<Notice> searchTitle(String firstSelect, String secondSelect, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList <Notice> list =new NoticeDao().searchTitle(conn,firstSelect,secondSelect,pi);
		
		close(conn);
		return list;
	}

	public int selectSearchingCount(String firstSelect, String secondSelect) {
		
		Connection conn = getConnection();
		
		int listCount = new NoticeDao().selectSearchingCount(conn,firstSelect,secondSelect);
		
		close(conn);
		return listCount;
	}
	
	public int NoticeCount() {
		
		Connection conn = getConnection();
		
		int n=new NoticeDao().NoticeCount(conn);
		
		close(conn);
		
		return n;
	}
	public ArrayList<Notice> sselectNoticeList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().sselectNoticeList(conn,pi);
		
		close(conn);
		
		return list;
		
	}
	
	//공지사항 세부 조회
	public ArrayList<Notice> sselectNotice(int noticeNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> n = new NoticeDao().sselectNotice(conn,noticeNo);
		
		close(conn);
		
		return n;
	}


}
