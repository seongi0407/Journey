package com.kh.journey.home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.journey.room.service.RoomService;
import com.kh.journey.room.vo.RoomVo;

@WebServlet("/home")
public class HomeController extends HttpServlet {
   
   private final RoomService service;
   
   // Constructor
   public HomeController() {
      this.service = new RoomService();
   }
   
   // 홈페이지 화면
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      try {
         // service 호출
         List<RoomVo> voList = service.getRoomListForHome();
         
         // 결과
         req.setAttribute("voList", voList);
         
         req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
         
      } catch(Exception e) {
         
      }
   } // doGet
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   } // doPost
} // class
