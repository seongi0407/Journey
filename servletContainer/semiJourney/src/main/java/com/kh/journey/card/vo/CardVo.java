package com.kh.journey.card.vo;

public class CardVo {

	public CardVo() {
		super();
	}
	public CardVo(String no, String memNo, String cardNick, String cardNum, String cvcNum, String expireDate,
			String pwd) {
		super();
		this.no = no;
		this.memNo = memNo;
		this.cardNick = cardNick;
		this.cardNum = cardNum;
		this.cvcNum = cvcNum;
		this.expireDate = expireDate;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "CardVo [no=" + no + ", memNo=" + memNo + ", cardNick=" + cardNick + ", cardNum=" + cardNum + ", cvcNum="
				+ cvcNum + ", expireDate=" + expireDate + ", pwd=" + pwd + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMemNo() {
		return memNo;
	}
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	public String getCardNick() {
		return cardNick;
	}
	public void setCardNick(String cardNick) {
		this.cardNick = cardNick;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCvcNum() {
		return cvcNum;
	}
	public void setCvcNum(String cvcNum) {
		this.cvcNum = cvcNum;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getpwd() {
		return pwd;
	}
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
	private String no;
	private String memNo;
	private String cardNick;
	private String cardNum;
	private String cvcNum;
	private String expireDate;
	private String pwd;
	


}
