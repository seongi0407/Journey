package com.kh.journey.host.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.journey.host.vo.HostVo;

public class HostDao {
	
	// 로그 인
	public HostVo login(Connection conn, HostVo vo) throws Exception {
		
		String sql = "SELECT * FROM HOST WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		HostVo loginHostVo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String name = rs.getString("NAME");
			String phone = rs.getString("PHONE");
			String profile = rs.getString("PROFILE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			loginHostVo = new HostVo();
			loginHostVo.setNo(no);
			loginHostVo.setId(id);
			loginHostVo.setPwd(pwd);
			loginHostVo.setName(name);
			loginHostVo.setPhone(phone);
			loginHostVo.setProfile(profile);
			loginHostVo.setEnrollDate(enrollDate);
			loginHostVo.setDelYn(delYn);
		}
		
		System.out.println(loginHostVo);
		
		close(rs);
		close(pstmt);
		
		return loginHostVo;
	} // login

	// 회원 가입
	public int join(Connection conn, HostVo vo) throws Exception {
		
		// SQL
		String sql = "INSERT INTO HOST(NO, ID, PWD, NAME, PHONE, PROFILE) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getPhone());
		pstmt.setString(5, vo.getProfile());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	} // join
	
	// 회원 탈퇴
	public int quit(Connection conn, String no) throws Exception {
		
		// SQL
		String sql = "UPDATE HOST SET DEL_YN = 'Y' WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	} // quit
	
	// 회원 정보 수정
	public int edit(Connection conn, HostVo vo) throws Exception {
		
		// SQL
		String sql = "UPDATE HOST SET PWD = ?, PHONE = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getPhone());
		pstmt.setString(3, vo.getNo());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	} // edit
} // class
