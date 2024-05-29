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
			String cardNick = rs.getString("CARD_NICK");
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

		System.out.println(cardVoList);

		close(rs);
		close(pstmt);

		return cardVoList;
	}

	// 예약시 룸 정보 가져오기
	public List<ReservationVo> getRoomDetail(Connection conn, String roomNo) throws Exception {
		String sql = "SELECT R.IMG_01, H.NAME AS HOST_NAME, H.PROFILE, TO_CHAR(H.ENROLL_DATE, 'YYYY-MM')ENROLL_DATE, R.NAME AS ROOM_NAME, R.WEEKDAY_PRICE, R.WEEKEND_PRICE FROM ROOM R JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO = A.HOST_NO WHERE R.NO = ?";
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

		String sql = "INSERT INTO RESERVATION (NO, PAY_METHOD_CODE, RESERVATOR_NO, ROOM_NO, SUM, IN_DATE, OUT_DATE, GUEST_COUNT, CARD_NO)\r\n"
				+ "VALUES (SEQ_RESERVATION.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPayMethodCode());
		pstmt.setString(2, vo.getReservatorNo());
		pstmt.setString(3, vo.getRoomNo());
		pstmt.setString(4, vo.getSum());
		pstmt.setString(5, vo.getInDate());
		pstmt.setString(6, vo.getOutDate());
		pstmt.setString(7, vo.getGuestCount());
		pstmt.setString(8, vo.getCardNo());
		int result = pstmt.executeUpdate();

		return result;
	}

	// 예약확인
	public ReservationVo getNewReservation(Connection conn, String loginMemNo) throws Exception {
		String sql = "SELECT * FROM ( SELECT RV.IN_DATE , A.ADDRESS ,RV.OUT_DATE , R.NAME AS ROOM_NAME , R.IMG_01 , RV.SUM, H.NAME AS HOST_NAME , H.PROFILE, RV.GUEST_COUNT FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO = R.NO JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO = A.HOST_NO WHERE RESERVATOR_NO = ? AND RV.DEL_YN ='N' AND RV.REFUND_YN ='N' ORDER BY RESERVE_DATE DESC ) WHERE ROWNUM = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		ReservationVo vo = null;
		if (rs.next()) {

			String roomImg = rs.getString("IMG_01");
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String roomName = rs.getString("ROOM_NAME");
			String hostName = rs.getString("HOST_NAME");
			String sum = rs.getString("SUM");
			String guestCount = rs.getString("GUEST_COUNT");
			String address = rs.getString("ADDRESS");

			vo = new ReservationVo();
			vo.setRoomImg(roomImg);
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setRoomName(roomName);
			vo.setHostName(hostName);
			vo.setSum(sum);
			vo.setGuestCount(guestCount);
			vo.setAddress(address);

		}
		return vo;
	}

	// 회원화면
	// 멤버 - 예약내역조회 - 예정된 예약
	public List<ReservationVo> getReservationList(Connection conn, String loginMemNo) throws Exception {

		// 예정된 예약
		String sql = "SELECT RV.NO RESERVE_NO, RV.IN_DATE ,RV.OUT_DATE, A.ADDRESS , R.NAME AS ROOM_NAME , R.IMG_01 , RV.SUM, H.NAME AS HOST_NAME, H.PHONE, H.PROFILE FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO = R.NO JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO = A.HOST_NO WHERE RESERVATOR_NO = ? AND RV.DEL_YN ='N' AND RV.REFUND_YN ='N' AND IN_DATE > SYSDATE ORDER BY RV.IN_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> reservationList = new ArrayList<ReservationVo>();
		while (rs.next()) {
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String name = rs.getString("ROOM_NAME");
			String img_01 = rs.getString("IMG_01");
			String sum = rs.getString("SUM");
			String hostName = rs.getString("HOST_NAME");
			String hostPhone = rs.getString("PHONE");
			String hostProfile = rs.getString("PROFILE");
			String address = rs.getString("ADDRESS");
			String reserveNo = rs.getString("RESERVE_NO");

			ReservationVo vo = new ReservationVo();
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setRoomName(name);
			vo.setRoomNo(img_01);
			vo.setSum(sum);
			vo.setHostName(hostName);
			vo.setHostPhone(hostPhone);
			vo.setHostProfile(hostProfile);
			vo.setAddress(address);
			vo.setReserveNo(reserveNo);
			reservationList.add(vo);
		}
		return reservationList;
	}

	// 멤버 - 예약내역조회 - 지난 예약
	public List<ReservationVo> getHistoryList(Connection conn, String loginMemNo) throws Exception {

		// 예정된 예약
		String sql = "SELECT RV.NO RESERVE_NO, RV.IN_DATE ,RV.OUT_DATE, R.NAME , R.IMG_01, RW.NO REVIEW_NO FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO = R.NO LEFT JOIN REVIEW RW ON RV.NO = RW.RESERVE_NO WHERE RESERVATOR_NO = ? AND RV.DEL_YN ='N' AND RV.REFUND_YN ='N' AND OUT_DATE < SYSDATE ORDER BY RV.OUT_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> historyList = new ArrayList<ReservationVo>();
		while (rs.next()) {
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String name = rs.getString("NAME");
			String img_01 = rs.getString("IMG_01");
			String reviewNo = rs.getString("REVIEW_NO");
			String reserveNo = rs.getString("RESERVE_NO");

			ReservationVo vo = new ReservationVo();
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setRoomName(name);
			vo.setRoomNo(img_01);
			vo.setRoomNo(img_01);
			vo.setReviewNo(reviewNo);
			vo.setReserveNo(reserveNo);
			historyList.add(vo);
		}
		return historyList;
	}

	// 멤버 - 예약내역조회 - 환불된 예약
	public List<ReservationVo> getRefundList(Connection conn, String loginMemNo) throws Exception {

		// 예정된 예약
		String sql = "SELECT RV.IN_DATE ,RV.OUT_DATE, R.NAME , R.IMG_01 FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO =R.NO WHERE RESERVATOR_NO = ? AND RV.DEL_YN ='N' AND RV.REFUND_YN ='Y' ORDER BY RESERVE_DATE DESC";
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

	// 호스트화면
	// 호스트 - 예정된 예약
	public List<ReservationVo> getReservationListByHostNo(Connection conn, String hostNo) throws Exception {
		String sql = "SELECT RV.NO, R.NAME, RV.IN_DATE, RV.OUT_DATE, RV.SUM , RV.GUEST_COUNT, M.PROFILE, M.NAME MEM_NAME, M.EMAIL, M.PHONE FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO = R.NO JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO = A.HOST_NO JOIN MEMBER M ON M.NO= RV.RESERVATOR_NO WHERE H.NO = ? AND RV.DEL_YN = 'N' AND RV.REFUND_YN = 'N' AND RV.IN_DATE >= SYSDATE ORDER BY RV.IN_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hostNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> reservationList = new ArrayList<>();
		while (rs.next()) {
			String reserveNo = rs.getString("NO");
			String inDate = rs.getString("IN_DATE");
			String outDate = rs.getString("OUT_DATE");
			String roomName = rs.getString("NAME");
			String sum = rs.getString("SUM");
			String guestCount = rs.getString("GUEST_COUNT");
			String reservatorProfile = rs.getString("PROFILE");
			String reservatorName = rs.getString("MEM_NAME");
			String reservatorEmail = rs.getString("EMAIL");
			String reservatorPhone = rs.getString("PHONE");
			
			ReservationVo vo = new ReservationVo();
			vo.setReserveNo(reserveNo);
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setRoomName(roomName);
			vo.setSum(sum);
			vo.setGuestCount(guestCount);
			vo.setReservatorProfile(reservatorProfile);
			vo.setReservatorName(reservatorName);
			vo.setReservatorEmail(reservatorEmail);
			vo.setReservatorPhone(reservatorPhone);

			reservationList.add(vo);
		}
		
		System.out.println("dao"+reservationList);
		return reservationList;
	}

	// 호스트 - 지난예약
	public List<ReservationVo> getHistoryListByHostNo(Connection conn, String hostNo) throws Exception {
		String sql = "SELECT RV.NO, R.NAME, RV.IN_DATE, RV.OUT_DATE, RV.SUM , RV.GUEST_COUNT, M.PROFILE, M.NAME MEM_NAME, M.EMAIL, M.PHONE FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO = R.NO JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO = A.HOST_NO JOIN MEMBER M ON M.NO= RV.RESERVATOR_NO WHERE H.NO = ? AND RV.REFUND_YN ='N' AND OUT_DATE < SYSDATE ORDER BY RV.OUT_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hostNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> historyList = new ArrayList<>();
		while (rs.next()) {
			ReservationVo vo = new ReservationVo();
			vo.setReserveNo(rs.getString("NO"));
			vo.setInDate(rs.getString("IN_DATE"));
			vo.setOutDate(rs.getString("OUT_DATE"));
			vo.setRoomName(rs.getString("NAME"));
			vo.setSum(rs.getString("SUM"));
			vo.setGuestCount(rs.getString("GUEST_COUNT"));
			vo.setReservatorProfile(rs.getString("PROFILE"));
			vo.setReservatorName(rs.getString("MEM_NAME"));
			vo.setReservatorEmail(rs.getString("EMAIL"));
			vo.setReservatorPhone(rs.getString("PHONE"));

			historyList.add(vo);
		}
		return historyList;
	}

	// 호스트 - 환불된 예약
	public List<ReservationVo> getRefundListByHostNo(Connection conn, String hostNo) throws Exception {
		String sql = "SELECT RV.NO, R.NAME, RV.SUM , M.PROFILE, M.NAME MEM_NAME FROM RESERVATION RV JOIN ROOM R ON RV.ROOM_NO = R.NO JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO JOIN HOST H ON H.NO = A.HOST_NO JOIN MEMBER M ON M.NO= RV.RESERVATOR_NO WHERE H.NO = ? AND RV.DEL_YN ='N' AND RV.REFUND_YN ='Y' ORDER BY RESERVE_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hostNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReservationVo> refundList = new ArrayList<>();
		while (rs.next()) {
			ReservationVo vo = new ReservationVo();
			vo.setReserveNo(rs.getString("NO"));
			vo.setRoomName(rs.getString("NAME"));
			vo.setSum(rs.getString("SUM"));
			vo.setReservatorProfile(rs.getString("PROFILE"));
			vo.setReservatorName(rs.getString("MEM_NAME"));

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

	// 예약 취소
	public int cancelReservation(Connection conn, String reserveNo) throws Exception {
		String sql = "UPDATE RESERVATION SET REFUND_YN='Y' WHERE NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reserveNo);

		int result = pstmt.executeUpdate();

		close(pstmt);
		return result;
	}

}
