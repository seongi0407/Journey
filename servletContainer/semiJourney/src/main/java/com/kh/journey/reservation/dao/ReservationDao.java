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

}
