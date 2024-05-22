package com.kh.journey.member.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.journey.member.service.MemberService;
import com.kh.journey.member.vo.MemberVo;


@MultipartConfig(
	maxFileSize = 1024 * 1024 * 10,
	maxRequestSize = 1024 * 1024 * 50,
	fileSizeThreshold = 1024 * 1024 * 10
)
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	
	private MemberService service = null;
	
	// Contructor
	public MemberJoinController() {
		service = new MemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/ju/member/join.jsp").forward(req, resp);
	} // doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 데이터 꺼내기
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String pwd2 = req.getParameter("pwd2");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String birthDate = req.getParameter("birth-date");
			Part profile = req.getPart("profile");

			String changeName = "";
			if(profile.getSize() > 0) {
				// 파일을 서버에 저장하기
				String originName = profile.getSubmittedFileName();
				InputStream is = profile.getInputStream();
				
				// 파일아웃풋 스트림 준비
				String path = "D:\\dev\\servletWorkspace\\test\\src\\main\\webapp\\resources\\upload\\";
				String random = UUID.randomUUID().toString();
				String ext = originName.substring(originName.lastIndexOf("."));
				changeName = "member_" + System.currentTimeMillis() + "_" + random + ext;
				FileOutputStream fos = new FileOutputStream(path + changeName);
				
				byte[] buf = new byte[1024];
				
				int size = 0;
				while((size = is.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}
				
				is.close();
				fos.close();
			}
			
			// 데이터 뭉치기
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setPwd2(pwd2);
			vo.setName(name);
			vo.setEmail(email);
			vo.setPhone(phone);
			vo.setBirthDate(birthDate);
			vo.setProfile(changeName);
			
			// 서비스 호출
			int result = service.join(vo);
			
			// 결과 처리
			if(result == 1) {
				req.setAttribute("alertMsg", "회원가입 성공");
			} else {
				req.setAttribute("alertMsg", "회원가입 실패");
			}
			
			resp.sendRedirect("/journey/home");
			
		} catch(Exception e) {
			System.out.println("[ERROR-M0001] " + e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	} // doPost
} // class
