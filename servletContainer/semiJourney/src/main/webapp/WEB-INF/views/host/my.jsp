<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 마이페이지</title>

<link rel="stylesheet" href="/journey/resources/css/host/my.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	
	<main class="main">
	
	  <div>
	    <h1>계정</h1>
	  </div>
	
	  <span style="font-weight: bold;">${sessionScope.loginHostVo.name}, </span>
	  <span>•</span>
	  <span>프로필로 이동</span>
	
	  <div class="menuOutter">
	    <div class="menuInner" onclick="location.href='/journey/host/edit'">
	      <div class="menuIcon"><img id="iconImg" src="/journey/resources/upload/host/${sessionScope.loginHostVo.profile}"></div>
	      <div class="menuTitle">개인정보 수정</div>
	      <div class="memnuContent">개인정보를 수정합니다</div>
	    </div>
	    <div class="menuInner">
	      <div class="menuIcon" onclick="location.href='/journey/book/list'"><img id="iconImg" src="/journey/resources/img/my/security.png"></div>
	      <div class="menuTitle">예약 정보 관리</div>
	      <div class="memnuContent">예약 정보를 관리합니다.</div>
	    </div>
	    <div class="menuInner">
	      <div class="menuIcon" onclick="location.href='/journey/host/quit'"><img id="iconImg" src="/journey/resources/img/my/cardAdd.png"></div>
	      <div class="menuTitle">회원 탈퇴</div>
	      <div class="memnuContent">회원 탈퇴를 진행합니다.</div>
	    </div>
	
	  </div>
	  </div>
	</main>
	
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
</body>
</html>
