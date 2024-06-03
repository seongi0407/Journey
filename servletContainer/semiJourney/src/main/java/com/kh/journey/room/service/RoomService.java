package com.kh.journey.room.service;

import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.commit;
import static com.kh.journey.db.JDBCTemplate.getConnection;
import static com.kh.journey.db.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.journey.review.vo.ReviewVo;
import com.kh.journey.room.dao.RoomDao;
import com.kh.journey.room.vo.AttachmentVo;
import com.kh.journey.room.vo.RoomVo;

public class RoomService {
   
   private final RoomDao dao;
   
   // Constructor
   public RoomService() {
      this.dao = new RoomDao();
   }

   // 객실 등록
   public int insert(RoomVo vo, List<AttachmentVo> attVoList) throws Exception {
      
      // 비즈니스 로직
      
      // dao 호출
      Connection conn = getConnection();
      int result = dao.insert(conn, vo);
      
      int attResult = 1;
      if(attVoList.size() > 0) {
         attResult = dao.insertRoomAttachment(conn, attVoList);
      }
      
      if(result * attResult >= 1) {
         commit(conn);
      } else {
         rollback(conn);
      }
      close(conn);
      
      return result * attResult;
   } // insert

   // 객실 삭제
   public int delete(String no) throws Exception {
      
      // dao 호출
      Connection conn = getConnection();
      int result = dao.delete(conn, no);
      
      if(result >= 1) {
         commit(conn);
      } else {
         rollback(conn);
      }
      close(conn);
      
      return result;
   } // delete

   // 객실 수정
   public int edit(RoomVo vo) throws Exception {
      
      // dao 호출
      Connection conn = getConnection();
      int result = dao.edit(conn, vo);
      
      if(result >= 1) {
         commit(conn);
      } else {
         rollback(conn);
      }
      close(conn);
      
      return result;
   } // edit

   // 객실 목록 조회 (홈페이지 전용)
   public List<RoomVo> getRoomListForHome() throws Exception {
      
      // dao 호출
      Connection conn = getConnection();
      List<RoomVo> voList = dao.getRoomListForHome(conn);
      
      close(conn);
      
      return voList;
   } // getRoomListForHome
   
   // 객실 목록 조회 (위시리스트 전용)
   public List<RoomVo> getRoomListForWish(String no) throws Exception {
      
      // dao 호출
      Connection conn = getConnection();
      List<RoomVo> voList = dao.getRoomListForWish(conn, no);
      
      close(conn);
      
      return voList;
   } // getRoomListForWish
   
   // 객실 목록 조회 (호스트 전용)
   public List<RoomVo> getRoomListForHost(String accomNo) throws Exception {
      
      // dao 호출
      Connection conn = getConnection();
      List<RoomVo> voList = dao.getRoomListForHost(conn, accomNo);
      
      close(conn);
      
      return voList;
   } // getRoomListForHost

   public RoomVo getRoomDetail(String no) throws Exception {
      
      // dao 호출
      Connection conn = getConnection();
      RoomVo vo = dao.getRoomDetail(conn, no);
      
      close(conn);
      
      return vo;
   } // getRoomDetail

   // 객실 이미지 가져오기
   public List<AttachmentVo> getAttachment(String no) throws Exception {
      
      // dao
      Connection conn = getConnection();
      
      List<AttachmentVo> attVoList = dao.getAttachment(conn, no);
      
      close(conn);
      
      return attVoList;
   } // getAttachment

   public List<ReviewVo> getReview(String no) throws Exception {
      
      // dao 호출
      Connection conn = getConnection();
      
      List<ReviewVo> reVoList = dao.getReview(conn, no);
      
      close(conn);
      
      return reVoList;
   } // getReview
   
	// 객실명 중복 검사
	public RoomVo checkDup(String name) throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		RoomVo vo = dao.checkDup(conn, name);
		
		close(conn);
		
		return vo;
	} // checkDup
	
	// 테마명 가져오기
	public List<RoomVo> getTheme() throws Exception {
		
		// 비즈니스 로직
		
		// DAO 호출
		Connection conn = getConnection();
		List<RoomVo> thVoList = dao.getTheme(conn);
		
		close(conn);
		
		return thVoList;
	} // getTheme
} // class
