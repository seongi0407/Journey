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

@WebServlet("/member/review/list")
public class MyReviewListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String memberNo = loginMemberVo.getNo();

			if (loginMemberVo != null) {
				ReviewService rs = new ReviewService();
				List<ReviewVo> voList = rs.getReviewListAllByMemberNo(memberNo);

				req.setAttribute("voList", voList);
				req.getRequestDispatcher("/WEB-INF/views/review/myReviewList.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
			}
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