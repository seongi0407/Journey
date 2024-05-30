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

@WebServlet("/room/list")
public class RoomListController extends HttpServlet {
	
	private final RoomService service;
	
	// Constructor
	public RoomListController() {
		this.service = new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// service 호출
			List<RoomVo> voList = service.getRoomList();
			
			// 결과
			req.setAttribute("voList", voList);
			
			req.getRequestDispatcher("/WEB-INF/views/list2.jsp").forward(req, resp);
			
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
