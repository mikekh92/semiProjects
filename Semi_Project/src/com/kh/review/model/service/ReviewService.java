package com.kh.review.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.review.model.dao.ReviewDao;
import com.kh.review.model.vo.Review;

public class ReviewService {

public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount=new ReviewDao().selectListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList<Review> selectReviewList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList <Review> list =new ReviewDao().selectReviewList(conn,pi);
		
		close(conn);
		return list;
	}

	public Review selectReview(int reviewNo) {
		
		Connection conn = getConnection();
		
		Review r = new ReviewDao().selectReview(conn, reviewNo);
		
		close(conn);
		return r ;
	}

	public int insertReviewAnswer(Review r) {
		
		Connection conn = getConnection();
		
		ReviewDao Dao = new ReviewDao();
		
		
		int result=Dao.insertReviewAnswer(conn,r);
		
		int results =Dao.updateReviewAnswer(conn,r.getReviewNo());
		
		if(result>0&&results>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		if(result>0&&results>0) {
			return 1;
		}else {
			return 0;
		}
		
	
		
	}

	public int updateReview(int reviewNo, String reviewAnswer) {
		
		Connection conn =getConnection();
		
		int result= new ReviewDao().updateReview(conn,reviewNo,reviewAnswer);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int selectDelete(int[] reviewNoForDelete) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().selectDelete(conn,reviewNoForDelete); 
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Review> searchValues(String firstSelect, String secondSelect, PageInfo pi) {
		
		Connection conn =getConnection();
		
		ArrayList<Review> list = new ReviewDao().searchValues(conn,firstSelect,secondSelect,pi);
		close(conn);
		return list;
	}

	public int selectSearchingCount(String firstSelect, String secondSelect) {
		
		Connection conn = getConnection();
		
		int listCount = new ReviewDao().selectSearchingCount(conn,firstSelect,secondSelect);
		
		close(conn);
		return listCount;
	}

}
