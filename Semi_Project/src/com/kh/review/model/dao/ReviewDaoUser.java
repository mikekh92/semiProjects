package com.kh.review.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.review.model.vo.Review;
import static com.kh.common.JDBCTemplate.*;

public class ReviewDaoUser {

	private Properties prop = new Properties();
	
	public ReviewDaoUser() {
		String fileName=ReviewDaoUser.class.getResource("/db/review/review-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertReview(Connection conn, Review r) {
		
		int result =0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setInt(3, r.getUserNo()); 
			pstmt.setInt(4, r.getProNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
		
		
	}

	public ArrayList<Review> selectReviewList(Connection conn, int productNo) {
		
		ArrayList <Review> list = new ArrayList<>();
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectReviewListUser");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("REVIEW_NO")
														,rset.getString("PRO_NAME")
														,rset.getString("USER_ID")
														,rset.getString("REVIEW_TITLE")
														,rset.getString("REVIEW_CONTENT")
														,rset.getDate("REVIEW_DATE")
														,rset.getInt("REVIEW_VIEWNO")));
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


}
