package com.kh.journey.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.host.vo.HostVo;
import com.kh.journey.member.vo.MemberVo;
import com.kh.journey.reservation.service.ReservationService;
import com.kh.journey.reservation.vo.ReservationVo;

@WebServlet("/book/list")
public class ReservationListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			HostVo loginHostVo = (HostVo) session.getAttribute("loginHostVo");

			if (loginHostVo == null && loginMemberVo == null) {
				resp.sendRedirect("/journey/home");
			} else if (loginHostVo != null) {
				// 호스트 화면
				String hostNo = loginHostVo.getNo();
				ReservationService rs = new ReservationService();
				List<ReservationVo> reservationList = rs.getReservationListByHostNo(hostNo);
				List<ReservationVo> historyList = rs.getHistoryListByHostNo(hostNo);
				List<ReservationVo> refundList = rs.getRefundListByHostNo(hostNo);

				req.setAttribute("reservationList", reservationList);
				req.setAttribute("historyList", historyList);
				req.setAttribute("refundList", refundList);

				req.getRequestDispatcher("/WEB-INF/views/book/hostBookInfo.jsp").forward(req, resp);
			} else if (loginMemberVo != null) {
				// 회원 화면
				String loginMemNo = loginMemberVo.getNo();
				ReservationService rs = new ReservationService();
				List<ReservationVo> reservationList = rs.getReservationList(loginMemNo);
				List<ReservationVo> historyList = rs.getHistoryList(loginMemNo);
				List<ReservationVo> refundList = rs.getRefundList(loginMemNo);

				req.setAttribute("reservationList", reservationList);
				req.setAttribute("historyList", historyList);
				req.setAttribute("refundList", refundList);
				req.getRequestDispatcher("/WEB-INF/views/book/list.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
			}

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