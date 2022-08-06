package com.kh.product.model.vo;

public class Category {
	private int cateNo;
	private String cateName;
	
	public Category() {
		super();
	}

	public Category(int cateNo, String cateName) {
		super();
		this.cateNo = cateNo;
		this.cateName = cateName;
	}

	public Category(String cateName) {
		super();
		this.cateName = cateName;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "Category [cateNo=" + cateNo + ", cateName=" + cateName + "]";
	}

	
	
}
