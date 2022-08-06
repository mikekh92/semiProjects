package com.kh.review.model.vo;

import java.sql.Date;

public class Review {

	private int reviewNo;
	private Date reviewDate;
	private String reviewContent;
	private String reviewResult;
	private String reviewAnswer;
	private String reviewPhoto;
	private String reviewStar;
	private String reviewAnswerDate;
	private int reviewViewNo;
	private String reviewStatus;
	private int proNo;
	private int userNo;
	private String reviewWriter;
	private String reviewProduct;
	private String reviewTitle;
	
	public Review() {
		super();
	}
	
	
	

	public Review(int reviewNo, Date reviewDate, String reviewContent, String reviewResult, String reviewAnswer,
			String reviewPhoto, String reviewStar, String reviewAnswerDate, int reviewViewNo, String reviewStatus,
			int proNo, int userNo, String reviewWriter, String reviewProduct, String reviewTitle) {
		super();
		this.reviewNo = reviewNo;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.reviewResult = reviewResult;
		this.reviewAnswer = reviewAnswer;
		this.reviewPhoto = reviewPhoto;
		this.reviewStar = reviewStar;
		this.reviewAnswerDate = reviewAnswerDate;
		this.reviewViewNo = reviewViewNo;
		this.reviewStatus = reviewStatus;
		this.proNo = proNo;
		this.userNo = userNo;
		this.reviewWriter = reviewWriter;
		this.reviewProduct = reviewProduct;
		this.reviewTitle = reviewTitle;
	}

	public Review(int reviewNo, String reviewProduct, String reviewWriter, String reviewTitle, String reviewContent, Date reviewDate,
			int reviewViewNo) {
		super();
		this.reviewNo = reviewNo;
		this.reviewProduct = reviewProduct;
		this.reviewWriter = reviewWriter;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewViewNo = reviewViewNo;
	}
	
	public Review(int reviewNo, String reviewPhoto, String reviewProduct, String reviewWriter, String reviewTitle,
			String reviewContent, String reviewResult, Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.reviewPhoto = reviewPhoto;
		this.reviewProduct = reviewProduct;
		this.reviewWriter = reviewWriter;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewResult = reviewResult;
		this.reviewDate = reviewDate;
	}
	

	public Review(int reviewNo, String reviewPhoto, String reviewTitle, String reviewProduct, String reviewWriter,
			Date reviewDate, String reviewResult, String reviewContent, String reviewAnswer) {
		super();
		this.reviewNo = reviewNo;
		this.reviewPhoto = reviewPhoto;
		this.reviewTitle = reviewTitle;
		this.reviewProduct = reviewProduct;
		this.reviewWriter = reviewWriter;
		this.reviewDate = reviewDate;
		this.reviewResult = reviewResult;
		this.reviewContent = reviewContent;
		this.reviewAnswer = reviewAnswer;
	}




	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public String getReviewProduct() {
		return reviewProduct;
	}

	public void setReviewProduct(String reviewProduct) {
		this.reviewProduct = reviewProduct;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}

	public String getReviewAnswer() {
		return reviewAnswer;
	}

	public void setReviewAnswer(String reviewAnswer) {
		this.reviewAnswer = reviewAnswer;
	}

	public String getReviewPhoto() {
		return reviewPhoto;
	}

	public void setReviewPhoto(String reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
	}

	public String getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(String reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getReviewAnswerDate() {
		return reviewAnswerDate;
	}

	public void setReviewAnswerDate(String reviewAnswerDate) {
		this.reviewAnswerDate = reviewAnswerDate;
	}

	public int getReviewViewNo() {
		return reviewViewNo;
	}

	public void setReviewViewNo(int reviewViewNo) {
		this.reviewViewNo = reviewViewNo;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewDate=" + reviewDate + ", reviewContent=" + reviewContent
				+ ", reviewResult=" + reviewResult + ", reviewAnswer=" + reviewAnswer + ", reviewPhoto=" + reviewPhoto
				+ ", reviewStar=" + reviewStar + ", reviewAnswerDate=" + reviewAnswerDate + ", reviewViewNo="
				+ reviewViewNo + ", reviewStatus=" + reviewStatus + ", proNo=" + proNo + "]";
	}
	
	
	
}
