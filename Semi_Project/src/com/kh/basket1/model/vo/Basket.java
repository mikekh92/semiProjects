package com.kh.basket1.model.vo;

public class Basket {
	private int basketNo;
	private int userNo;
	private int proNo;
	private int payOrderNo;
	private String proName;
	private int proPrice;
	public Basket(int proNo, String proName, int proPrice, int payOrderNo) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.proPrice = proPrice;
		this.payOrderNo = payOrderNo;
	}
	public Basket() {
		super();
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public Basket(int basketNo, int userNo, int proNo, int payOrderNo) {
		super();
		this.basketNo = basketNo;
		this.userNo = userNo;
		this.proNo = proNo;
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
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public int getPayOrderNo() {
		return payOrderNo;
	}
	public void setPayOrderNo(int payOrderNo) {
		this.payOrderNo = payOrderNo;
	}
	@Override
	public String toString() {
		return "Basket [basketNo=" + basketNo + ", userNo=" + userNo + ", proNo=" + proNo + ", payOrderNo=" + payOrderNo
				+ "]";
	}
	
	
}
