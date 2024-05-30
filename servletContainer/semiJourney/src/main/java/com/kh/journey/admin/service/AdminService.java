package com.kh.journey.admin.service;

import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.journey.admin.dao.AdminDao;
import com.kh.journey.admin.vo.AdminVo;

public class AdminService {
	
	private final AdminDao dao;
	
	// Constructor
	public AdminService() {
		this.dao = new AdminDao();
	}
	
	public AdminVo login(AdminVo vo) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		AdminVo loginAdminVo = dao.login(conn, vo);
		
		close(conn);
		
		return loginAdminVo;
	} // login
	
	// 회원 관리
	public void Edit() {
		
	} // Edit
} // class
