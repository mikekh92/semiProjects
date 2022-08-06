package com.kh.notice.model.vo;

import java.sql.Date;

public class Notice {

	private int noticeNo;						//NOTICE_NO(공지사항)
	private String noticeTitle;				//NOTICE_TITLE(제목)
	private String noticeContent;		//NOTICE_CONTENT(내용)
	private String noticeWriter;			
	private Date noticeDate;				//NOTICE_DATE(작성일)
	private int noticeViewNo;				//NOTICE_VIEWNO(조회수)
	private int userNo;
	private String noticeStatus;
	public Notice() {
		super();
	}
		
		public Notice(int noticeNo, String noticeTitle, String noticeContent, Date noticeDate, int noticeViewNo,
				int userNo, String noticeWriter) {
			super();
			this.noticeNo = noticeNo;
			this.noticeTitle = noticeTitle;
			this.noticeContent = noticeContent;
			this.noticeDate = noticeDate;
			this.noticeViewNo = noticeViewNo;
			this.userNo = userNo;
			this.noticeWriter = noticeWriter;
		}

		public Notice(int noticeNo, String noticeTitle, String noticeWriter,  int noticeViewNo,Date noticeDate ) {
			super();
			this.noticeNo = noticeNo;
			this.noticeTitle = noticeTitle;
			this.noticeWriter = noticeWriter;
			this.noticeViewNo = noticeViewNo;
			this.noticeDate = noticeDate;
		}
		
		

		public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, Date noticeDate) {
			super();
			this.noticeNo = noticeNo;
			this.noticeTitle = noticeTitle;
			this.noticeContent = noticeContent;
			this.noticeWriter = noticeWriter;
			this.noticeDate = noticeDate;
		}

		public Notice(int noticeNo, String noticeTitle, String noticeContent, Date noticeDate,String noticeWriter, 
				String noticeStatus) {
			super();
			this.noticeNo = noticeNo;
			this.noticeTitle = noticeTitle;
			this.noticeContent = noticeContent;
			this.noticeDate = noticeDate;
			this.noticeWriter = noticeWriter;
			this.noticeStatus = noticeStatus;
		}

		public Notice(int noticeNo, String noticeTitle) {
			super();
			this.noticeNo = noticeNo;
			this.noticeTitle = noticeTitle;
		}

		public int getNoticeNo() {
			return noticeNo;
		}
		public void setNoticeNo(int noticeNo) {
			this.noticeNo = noticeNo;
		}
		public String getNoticeTitle() {
			return noticeTitle;
		}
		public void setNoticeTitle(String noticeTitle) {
			this.noticeTitle = noticeTitle;
		}
		public String getNoticeContent() {
			return noticeContent;
		}
		public void setNoticeContent(String noticeContent) {
			this.noticeContent = noticeContent;
		}
		public Date getNoticeDate() {
			return noticeDate;
		}
		public void setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate;
		}
		public int getNoticeViewNo() {
			return noticeViewNo;
		}
		public void setNoticeViewNo(int noticeViewNo) {
			this.noticeViewNo = noticeViewNo;
		}
		
		public int getUserNo() {
			return userNo;
		}

		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}
		
		public String getNoticeWriter() {
			return noticeWriter;
		}

		public void setNoticeWriter(String noticeWriter) {
			this.noticeWriter = noticeWriter;
		}

		public String getNoticeStatus() {
			return noticeStatus;
		}

		public void setNoticeStatus(String noticeStatus) {
			this.noticeStatus = noticeStatus;
		}

		@Override
		public String toString() {
			return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
					+ ", noticeDate=" + noticeDate + ", noticeViewNo=" + noticeViewNo + ", userNo=" + userNo
					+ ", noticeWriter=" + noticeWriter + "]";
		}

		
		
		
		
		
		
		
		
		
		
		
}
