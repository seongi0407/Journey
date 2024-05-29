package com.kh.journey.accom.service;

import java.sql.Connection;
import java.util.List;

import com.kh.journey.accom.dao.AccomDao;
import com.kh.journey.accom.vo.AccomVo;
import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.getConnection;
import static com.kh.journey.db.JDBCTemplate.commit;
import static com.kh.journey.db.JDBCTemplate.rollback;

public class AccomService {

	private final AccomDao dao;

	public AccomService() {
		dao = new AccomDao();
	}

	public int insert(AccomVo vo) throws Exception {

//		비즈니스 로직

//		DAO 호출
		Connection conn = getConnection();
		int result = dao.insert(conn, vo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		return result;

	}

	public List<AccomVo> selectAccomList(String hostNo) throws Exception {

//		비즈니스 로직

//		DAO 호출
		Connection conn = getConnection();
		List<AccomVo> accomList = dao.selectAccomList(conn, hostNo);
		close(conn);
		return accomList;

	}

	public AccomVo getAccomByNo(String no) throws Exception {
		Connection conn = getConnection();
		AccomVo vo = dao.getAccomByNo(conn, no);
		close(conn);
		return vo;
	}

	public int edit(AccomVo vo) throws Exception {

//		비즈니스 로직

//		DAO 호출 
		Connection conn = getConnection();
		int result = dao.edit(conn, vo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int delete(AccomVo vo) throws Exception {

		Connection conn = getConnection();
		int result = dao.delete(conn, vo);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		return result;
	}


}