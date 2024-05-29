package com.kh.journey.reservation.vo;

public class ReservationVo {

	
	private String reserveNo;
	public ReservationVo() {
		super();
	}
	public ReservationVo(String reserveNo, String reservatorNo, String reservatorName, String reservatorEmail,
			String reservatorPhone, String reservatorProfile, String sum, String inDate, String outDate, String stayDay,
			String reserveDate, String delYn, String refundYn, String guestCount, String reviewNo, String roomNo,
			String roomName, String roomImg, String weekdayPrice, String weekendPrice, String address, String hostName,
			String hostEnrollDate, String hostPhone, String hostProfile, String payMethodName, String cardNo,
			String payMethodCode) {
		super();
		this.reserveNo = reserveNo;
		this.reservatorNo = reservatorNo;
		this.reservatorName = reservatorName;
		this.reservatorEmail = reservatorEmail;
		this.reservatorPhone = reservatorPhone;
		this.reservatorProfile = reservatorProfile;
		this.sum = sum;
		this.inDate = inDate;
		this.outDate = outDate;
		this.stayDay = stayDay;
		this.reserveDate = reserveDate;
		this.delYn = delYn;
		this.refundYn = refundYn;
		this.guestCount = guestCount;
		this.reviewNo = reviewNo;
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.roomImg = roomImg;
		this.weekdayPrice = weekdayPrice;
		this.weekendPrice = weekendPrice;
		this.address = address;
		this.hostName = hostName;
		this.hostEnrollDate = hostEnrollDate;
		this.hostPhone = hostPhone;
		this.hostProfile = hostProfile;
		this.payMethodName = payMethodName;
		this.cardNo = cardNo;
		this.payMethodCode = payMethodCode;
	}
	@Override
	public String toString() {
		return "ReservationVo [reserveNo=" + reserveNo + ", reservatorNo=" + reservatorNo + ", reservatorName="
				+ reservatorName + ", reservatorEmail=" + reservatorEmail + ", reservatorPhone=" + reservatorPhone
				+ ", reservatorProfile=" + reservatorProfile + ", sum=" + sum + ", inDate=" + inDate + ", outDate="
				+ outDate + ", stayDay=" + stayDay + ", reserveDate=" + reserveDate + ", delYn=" + delYn + ", refundYn="
				+ refundYn + ", guestCount=" + guestCount + ", reviewNo=" + reviewNo + ", roomNo=" + roomNo
				+ ", roomName=" + roomName + ", roomImg=" + roomImg + ", weekdayPrice=" + weekdayPrice
				+ ", weekendPrice=" + weekendPrice + ", address=" + address + ", hostName=" + hostName
				+ ", hostEnrollDate=" + hostEnrollDate + ", hostPhone=" + hostPhone + ", hostProfile=" + hostProfile
				+ ", payMethodName=" + payMethodName + ", cardNo=" + cardNo + ", payMethodCode=" + payMethodCode + "]";
	}
	public String getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getReservatorNo() {
		return reservatorNo;
	}
	public void setReservatorNo(String reservatorNo) {
		this.reservatorNo = reservatorNo;
	}
	public String getReservatorName() {
		return reservatorName;
	}
	public void setReservatorName(String reservatorName) {
		this.reservatorName = reservatorName;
	}
	public String getReservatorEmail() {
		return reservatorEmail;
	}
	public void setReservatorEmail(String reservatorEmail) {
		this.reservatorEmail = reservatorEmail;
	}
	public String getReservatorPhone() {
		return reservatorPhone;
	}
	public void setReservatorPhone(String reservatorPhone) {
		this.reservatorPhone = reservatorPhone;
	}
	public String getReservatorProfile() {
		return reservatorProfile;
	}
	public void setReservatorProfile(String reservatorProfile) {
		this.reservatorProfile = reservatorProfile;
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
	public String getStayDay() {
		return stayDay;
	}
	public void setStayDay(String stayDay) {
		this.stayDay = stayDay;
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
	public String getGuestCount() {
		return guestCount;
	}
	public void setGuestCount(String guestCount) {
		this.guestCount = guestCount;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomImg() {
		return roomImg;
	}
	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHostEnrollDate() {
		return hostEnrollDate;
	}
	public void setHostEnrollDate(String hostEnrollDate) {
		this.hostEnrollDate = hostEnrollDate;
	}
	public String getHostPhone() {
		return hostPhone;
	}
	public void setHostPhone(String hostPhone) {
		this.hostPhone = hostPhone;
	}
	public String getHostProfile() {
		return hostProfile;
	}
	public void setHostProfile(String hostProfile) {
		this.hostProfile = hostProfile;
	}
	public String getPayMethodName() {
		return payMethodName;
	}
	public void setPayMethodName(String payMethodName) {
		this.payMethodName = payMethodName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getPayMethodCode() {
		return payMethodCode;
	}
	public void setPayMethodCode(String payMethodCode) {
		this.payMethodCode = payMethodCode;
	}
	private String reservatorNo;
	private String reservatorName;
	private String reservatorEmail;
	private String reservatorPhone;
	private String reservatorProfile;
	private String sum;
	private String inDate;
	private String outDate;
	private String stayDay;
	private String reserveDate;
	private String delYn;
	private String refundYn;
	private String guestCount;
	private String reviewNo;

	private String roomNo;
	private String roomName;
	private String roomImg;
	private String weekdayPrice;
	private String weekendPrice;
	private String address;

	private String hostName;
	private String hostEnrollDate;
	private String hostPhone;
	private String hostProfile;

	private String payMethodName;
	private String cardNo;
	private String payMethodCode;

}