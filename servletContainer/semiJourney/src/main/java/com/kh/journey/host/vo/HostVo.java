package com.kh.journey.host.vo;

public class HostVo {
	private String no;
	private String id;
	private String pwd;
	private String pwd2;
	private String name;
	private String phone;
	private String profile;
	private String enrollDate;
	private String delYn;
	
	// Constructor
	public HostVo(String no, String id, String pwd, String pwd2, String name, String phone, String profile,
			String enrollDate, String delYn) {
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.name = name;
		this.phone = phone;
		this.profile = profile;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
	}
	public HostVo() {
	}
	
	@Override
	public String toString() {
		return "HostVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", name=" + name + ", phone="
				+ phone + ", profile=" + profile + ", enrollDate=" + enrollDate + ", delYn=" + delYn + "]";
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
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
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
