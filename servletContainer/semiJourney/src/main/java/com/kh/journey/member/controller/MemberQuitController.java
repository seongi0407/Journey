package com.kh.journey.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.member.service.MemberService;
import com.kh.journey.member.vo.MemberVo;

@WebServlet("/member/quit")
public class MemberQuitController extends HttpServlet {
	
	private MemberService service = null;
	
	// Constructor
	public MemberQuitController() {
		service = new MemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 데이터 꺼내기
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String no = loginMemberVo.getNo();
			
			// 복잡한 작업
			MemberService ms = new MemberService();
			int result = ms.quit(no);
			
			// 결과
			if(result != 1) {
				throw new Exception("회원 탈퇴 실패");
			}
			
			session.removeAttribute("loginMemberVo");
			session.setAttribute("alertMsg", "회원 탈퇴 성공");
			
			resp.sendRedirect("/journey/home");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	} // doPost
} // class
