package com.kh.review.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.review.model.dao.ReviewDaoUser;

import com.kh.review.model.vo.Review;
import static com.kh.common.JDBCTemplate.*;
public class ReviewServiceUser {

	public int insertReview(Review r) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDaoUser().insertReview(conn,r);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Review> selectReviewList(int productNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReviewDaoUser().selectReviewList(conn,productNo);
		
		close(conn);
		return list;
	}




}
