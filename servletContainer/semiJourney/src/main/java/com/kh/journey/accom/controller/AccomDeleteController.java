package com.kh.journey.accom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.journey.accom.service.AccomService;
import com.kh.journey.accom.vo.AccomVo;
import com.kh.journey.room.service.RoomService;
import com.kh.journey.wish.vo.WishVo;

@WebServlet("/accom/delete")
public class AccomDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();

			// 데이터 꺼내기
			String no = req.getParameter("no");

			// 서비스 호출
			AccomService as = new AccomService();
			int result = as.delete(no);
			
			Map<String, Integer> map = new HashMap<>();
			
			map.put("result", result);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(map);
			resp.setContentType("application/json; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			out.write(jsonStr);
			out.flush();
	        out.close();

			// 결과
			if (result < 1) {
				throw new Exception("숙소 삭제 실패");
			}

			resp.sendRedirect("/journey/home");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}