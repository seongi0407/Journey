package com.kh.journey.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.kh.journey.member.vo.MemberVo;
import com.kh.journey.reservation.service.ReservationService;
import com.kh.journey.reservation.vo.ReservationVo;

@WebServlet("/book/list")
public class ReservationListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
//			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String loginMemNo = "1";
			// loginMemberVo.getNo();

			// 서비스 호출
			ReservationService rs = new ReservationService();

			List<ReservationVo> reservationList = rs.getReservationList(loginMemNo);
			List<ReservationVo> historyList = rs.getHistoryList(loginMemNo);
			List<ReservationVo> refundList = rs.getRefundList(loginMemNo);

			System.out.println(reservationList);
			System.out.println(historyList);
			System.out.println(refundList);
			req.setAttribute("reservationList", reservationList);
			req.setAttribute("historyList", historyList);
			req.setAttribute("refundList", refundList);

			req.getRequestDispatcher("/WEB-INF/views/book/list.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}