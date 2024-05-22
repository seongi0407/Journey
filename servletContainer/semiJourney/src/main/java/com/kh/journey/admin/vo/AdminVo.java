package com.kh.journey.admin.vo;

public class AdminVo {
	private String no;
	private String id;
	private String pwd;
	private String name;
	private String enrollDate;
	private String delYn;
	
	// Constructor
	public AdminVo(String no, String id, String pwd, String name, String enrollDate, String delYn) {
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
	}
	public AdminVo() {
	}
	
	@Override
	public String toString() {
		return "AdminVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", enrollDate=" + enrollDate
				+ ", delYn=" + delYn + "]";
	}
	
	// Getter, Setter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
} // class
