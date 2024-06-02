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

//		String[] PROFANITY_LIST = new String[] { "18", "씨발", "존나" }; // 필터링할 욕설 목록
//
//		for (String profanity : PROFANITY_LIST) {
//			if (vo.getContent().contains(profanity)) {
//				throw new Exception("내용에 부적절한 단어가 포함되어 있습니다.");
//			}
//		}
//		if (vo.getContent() == null) {
//			throw new Exception("내용을 작성해주세요.");
//		}
//		// 추가 검증 (예: 제목 길이, 금지어 체크 등)
//		if (vo.getContent().length() > 20) {
//			throw new Exception("내용은 20자 이상 작성해주세요.");
//		}
//		if (vo.getContent().length() < 500) {
//			throw new Exception("내용은 500자 이하로 작성해주세요.");
//		}

		Connection conn = getConnection();
		ReviewDao dao = new ReviewDao();
		int result = dao.reviewInsert(conn, vo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
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