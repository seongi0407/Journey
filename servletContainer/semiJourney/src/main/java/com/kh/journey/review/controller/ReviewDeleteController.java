package com.kh.journey.review.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.journey.review.service.ReviewService;

@WebServlet("/review/delete")
public class ReviewDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String[] reviewNoList = req.getParameterValues("reviewNo");

			if (reviewNoList == null || reviewNoList.length == 0) {
				throw new Exception("삭제할 리뷰를 선택해주세요.");
			}

			System.out.println("리뷰 번호: " + Arrays.toString(reviewNoList));

			ReviewService rs = new ReviewService();
			int result = rs.deleteReview(reviewNoList);
			if (result != reviewNoList.length) {
				throw new Exception("리뷰 삭제 실패");
			}
			resp.sendRedirect("/journey/home");
		} catch (

		Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
