package com.kh.journey.room.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.journey.room.service.RoomService;

@WebServlet("/room/checkDate")
public class RoomCheckDateController extends HttpServlet {
	
	private final RoomService service;
	
	// constructor
	public RoomCheckDateController() {
		this.service = new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data 꺼내기
			String no = req.getParameter("no");
			String iDDate = req.getParameter("iDDate");
			String oDDate = req.getParameter("oDDate");
			
			// service 호출
//			int result = service.checkDate(no, iDDate, oDDate);
			
//			System.out.println("result: " + result);
			
			// 결과
			Map<String, Integer> map = new HashMap<>();
			
//			map.put("result", result);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(map);
			resp.setContentType("application/json; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			out.write(jsonStr);
			out.flush();
			out.close();
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	} // doPost
} // class
