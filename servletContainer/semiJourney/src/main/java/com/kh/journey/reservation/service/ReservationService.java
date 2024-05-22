package com.kh.journey.reservation.service;

import static com.kh.journey.db.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
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
		return cardVoList;
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

		System.out.println(result);
		return result;
	}

	// 예약내역보기
	public List<ReservationVo> getReservationList(String memberNo) throws Exception {
		Connection conn = getConnection();
		List<ReservationVo> reservationList = dao.getReservationList(conn, memberNo);
		close(conn);
		return reservationList;
	}

	public List<ReservationVo> getHistoryList(String loginMemNo) throws Exception {
		Connection conn = getConnection();
		List<ReservationVo> historyList = dao.getHistoryList(conn, loginMemNo);
		close(conn);
		return historyList;
	}

	public List<ReservationVo> getRefundList(String loginMemNo) throws Exception {
		Connection conn = getConnection();
		List<ReservationVo> refundList = dao.getRefundList(conn, loginMemNo);
		close(conn);
		return refundList;
	}
}
