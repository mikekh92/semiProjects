package com.kh.product.model.vo;

public class Product {
	private int proNo;//	PRO_NO	NUMBER
	private String proName;//	PRO_NAME	VARCHAR2(100 BYTE)
	private String proCode;//	PRO_CODE	VARCHAR2(100 BYTE)
	private String proImage;//	PRO_IMAGE	VARCHAR2(100 BYTE)
	private String proMaker;//	PRO_MAKER	VARCHAR2(100 BYTE)
	private String proDes;//	PRO_DES	VARCHAR2(1000 BYTE)
	private int cateBno;//	CATE_BNO	NUMBER
	private int cateSno;//	CATE_SNO	NUMBER
	private String proSize;//	PRO_SIZE	VARCHAR2(10 BYTE)
	private int proPrice;//	PRO_PRICE	NUMBER
	private int proAmount;//	PRO_AMOUNT	NUMBER
	private String proLevel;//	PRO_LEVEL	NUMBER
	private int deliveryPrice;//	DELIVERY_PRICE	NUMBER
	private String status;//	PRO_STATUS	CHAR(2 BYTE)
	private String sellstat;
	
	public Product() {
		super();
	}

	public Product(int proNo, String proName, String proCode, String proImage, String proMaker, String proDes,
			int cateBno, int cateSno, String proSize, int proPrice, int proAmount, String proLevel, int deliveryPrice,
			String status, String sellstat) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.proCode = proCode;
		this.proImage = proImage;
		this.proMaker = proMaker;
		this.proDes = proDes;
		this.cateBno = cateBno;
		this.cateSno = cateSno;
		this.proSize = proSize;
		this.proPrice = proPrice;
		this.proAmount = proAmount;
		this.proLevel = proLevel;
		this.deliveryPrice = deliveryPrice;
		this.status = status;
		this.sellstat = sellstat;
	}

	public Product(int proNo, String proName, String proCode, String proMaker, int proPrice, int proAmount,
			String status, String sellstat) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.proCode = proCode;
		this.proMaker = proMaker;
		this.proPrice = proPrice;
		this.proAmount = proAmount;
		this.status = status;
		this.sellstat = sellstat;
	}


	public Product(int proNo, String proName, String proCode, String proMaker, String proDes, int cateBno, int cateSno,
			String proSize, int proPrice, int proAmount, String proLevel, String status, String sellstat) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.proCode = proCode;
		this.proMaker = proMaker;
		this.proDes = proDes;
		this.cateBno = cateBno;
		this.cateSno = cateSno;
		this.proSize = proSize;
		this.proPrice = proPrice;
		this.proAmount = proAmount;
		this.proLevel = proLevel;
		this.status = status;
		this.sellstat = sellstat;
	}
	public Product(int proNo, String proName, String proImage, String proMaker, String proDes, int proPrice,
			int proAmount) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.proImage = proImage;
		this.proMaker = proMaker;
		this.proDes = proDes;
		this.proPrice = proPrice;
		this.proAmount = proAmount;
	}


	public Product(int proNo, String proName,int proPrice,String proImage, int cateBno, int cateSno) {
		super();
		this.proNo = proNo;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proImage = proImage;
		this.cateBno = cateBno;
		this.cateSno = cateSno;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getProImage() {
		return proImage;
	}

	public void setProImage(String proImage) {
		this.proImage = proImage;
	}

	public String getProMaker() {
		return proMaker;
	}

	public void setProMaker(String proMaker) {
		this.proMaker = proMaker;
	}

	public String getProDes() {
		return proDes;
	}

	public void setProDes(String proDes) {
		this.proDes = proDes;
	}

	public int getCateBno() {
		return cateBno;
	}

	public void setCateBno(int cateBno) {
		this.cateBno = cateBno;
	}

	public int getCateSno() {
		return cateSno;
	}

	public void setCateSno(int cateSno) {
		this.cateSno = cateSno;
	}

	public String getProSize() {
		return proSize;
	}

	public void setProSize(String proSize) {
		this.proSize = proSize;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public int getProAmount() {
		return proAmount;
	}

	public void setProAmount(int proAmount) {
		this.proAmount = proAmount;
	}

	public String getProLevel() {
		return proLevel;
	}

	public void setProLevel(String proLevel) {
		this.proLevel = proLevel;
	}

	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSellstat() {
		return sellstat;
	}

	public void setSellstat(String sellstat) {
		this.sellstat = sellstat;
	}

	@Override
	public String toString() {
		return "Product [proNo=" + proNo + ", proName=" + proName + ", proCode=" + proCode + ", proImage=" + proImage
				+ ", proMaker=" + proMaker + ", proDes=" + proDes + ", cateBno=" + cateBno + ", cateSno=" + cateSno
				+ ", proSize=" + proSize + ", proPrice=" + proPrice + ", proAmount=" + proAmount + ", proLevel="
				+ proLevel + ", deliveryPrice=" + deliveryPrice + ", status=" + status + ", sellstat=" + sellstat + "]";
	}



	
}
