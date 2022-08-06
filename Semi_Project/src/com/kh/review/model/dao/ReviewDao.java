package com.kh.review.model.dao;

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
import com.kh.review.model.vo.Review;

public class ReviewDao {

	private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName=ReviewDao.class.getResource("/db/review/review-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public ArrayList<Review> selectReviewList(Connection conn, PageInfo pi) {
		
		ArrayList<Review> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow =pi.getCurrentPage()*pi.getBoardLimit();
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("REVIEW_NO")
														,rset.getString("REVIEW_PHOTO")
														,rset.getString("PRO_NAME")
														,rset.getString("USER_ID")
														,rset.getString("REVIEW_TITLE")
														,rset.getString("REVIEW_CONTENT")
														,rset.getString("REVIEW_RESULT")
														,rset.getDate("REVIEW_DATE")));
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

	public Review selectReview(Connection conn, int reviewNo) {
		
		Review r = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectReview");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review(rset.getInt("REVIEW_NO")
						,rset.getString("REVIEW_PHOTO")
						,rset.getString("REVIEW_TITLE")
						,rset.getString("PRO_NAME")
						,rset.getString("USER_ID")
						,rset.getDate("REVIEW_DATE")
						,rset.getString("REVIEW_RESULT")
						,rset.getString("REVIEW_CONTENT")
						,rset.getString("REVIEW_ANSWER"));
						
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

	public int insertReviewAnswer(Connection conn, Review r) {
		
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReviewAnswer");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, r.getReviewAnswer());
			pstmt.setInt(2, r.getReviewNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
		
		
		
	}

	public int updateReviewAnswer(Connection conn, int reviewNo) {
		
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReviewAnswer");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateReview(Connection conn, int reviewNo, String reviewAnswer) {
		
		int result=0;
		
		PreparedStatement pstmt =null;
		
		String sql = prop.getProperty("updateReview");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, reviewAnswer);
			pstmt.setInt(2, reviewNo);
			
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selectDelete(Connection conn, int[] reviewNoForDelete) {
		
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDelete");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0; i<reviewNoForDelete.length; i++) {
				pstmt.setInt(i+1, reviewNoForDelete[i]);
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

	public ArrayList<Review> searchValues(Connection conn, String firstSelect, String secondSelect, PageInfo pi) {
		
		ArrayList <Review> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql ="";
		
		switch(firstSelect) {
		
		case "REVIEW_PRODUCT" : sql =prop.getProperty("searchProduct"); break;
		case "REVIEW_WRITER" : sql = prop.getProperty("searchWriter");break;
		case "REVIEW_TITLE" : sql = prop.getProperty("searchTitle");break;
		case "REVIEW_RESULT" :sql =prop.getProperty("searchResult");break;
	}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, secondSelect);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow =pi.getCurrentPage()*pi.getBoardLimit();
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset =pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("REVIEW_NO")
														,rset.getString("REVIEW_PHOTO")
														,rset.getString("PRO_NAME")
														,rset.getString("USER_ID")
														,rset.getString("REVIEW_TITLE")
														,rset.getString("REVIEW_CONTENT")
														,rset.getString("REVIEW_RESULT")
														,rset.getDate("REVIEW_DATE")));
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
		
		int listCount =0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql="";
		
		switch(firstSelect) {
		
		case "REVIEW_PRODUCT" : sql =prop.getProperty("searchProductCount"); break;
		case "REVIEW_WRITER" : sql = prop.getProperty("searchWriterCount");break;
		case "REVIEW_TITLE" : sql = prop.getProperty("searchTitleCount");break;
		case "REVIEW_RESULT" :sql =prop.getProperty("searchResultCount");break;
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

}
