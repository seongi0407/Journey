package com.kh.journey.member.service;

import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.commit;
import static com.kh.journey.db.JDBCTemplate.getConnection;
import static com.kh.journey.db.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.journey.member.dao.MemberDao;
import com.kh.journey.member.vo.MemberVo;


public class MemberService {
	
	private MemberDao dao = null;
	
	// Constructor
	public MemberService() {
		this.dao = new MemberDao();
	}
	
	// 로그 인
	public MemberVo login(MemberVo vo) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		MemberVo loginMemberVo = dao.login(conn, vo);
		
		close(conn);
		
		return loginMemberVo;
	} // login

	// 회원 가입
	public int join(MemberVo vo) throws Exception {
		
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
	
	// 회원 정보 수정 (이름)
	public int editName(MemberVo vo) throws Exception {
		
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
	
	// 회원 정보 수정 (비밀번호)
	public int editPwd(MemberVo vo) throws Exception {
		
		// 비즈니스 로직
		
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
	public int editPhone(MemberVo vo) throws Exception {
		
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
	
	// 회원 정보 수정 (이메일)
	public int editEmail(MemberVo vo) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		int result = dao.editEmail(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	} // editEmail
	
	// 회원 정보 수정 (생년월일)
	public int editBirth(MemberVo vo) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		int result = dao.editBirth(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	} // editBirth
	
	// 아이디 중복 검사
	public MemberVo checkDup(String id) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		MemberVo vo = dao.checkDup(conn, id);
		
		close(conn);
		
		return vo;
	} // checkDup
} // class
