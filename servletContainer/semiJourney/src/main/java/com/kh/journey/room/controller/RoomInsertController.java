package com.kh.journey.room.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.journey.room.service.RoomService;
import com.kh.journey.room.vo.AttachmentVo;
import com.kh.journey.room.vo.RoomVo;
import com.kh.journey.util.file.FileUpload;

@MultipartConfig(
	maxFileSize = 1024 * 1024 * 50,
	maxRequestSize = 1024 * 1024 * 500,
	fileSizeThreshold = 1024 * 1024 * 50
)
@WebServlet("/room/insert")
public class RoomInsertController extends HttpServlet {
	
	private final RoomService service;
	
	// Constructor
	public RoomInsertController() {
		service = new RoomService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(req, resp);
	} // doGet
	
	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 데이터 꺼내기
			// 기본 입력 값
			String name = req.getParameter("name");
			String themeCode = req.getParameter("themeCode");
			
			// 수용력
			String capacity = req.getParameter("capacity");
			String bathNum = req.getParameter("bathNum");
			String roomNum = req.getParameter("roomNum");

			// 침대
			String bedSingle = req.getParameter("bedSingle");
			String bedDouble = req.getParameter("bedDouble");
			String bedQueen = req.getParameter("bedQueen");
			
			// 가격
			String weekdayPrice = req.getParameter("weekdayPrice");
			String weekendPrice = req.getParameter("weekendPrice");
			
			// 편의시설
			String towelYn = req.getParameter("towelYn");
			String netflixYn = req.getParameter("netflixYn");
			String airconditionerYn = req.getParameter("airconditionerYn");
			String heatingYn = req.getParameter("heatingYn");
			String tvYn = req.getParameter("tvYn");
			String firealarmYn = req.getParameter("firealarmYn");
			String firstaidkitYn = req.getParameter("firstaidkitYn");
			String wifiYn = req.getParameter("wifiYn");
			String frigerYn = req.getParameter("frigerYn");
			String ovenYn = req.getParameter("ovenYn");
			String hairdryerYn = req.getParameter("hairdryerYn");
			
			RoomVo vo = new RoomVo();
			
			// 기본 입력 값
			vo.setName(name);
			vo.setThemeCode(themeCode);
			
			// 수용력
			vo.setCapacity(capacity);
			vo.setBathNum(bathNum);
			vo.setRoomNum(roomNum);
			
			// 침대
			vo.setBedSingle(bedSingle);
			vo.setBedDouble(bedDouble);
			vo.setBedQueen(bedQueen);
			
			// 가격
			vo.setWeekendPrice(weekendPrice);
			vo.setWeekdayPrice(weekdayPrice);

			// 편의시설
			vo.setAirconditionerYn(airconditionerYn);
			vo.setWifiYn(wifiYn);
			vo.setTvYn(tvYn);
			vo.setTowelYn(towelYn);
			vo.setOvenYn(ovenYn);
			vo.setFirealarmYn(firealarmYn);
			vo.setFirstaidkitYn(firstaidkitYn);
			vo.setNetflixYn(netflixYn);
			vo.setFrigerYn(frigerYn);
			vo.setHeatingYn(heatingYn);
			vo.setHairdryerYn(hairdryerYn);

			// 객실 이미지			
			Collection<Part> parts = req.getParts();

			List<Part> fileList = new ArrayList<Part>();
			for(Part part: parts) {
				if(part.getContentType() != null) {
					fileList.add(part);
				}
			}
			
			// 서버에 파일 업로드
			List<AttachmentVo> attVoList = new ArrayList<AttachmentVo>();
			for(Part f: fileList) {
				AttachmentVo attVo = FileUpload.saveFile(f);
				attVoList.add(attVo);
			}
			
			// service 호출
			int result = service.insert(vo, attVoList);
			
			if(result < 1) {
				throw new Exception("객실 등록 실패");
			}
			
			resp.sendRedirect("/journey/home");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // doPost
} // class
