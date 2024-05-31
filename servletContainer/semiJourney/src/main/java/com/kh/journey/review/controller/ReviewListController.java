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

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReviewService rs = new ReviewService();
			String roomNo = req.getParameter("roomNo");
			
			List<ReviewVo> voList = rs.getReviewListAllByRoomNo(roomNo);

			System.out.println(voList);
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
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
		doGet(req, resp);
	}
}