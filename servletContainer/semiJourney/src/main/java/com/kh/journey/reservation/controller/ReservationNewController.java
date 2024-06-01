package com.kh.journey.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.card.vo.CardVo;
import com.kh.journey.member.vo.MemberVo;
import com.kh.journey.reservation.service.ReservationService;
import com.kh.journey.reservation.vo.ReservationVo;

@WebServlet("/book/new")
public class ReservationNewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();

			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String loginMemNo = loginMemberVo.getNo();
			String roomNo = req.getParameter("roomNo");
			String inDate = req.getParameter("inDate");
			String outDate = req.getParameter("outDate");
			String guestCount = req.getParameter("guestCount");

			ReservationService rs = new ReservationService();
			List<CardVo> cardVoList = rs.getCardList(loginMemNo);
			List<ReservationVo> roomDetail = rs.getRoomDetail(roomNo, inDate, outDate);
			// 숙소 상세에서 예약정보 넘어오면 함께 넘겨야함.
			ReservationVo roomInfo = roomDetail.get(0);
			ReservationVo vo = new ReservationVo();
			vo.setRoomNo(roomNo);
			vo.setInDate(inDate);
			vo.setOutDate(outDate);
			vo.setGuestCount(guestCount);
			vo.setRoomImg(roomInfo.getRoomImg());
			vo.setHostName(roomInfo.getHostName());
			vo.setHostProfile(roomInfo.getHostProfile());
			vo.setHostEnrollDate(roomInfo.getHostEnrollDate());
			vo.setRoomName(roomInfo.getRoomName());
			vo.setWeekdayPrice(roomInfo.getWeekdayPrice());
			vo.setWeekendPrice(roomInfo.getWeekendPrice());
			vo.setStayDay(roomInfo.getStayDay());
			vo.setSum(roomInfo.getSum());

			req.setAttribute("vo", vo);
			req.setAttribute("cardVoList", cardVoList);
			req.getRequestDispatcher("/WEB-INF/views/book/new.jsp").forward(req, resp);

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();

			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String reservatorNo = loginMemberVo.getNo();

			if (loginMemberVo != null) {
				String roomNo = req.getParameter("roomNo");
				String inDate = req.getParameter("inDate");
				String outDate = req.getParameter("outDate");
				String guestCount = req.getParameter("guestCount");
				String sum = req.getParameter("sum");
				String payMethodCode = req.getParameter("payMethodCode");
				String cardNo = req.getParameter("cardNo");

				ReservationVo vo = new ReservationVo();

				vo.setReservatorNo(reservatorNo);
				vo.setRoomNo(roomNo);
				vo.setInDate(inDate);
				vo.setOutDate(outDate);
				vo.setGuestCount(guestCount);
				vo.setSum(sum);
				vo.setPayMethodCode(payMethodCode);
				vo.setCardNo(cardNo);

				System.out.println(vo);

				// 서비스 호출
				ReservationService rs = new ReservationService();
				int result = rs.ReservationInsert(vo);

				if (result != 1) {
					session.setAttribute("alertMsg", "숙소 예약 실패");
					throw new Exception("예약실패");
				}

				resp.sendRedirect("/journey/book/check");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}