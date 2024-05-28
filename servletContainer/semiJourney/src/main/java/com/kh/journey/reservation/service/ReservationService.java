package com.kh.journey.reservation.service;

import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.commit;
import static com.kh.journey.db.JDBCTemplate.getConnection;
import static com.kh.journey.db.JDBCTemplate.rollback;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.kh.journey.card.vo.CardVo;
import com.kh.journey.reservation.dao.ReservationDao;
import com.kh.journey.reservation.vo.ReservationVo;

public class ReservationService {

	private final ReservationDao dao;

	public ReservationService() {

		this.dao = new ReservationDao();
	}

	// 카드목록보기
	public List<CardVo> getCardList(String loginMemNo) throws Exception {

		Connection conn = getConnection();
		List<CardVo> cardVoList = dao.getCardList(conn, loginMemNo);
		close(conn);
		return cardVoList;
	}

	// 예약시 룸 정보 가져오기
	public List<ReservationVo> getRoomDetail(String roomNo, String inDateStr, String outDateStr) throws Exception {

		// 날짜 파싱
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date inDate = sdf.parse(inDateStr);
		Date outDate = sdf.parse(outDateStr);

		// 날짜 차이 계산
		long diffInMillies = Math.abs(outDate.getTime() - inDate.getTime());
		long stay = diffInMillies / (1000 * 60 * 60 * 24);

		Connection conn = getConnection();
		List<ReservationVo> roomDetail = dao.getRoomDetail(conn, roomNo);

		// sum을 계산해야됨.
		int total = 0;

		if (!roomDetail.isEmpty()) {
			ReservationVo roomInfo = roomDetail.get(0);
			int weekdayPrice = Integer.parseInt(roomInfo.getWeekdayPrice());
			int weekendPrice = Integer.parseInt(roomInfo.getWeekendPrice());
			total = calculateTotalCost(inDate, stay, weekdayPrice, weekendPrice);

			roomInfo.setStayDay(String.valueOf(stay)); // 숙박 일수 설정
			roomInfo.setSum(String.valueOf(total)); // 총 비용 설정
		}

		System.out.println(roomDetail);

		close(conn);
		return roomDetail;
	}

	// 날짜 이용해서 총함계 계산
	private int calculateTotalCost(Date startDate, long stayDays, int weekdayPrice, int weekendPrice) {
		int totalCost = 0;
		Calendar currentDate = Calendar.getInstance();
		currentDate.setTime(startDate);

		for (int i = 0; i < stayDays; i++) {
			int dayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
				totalCost += weekendPrice;
			} else {
				totalCost += weekdayPrice;
			}
			currentDate.add(Calendar.DATE, 1);
		}
		return totalCost;
	}

	// 예약 정보 등록
	public int ReservationInsert(ReservationVo vo) throws Exception {

		// 날짜 8자형식으로 변환
		if (vo.getInDate().length() == 10) {
			vo.setInDate(
					vo.getInDate().substring(0, 4) + vo.getInDate().substring(5, 7) + vo.getInDate().substring(8, 10));
		}
		if (vo.getOutDate().length() == 10) {
			vo.setOutDate(vo.getOutDate().substring(0, 4) + vo.getOutDate().substring(5, 7)
					+ vo.getOutDate().substring(8, 10));
		}

		// 서비스 호출
		Connection conn = getConnection();
		int result = dao.ReservationInsert(conn, vo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	// 예약확인
	public ReservationVo getNewReservation(String memberNo) throws Exception {
		Connection conn = getConnection();
		ReservationVo reservationCheck= dao.getNewReservation(conn, memberNo);
		close(conn);
		return reservationCheck;
	}

	// 예약내역조회 - 예정된 예약
	public List<ReservationVo> getReservationList(String memberNo) throws Exception {
		Connection conn = getConnection();
		List<ReservationVo> reservationList = dao.getReservationList(conn, memberNo);
		close(conn);
		return reservationList;
	}

	// 예약내역조회 - 지난 예약
	public List<ReservationVo> getHistoryList(String loginMemNo) throws Exception {
		Connection conn = getConnection();
		List<ReservationVo> historyList = dao.getHistoryList(conn, loginMemNo);
		close(conn);
		return historyList;
	}

	// 예약내역조회 - 환불된 예약
	public List<ReservationVo> getRefundList(String loginMemNo) throws Exception {
		Connection conn = getConnection();
		List<ReservationVo> refundList = dao.getRefundList(conn, loginMemNo);
		close(conn);
		return refundList;
	}

	public int cancelBook(String no) {
		
		return 0;
	}
}
