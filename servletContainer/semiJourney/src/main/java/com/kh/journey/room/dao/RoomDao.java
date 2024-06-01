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
      String sql = "INSERT INTO ROOM ( NO , NAME , THEME_CODE , CAPACITY , BATH_NUM , ROOM_NUM , BED_SINGLE , BED_DOUBLE , BED_QUEEN , WEEKDAY_PRICE , WEEKEND_PRICE , AIRCONDITIONER_YN , WIFI_YN , TOWEL_YN , OVEN_YN , FIREALARM_YN , FIRSTAIDKIT_YN , NETFLIX_YN , FRIGER_YN , HEATING_YN , HAIRDRYER_YN , TV_YN , ACCOM_NO ) VALUES ( SEQ_ROOM.NEXTVAL , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
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
      
      // 숙소 번호 넣어주기
      pstmt.setString(22, "1");
      
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
   public int delete(Connection conn) throws Exception {
      
      // sql
      String sql = "UPDATE ROOM SET DEL_YN = 'Y' WHERE NO = ? AND DEL_YN = 'N'";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      // 객실 번호 받아서 넣어주기
      pstmt.setString(1, "1");
      
      int result = pstmt.executeUpdate();
      
      close(pstmt);
      
      return result;
   } // delete
   
   // 숙소 삭제 시 해당 숙소의 모든 객실 삭제
   public int deleteAll(Connection conn, String no) throws Exception {
      
      // sql
      String sql = "UPDATE ROOM SET DEL_YN = 'Y' WHERE ACCOM_NO = ? AND DEL_YN = 'N'";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      // 숙소 번호 받아서 넣어주기
      pstmt.setString(1, no);
      
      int result = pstmt.executeUpdate();
      
      close(pstmt);
      
      return result;
   } // deleteAll

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
      
      // 객실 번호 받아서 넣어주기
      pstmt.setString(22, "1");
      
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
   public List<RoomVo> getRoomListForHost(Connection conn, String no) throws Exception {
      
      // sql
      String sql = "SELECT R.NO , R.NAME , R.WEEKDAY_PRICE , R.GRADE , R.IMG_01 , A.ADDRESS , T.THEME_NAME FROM ROOM R JOIN ACCOMMODATION A ON (R.ACCOM_NO = A.NO) JOIN THEME T ON (R.THEME_CODE = T.THEME_CODE) JOIN WISH_LIST W ON (W.ROOM_NO = R.NO) JOIN MEMBER M ON (W.MEM_NO = M.NO) WHERE M.NO = ? AND R.DEL_YN = 'N' AND A.DEL_YN = 'N' AND M.DEL_YN = 'N'";
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
      String sql = "SELECT H.NAME HOST_NAME , H.PROFILE , A.NAME ACCOM_NAME, A.ADDRESS , T.THEME_NAME , R.WEEKDAY_PRICE , R.CAPACITY , R.ROOM_NUM , R.BATH_NUM , R.BED_SINGLE , R.BED_DOUBLE , R.BED_QUEEN , R.GRADE , R.NAME FROM ROOM R JOIN ACCOMMODATION A ON (R.ACCOM_NO = A.NO) JOIN HOST H ON (A.HOST_NO = H.NO) JOIN THEME T ON (R.THEME_CODE = T.THEME_CODE) WHERE R.NO = ? AND R.DEL_YN = 'N'";
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
         String grade = rs.getString("GRADE");
         
         String capacity = rs.getString("CAPACITY");
         String roomNum = rs.getString("ROOM_NUM");
         String bathNum = rs.getString("BATH_NUM");
         
         int bedSingle = rs.getInt("BED_SINGLE");
         int bedDouble = rs.getInt("BED_DOUBLE");
         int bedQueen = rs.getInt("BED_QUEEN");
         
         int bedNum = bedSingle + bedDouble + bedQueen;
         String bedNumString = "" + bedNum;
         
         vo = new RoomVo();
         
         vo.setNo(no);
         
         vo.setAccomName(accomName);
         vo.setHostName(hostName);
         vo.setHostProfile(hostProfile);
         
         vo.setAddress(address);
         
         vo.setThemeName(themeName);
         
         vo.setName(name);
         vo.setWeekdayPrice(weekdayPrice);
         vo.setGrade(grade);
         
         vo.setCapacity(capacity);
         vo.setRoomNum(roomNum);
         vo.setBathNum(bathNum);
         
         vo.setBedNum(bedNumString);
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
} // class
