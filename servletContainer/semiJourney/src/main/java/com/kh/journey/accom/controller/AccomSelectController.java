package com.kh.journey.accom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.host.vo.HostVo;

@WebServlet("/accom/select")
public class AccomSelectController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			HostVo loginHostVo = (HostVo) session.getAttribute("loginHostVo");

			if (loginHostVo == null) {
				resp.sendRedirect("/journey/host/login");
				return;
			}
			
			req.getRequestDispatcher("/WEB-INF/views/accom/select.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}