package com.kh.journey.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.journey.reservation.service.ReservationService;
import com.kh.journey.reservation.vo.ReservationVo;

@WebServlet("/book/calculatePrice")
public class PriceCalculationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String roomNo = req.getParameter("roomNo");
			String inDateStr = req.getParameter("inDate");
			String outDateStr = req.getParameter("outDate");

			ReservationService rs = new ReservationService();
			List<ReservationVo> roomDetail = rs.getRoomDetail(roomNo, inDateStr, outDateStr);

			int totalSum = 0;
			long stayDays = 0;
			int weekdayPrice = 0;
			int weekendPrice = 0;
			if (!roomDetail.isEmpty()) {
				ReservationVo roomInfo = roomDetail.get(0);
				totalSum = Integer.parseInt(roomInfo.getSum());
				stayDays = Long.parseLong(roomInfo.getStayDay());
				weekdayPrice = Integer.parseInt(roomInfo.getWeekdayPrice());
				weekendPrice = Integer.parseInt(roomInfo.getWeekendPrice());
			}

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("{\"totalSum\": \"" + totalSum + "\", \"stayDays\": \"" + stayDays + "\"}");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
