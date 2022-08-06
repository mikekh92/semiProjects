package com.kh.detail.model.vo;

public class Basket {
	private int proNo;
	private int basketNo;
	private int userNo;
	private String proName;
	private String proImage;
	private int payOrderNo;
	private String baStatus;
	private int proAmount;
	private int proPrice;
	
	public Basket() {
		super();
	}

	public Basket(int basketNo, int userNo, String proName, String proImage, int payOrderNo, String baStatus,
			int proAmount, int proPrice) {
		super();
		this.basketNo = basketNo;
		this.userNo = userNo;
		this.proName = proName;
		this.proImage = proImage;
		this.payOrderNo = payOrderNo;
		this.baStatus = baStatus;
		this.proAmount = proAmount;
		this.proPrice = proPrice;
	}

	public Basket(int basketNo, String proName, String proImage, int payOrderNo, int proPrice) {
		super();
		this.basketNo = basketNo;
		this.proName = proName;
		this.proImage = proImage;
		this.payOrderNo = payOrderNo;
		this.proPrice = proPrice;
	}

	
	
	
	public Basket(int basketNo, int userNo,int proNo, int payOrderNo) {
		super();
		this.basketNo = basketNo;
		this.userNo = userNo;
		this.setProNo(proNo);
		this.payOrderNo = payOrderNo;
	}

	public int getBasketNo() {
		return basketNo;
	}

	public void setBasketNo(int basketNo) {
		this.basketNo = basketNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProImage() {
		return proImage;
	}

	public void setProImage(String proImage) {
		this.proImage = proImage;
	}

	public int getPayOrderNo() {
		return payOrderNo;
	}

	public void setPayOrderNo(int payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public String getBaStatus() {
		return baStatus;
	}

	public void setBaStatus(String baStatus) {
		this.baStatus = baStatus;
	}

	public int getProAmount() {
		return proAmount;
	}

	public void setProAmount(int proAmount) {
		this.proAmount = proAmount;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public int getProNo() {
		return proNo;
	}
	
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	@Override
	public String toString() {
		return "Basket [basketNo=" + basketNo + ", userNo=" + userNo + ", proName=" + proName + ", proImage=" + proImage
				+ ", payOrderNo=" + payOrderNo + ", baStatus=" + baStatus + ", proAmount=" + proAmount + ", proPrice="
				+ proPrice + "]";
	}


	
	
}
