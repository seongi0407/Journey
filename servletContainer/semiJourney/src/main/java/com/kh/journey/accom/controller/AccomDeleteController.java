package com.kh.journey.accom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.accom.service.AccomService;
import com.kh.journey.accom.vo.AccomVo;
import com.kh.journey.host.vo.HostVo;

@WebServlet("/accom/delete")
public class AccomDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();

			// 데이터 꺼내기
			String no = req.getParameter("no");

			AccomVo vo = new AccomVo();
			vo.setNo(no);

			// 서비스 호출
			AccomService as = new AccomService();
			int result = as.delete(vo);

			if (result != 1) {
				throw new Exception("숙소 정보 삭제 실패");
			}

			// 결과
			if (result < 1) {
				session.setAttribute("alertMsg", "숙소 삭제 실패");
				throw new Exception("숙소 삭제 실패");
			}
			session.setAttribute("alertMsg", "숙소 삭제 성공");

			resp.sendRedirect("/journey/home");

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