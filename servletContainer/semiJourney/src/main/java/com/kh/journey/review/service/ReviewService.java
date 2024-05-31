package com.kh.journey.review.service;

import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.commit;
import static com.kh.journey.db.JDBCTemplate.getConnection;
import static com.kh.journey.db.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.journey.review.dao.ReviewDao;
import com.kh.journey.review.vo.ReviewVo;

public class ReviewService {

	private final ReviewDao dao;

	public ReviewService() {
		dao = new ReviewDao();
	}

	// 리뷰 등록
	public int reviewInsert(ReviewVo vo) throws Exception {

		Connection conn = getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.reviewInsert(conn, vo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		System.out.println(result);
		return result;
	}

	// 최신리뷰 6개
	public List<ReviewVo> getReviewListByRoomNo(String roomNo) throws Exception {
		ReviewDao dao = new ReviewDao();
		Connection conn = getConnection();
		List<ReviewVo> voList = dao.getReviewListByRoomNo(conn, roomNo);
		close(conn);
		return voList;
	}

	// 해당 객실 모든 리뷰보기
	public List<ReviewVo> getReviewListAllByRoomNo(String roomNo) throws Exception {

		Connection conn = getConnection();
		List<ReviewVo> voList = dao.getReviewListAllByRoomNo(conn, roomNo);

		close(conn);

		return voList;
	}

	// 내가 쓴 리뷰
	public List<ReviewVo> getReviewListAllByMemberNo(String memberNo) throws Exception {

		Connection conn = getConnection();
		List<ReviewVo> review = dao.getReviewListAllByMemberNo(conn, memberNo);

		close(conn);

		return review;
	}

	// 리뷰 수정(내용가져오기)
	public List<ReviewVo> getReviewByNo(String reviewNo) throws Exception {

		Connection conn = getConnection();
		List<ReviewVo> review = dao.getReviewByNo(conn, reviewNo);

		close(conn);

		return review;
	}

	// 리뷰 수정(업데이트)
	public int editReviewContent(ReviewVo vo) throws Exception {
		System.out.println(vo);
		Connection conn = getConnection();
		int result = dao.editReviewContent(conn, vo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;

	}

	// 리뷰 삭제
	public int deleteReview(String[] reviewNoList) throws Exception {
		Connection conn = getConnection();

		int result = 0;

		for (String reviewNo : reviewNoList) {
			result += dao.deleteReview(conn, reviewNo);
		}

		if (result == reviewNoList.length) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

}