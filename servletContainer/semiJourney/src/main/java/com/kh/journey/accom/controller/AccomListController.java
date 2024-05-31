package com.kh.journey.accom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.accom.service.AccomService;
import com.kh.journey.accom.vo.AccomVo;
import com.kh.journey.host.vo.HostVo;

@WebServlet("/accom/list")
public class AccomListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			HostVo loginHostVo = (HostVo) session.getAttribute("loginHostVo");

			if (loginHostVo == null) {
				resp.sendRedirect("/journey/host/login");
				return;
			}

			String hostNo = loginHostVo.getNo();

			// 서비스 호출
			AccomService as = new AccomService();

			// 데이터 꺼내기
			List<AccomVo> voList = as.selectAccomList(hostNo);

			// 결과
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/accom/list.jsp").forward(req, resp);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}