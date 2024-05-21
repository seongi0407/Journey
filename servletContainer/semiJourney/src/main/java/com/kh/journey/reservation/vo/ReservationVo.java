package com.kh.journey.reservation.vo;

public class ReservationVo {

	private String no;
	private String payMethodCode;
	private String reservatorNo;
	private String roomNo;
	private String sum;
	private String inDate;
	private String outDate;
	private String reserveDate;
	private String delYn;
	private String refundYn;
	private String peopleCnt;

	private String payMethodName;
	private String roomName;
	private String reservatorName;
	private String weekdayPrice;
	private String weekendPrice;

	public ReservationVo() {
		super();
	}

	public ReservationVo(String no, String payMethodCode, String reservatorNo, String roomNo, String sum, String inDate,
			String outDate, String reserveDate, String delYn, String refundYn, String peopleCnt, String payMethodName,
			String roomName, String reservatorName, String weekdayPrice, String weekendPrice) {
		super();
		this.no = no;
		this.payMethodCode = payMethodCode;
		this.reservatorNo = reservatorNo;
		this.roomNo = roomNo;
		this.sum = sum;
		this.inDate = inDate;
		this.outDate = outDate;
		this.reserveDate = reserveDate;
		this.delYn = delYn;
		this.refundYn = refundYn;
		this.peopleCnt = peopleCnt;
		this.payMethodName = payMethodName;
		this.roomName = roomName;
		this.reservatorName = reservatorName;
		this.weekdayPrice = weekdayPrice;
		this.weekendPrice = weekendPrice;
	}

	@Override
	public String toString() {
		return "ReservationVo [no=" + no + ", payMethodCode=" + payMethodCode + ", reservatorNo=" + reservatorNo
				+ ", roomNo=" + roomNo + ", sum=" + sum + ", inDate=" + inDate + ", outDate=" + outDate
				+ ", reserveDate=" + reserveDate + ", delYn=" + delYn + ", refundYn=" + refundYn + ", peopleCnt="
				+ peopleCnt + ", payMethodName=" + payMethodName + ", roomName=" + roomName + ", reservatorName="
				+ reservatorName + ", weekdayPrice=" + weekdayPrice + ", weekendPrice=" + weekendPrice + "]";
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPayMethodCode() {
		return payMethodCode;
	}

	public void setPayMethodCode(String payMethodCode) {
		this.payMethodCode = payMethodCode;
	}

	public String getReservatorNo() {
		return reservatorNo;
	}

	public void setReservatorNo(String reservatorNo) {
		this.reservatorNo = reservatorNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getRefundYn() {
		return refundYn;
	}

	public void setRefundYn(String refundYn) {
		this.refundYn = refundYn;
	}

	public String getPeopleCnt() {
		return peopleCnt;
	}

	public void setPeopleCnt(String peopleCnt) {
		this.peopleCnt = peopleCnt;
	}

	public String getPayMethodName() {
		return payMethodName;
	}

	public void setPayMethodName(String payMethodName) {
		this.payMethodName = payMethodName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getReservatorName() {
		return reservatorName;
	}

	public void setReservatorName(String reservatorName) {
		this.reservatorName = reservatorName;
	}

	public String getWeekdayPrice() {
		return weekdayPrice;
	}

	public void setWeekdayPrice(String weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}

	public String getWeekendPrice() {
		return weekendPrice;
	}

	public void setWeekendPrice(String weekendPrice) {
		this.weekendPrice = weekendPrice;
	}

}