package com.kh.journey.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.member.vo.MemberVo;
import com.kh.journey.review.service.ReviewService;
import com.kh.journey.review.vo.ReviewVo;

//게시글 등록
@WebServlet("/review/insert")
public class ReviewInsertController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String reserveNo = req.getParameter("reserveNo");
		// 결과출력
		req.setAttribute("reserveNo", reserveNo);
		req.getRequestDispatcher("/WEB-INF/views/review/insert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();

			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

			// 데이터 꺼내기
			String writerNo = loginMemberVo.getNo();
			String reserveNo = req.getParameter("reserveNo");
			String content = req.getParameter("content");
			String accuracy = req.getParameter("accuracy");
			String clean = req.getParameter("clean");
			String checkin = req.getParameter("checkin");
			String location = req.getParameter("location");
			String communication = req.getParameter("communication");

			ReviewVo vo = new ReviewVo();
			vo.setWriterNo(writerNo);
			vo.setReserveNo(reserveNo);
			vo.setContent(content);
			vo.setAccuracy(accuracy);
			vo.setClean(clean);
			vo.setCheckin(checkin);
			vo.setLocation(location);
			vo.setCommunication(communication);

			// 서비스 호출
			ReviewService bs = new ReviewService();
			int result = bs.reviewInsert(vo);

			if (result != 1) {
				session.setAttribute("alertMsg", "리뷰 작성 실패");

				throw new Exception("리뷰 작성 실패");
			}
			session.setAttribute("alertMsg", "리뷰 작성 성공");
			resp.sendRedirect("/journey/member/review/list");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		// 결과 출력

	}
}
