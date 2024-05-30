package com.kh.journey.room.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.review.vo.ReviewVo;
import com.kh.journey.room.service.RoomService;
import com.kh.journey.room.vo.AttachmentVo;
import com.kh.journey.room.vo.RoomVo;

@WebServlet("/room/detail")
public class RoomDetailController extends HttpServlet {
	
	private final RoomService service;
	
	// Constructor
	public RoomDetailController() {
		this.service = new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// service 호출
			RoomVo vo = service.getRoomDetail();
			List<AttachmentVo> attVoList = service.getAttachment();
			List<ReviewVo> reVoList = service.getReview();

			// 결과
			if(vo == null) {
				throw new Exception("객실 상세 조회 실패");
			}
			
			req.setAttribute("vo", vo);
			req.setAttribute("attVoList", attVoList);
			req.setAttribute("reVoList", reVoList);
			
			req.getRequestDispatcher("/WEB-INF/views/room/detail.jsp").forward(req, resp);
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	} // doPost
} // class
