package com.kh.journey.wish.controller;

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
import com.kh.journey.wish.service.WishService;
import com.kh.journey.wish.vo.WishVo;

@WebServlet("/wish/delete")
public class WishDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			// 데이터 꺼내기
			String wishNo = req.getParameter("wishNo");
			String memberNo = req.getParameter("memberNo");
			
			// 로그인 확인
			if(memberNo == null) {
				throw new Exception("로그인이 필요합니다.");
			}
			
			WishVo wishVo = new WishVo();
		 	wishVo.setNo(wishNo);
            wishVo.setMemNo(memberNo);
			
            System.out.println("vo: " + wishVo);
            
			//서비스 호출 
			WishService ws = new WishService();
			int result = ws.delete(wishVo);
			
			//결과
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
	         if(result < 1) {
	            session.setAttribute("alertMsg", "위시리스트 삭제 실패");
	            throw new Exception("위시리스트 삭제 실패");
	         }
	         session.setAttribute("alertMsg", "위시리스트 삭제 성공");
	       
	         
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
