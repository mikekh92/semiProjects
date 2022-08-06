package com.kh.member.model.vo;

public class Address {
	private int Post_Code;
	private String Road_Address;
	private String Jibun_Address;
	private String Detail_Address;
	private String Extra_Address;
	
	
	public Address() {
		super();
	}


	public Address(int post_Code, String road_Address, String jibun_Address, String detail_Address, String extra_Address) {
		super();
		this.Post_Code = post_Code;
		this.Road_Address = road_Address;
		this.Jibun_Address = jibun_Address;
		this.Detail_Address = detail_Address;
		this.Extra_Address = extra_Address;
	}


	public int getPost_Code() {
		return Post_Code;
	}


	public void setPost_Code(int post_Code) {
		Post_Code = post_Code;
	}


	public String getRoad_Address() {
		return Road_Address;
	}


	public void setRoad_Address(String road_Address) {
		Road_Address = road_Address;
	}


	public String getJibun_Address() {
		return Jibun_Address;
	}


	public void setJibun_Address(String jibun_Address) {
		Jibun_Address = jibun_Address;
	}


	public String getDetail_Address() {
		return Detail_Address;
	}


	public void setDetail_Address(String detail_Address) {
		Detail_Address = detail_Address;
	}


	public String getExtra_Address() {
		return Extra_Address;
	}


	public void setExtra_Address(String extra_Address) {
		Extra_Address = extra_Address;
	}


	@Override
	public String toString() {
		return "Address [Post_Code=" + Post_Code + ", Road_Address=" + Road_Address + ", Jibun_Address=" + Jibun_Address
				+ ", Detail_Address=" + Detail_Address + ", Extra_Address=" + Extra_Address + "]";
	}

	
	
	
	

}
