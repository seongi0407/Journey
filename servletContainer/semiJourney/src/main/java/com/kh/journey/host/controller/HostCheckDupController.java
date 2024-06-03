package com.kh.journey.host.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.journey.host.service.HostService;
import com.kh.journey.host.vo.HostVo;

@WebServlet("/host/checkDup")
public class HostCheckDupController extends HttpServlet {
	
	private final HostService service;
	
	// constructor
	public HostCheckDupController() {
		this.service = new HostService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id = req.getParameter("id");
			
			// 서비스 호출
			HostVo vo = service.checkDup(id);
			
			// 결과
			int result = 0;
			if(vo != null) {
				result = 1;
			}
			
			Map<String, Integer> map = new HashMap<>();
			
			map.put("result", result);
			
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
