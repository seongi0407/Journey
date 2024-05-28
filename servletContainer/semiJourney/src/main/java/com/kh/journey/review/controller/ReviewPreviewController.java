package com.kh.journey.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.journey.review.service.ReviewService;
import com.kh.journey.review.vo.ReviewVo;

@WebServlet("/review/preview")
public class ReviewPreviewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//해당 room 리뷰리스트보기
			String roomNo = req.getParameter("roomNo");

			ReviewService rs = new ReviewService();
			List<ReviewVo> voList = rs.getReviewListByRoomNo(roomNo);
			req.setAttribute("voList", voList);
			req.setAttribute("roomNo", roomNo);
			req.getRequestDispatcher("/WEB-INF/views/review/preview.jsp").forward(req, resp);
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
