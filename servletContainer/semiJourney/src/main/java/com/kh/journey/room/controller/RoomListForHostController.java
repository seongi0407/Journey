package com.kh.journey.room.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.journey.room.service.RoomService;
import com.kh.journey.room.vo.RoomVo;

@WebServlet("/host/room/list")
public class RoomListForHostController extends HttpServlet {
	
	private final RoomService service;
	
	// Constructor
	public RoomListForHostController() {
		this.service = new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// date 꺼내기
			String accomNo = req.getParameter("accomNo");
			
			// service 호출
			List<RoomVo> voList = service.getRoomListForHost(accomNo);
			
			// 결과
			req.setAttribute("voList", voList);
			req.setAttribute("accomNo", accomNo);
			
			req.getRequestDispatcher("/WEB-INF/views/room/list.jsp").forward(req, resp);
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	} // doPost
} // class
