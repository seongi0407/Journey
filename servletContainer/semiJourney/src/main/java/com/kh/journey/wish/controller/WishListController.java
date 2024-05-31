package com.kh.journey.wish.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.member.vo.MemberVo;
import com.kh.journey.room.service.RoomService;
import com.kh.journey.room.vo.RoomVo;

@WebServlet("/wish/list")
public class WishListController extends HttpServlet{
	
	private final RoomService service;
	
	public WishListController() {
		this.service =  new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			
            MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
            if (loginMemberVo == null) {
            	throw new Exception("위시리스트 조회 중 오류 발생");
            }
			
			String no = loginMemberVo.getNo();
			
//          서비스 호출
            List<RoomVo> roomVoList = service.getRoomListForWish(no);
            
            System.out.println(roomVoList);
 
//			결과 	
			req.setAttribute("roomVoList", roomVoList);
			
			req.getRequestDispatcher("/WEB-INF/views/wish/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}