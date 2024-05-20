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

	public List<ReviewVo> selectReviewList(Connection conn, int roomNo) throws Exception {
		// SQL
		String sql = "SELECT M.PROFILE , M.NAME , R.CONTENT , R.ACCURACY , R.CLEAN , R.CHECKIN , R.LOCATION , R.COMMUNICATION , R.ENROLL_DATE FROM REVIEW R JOIN RESERVATION RV ON R.RESERVE_NO = RV.NO JOIN MEMBER M ON RV.RESERVATOR_NO=M.NO JOIN ROOM RM ON RM.NO = RV.ROOM_NO WHERE RV.ROOM_NO = ? AND M.DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, roomNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReviewVo> voList = new ArrayList<ReviewVo>();
		ReviewVo vo = null;
		while (rs.next()) {
			String profile = rs.getString("PROFILE");
			String writerName = rs.getString("NAME");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			int accuracy = rs.getInt("ACCURACY");
			int clean = rs.getInt("CLEAN");
			int checkin = rs.getInt("CHECKIN");
			int loation = rs.getInt("LOCATION");
			int communication = rs.getInt("COMMUNICATION");

			String starAvg = Integer.toString((accuracy + clean + checkin + loation + communication) / 5);
			System.out.println(starAvg);

			vo = new ReviewVo();
			vo.setProfile(profile);
			vo.setWriterName(writerName);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setStarAvg(starAvg);

			voList.add(vo);
		}

		System.out.println("D" + voList);
		close(pstmt);
		close(rs);
		return voList;
	}// method
}
