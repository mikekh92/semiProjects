package com.kh.serviceCenter.model.vo;

import java.sql.Date;

public class QNA {
	private int qnaNo;
	private String qnaCate;
	private String qnaId;
	private Date qnaEnterdate;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaAnswerdate;
	private String qnaAnswer;
	private String qnaStatus;
	public QNA() {
		super();
	}
	public QNA(int qnaNo, String qnaCate, String qnaId, Date qnaEnterdate, String qnaTitle, String qnaContent,
			Date qnaAnswerdate, String qnaAnswer, String qnaStatus) {
		super();
		this.qnaNo = qnaNo;
		this.qnaCate = qnaCate;
		this.qnaId = qnaId;
		this.qnaEnterdate = qnaEnterdate;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaAnswerdate = qnaAnswerdate;
		this.qnaAnswer = qnaAnswer;
		this.qnaStatus = qnaStatus;
	}
	
	public QNA(String qnaId, String qnaCate, String qnaTitle, String qnaContent) {
		super();
		this.qnaId = qnaId;
		this.qnaCate = qnaCate;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaCate() {
		return qnaCate;
	}
	public void setQnaCate(String qnaCate) {
		this.qnaCate = qnaCate;
	}
	public String getQnaId() {
		return qnaId;
	}
	public void setQnaId(String qnaId) {
		this.qnaId = qnaId;
	}
	public Date getQnaEnterdate() {
		return qnaEnterdate;
	}
	public void setQnaEnterdate(Date qnaEnterdate) {
		this.qnaEnterdate = qnaEnterdate;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public Date getQnaAnswerdate() {
		return qnaAnswerdate;
	}
	public void setQnaAnswerdate(Date qnaAnswerdate) {
		this.qnaAnswerdate = qnaAnswerdate;
	}
	public String getQnaAnswer() {
		return qnaAnswer;
	}
	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}
	public String getQnaStatus() {
		return qnaStatus;
	}
	public void setQnaStatus(String qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	@Override
	public String toString() {
		return "QNA [qnaNo=" + qnaNo + ", qnaCate=" + qnaCate + ", qnaId=" + qnaId + ", qnaEnterdate=" + qnaEnterdate
				+ ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaAnswerdate=" + qnaAnswerdate
				+ ", qnaAnswer=" + qnaAnswer + ", qnaStatus=" + qnaStatus + "]";
	}
	
	
}
