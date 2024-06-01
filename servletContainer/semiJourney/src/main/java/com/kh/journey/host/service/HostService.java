package com.kh.journey.host.service;

import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.commit;
import static com.kh.journey.db.JDBCTemplate.getConnection;
import static com.kh.journey.db.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.journey.host.dao.HostDao;
import com.kh.journey.host.vo.HostVo;

public class HostService {
	
	private final HostDao dao;
	
	// Constructor
	public HostService() {
		this.dao = new HostDao();
	}
	
	// 로그 인
	public HostVo login(HostVo vo) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		HostVo loginHostVo = dao.login(conn, vo);
		
		close(conn);
		
		return loginHostVo;
	} // login

	// 회원 가입
	public int join(HostVo vo) throws Exception {
		
		// 비지니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		int result = dao.join(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	} // join
	
	// 회원 탈퇴
	public int quit(String no) throws Exception {
		
		// 비지니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		int result = dao.quit(conn, no);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	} // quit
	
	// 호스트 정보 수정 (이름)
	public int editName(HostVo vo) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		int result = dao.editName(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	} // editName
	
	// 호스트 정보 수정 (비밀번호)
	public int editPwd(HostVo vo) throws Exception {
		
		// 비즈니스 로직
		if(!vo.getPwd().equals(vo.getPwd2())) {
			throw new Exception("비밀번호 변경 실패");
		}
		
		// DAO 호출
		Connection conn = getConnection();
		int result = dao.editPwd(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	} // editPwd
	
	// 회원 정보 수정 (전화번호)
	public int editPhone(HostVo vo) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		int result = dao.editPhone(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	} // editPhone

	// 아이디 중복 검사
	public HostVo checkDup(String id) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		HostVo vo = dao.checkDup(conn, id);
		
		close(conn);
		
		return vo;
	} // checkDup
} // class
