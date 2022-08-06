package com.kh.product.model.vo;

public class Attachment {
	private int fileNo;
	private int refPno;
	private String originName;
	private String changeName;
	private String filePath;
	
	public Attachment() {
		super();
	}

	public Attachment(int fileNo, int refPno, String originName, String changeName, String filePath) {
		super();
		this.fileNo = fileNo;
		this.refPno = refPno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getRefPno() {
		return refPno;
	}

	public void setRefPno(int refPno) {
		this.refPno = refPno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refPno=" + refPno + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + "]";
	}

	

	
}
