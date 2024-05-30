package com.kh.journey.admin.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.journey.admin.vo.AdminVo;

public class AdminDao {
	
	public AdminVo login(Connection conn, AdminVo vo) throws Exception {
		
		String sql = "SELECT * FROM ADMIN WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		AdminVo loginAdminVo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String name = rs.getString("NAME");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			loginAdminVo = new AdminVo();
			loginAdminVo.setNo(no);
			loginAdminVo.setId(id);
			loginAdminVo.setPwd(pwd);
			loginAdminVo.setName(name);
			loginAdminVo.setEnrollDate(enrollDate);
			loginAdminVo.setDelYn(delYn);
		}
		
		close(rs);
		close(pstmt);
		
		return loginAdminVo;
	} // login
} // class
