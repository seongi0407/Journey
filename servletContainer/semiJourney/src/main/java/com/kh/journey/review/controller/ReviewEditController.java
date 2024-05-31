package com.kh.journey.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.member.vo.MemberVo;
import com.kh.journey.review.service.ReviewService;
import com.kh.journey.review.vo.ReviewVo;

@WebServlet("/review/edit")
public class ReviewEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String reviewNo = req.getParameter("reviewNo");

			// 서비스 호출
			ReviewService rs = new ReviewService();

			List<ReviewVo> review = rs.getReviewByNo(reviewNo);

			req.setAttribute("review", review);
			req.getRequestDispatcher("/WEB-INF/views/review/edit.jsp").forward(req, resp);
		} catch (Exception e) {
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

			// 데이터 꺼내기
			String no = req.getParameter("no");
			String content = req.getParameter("content");

			ReviewVo vo = new ReviewVo();
			vo.setNo(no);
			vo.setContent(content);

			// 서비스 호출
			ReviewService bs = new ReviewService();
			int result = bs.editReviewContent(vo);

			if (result != 1) {
				session.setAttribute("alertMsg", "리뷰 수정 실패");

				throw new Exception("리뷰 수정 실패");
			}
			session.setAttribute("alertMsg", "리뷰 수정 성공");
			resp.sendRedirect("/journey/member/review/list");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}