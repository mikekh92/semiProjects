package com.kh.memManage.model.vo;

import java.sql.Date;

public class Member {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private Date userBirth;
	private String gender;
	private String email;
	private String phone;
	private Date enterDate;
	private String uStatus;
	private int userRPC;
	public Member() {
		super();
	}

	public Member(int userNo, String userId, String userPw, String userName, Date userBirth,
			String gender, String email, String phone, Date enterDate, String uStatus, int userRPC) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.enterDate = enterDate;
		this.uStatus = uStatus;
		this.userRPC = userRPC;
	}

	public Member(int userNo, String userId, String userName, Date userBirth, String gender,
			String email, String phone, Date enterDate, String uStatus, int userRPC) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userBirth = userBirth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.enterDate = enterDate;
		this.uStatus = uStatus;
		this.userRPC = userRPC;
	}

	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	public int getUserRPC() {
		return userRPC;
	}
	public void setUserRPC(int userRPC) {
		this.userRPC = userRPC;
	}
	
	public String getuStatus() {
		return uStatus;
	}

	public void setuStatus(String uStatus) {
		this.uStatus = uStatus;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userBirth=" + userBirth + ", gender=" + gender + ", email=" + email
				+ ", phone=" + phone + ", enterDate=" + enterDate + ", userRPC=" + userRPC
				+ "]";
	}
	
	
}
