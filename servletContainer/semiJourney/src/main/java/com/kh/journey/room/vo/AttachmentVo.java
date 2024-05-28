package com.kh.journey.room.vo;

public class AttachmentVo {
	
	private String refNo;
	private String originName;
	private String changeName;
	private String uploadDate;
	private String delYn;
	
	// Constructor
	public AttachmentVo(String refNo, String originName, String changeName, String uploadDate, String delYn) {
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.uploadDate = uploadDate;
		this.delYn = delYn;
	}
	public AttachmentVo() {
	}
	
	@Override
	public String toString() {
		return "AttachmentVo [refNo=" + refNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", uploadDate=" + uploadDate + ", delYn=" + delYn + "]";
	}
	
	// Getter, Setter
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
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
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
} // class
