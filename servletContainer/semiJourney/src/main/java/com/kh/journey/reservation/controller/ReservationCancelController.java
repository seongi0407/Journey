package com.kh.journey.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.reservation.service.ReservationService;

@WebServlet("/book/cancel")
public class ReservationCancelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String reserveNo = req.getParameter("reserveNo");

			System.out.println("예약 번호: " + reserveNo);

			ReservationService rs = new ReservationService();
			int result = rs.cancelReservation(reserveNo);
			if (result != 1) {
				session.setAttribute("alertMsg", "예약 취소 실패");
				throw new Exception("예약 취소 실패");
			}
			session.setAttribute("alertMsg", "예약 취소 성공");

			resp.sendRedirect("/journey/book/list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}