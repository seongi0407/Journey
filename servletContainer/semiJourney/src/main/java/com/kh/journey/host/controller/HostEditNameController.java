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

@WebServlet("/host/edit/name")
public class HostEditNameController extends HttpServlet {

	private final HostService service;
	
	// Constructor
	public HostEditNameController() {
		this.service = new HostService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/host/edit/name.jsp").forward(req, resp);
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {	
			// 데이터 꺼내기
			HttpSession session = req.getSession();
			HostVo loginHostVo = (HostVo) session.getAttribute("loginHostVo");
		
			String no = loginHostVo.getNo();
			String name = req.getParameter("name");
			
			HostVo vo = new HostVo();
			vo.setNo(no);
			vo.setName(name);
			
			// 서비스 호출
			int result = service.editName(vo);
			
			// 결과
			if(result < 1) {
				session.setAttribute("alertMsg", "회원 정보 수정 실패");
				throw new Exception("회원 정보 수정 실패");
			}
			
			loginHostVo.setName(name);
			req.removeAttribute("loginHostVo");
			
			session.setAttribute("loginHostVo", loginHostVo);
			session.setAttribute("alertMsg", "회원 정보 수정 성공");
			
			resp.sendRedirect("/journey/home");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	} // doPost
} // class
