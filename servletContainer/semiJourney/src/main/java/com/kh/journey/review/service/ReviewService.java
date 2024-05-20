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

	// 게시글 등록
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

	public List<ReviewVo> selectReviewList(int roomNo) throws Exception {

		// DAO 호출
		Connection conn = getConnection();
		List<ReviewVo> voList = dao.selectReviewList(conn, roomNo);

		close(conn);
		System.out.println("S"+voList);

		return voList;
	}

}
