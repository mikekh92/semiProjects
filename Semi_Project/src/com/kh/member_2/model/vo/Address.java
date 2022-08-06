package com.kh.member_2.model.vo;

public class Address {
	String userId;
	int postCode;
	String roadAddress;
	String jibunAddress;
	String detailAddress;
	String extraAddress;
	public Address() {
		super();
	}
	public Address(String userId, int postCode, String roadAddress, String jibunAddress, String detailAddress,
			String extraAddress) {
		super();
		this.userId = userId;
		this.postCode = postCode;
		this.roadAddress = roadAddress;
		this.jibunAddress = jibunAddress;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
	}
	
	public Address(int postCode, String roadAddress, String jibunAddress, String detailAddress, String extraAddress) {
		super();
		this.postCode = postCode;
		this.roadAddress = roadAddress;
		this.jibunAddress = jibunAddress;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getJibunAddress() {
		return jibunAddress;
	}
	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getExtraAddress() {
		return extraAddress;
	}
	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	@Override
	public String toString() {
		return "ADDRESS [userId=" + userId + ", postCode=" + postCode + ", roadAddress=" + roadAddress
				+ ", jibunAddress=" + jibunAddress + ", detailAddress=" + detailAddress + ", extraAddress="
				+ extraAddress + "]";
	}
	
	
}
