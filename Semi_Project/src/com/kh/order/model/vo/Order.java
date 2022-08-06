package com.kh.order.model.vo;

import java.sql.Date;

public class Order {

		private int orderNo;
		private String orderOno;
		private int payOrderNo;
		private int productPrice;
		private Date orderDate;
		private int userNo;
		private int productNo;
		private String orderer;
		private String productName;
		private int allPrice = productPrice*payOrderNo;
		
		public Order() {
			super();
		}
		
		

		public Order(int orderNo, String orderOno, int payOrderNo, int productPrice, Date orderDate, int userNo,
				int productNo, String orderer, String productName, int allPrice) {
			super();
			this.orderNo = orderNo;
			this.orderOno = orderOno;
			this.payOrderNo = payOrderNo;
			this.productPrice = productPrice;
			this.orderDate = orderDate;
			this.userNo = userNo;
			this.productNo = productNo;
			this.orderer = orderer;
			this.productName = productName;
			this.allPrice = allPrice;
		}



		public Order(String orderOno, int orderNo, Date orderDate, String orderer, String productName, int productPrice) {
			super();
			this.orderOno = orderOno;
			this.orderNo = orderNo;
			this.orderDate = orderDate;
			this.orderer = orderer;
			this.productName = productName;
			this.productPrice = productPrice;
		}

		public int getOrderNo() {
			return orderNo;
		}

		public void setOrderNo(int orderNo) {
			this.orderNo = orderNo;
		}

		public String getOrderOno() {
			return orderOno;
		}

		public void setOrderOno(String orderOno) {
			this.orderOno = orderOno;
		}

		public int getPayOrderNo() {
			return payOrderNo;
		}

		public void setPayOrderNo(int payOrderNo) {
			this.payOrderNo = payOrderNo;
		}

		public int getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}

		

		public Date getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}

		public int getUserNo() {
			return userNo;
		}

		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}

		public int getProductNo() {
			return productNo;
		}

		public void setProductNo(int productNo) {
			this.productNo = productNo;
		}

		public String getOrderer() {
			return orderer;
		}


		public void setOrderer(String orderer) {
			this.orderer = orderer;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}



		public int getAllPrice() {
			return allPrice;
		}

		public void setAllPrice(int allPrice) {
			this.allPrice = allPrice;
		}



		@Override
		public String toString() {
			return "Order [orderNo=" + orderNo + ", orderOno=" + orderOno + ", payOrderNo=" + payOrderNo
					+ ", productPrice=" + productPrice + ", orderDate=" + orderDate + ", userNo=" + userNo
					+ ", productNo=" + productNo + ", orderer=" + orderer + ", productName=" + productName
					+ ", allPrice=" + allPrice + "]";
		}

		

		
}

		