package com.kh.journey.accom.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.journey.accom.vo.AccomVo;

public class AccomDao {

	public int insert(Connection conn, AccomVo vo) throws Exception {

		String sql = "INSERT INTO ACCOMMODATION (NO, HOST_NO, NAME, ADDRESS, SWIM_YN, SPA_YN, DISABLED_YN, PARKING_YN, ELEVATOR_YN, BREAKFAST_YN, SMOKE_YN, IMG_URL) VALUES (SEQ_ACCOMMODATION.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getHostNo());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getAddress());
		pstmt.setString(4, vo.getSwimYn());
		pstmt.setString(5, vo.getSpaYn());
		pstmt.setString(6, vo.getDisabledYn());
		pstmt.setString(7, vo.getParkingYn());
		pstmt.setString(8, vo.getElevatorYn());
		pstmt.setString(9, vo.getBreakfastYn());
		pstmt.setString(10, vo.getSmokeYn());
		pstmt.setString(11, vo.getImgUrl());
//		pstmt.setString(12, vo.getHostName());
//		pstmt.setString(13, vo.getHostPhone());

		int result = pstmt.executeUpdate();
		close(pstmt);

		return result;

	}

	public List<AccomVo> selectAccomList(Connection conn, String hostNo) throws Exception {

		String sql = "SELECT NO , HOST_NO , NAME , ADDRESS , SWIM_YN , SPA_YN , DISABLED_YN , PARKING_YN , ELEVATOR_YN , BREAKFAST_YN , SMOKE_YN , IMG_URL FROM ACCOMMODATION WHERE HOST_NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hostNo);
		ResultSet rs = pstmt.executeQuery();

		List<AccomVo> accomList = new ArrayList<AccomVo>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String address = rs.getString("ADDRESS");
			String swimYn = rs.getString("SWIM_YN");
			String spaYn = rs.getString("SPA_YN");
			String disabledYn = rs.getString("DISABLED_YN");
			String parkingYn = rs.getString("PARKING_YN");
			String elevatorYn = rs.getString("ELEVATOR_YN");
			String breakfastYn = rs.getString("BREAKFAST_YN");
			String smokeYn = rs.getString("SMOKE_YN");
			String imgUrl = rs.getString("IMG_URL");

			AccomVo vo = new AccomVo();
			vo.setNo(no);
			vo.setHostNo(hostNo);
			vo.setName(name);
			vo.setAddress(address);
			vo.setSwimYn(swimYn);
			vo.setSpaYn(spaYn);
			vo.setDisabledYn(disabledYn);
			vo.setParkingYn(parkingYn);
			vo.setElevatorYn(elevatorYn);
			vo.setBreakfastYn(breakfastYn);
			vo.setSmokeYn(smokeYn);
			vo.setImgUrl(imgUrl);

			accomList.add(vo);
		}

		close(rs);
		close(pstmt);
		
		return accomList;
	}

	public AccomVo getAccomByNo(Connection conn, String no) throws Exception {
		String sql = "SELECT * FROM ACCOMMODATION WHERE NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		AccomVo vo = null;
		if (rs.next()) {
//			String no = rs.getString("NO");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String swimYn = rs.getString("SWIM_YN");
			String spaYn = rs.getString("SPA_YN");
			String disabledYn = rs.getString("DISABLED_YN");
			String parkingYn = rs.getString("PARKING_YN");
			String elevatorYn = rs.getString("ELEVATOR_YN");
			String breakfastYn = rs.getString("BREAKFAST_YN");
			String smokeYn = rs.getString("SMOKE_YN");
			String imgUrl = rs.getString("IMG_URL");

			vo = new AccomVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setAddress(address);
			vo.setSwimYn(swimYn);
			vo.setSpaYn(spaYn);
			vo.setDisabledYn(disabledYn);
			vo.setParkingYn(parkingYn);
			vo.setElevatorYn(elevatorYn);
			vo.setBreakfastYn(breakfastYn);
			vo.setSmokeYn(smokeYn);
			vo.setImgUrl(imgUrl);
		}
		close(rs);
		close(pstmt);
		return vo;
	}

	public int edit(Connection conn, AccomVo vo) throws Exception {

//		SQL
		String sql = "UPDATE ACCOMMODATION SET NAME=? ,ADDRESS=? ,SWIM_YN=? ,SPA_YN=? ,DISABLED_YN=? ,PARKING_YN=? ,ELEVATOR_YN=? ,BREAKFAST_YN=? ,SMOKE_YN=?, IMG_URL=? WHERE NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getAddress());
		pstmt.setString(3, vo.getSwimYn());
		pstmt.setString(4, vo.getSpaYn());
		pstmt.setString(5, vo.getDisabledYn());
		pstmt.setString(6, vo.getParkingYn());
		pstmt.setString(7, vo.getElevatorYn());
		pstmt.setString(8, vo.getBreakfastYn());
		pstmt.setString(9, vo.getSmokeYn());
		pstmt.setString(10, vo.getImgUrl());
		pstmt.setString(11, vo.getNo());

		int result = pstmt.executeUpdate();

		close(pstmt);

		return result;

	}

	public int delete(Connection conn, AccomVo vo) throws Exception {

		String sql = "UPDATE ACCOMMODATION SET DEL_YN='Y' WHERE NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNo());
		int result = pstmt.executeUpdate();
		
		close(pstmt);

		return result;
	}

}