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

@WebServlet("/member/edit/email")
public class MemberEditEmailController extends HttpServlet {
	
	private final MemberService service;
	
	// Constructor
	public MemberEditEmailController() {
		this.service = new MemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/edit/email.jsp").forward(req, resp);
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {	
			// 데이터 꺼내기
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
		
			String no = loginMemberVo.getNo();
			String email = req.getParameter("email");
			
			MemberVo vo = new MemberVo();
			vo.setNo(no);
			vo.setName(email);
			
			// 서비스 호출
			int result = service.editEmail(vo);
			
			// 결과
			if(result < 1) {
				session.setAttribute("alertMsg", "회원 정보 수정 실패");
				throw new Exception("회원 정보 수정 실패");
			}
			
			loginMemberVo.setEmail(email);
			req.removeAttribute("loginMemberVo");
			
			session.setAttribute("loginMemberVo", loginMemberVo);
			session.setAttribute("alertMsg", "회원 정보 수정 성공");
			
			resp.sendRedirect("/journey/home");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	} // doPost
} // class
