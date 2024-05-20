package com.kh.journey.review.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.journey.review.vo.ReviewVo;

public class ReviewDao {

	// 게시글 등록
	public int insert(Connection conn, ReviewVo vo) throws Exception {

		String sql = "INSERT INTO REVIEW(NO, RESERVE_NO, CONTENT, ACCURACY, CLEAN, CHECKIN, LOCATION, COMMUNICATION) VALUES(SEQ_REVIEW.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getReserveNo());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getAccuracy());
		pstmt.setString(4, vo.getClean());
		pstmt.setString(5, vo.getCheckin());
		pstmt.setString(6, vo.getLocation());
		pstmt.setString(7, vo.getCommunication());

		int result = pstmt.executeUpdate();

		close(pstmt);

		return result;
	}

	

}
