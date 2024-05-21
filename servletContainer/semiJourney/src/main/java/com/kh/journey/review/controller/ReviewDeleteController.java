package com.kh.journey.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.journey.review.service.ReviewService;

@WebServlet("/review/delete")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewNo = req.getParameter("reviewNo");

		// ReviewService를 사용하여 리뷰 삭제 처리
		ReviewService reviewService = new ReviewService();
		try {
			int result = reviewService.deleteReview(reviewNo);

			if (result == 1) {
				// 리뷰 목록 페이지로 리다이렉트
				resp.sendRedirect(req.getContextPath() + "/review/list");
			} else {
				req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
		}
	}
}
