package com.kh.report.model.vo;

import java.sql.Date;

public class Report {
	private int repNo;
	private Date repEnterdate;
	private String repTitle;
	private String repContent;
	private String repUserId;
	private String repRepoter;
	private String repStatus;
	public Report() {
		super();
	}
	public Report(int repNo, Date repEnterdate, String repTitle, String repContent, String repUserId, String repRepoter,
			String repStatus) {
		super();
		this.repNo = repNo;
		this.repEnterdate = repEnterdate;
		this.repTitle = repTitle;
		this.repContent = repContent;
		this.repUserId = repUserId;
		this.repRepoter = repRepoter;
		this.repStatus = repStatus;
	}
	public int getrepNo() {
		return repNo;
	}
	public void setrepNo(int repNo) {
		this.repNo = repNo;
	}
	public Date getrepEnterdate() {
		return repEnterdate;
	}
	public void setrepEnterdate(Date repEnterdate) {
		this.repEnterdate = repEnterdate;
	}
	public String getrepTitle() {
		return repTitle;
	}
	public void setrepTitle(String repTitle) {
		this.repTitle = repTitle;
	}
	public String getrepContent() {
		return repContent;
	}
	public void setrepContent(String repContent) {
		this.repContent = repContent;
	}
	public String getrepUserId() {
		return repUserId;
	}
	public void setrepUserId(String repUserId) {
		this.repUserId = repUserId;
	}
	public String getrepRepoter() {
		return repRepoter;
	}
	public void setrepRepoter(String repRepoter) {
		this.repRepoter = repRepoter;
	}
	public String getrepStatus() {
		return repStatus;
	}
	public void setrepStatus(String repStatus) {
		this.repStatus = repStatus;
	}
	@Override
	public String toString() {
		return "Report [repNo=" + repNo + ", repEnterdate=" + repEnterdate + ", repTitle=" + repTitle + ", repContent="
				+ repContent + ", repUserId=" + repUserId + ", repRepoter=" + repRepoter + ", repStatus=" + repStatus
				+ "]";
	}
	
	
}
