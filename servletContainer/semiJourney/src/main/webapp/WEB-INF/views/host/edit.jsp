<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 개인 정보 수정</title>

<link rel="stylesheet" href="/journey/resources/css/host/edit.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
  
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<nav id="navText">
	  <div class="backImgBox"><img src="/journey/resources/img/my/goback.png"></div>
	  <span>계정 > 개인정보</span>
	  <div>
	    <h1>개인정보</h1>
	  </div>
	</nav>
	
	<main>
	  <form action="">
	    <section class="rsv_inner">
	      <div class="updateMember">
	
	        <div class="updateMemberPersonal">
	          <div class="updateInner">
	            <div id="name">
	              <h3>실명</h3>
	            </div>
	            <div name="name"><span>${sessionScope.loginHostVo.name}</span></div>
	          </div>
	          <div class="update"><span class="updateName" role="button" onclick="location.href='/journey/host/edit/name'">수정</span></div>
	        </div>
	        <div><br>
	          <hr />
	        </div>
	        
	        <div class="updateMemberPersonal">
	          <div class="updateInner">
	            <div id="e-mail">
	              <h3>비밀번호</h3>
	            </div>
	            <div name="e-mail"><span>********</span></div>
	          </div>
	          <div class="update"><span class="updateEmail" role="button" onclick="location.href='/journey/host/edit/password'">수정</span></div>
	        </div>
	        <div><br>
	          <hr />
	        </div>
	
	        <div class="updateMemberPersonal">
	          <div class="updateInner">
	            <div id="phone">
	              <h3>전화번호</h3>
	            </div>
	            <div name="phone"><span>${sessionScope.loginHostVo.phone}</span></div>
	          </div>
	          <div class="update"><span class="updatePhoneNumber" role="button" onclick="location.href='/journey/host/edit/phone'">수정</span></div>
	        </div>
	        <div><br>
	          <hr />
	        </div>
	
	      </div>
	    </section>
	  </form>
	
	  <aside>
	    <div class="asideBox">
	      <div class="asideText">
	        <img src="/journey/resources/img/my/security1.png">
	        <h3>여기에 내 개인정보가 표시되지 않는 이유가 무엇인가요?</h3>
	        <span>신분이 노출되지 않도록 일부 계정 정보가 숨김 처리되었습니다.</span>
	        <br><br>
	        <hr>
	      </div>
	      <div class="asideText">
	        <img src="/journey/resources/img/my/security2.png">
	        <h3>수정할 수 있는 세부 정보는 무엇인가요?</h3>
	        <span>연락처 정보와 개인정보를 수정하실 수 있습니다. 본인 인증 시 이 정보를 사용했다면 호스팅을 계속하기 위해 또는 다음번 예약 진행 시 다시 인증을 받으셔야 합니다.</span>
	        <br><br>
	        <hr>
	      </div>
	      <div class="asideText">
	        <img src="/journey/resources/img/my/security3.png">
	        <h3>다른 사람에게 어떤 정보가 공개되나요?</h3>
	        <span>에어비앤비는 예약이 확정된 후에만 호스트 및 게스트의 연락처 정보를 공개합니다.</span>
	      </div>
	    </div>
	  </aside>
	</main>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
  
</body>
</html>