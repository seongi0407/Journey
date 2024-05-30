package com.kh.journey.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.admin.service.AdminService;
import com.kh.journey.admin.vo.AdminVo;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet {
	
	private final AdminService service;
	
	// Constructor
	public AdminLoginController() {
		this.service = new AdminService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/ju/admin/login.jsp").forward(req, resp);
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 세션
			HttpSession session = req.getSession();
			
			// 데이터 작업
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			AdminVo vo = new AdminVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			// 서비스 호출
			AdminVo loginAdminVo = service.login(vo);
			
			// 결과
			if(loginAdminVo != null) {
				session.setAttribute("alertMsg", "로그인 성공");
				session.setAttribute("loginAdminVo", loginAdminVo);
			} else {
				session.setAttribute("alertMsg", "로그인 실패");
			}
			
			resp.sendRedirect("/journey/home");
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "로그인 중 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	} // doPost
} // class
