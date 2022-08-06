package com.kh.serviceCenter.model.vo;

public class FAQ {
	private int faqNo;
	private String faqCate;
	private String faqTitle;
	private String faqContent;
	private String faqStatus;
	public FAQ() {
		super();
	}
	public FAQ(int faqNo, String faqCate, String faqTitle, String faqContent, String faqStatus) {
		super();
		this.faqNo = faqNo;
		this.faqCate = faqCate;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqStatus = faqStatus;
	}
	
	public FAQ(int faqNo, String faqCate, String faqTitle, String faqContent) {
		super();
		this.faqNo = faqNo;
		this.faqCate = faqCate;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}
	
	public FAQ(String faqCate, String faqTitle, String faqContent) {
		super();
		this.faqCate = faqCate;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqCate() {
		return faqCate;
	}
	public void setFaqCate(String faqCate) {
		this.faqCate = faqCate;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getFaqStatus() {
		return faqStatus;
	}
	public void setFaqStatus(String faqStatus) {
		this.faqStatus = faqStatus;
	}
	@Override
	public String toString() {
		return "ServiceCenter [faqNo=" + faqNo + ", faqCate=" + faqCate + ", faqTitle=" + faqTitle + ", faqContent="
				+ faqContent + ", faqStatus=" + faqStatus + "]";
	}
	
	
	
}
