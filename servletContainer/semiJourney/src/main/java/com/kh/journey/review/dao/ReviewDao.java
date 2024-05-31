package com.kh.journey.review.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.journey.review.vo.ReviewVo;

public class ReviewDao {

	// 게시글 등록
	public int reviewInsert(Connection conn, ReviewVo vo) throws Exception {

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

	// 최신리뷰 6개
	public List<ReviewVo> getReviewListByRoomNo(Connection conn, String roomNo) throws Exception {

		String sql = "SELECT * FROM(SELECT R.NO, M.PROFILE, M.NAME, R.CONTENT, R.ACCURACY, R.CLEAN, R.CHECKIN, R.LOCATION, R.COMMUNICATION, R.ENROLL_DATE, ROWNUM AS RN FROM REVIEW R JOIN RESERVATION RV ON R.RESERVE_NO = RV.NO JOIN MEMBER M ON RV.RESERVATOR_NO = M.NO WHERE RV.ROOM_NO = ? AND R.DEL_YN = 'N' AND M.DEL_YN = 'N' ORDER BY R.ENROLL_DATE DESC) WHERE RN <= 6";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, roomNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReviewVo> voList = new ArrayList<ReviewVo>();
		ReviewVo vo = null;
		while (rs.next()) {
			String no = rs.getString("NO");
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
			vo.setNo(no);
			vo.setProfile(profile);
			vo.setWriterName(writerName);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setStarAvg(starAvg);

			voList.add(vo);
		}
		close(pstmt);
		close(rs);
		return voList;

	}

	// 해당 객실 모든 리뷰보기
	public List<ReviewVo> getReviewListAllByRoomNo(Connection conn, String roomNo) throws Exception {

		String sql = "SELECT R.NO, M.PROFILE , M.NAME , R.CONTENT , R.ACCURACY , R.CLEAN , R.CHECKIN , R.LOCATION , R.COMMUNICATION , R.ENROLL_DATE FROM REVIEW R JOIN RESERVATION RV ON R.RESERVE_NO = RV.NO JOIN MEMBER M ON RV.RESERVATOR_NO=M.NO JOIN ROOM RM ON RM.NO = RV.ROOM_NO WHERE RV.ROOM_NO = ? AND R.DEL_YN = 'N' AND M.DEL_YN = 'N' ORDER BY R.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, roomNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReviewVo> voList = new ArrayList<ReviewVo>();
		ReviewVo vo = null;
		while (rs.next()) {
			String no = rs.getString("NO");
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
			vo.setNo(no);
			vo.setProfile(profile);
			vo.setWriterName(writerName);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setStarAvg(starAvg);

			voList.add(vo);
		}
		close(pstmt);
		close(rs);
		return voList;
	}

	// 내가 쓴 리뷰 보기
	public List<ReviewVo> getReviewListAllByMemberNo(Connection conn, String memberNo) throws Exception {
		String sql = "SELECT R.NO, RM.IMG_01 ROOM_IMG, RM.NAME ROOM_NAME, R.CONTENT , R.ACCURACY , R.CLEAN , R.CHECKIN , R.LOCATION , R.COMMUNICATION , R.ENROLL_DATE FROM REVIEW R JOIN RESERVATION RV ON R.RESERVE_NO = RV.NO JOIN MEMBER M ON RV.RESERVATOR_NO=M.NO JOIN ROOM RM ON RM.NO = RV.ROOM_NO WHERE RV.RESERVATOR_NO = ? AND R.DEL_YN = 'N' AND M.DEL_YN = 'N' ORDER BY R.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReviewVo> voList = new ArrayList<ReviewVo>();
		ReviewVo vo = null;
		while (rs.next()) {
			String no = rs.getString("NO");
			String roomImg = rs.getString("ROOM_IMG");
			String roomName = rs.getString("ROOM_NAME");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			int accuracy = rs.getInt("ACCURACY");
			int clean = rs.getInt("CLEAN");
			int checkin = rs.getInt("CHECKIN");
			int loation = rs.getInt("LOCATION");
			int communication = rs.getInt("COMMUNICATION");

			String starAvg = Integer.toString((accuracy + clean + checkin + loation + communication) / 5);

			vo = new ReviewVo();
			vo.setNo(no);
			vo.setRoomImg(roomImg);
			vo.setRoomName(roomName);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setStarAvg(starAvg);

			voList.add(vo);
		}
		close(pstmt);
		close(rs);
		return voList;
	}

	// 리뷰 수정(내용가져오기)
	public List<ReviewVo> getReviewByNo(Connection conn, String reviewNo) throws Exception {

		String sql = "SELECT * FROM REVIEW WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reviewNo);
		ResultSet rs = pstmt.executeQuery();

		List<ReviewVo> review = new ArrayList<ReviewVo>();

		if (rs.next()) {
			ReviewVo vo = new ReviewVo();
			String content = rs.getString("CONTENT");
			String accuracy = rs.getString("ACCURACY");
			String clean = rs.getString("CLEAN");
			String checkin = rs.getString("CHECKIN");
			String loation = rs.getString("LOCATION");
			String communication = rs.getString("COMMUNICATION");

			vo = new ReviewVo();
			vo.setNo(reviewNo);
			vo.setContent(content);
			vo.setAccuracy(accuracy);
			vo.setClean(clean);
			vo.setCheckin(checkin);
			vo.setLocation(loation);
			vo.setCommunication(communication);

			review.add(vo);
		}
		System.out.println(review);
		return review;
	}

	// 리뷰 수정(업데이트)
	public int editReviewContent(Connection conn, ReviewVo vo) throws Exception {
		String sql = "UPDATE REVIEW SET CONTENT = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getContent());
		pstmt.setString(2, vo.getNo());
		int result = pstmt.executeUpdate();

		close(pstmt);
		return result;
	}

	// 리뷰 삭제
	public int deleteReview(Connection conn, String reviewNo) throws Exception {

		String sql = "UPDATE REVIEW SET DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reviewNo);
		int result = pstmt.executeUpdate();

		close(pstmt);
		return result;
	}

}
