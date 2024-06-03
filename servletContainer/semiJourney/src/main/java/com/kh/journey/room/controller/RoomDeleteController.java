package com.kh.journey.room.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.journey.room.service.RoomService;

@WebServlet("/room/delete")
public class RoomDeleteController extends HttpServlet {
	
	private final RoomService service;
	
	// Constructor
	public RoomDeleteController() {
		this.service = new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data 꺼내기
			String no = req.getParameter("no");
			
			// service 호출
			int result = service.delete(no);
			
			if(result < 1) {
				throw new Exception("객실 삭제 실패");
			}
			
			req.setAttribute("alertMsg", "객실 삭제 성공");
			
			resp.sendRedirect("/journey/home");
			
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
