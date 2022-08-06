package com.kh.member.model.vo;

public class management {
	
	
	
	private String bank_Name;	//계좌이름
	private String acount_Num;		//계좌번호
	
	private String bank_Name2;	//계좌이름
	private String acount_Num2;		//계좌번호
	
	private String bank_Name3;	//계좌이름
	private String acount_Num3;	//계좌번호
	
	
	public management() {
		super();
	}


	public management(String bank_Name, String acount_Num, String bank_Name2, String acount_Num2, String bank_Name3,
			String acount_Num3) {
		super();
		this.bank_Name = bank_Name;
		this.acount_Num = acount_Num;
		this.bank_Name2 = bank_Name2;
		this.acount_Num2 = acount_Num2;
		this.bank_Name3 = bank_Name3;
		this.acount_Num3 = acount_Num3;
	}


	public String getBank_Name() {
		return bank_Name;
	}


	public void setBank_Name(String bank_Name) {
		this.bank_Name = bank_Name;
	}


	public String getAcount_Num() {
		return acount_Num;
	}


	public void setAcount_Num(String acount_Num) {
		this.acount_Num = acount_Num;
	}


	public String getBank_Name2() {
		return bank_Name2;
	}


	public void setBank_Name2(String bank_Name2) {
		this.bank_Name2 = bank_Name2;
	}


	public String getAcount_Num2() {
		return acount_Num2;
	}


	public void setAcount_Num2(String acount_Num2) {
		this.acount_Num2 = acount_Num2;
	}


	public String getBank_Name3() {
		return bank_Name3;
	}


	public void setBank_Name3(String bank_Name3) {
		this.bank_Name3 = bank_Name3;
	}


	public String getAcount_Num3() {
		return acount_Num3;
	}


	public void setAcount_Num3(String acount_Num3) {
		this.acount_Num3 = acount_Num3;
	}


	@Override
	public String toString() {
		return "management [bank_Name=" + bank_Name + ", acount_Num=" + acount_Num + ", bank_Name2=" + bank_Name2
				+ ", acount_Num2=" + acount_Num2 + ", bank_Name3=" + bank_Name3 + ", acount_Num3=" + acount_Num3 + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
