package com.kh.journey.member.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.journey.member.vo.MemberVo;

public class MemberDao {
	
	// 로그 인
	public MemberVo login(Connection conn, MemberVo vo) throws Exception {

		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo loginMemberVo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String name = rs.getString("NAME");
			String email = rs.getString("EMAIL");
			String mileage = rs.getString("MILEAGE");
			String phone = rs.getString("PHONE");
			String profile = rs.getString("PROFILE");
			String birthDate = rs.getString("BIRTH_DATE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			loginMemberVo = new MemberVo();
			loginMemberVo.setNo(no);
			loginMemberVo.setId(id);
			loginMemberVo.setPwd(pwd);
			loginMemberVo.setName(name);
			loginMemberVo.setEmail(email);
			loginMemberVo.setMileage(mileage);
			loginMemberVo.setPhone(phone);
			loginMemberVo.setProfile(profile);
			loginMemberVo.setBirthDate(birthDate);
			loginMemberVo.setEnrollDate(enrollDate);
			loginMemberVo.setDelYn(delYn);
		}
		
		System.out.println(loginMemberVo);
		
		close(rs);
		close(pstmt);
		
		return loginMemberVo;
	} // login

	// 회원 가입
	public int join(Connection conn, MemberVo vo) throws Exception {
		
		// SQL
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NAME, EMAIL, PHONE, PROFILE, BIRTH_DATE) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getEmail());
		pstmt.setString(5, vo.getPhone());
		pstmt.setString(6, vo.getProfile());
		pstmt.setString(7, vo.getBirthDate());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	} // join
	
	// 회원 탈퇴
	public int quit(Connection conn, String no) throws Exception {
		
		// SQL
		String sql = "UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	} // quit
	
	// 회원 정보 수정
	public int edit(Connection conn, MemberVo vo) throws Exception {
		
		// SQL
		String sql = "UPDATE MEMBER SET PWD = ?, EMAIL = ?, PHONE = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getEmail());
		pstmt.setString(3, vo.getPhone());
		pstmt.setString(4, vo.getNo());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	} // edit
} // class
