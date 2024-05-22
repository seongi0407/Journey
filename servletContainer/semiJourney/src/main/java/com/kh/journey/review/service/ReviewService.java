package com.kh.journey.review.service;

import static com.kh.journey.db.JDBCTemplate.*;

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
	public int insert(ReviewVo vo) throws Exception {

		Connection conn = getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.insert(conn, vo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		System.out.println(result);
		return result;
	}

	public List<ReviewVo> getReviewsByPage(int roomNo) throws Exception {
		ReviewDao dao = new ReviewDao();
		Connection conn = getConnection();
		List<ReviewVo> voList = dao.getReviewsByPage(conn, roomNo);
		close(conn);
		return voList;
	}

	// 리뷰 조회(목록/상세)
	public List<ReviewVo> selectReviewList(int roomNo) throws Exception {
		Connection conn = getConnection();
		List<ReviewVo> voList = dao.selectReviewList(conn, roomNo);

		close(conn);

		return voList;
	}

	// 리뷰 삭제
	public int deleteReview(String reviewNo) throws Exception {
		Connection conn = getConnection();
		int result = dao.deleteReview(conn, reviewNo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

}
