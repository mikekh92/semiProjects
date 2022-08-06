package com.kh.notice.model.dao;

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
import com.kh.notice.model.vo.Notice;

public class NoticeDao {
	
private Properties prop = new Properties();
	
	public NoticeDao() {
		String fileName = NoticeDao.class.getResource("/db/notice/notice-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public int insertNotice(Connection conn, Notice n) {
		
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,n.getNoticeTitle() );
			pstmt.setString(2, n.getNoticeContent() );
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi) {
		
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow =pi.getCurrentPage()*pi.getBoardLimit();
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO")
													,rset.getString("NOTICE_TITLE")
													,rset.getString("USER_NAME")
													,rset.getInt("NOTICE_VIEWNO")
													,rset.getDate("NOTICE_DATE")));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int increaseCount(Connection conn, int noticeNo) {
		
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public Notice selectNotice(Connection conn, int noticeNo) {
		
		Notice n = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice(rset.getInt("NOTICE_NO")
						,rset.getString("NOTICE_TITLE")
						,rset.getString("NOTICE_CONTENT")
						,rset.getString("USER_ID")
						,rset.getDate("NOTICE_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}

	public int updateNotice(Connection conn, Notice n) {
		
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		
		int result =0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selectListCount(Connection conn) {
		
		int listCount=0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public int selectDelete(Connection conn, int[] noticeNoForDelete) {
		
		int result= 0;
		
		PreparedStatement pstmt =null;
		
		String sql =prop.getProperty("selectDelete");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			for(int i = 0 ; i < noticeNoForDelete.length ; i++) {				
				pstmt.setInt(i+1, noticeNoForDelete[i]);
				result +=pstmt.executeUpdate();	
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		return result;
	}

	public ArrayList<Notice> searchTitle(Connection conn, String firstSelect, String secondSelect, PageInfo pi) {
		
		ArrayList <Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt =null;
		ResultSet rset =null;

		String sql="";

		switch(firstSelect){
		
		case "NOTICE_TITLE" :  sql = prop.getProperty("searchTitle"); break;
//		case NOTICE_WRITER: String sql = prop.getProperty("searchWriter"); break;

		}
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, secondSelect);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow =pi.getCurrentPage()*pi.getBoardLimit();
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO")
													,rset.getString("NOTICE_TITLE")
													,rset.getString("USER_NAME")
													,rset.getInt("NOTICE_VIEWNO")
													,rset.getDate("NOTICE_DATE")));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int selectSearchingCount(Connection conn, String firstSelect, String secondSelect) {
	
		int listCount=0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql="";
		
		switch(firstSelect) {
		
		case "NOTICE_TITLE": sql =prop.getProperty("selectSearchCount"); break;
		//case 
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, secondSelect);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public ArrayList<Notice> sselectNoticeList(Connection conn,PageInfo pi) {
		
		//SELECT문 - > ResultSet 객체 (여러 행)
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO")
									,rset.getString("NOTICE_TITLE")
									));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Notice> sselectNotice(Connection conn, int noticeNo) {
		//select문으로 noticeNo에 해당하는 글 1개 or 0개 조회
		PreparedStatement pstmt = null;
		ArrayList<Notice> nt = new ArrayList<>();
		ResultSet rset=null;

		System.out.println(noticeNo);
		String sql=prop.getProperty("noticedetailmain");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				nt.add(new Notice(rset.getInt("NOTICE_NO")
							,rset.getString("NOTICE_TITLE")
							,rset.getString("NOTICE_CONTENT")
							,rset.getDate("NOTICE_DATE")
							,rset.getString("NOTICE_WRITER")
							,rset.getString("NOTICE_STATUS")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("nt : " + nt);
		return nt;
	}

	public int NoticeCount(Connection conn) {
		
		int listCount = 0; 
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		
		String sql= prop.getProperty("selectNoticeCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT"); //나올 행이 하나뿐이기 때문에 while문이 아닌 if문 사용
			}
			
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
