package com.kh.journey.room.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.journey.review.vo.ReviewVo;
import com.kh.journey.room.vo.AttachmentVo;
import com.kh.journey.room.vo.RoomVo;

public class RoomDao {
   
   // 객실 등록
   public int insert(Connection conn, RoomVo vo) throws Exception {
      
      // sql
      String sql = "INSERT INTO ROOM ( NO , NAME , THEME_CODE , CAPACITY , BATH_NUM , ROOM_NUM , BED_SINGLE , BED_DOUBLE , BED_QUEEN , WEEKDAY_PRICE , WEEKEND_PRICE , AIRCONDITIONER_YN , WIFI_YN , TOWEL_YN , OVEN_YN , FIREALARM_YN , FIRSTAIDKIT_YN , NETFLIX_YN , FRIGER_YN , HEATING_YN , HAIRDRYER_YN , TV_YN , ACCOM_NO , IMG_01 , IMG_02 , IMG_03 , IMG_04 , IMG_05) VALUES ( SEQ_ROOM.NEXTVAL , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      pstmt.setString(1, vo.getName());
      pstmt.setString(2, vo.getThemeCode());
      
      pstmt.setString(3, vo.getCapacity());
      pstmt.setString(4, vo.getBathNum());
      pstmt.setString(5, vo.getRoomNum());
      
      pstmt.setString(6, vo.getBedSingle());
      pstmt.setString(7, vo.getBedDouble());
      pstmt.setString(8, vo.getBedQueen());
      
      pstmt.setString(9, vo.getWeekdayPrice());
      pstmt.setString(10, vo.getWeekendPrice());
      
      pstmt.setString(11, vo.getAirconditionerYn());
      pstmt.setString(12, vo.getWifiYn());
      pstmt.setString(13, vo.getTowelYn());
      pstmt.setString(14, vo.getOvenYn());
      pstmt.setString(15, vo.getFirealarmYn());
      pstmt.setString(16, vo.getFirstaidkitYn());
      pstmt.setString(17, vo.getNetflixYn());
      pstmt.setString(18, vo.getFrigerYn());
      pstmt.setString(19, vo.getHeatingYn());
      pstmt.setString(20, vo.getHairdryerYn());
      pstmt.setString(21, vo.getTvYn());
      
      // 숙소
      pstmt.setString(22, vo.getAccomNo());
      
      // 이미지
      pstmt.setString(23, vo.getImg01());
      pstmt.setString(24, vo.getImg02());
      pstmt.setString(25, vo.getImg03());
      pstmt.setString(26, vo.getImg04());
      pstmt.setString(27, vo.getImg05());
      
      int result = pstmt.executeUpdate();
      
      close(pstmt);
      
      return result;
   } // insert
   
   // 객실 사진 등록
   public int insertRoomAttachment(Connection conn, List<AttachmentVo> attVoList) throws Exception {
      
      // sql
      String sql = "INSERT ALL";
      for (AttachmentVo attVo: attVoList) {
         sql += " INTO ROOM_ATTACHMENT(NO, REF_NO, ORIGIN_NAME, CHANGE_NAME) VALUES((SELECT FN_GET_ROOM_ATTACHMENT_SEQ_NEXTVAL FROM DUAL), SEQ_ROOM.CURRVAL, '" + attVo.getOriginName() + "', '" + attVo.getChangeName() + "')";
      }
      sql += " SELECT * FROM DUAL";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      int result = pstmt.executeUpdate();
      
      close(pstmt);
      
      return result;
   } // insertRoomAttachment

   // 객실 삭제
   public int delete(Connection conn, String no) throws Exception {
      
      // sql
      String sql = "UPDATE ROOM SET DEL_YN = 'Y' WHERE NO = ? AND DEL_YN = 'N'";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      // 객실 번호 받아서 넣어주기
      pstmt.setString(1, no);
      
      int result = pstmt.executeUpdate();
      
      close(pstmt);
      
      return result;
   } // delete

   // 객실 수정
   public int edit(Connection conn, RoomVo vo) throws Exception {
      
      // sql
      String sql = "UPDATE ROOM SET NAME = ? , THEME_CODE = ? , CAPACITY = ? , BATH_NUM = ? , ROOM_NUM = ? , BED_SINGLE = ? , BED_DOUBLE = ? , BED_QUEEN = ? , WEEKDAY_PRICE = ? , WEEKEND_PRICE = ? , AIRCONDITIONER_YN = ? , WIFI_YN = ? , TOWEL_YN = ? , OVEN_YN = ? , FIREALARM_YN = ? , FIRSTAIDKIT_YN = ? , NETFLIX_YN = ? , FRIGER_YN = ? , HEATING_YN = ? , HAIRDRYER_YN = ? , TV_YN = ? , MODIFY_DATE = SYSDATE WHERE NO = ? AND DEL_YN = 'N'";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getName());
      pstmt.setString(2, vo.getThemeCode());
      
      pstmt.setString(3, vo.getCapacity());
      pstmt.setString(4, vo.getBathNum());
      pstmt.setString(5, vo.getRoomNum());
      
      pstmt.setString(6, vo.getBedSingle());
      pstmt.setString(7, vo.getBedDouble());
      pstmt.setString(8, vo.getBedQueen());
      
      pstmt.setString(9, vo.getWeekdayPrice());
      pstmt.setString(10, vo.getWeekendPrice());
      
      pstmt.setString(11, vo.getAirconditionerYn());
      pstmt.setString(12, vo.getWifiYn());
      pstmt.setString(13, vo.getTowelYn());
      pstmt.setString(14, vo.getOvenYn());
      pstmt.setString(15, vo.getFirealarmYn());
      pstmt.setString(16, vo.getFirstaidkitYn());
      pstmt.setString(17, vo.getNetflixYn());
      pstmt.setString(18, vo.getFrigerYn());
      pstmt.setString(19, vo.getHeatingYn());
      pstmt.setString(20, vo.getHairdryerYn());
      pstmt.setString(21, vo.getTvYn());
      
      // 객실 번호
      pstmt.setString(22, vo.getNo());
      
      int result = pstmt.executeUpdate();
      
      close(pstmt);
      
      return result;
   } // edit

   // 객실 목록 조회 (홈페이지 전용)
   public List<RoomVo> getRoomListForHome(Connection conn) throws Exception {
      
      // sql
      String sql = "SELECT R.NO, R.NAME , R.WEEKDAY_PRICE , R.GRADE , R.IMG_01 , A.ADDRESS , T.THEME_NAME FROM ROOM R JOIN ACCOMMODATION A ON (R.ACCOM_NO = A.NO) JOIN THEME T ON (R.THEME_CODE = T.THEME_CODE) WHERE R.DEL_YN = 'N' ORDER BY R.NO DESC";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      
      RoomVo vo = null;
      List<RoomVo> voList = new ArrayList<RoomVo>();
      
      while(rs.next()) {
         String name = rs.getString("NAME");
         String weekdayPrice = rs.getString("WEEKDAY_PRICE");
         String grade = rs.getString("GRADE");
         String address = rs.getString("ADDRESS");
         String themeName = rs.getString("THEME_NAME");
         String imgUrl = rs.getString("IMG_01");
         String no = rs.getString("NO");
         
         vo = new RoomVo();
         
         vo.setName(name);
         vo.setWeekdayPrice(weekdayPrice);
         vo.setGrade(grade);
         vo.setAddress(address);
         vo.setThemeName(themeName);
         vo.setImg01(imgUrl);
         vo.setNo(no);
         
         voList.add(vo);
      }
      
      close(rs);
      close(pstmt);
      
      return voList;
   } // getRoomListForHome
   
   // 객실 목록 조회 (위시리스트 전용)
   public List<RoomVo> getRoomListForWish(Connection conn, String no) throws Exception {
      
      // sql
      String sql = "SELECT R.NO , R.NAME , R.WEEKDAY_PRICE , R.GRADE , R.IMG_01 , A.ADDRESS , T.THEME_NAME , W.NO WISH_NO FROM ROOM R JOIN ACCOMMODATION A ON (R.ACCOM_NO = A.NO) JOIN THEME T ON (R.THEME_CODE = T.THEME_CODE) JOIN WISH_LIST W ON (W.ROOM_NO = R.NO) JOIN MEMBER M ON (W.MEM_NO = M.NO) WHERE M.NO = ? AND R.DEL_YN = 'N' AND A.DEL_YN = 'N' AND M.DEL_YN = 'N'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, no);;
      ResultSet rs = pstmt.executeQuery();
      
      RoomVo vo = null;
      List<RoomVo> voList = new ArrayList<RoomVo>();
      
      while(rs.next()) {
         String name = rs.getString("NAME");
         String weekdayPrice = rs.getString("WEEKDAY_PRICE");
         String grade = rs.getString("GRADE");
         String address = rs.getString("ADDRESS");
         String themeName = rs.getString("THEME_NAME");
         String imgUrl = rs.getString("IMG_01");
         String roomNo = rs.getString("NO");
         String wishNo = rs.getString("WISH_NO");
         
         vo = new RoomVo();
         
         vo.setName(name);
         vo.setWeekdayPrice(weekdayPrice);
         vo.setGrade(grade);
         vo.setAddress(address);
         vo.setThemeName(themeName);
         vo.setImg01(imgUrl);
         vo.setNo(roomNo);
         vo.setWishNo(wishNo);
         
         voList.add(vo);
      }
      
      close(rs);
      close(pstmt);
      
      return voList;
   } // getRoomListForWish
   
   // 객실 목록 조회 (위시리스트 전용)
   public List<RoomVo> getRoomListForHost(Connection conn, String accomNo) throws Exception {
      
      // sql
      String sql = "SELECT R.NO , R.NAME , R.WEEKDAY_PRICE , R.GRADE , R.IMG_01 , A.ADDRESS , T.THEME_NAME FROM ROOM R JOIN ACCOMMODATION A ON (R.ACCOM_NO = A.NO) JOIN THEME T ON (R.THEME_CODE = T.THEME_CODE) WHERE A.NO = ? AND R.DEL_YN = 'N'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, accomNo);
      ResultSet rs = pstmt.executeQuery();
      
      RoomVo vo = null;
      List<RoomVo> voList = new ArrayList<RoomVo>();
      
      while(rs.next()) {
         String name = rs.getString("NAME");
         String weekdayPrice = rs.getString("WEEKDAY_PRICE");
         String grade = rs.getString("GRADE");
         String address = rs.getString("ADDRESS");
         String themeName = rs.getString("THEME_NAME");
         String imgUrl = rs.getString("IMG_01");
         String roomNo = rs.getString("NO");
         
         vo = new RoomVo();
         
         vo.setName(name);
         vo.setWeekdayPrice(weekdayPrice);
         vo.setGrade(grade);
         vo.setAddress(address);
         vo.setThemeName(themeName);
         vo.setImg01(imgUrl);
         vo.setNo(roomNo);
         
         voList.add(vo);
      }
      
      close(rs);
      close(pstmt);
      
      return voList;
   } // getRoomListForHost

   public RoomVo getRoomDetail(Connection conn, String no) throws Exception {
      
      // sql
      String sql = "SELECT H.NAME HOST_NAME , H.PROFILE , A.NAME ACCOM_NAME , A.ADDRESS , A.LATITUDE , A.LONGITUDE , T.THEME_NAME , R.IMG_01 , R.WEEKDAY_PRICE , R.WEEKEND_PRICE , R.CAPACITY , R.ROOM_NUM , R.BATH_NUM , R.BED_SINGLE , R.BED_DOUBLE , R.BED_QUEEN , R.GRADE , R.NAME , R.WEEKEND_PRICE , R.TOWEL_YN , R.TV_YN , R.NETFLIX_YN , R.AIRCONDITIONER_YN , R.HEATING_YN , R.FIREALARM_YN , R.FIRSTAIDKIT_YN , R.WIFI_YN , R.FRIGER_YN , R.OVEN_YN , R.HAIRDRYER_YN FROM ROOM R JOIN ACCOMMODATION A ON (R.ACCOM_NO = A.NO) JOIN HOST H ON (A.HOST_NO = H.NO) JOIN THEME T ON (R.THEME_CODE = T.THEME_CODE) WHERE R.NO = ? AND R.DEL_YN = 'N'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      // 객실 번호 넣어주기
      pstmt.setString(1, no);
      
      ResultSet rs = pstmt.executeQuery();
      
      RoomVo vo = null;
      
      if(rs.next()) {
         String hostName = rs.getString("HOST_NAME");
         String accomName = rs.getString("ACCOM_NAME");
         String hostProfile = rs.getString("PROFILE");
         
         String address = rs.getString("ADDRESS");
         
         String themeName = rs.getString("THEME_NAME");

         String name = rs.getString("NAME");
         String weekdayPrice = rs.getString("WEEKDAY_PRICE");
         String weekendPrice = rs.getString("WEEKEND_PRICE");
         String grade = rs.getString("GRADE");
         
         String capacity = rs.getString("CAPACITY");
         String roomNum = rs.getString("ROOM_NUM");
         String bathNum = rs.getString("BATH_NUM");
         
         String bedSingle = rs.getString("BED_SINGLE");
         String bedDouble = rs.getString("BED_DOUBLE");
         String bedQueen = rs.getString("BED_QUEEN");
         
         int bedSingleInt = rs.getInt("BED_SINGLE");
         int bedDoubleInt = rs.getInt("BED_DOUBLE");
         int bedQueenInt = rs.getInt("BED_QUEEN");
         
         int bedNum = bedSingleInt + bedDoubleInt + bedQueenInt;
         String bedNumString = "" + bedNum;
         
         String towelYn = rs.getString("TOWEL_YN");
         String tvYn = rs.getString("TV_YN");
         String netflix = rs.getString("NETFLIX_YN");
         String airconditionerYn = rs.getString("AIRCONDITIONER_YN");
         String heatingYn = rs.getString("HEATING_YN");
         String firealarmYn = rs.getString("FIREALARM_YN");
         String firstaidkitYn = rs.getString("FIRSTAIDKIT_YN");
         String wifiYn = rs.getString("WIFI_YN");
         String frigerYn = rs.getString("FRIGER_YN");
         String ovenYn = rs.getString("OVEN_YN");
         String hairdryerYn = rs.getString("HAIRDRYER_YN");
         
         String latitude = rs.getString("LATITUDE");
         String longitude = rs.getString("LONGITUDE");
         
         String img01 = rs.getString("IMG_01");
         
         vo = new RoomVo();
         
         vo.setNo(no);
         
         vo.setAccomName(accomName);
         vo.setHostName(hostName);
         vo.setHostProfile(hostProfile);
         
         vo.setAddress(address);
         
         vo.setThemeName(themeName);
         
         vo.setName(name);
         vo.setWeekdayPrice(weekdayPrice);
         vo.setWeekendPrice(weekendPrice);
         vo.setGrade(grade);
         
         vo.setCapacity(capacity);
         vo.setRoomNum(roomNum);
         vo.setBathNum(bathNum);
         
         vo.setBedSingle(bedSingle);
         vo.setBedDouble(bedDouble);
         vo.setBedQueen(bedQueen);
         vo.setBedNum(bedNumString);
         
         vo.setAirconditionerYn(airconditionerYn);
         vo.setFirealarmYn(firealarmYn);
         vo.setFirstaidkitYn(firstaidkitYn);
         vo.setWifiYn(wifiYn);
         vo.setTvYn(tvYn);
         vo.setTowelYn(towelYn);
         vo.setOvenYn(ovenYn);
         vo.setNetflixYn(netflix);
         vo.setHeatingYn(heatingYn);
         vo.setHairdryerYn(hairdryerYn);
         vo.setFrigerYn(frigerYn);
         
         vo.setLatitude(latitude);
         vo.setLongitude(longitude);
         
         vo.setImg01(img01);
      }
      
      close(rs);
      close(pstmt);

      return vo;
   } // getRoomDetail

   // 객실 이미지 가져오기
   public List<AttachmentVo> getAttachment(Connection conn, String refNo) throws Exception {
      
      // sql
      String sql = "SELECT ORIGIN_NAME, CHANGE_NAME, UPLOAD_DATE FROM ROOM_ATTACHMENT WHERE REF_NO = ? AND DEL_YN = 'N'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      // 객실 번호 넣어주기
      pstmt.setString(1, refNo);
      
      ResultSet rs = pstmt.executeQuery();
      
      List<AttachmentVo> attVoList = new ArrayList<AttachmentVo>();
      AttachmentVo attVo = null;
      
      while(rs.next()) {
         String originName = rs.getString("ORIGIN_NAME");
         String changeName = rs.getString("CHANGE_NAME");
         String uploadDate = rs.getString("UPLOAD_DATE");
         
         attVo = new AttachmentVo();
         
         attVo.setRefNo(refNo);
         attVo.setChangeName(changeName);
         attVo.setOriginName(originName);
         attVo.setUploadDate(uploadDate);
         
         attVoList.add(attVo);
      }
      
      close(rs);
      close(pstmt);
      
      return attVoList;
   } // getAttachment

   public List<ReviewVo> getReview(Connection conn, String no) throws Exception {
      
      // sql
      String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM ( SELECT RE.CONTENT , RE.ACCURACY , RE.CLEAN , RE.CHECKIN , RE.LOCATION , RE.COMMUNICATION , RE.ENROLL_DATE , M.NAME , M.PROFILE FROM REVIEW RE JOIN RESERVATION RV ON (RE.RESERVE_NO = RV.NO) JOIN ROOM R ON (R.NO = RV.ROOM_NO) JOIN MEMBER M ON (M.NO = RV.RESERVATOR_NO) WHERE R.NO = ? AND RE.DEL_YN = 'N' ORDER BY RE.ENROLL_DATE DESC ) T ) WHERE RNUM BETWEEN 1 AND 6";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      // 객실 번호 넣어주기
      pstmt.setString(1, no);
      
      ResultSet rs = pstmt.executeQuery();
      
      List<ReviewVo> reVoList = new ArrayList<ReviewVo>();
      ReviewVo vo = null;
      
      while(rs.next()) {
         String content = rs.getString("CONTENT");
         String writerName = rs.getString("NAME");
         String profile = rs.getString("PROFILE");
         String enrollDate = rs.getString("ENROLL_DATE");
         
         int accuracy = rs.getInt("ACCURACY");
         int clean = rs.getInt("CLEAN");
         int checkin = rs.getInt("CHECKIN");
         int location = rs.getInt("LOCATION");
         int communication = rs.getInt("COMMUNICATION");
         
         int avg = (accuracy + clean + checkin + location + communication) / 5;
         
         String starAvg = "" + avg;
         
         vo = new ReviewVo();
         
         vo.setContent(content);
         vo.setWriterName(writerName);
         vo.setProfile(profile);
         vo.setEnrollDate(enrollDate);
         
         vo.setStarAvg(starAvg);
         
         reVoList.add(vo);
      }
      
      close(rs);
      close(pstmt);
      
      return reVoList;
   } // getReview

	// 객실명 중복 검사
	public RoomVo checkDup(Connection conn, String name) throws Exception {
		
		// SQL
		String sql = "SELECT NO FROM ROOM WHERE NAME = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		
		RoomVo vo = null;
		if(rs.next()) {
			
			String no = rs.getString("NO");
			vo = new RoomVo();
			vo.setName(name);
		}

		close(rs);
		close(pstmt);
		
		return vo;
	} // checkDup

	public List<RoomVo> getTheme(Connection conn) throws Exception {
		
	      // sql
	      String sql = "SELECT THEME_CODE, THEME_NAME FROM THEME";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      ResultSet rs = pstmt.executeQuery();
	      
	      List<RoomVo> thVoList = new ArrayList<RoomVo>();
	      RoomVo vo = null;
	      
	      while(rs.next()) {
	         String themeCode = rs.getString("THEME_CODE");
	         String themeName = rs.getString("THEME_NAME");
	         
	         vo = new RoomVo();
	         vo.setThemeCode(themeCode);
	         vo.setThemeName(themeName);
	         
	         thVoList.add(vo);
	      }
	      
	      close(rs);
	      close(pstmt);
	      
	      return thVoList;
	} // getTheme

	// 체크인 날짜 중복 확인
	public int checkInDate(Connection conn, String no, String iDDate) throws Exception {
		
		// sql
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE ROOM_NO = ? AND IN_DATE <= ? AND OUT_DATE > ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, iDDate);
		pstmt.setString(3, iDDate);
		ResultSet rs = pstmt.executeQuery();
		
		int result1 = 1;
		if(rs.next()) {
		   result1 = rs.getInt("COUNT(*)");
		}
		
		close(rs);
		close(pstmt);
		
		return result1;
	} // checkInDate

	// 체크아웃 날짜 중복 확인
	public int checkOutDate(Connection conn, String no, String oDDate) throws Exception {
		
		// sql
		String sql = "SELECT COUNT(*) FROM RESERVATION WHERE ROOM_NO = ? AND IN_DATE < ? AND OUT_DATE >= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, oDDate);
		pstmt.setString(3, oDDate);
		ResultSet rs = pstmt.executeQuery();
		
		int result2 = 1;
		if(rs.next()) {
		   result2 = rs.getInt("COUNT(*)");
		}
		
		close(rs);
		close(pstmt);
		
		return result2;
	} // checkOutDate

//	// 객실 평점 등록
//	public int setRoomGrade(Connection conn, List<ReviewVo> reVoList, String roomNo) throws Exception {
//		
//	    // sql
//	    
//	    int result = 0;
//	    PreparedStatement pstmt = null;
//	    for(ReviewVo vo: reVoList) {
//	    	String sql = "UPDATE ROOM SET GRADE = ? WHERE NO = ?";
//	    	pstmt = conn.prepareStatement(sql);
//	    	pstmt.setString(1, vo.getStarAvg());
//	    	pstmt.setString(2, roomNo);
//	    	
//	    	result = pstmt.executeUpdate();
//	    }	    
//	    
//	    close(pstmt);
//	    
//	    return result;
//	} // setRoomGrade
//
//	// 평점 등록을 위한 리뷰 수집
//	public List<ReviewVo> getReviewForSetGrade(Connection conn, String roomNo) throws Exception {
//		
//		String sql = "SELECT ROWNUM , T.NO , T.PROFILE , T.NAME , T.CONTENT , T.ACCURACY , T.CLEAN , T.CHECKIN , T.LOCATION , T.COMMUNICATION , T.ENROLL_DATE FROM ( SELECT R.NO , M.PROFILE , M.NAME , R.CONTENT , R.ACCURACY , R.CLEAN , R.CHECKIN , R.LOCATION , R.COMMUNICATION , R.ENROLL_DATE FROM REVIEW R JOIN RESERVATION RV ON R.RESERVE_NO = RV.NO JOIN MEMBER M ON RV.RESERVATOR_NO=M.NO JOIN ROOM RM ON RM.NO = RV.ROOM_NO WHERE RV.ROOM_NO = ? AND R.DEL_YN = 'N' AND M.DEL_YN = 'N' ORDER BY R.ENROLL_DATE DESC ) T";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, roomNo);
//		ResultSet rs = pstmt.executeQuery();
//
//		List<ReviewVo> voList = new ArrayList<ReviewVo>();
//		ReviewVo vo = null;
//		while (rs.next()) {
//			String rownum = rs.getString("ROWNUM");
//			String no = rs.getString("NO");
//			String profile = rs.getString("PROFILE");
//			String writerName = rs.getString("NAME");
//			String content = rs.getString("CONTENT");
//			String enrollDate = rs.getString("ENROLL_DATE");
//			int accuracy = rs.getInt("ACCURACY");
//			int clean = rs.getInt("CLEAN");
//			int checkin = rs.getInt("CHECKIN");
//			int loation = rs.getInt("LOCATION");
//			int communication = rs.getInt("COMMUNICATION");
//
//			String starAvg = Integer.toString((accuracy + clean + checkin + loation + communication) / 5);
//
//			vo = new ReviewVo();
//			vo.setNo(no);
//			vo.setProfile(profile);
//			vo.setWriterName(writerName);
//			vo.setContent(content);
//			vo.setEnrollDate(enrollDate);
//			vo.setStarAvg(starAvg);
//			vo.setRownum(rownum);
//
//			voList.add(vo);
//		}
//		
//		close(pstmt);
//		close(rs);
//		
//		return voList;
//	} // getReviewForSetGrade
} // class
