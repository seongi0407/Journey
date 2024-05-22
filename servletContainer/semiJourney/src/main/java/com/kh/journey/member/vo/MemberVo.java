package com.kh.journey.member.vo;

public class MemberVo {
	private String no;
	private String id;
	private String pwd;
	private String pwd2;
	private String name;
	private String email;
	private String mileage;
	private String phone;
	private String profile;
	private String birthDate;
	private String enrollDate;
	private String delYn;
	
	// Constructor
	public MemberVo(String no, String id, String pwd, String pwd2, String name, String email, String mileage,
			String phone, String profile, String birthDate, String enrollDate, String delYn) {
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.name = name;
		this.email = email;
		this.mileage = mileage;
		this.phone = phone;
		this.profile = profile;
		this.birthDate = birthDate;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
	}
	public MemberVo() {
	}
	
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", name=" + name + ", email="
				+ email + ", mileage=" + mileage + ", phone=" + phone + ", profile=" + profile + ", birthDate="
				+ birthDate + ", enrollDate=" + enrollDate + ", delYn=" + delYn + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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
