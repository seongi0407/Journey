package com.kh.journey.review.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
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
			HttpSession session = req.getSession();
			Gson gson = new Gson();
			String[] reviewNoList = gson.fromJson(new InputStreamReader(req.getInputStream()), String[].class);

			System.out.println(Arrays.toString(reviewNoList));

			if (reviewNoList == null || reviewNoList.length == 0) {
				throw new Exception("삭제할 리뷰를 선택해주세요.");
			}

			ReviewService rs = new ReviewService();
			int result = rs.deleteReview(reviewNoList);
			if (result != reviewNoList.length) {
				session.setAttribute("alertMsg", "리뷰 삭제 실패");
				throw new Exception("리뷰 삭제 실패");
			}
			session.setAttribute("alertMsg", "리뷰 삭제 성공");
			resp.sendRedirect("/journey/home");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
