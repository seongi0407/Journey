package com.kh.journey.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.host.service.HostService;
import com.kh.journey.host.vo.HostVo;

@WebServlet("/host/quit")
public class HostQuitController extends HttpServlet {

	private final HostService service;
	
	// Constructor
	public HostQuitController() {
		this.service = new HostService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 데이터 꺼내기
			HttpSession session = req.getSession();
			HostVo loginHostVo = (HostVo) session.getAttribute("loginHostVo");
			String no = loginHostVo.getNo();
			
			// 복잡한 작업
			int result = service.quit(no);
			
			// 결과
			if(result != 1) {
				throw new Exception("회원 탈퇴 실패");
			}
			
			session.removeAttribute("loginHostVo");
			session.setAttribute("alertMsg", "회원 탈퇴 성공");
			
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
