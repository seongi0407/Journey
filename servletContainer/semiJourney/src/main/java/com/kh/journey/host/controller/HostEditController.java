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

@WebServlet("/host/edit")
public class HostEditController extends HttpServlet {
	
	private HostService service = null;
	
	// Constructor
	public HostEditController() {
		service = new HostService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			HostVo loginHostVo = (HostVo) session.getAttribute("loginHostVo");
			
			if(loginHostVo == null) {
				throw new Exception();
			}

			req.getRequestDispatcher("/WEB-INF/views/ju/host/edit.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 데이터 꺼내기
			HostVo vo = new HostVo();
			HttpSession session = req.getSession();
			HostVo loginHostVo = (HostVo) session.getAttribute("loginHostVo");
		
			String no = loginHostVo.getNo();
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			String phone = req.getParameter("phone");
			
			vo.setNo(no);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setPwd2(pwd2);
			vo.setPhone(phone);
			
			// 서비스 호출
			int result = service.edit(vo);
			
			// 결과
			if(result != 1) {
				throw new Exception("회원 정보 수정 실패");
			}
			session.setAttribute("alertMsg", "회원 정보 수정 성공");
			
			resp.sendRedirect("/journey/home");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", "회원정보 수정 중 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	} // doPost
} // class
