package com.kh.journey.reservation.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.journey.card.vo.CardVo;
import com.kh.journey.reservation.vo.ReservationVo;

public class ReservationDao {

	// 카드목록(정보) 가져오기
	public List<CardVo> getCardList(Connection conn, String loginMemNo) throws Exception {
		String sql = "SELECT * FROM CARD_INFO WHERE MEM_NO = ? ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		List<CardVo> cardVoList = new ArrayList<CardVo>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String memNo = rs.getString("MEM_NO");
			String cardNick = rs.getString("NO");
			String cardNum = rs.getString("CARD_NUM");
			String cvcNum = rs.getString("CVC_NUM");
			String expireDate = rs.getString("EXPIRE_DATE");
			String pwd = rs.getString("PWD");

			CardVo vo = new CardVo();
			vo.setNo(no);
			vo.setMemNo(memNo);
			vo.setCardNick(cardNick);
			vo.setCardNum(cardNum);
			vo.setCvcNum(cvcNum);
			vo.setExpireDate(expireDate);
			vo.setpwd(pwd);
			cardVoList.add(vo);
		}

		close(rs);
		close(pstmt);

		return cardVoList;
	}

	//예약시 룸 정보 가져오기
	public List<ReservationVo> getRoomDetail(Connection conn, String roomNo) throws Exception {
		String sql = "SELECT R.IMG_01, H.NAME AS HOST_NAME, H.PROFILE, H.ENROLL_DATE, R.NAME AS ROOM_NAME, R.WEEKDAY_PRICE, R.WEEKEND_PRICE FROM ROOM R JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO = A.HOST_NO WHERE R.NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, roomNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> roomDetail = new ArrayList<ReservationVo>();
		while (rs.next()) {

			String roomImg = rs.getString("IMG_01");
			String hostName = rs.getString("HOST_NAME");
			String profile = rs.getString("PROFILE");
			String hostEnrollDate = rs.getString("ENROLL_DATE");
			String roomName = rs.getString("ROOM_NAME");
			String weekdayPrice = rs.getString("WEEKDAY_PRICE");
			String weekendPrice = rs.getString("WEEKEND_PRICE");

			ReservationVo vo = new ReservationVo();
			vo.setRoomImg(roomImg);
			vo.setHostName(hostName);
			vo.setHostProfile(profile);
			vo.setHostEnrollDate(hostEnrollDate);
			vo.setRoomName(roomName);
			vo.setWeekdayPrice(weekdayPrice);
			vo.setWeekendPrice(weekendPrice);
			roomDetail.add(vo);
		}
		return roomDetail;

	}

	// 예약 내역 등록하기
	public int ReservationInsert(Connection conn, ReservationVo vo) throws Exception {

		String sql = "INSERT INTO RESERVATION (NO, PAY_METHOD_CODE, RESERVATOR_NO, ROOM_NO, SUM, IN_DATE, OUT_DATE)\r\n"
				+ "VALUES (SEQ_RESERVATION.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPayMethodCode());
		pstmt.setString(2, vo.getReservatorNo());
		pstmt.setString(3, vo.getRoomNo());
		pstmt.setString(4, vo.getSum());
		pstmt.setString(5, vo.getInDate());
		pstmt.setString(6, vo.getOutDate());
		int result = pstmt.executeUpdate();

		return result;
	}

	// 예약확인
	public List<ReservationVo> getMostRecentReservation(Connection conn, String loginMemNo) throws Exception {
		String sql = "SELECT * FROM ( SELECT RV.IN_DATE, RV.OUT_DATE, R.IMG_01, H.NAME AS HOST_NAME, RV.SUM, R.NAME AS ROOM_NAME, RV.GUEST_COUNT FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO = R.NO JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO = A.HOST_NO WHERE RV.RESERVATOR_NO = ? AND RV.DEL_YN = 'N' AND RV.REFUND_YN = 'N' AND RV.IN_DATE > SYSDATE ORDER BY RV.RESERVE_DATE DESC ) WHERE ROWNUM = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> reservationList = new ArrayList<ReservationVo>();
		while (rs.next()) {

			String roomImg = rs.getString("IMG_01");
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String roomName = rs.getString("ROOM_NAME");
			String hostName = rs.getString("HOST_NAME");
			String weekdayPrice = rs.getString("WEEKDAY_PRICE");
			String weekendPrice = rs.getString("WEEKEND_PRICE");
			String sum = rs.getString("SUM");
			String guestCount = rs.getString("GUEST_COUNT");

			ReservationVo vo = new ReservationVo();
			vo.setRoomImg(roomImg);
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setRoomName(roomName);
			vo.setHostName(hostName);
			vo.setWeekdayPrice(weekdayPrice);
			vo.setWeekendPrice(weekendPrice);
			vo.setSum(sum);
			vo.setGuestCount(guestCount);

			reservationList.add(vo);
		}

		return reservationList;
	}

	// 예약내역조회 - 예정된 예약
	public List<ReservationVo> getReservationList(Connection conn, String loginMemNo) throws Exception {

		// 예정된 예약
		String sql = "SELECT RV.IN_DATE ,RV.OUT_DATE , R.NAME , R.IMG_01 FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO =R.NO WHERE RESERVATOR_NO = ? AND RV.DEL_YN ='N' AND RV.REFUND_YN ='N' AND IN_DATE > SYSDATE ORDER BY RESERVE_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> reservationList = new ArrayList<ReservationVo>();
		while (rs.next()) {
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String name = rs.getString("NAME");
			String img_01 = rs.getString("IMG_01");

			ReservationVo vo = new ReservationVo();
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setRoomName(name);
			vo.setRoomNo(img_01);
			reservationList.add(vo);
		}
		return reservationList;
	}

	// 예약내역조회 - 지난 예약
	public List<ReservationVo> getHistoryList(Connection conn, String loginMemNo) throws Exception {

		// 예정된 예약
		String sql = "SELECT RV.IN_DATE ,RV.OUT_DATE , R.NAME , R.IMG_01 FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO =R.NO WHERE RESERVATOR_NO = ? AND RV.DEL_YN ='N' AND RV.REFUND_YN ='N' AND OUT_DATE < SYSDATE ORDER BY RESERVE_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> historyList = new ArrayList<ReservationVo>();
		while (rs.next()) {
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String name = rs.getString("NAME");
			String img_01 = rs.getString("IMG_01");

			ReservationVo vo = new ReservationVo();
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setRoomName(name);
			vo.setRoomNo(img_01);
			historyList.add(vo);
		}
		return historyList;
	}

	// 예약내역조회 - 환불된 예약
	public List<ReservationVo> getRefundList(Connection conn, String loginMemNo) throws Exception {

		// 예정된 예약
		String sql = "SELECT RV.RESERVE_DATE , R.NAME , R.IMG_01 FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO =R.NO WHERE RESERVATOR_NO = ? AND RV.DEL_YN ='N' AND RV.REFUND_YN ='Y' ORDER BY RESERVE_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> refundList = new ArrayList<ReservationVo>();
		while (rs.next()) {
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String name = rs.getString("NAME");
			String img_01 = rs.getString("IMG_01");

			ReservationVo vo = new ReservationVo();
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setRoomName(name);
			vo.setRoomNo(img_01);
			refundList.add(vo);
		}
		return refundList;
	}

	// 예약상세조회
	public List<ReservationVo> getReservationDetail(Connection conn, String loginMemNo) throws Exception {
		String sql = "SELECT RV.NO , RV.IN_DATE , RV.OUT_DATE , RV.SUM , RV.RESERVE_DATE , R.NAME , R.IMG_01 , H.NAME , H.PROFILE FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO = R.NO JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO=A.HOST_NO WHERE RESERVATOR_NO = ? ORDER BY RESERVE_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> reservationList = new ArrayList<ReservationVo>();
		while (rs.next()) {

			String roomNo = rs.getString("NO");
			String reservatorNo = rs.getString("RESERVATOR_NO");
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String reserveDate = rs.getString("RESERVE_DATE");
			// 카드or통장입금인지 코드말고 이름으로 받기
			String payMethodName = rs.getString("PAY_METHOD_CODE");
			String sum = rs.getString("SUM");
			String roomName = rs.getString("ROOM_NO");
			String guestCount = rs.getString("CVC_NUM");

			ReservationVo vo = new ReservationVo();
			vo.setRoomNo(roomNo);
			vo.setReservatorNo(reservatorNo);
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setReserveDate(reserveDate);
			vo.setPayMethodName(payMethodName);
			vo.setSum(sum);
			vo.setRoomName(roomName);
			vo.setGuestCount(guestCount);
			reservationList.add(vo);
		}
		return reservationList;
	}
}
