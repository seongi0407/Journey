<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<img id="img-logo" src="/journey/resources/img/header/airbnb.png" alt="" onclick="location.href='/journey/home'">
	
	<div class="header-right">
		<div id="introduce">당신의 공간을 여정하세요</div>
		<div id="profile-icon" onclick="showAccountContent()">
			<img id="menu-icon" width="16" src="/journey/resources/img/header/menu.svg"
				alt="메뉴 아이콘"> <img id="user-icon" width="30"
				src="/journey/resources/img/header/profile.svg" alt="유저 아이콘">
		</div>
		
		<c:choose>
		
			<c:when test="${not empty sessionScope.loginAdminVo.name}">
				<div class="account-content" id="account-content">
					<button>메세지</button>
					<button>경고주기</button>
					<hr>
					<button onclick="location.href='/journey/home'">리뷰 관리</button>
					<button onclick="location.href='/journey/home'">FAQ</button>
					<button>QNA</button>
					<hr>
					<button>도움말 센터</button>
					<button onclick="location.href='/journey/admin/logout'">로그아웃</button>
				</div>				
			</c:when>
			
			<c:when test="${not empty sessionScope.loginHostVo.name}">
				<div class="account-content" id="account-content">
					<button>메세지</button>
					<button onclick="location.href='/journey/book/list'">예약</button>
					<button>호스팅 수입</button>
					<hr>
					<button onclick="location.href='/journey/host/my'">계정</button>
					<button onclick="location.href='/journey/accom/list'">숙소 관리</button>
					<hr>
					<button>도움말 센터</button>
					<button onclick="location.href='/journey/host/logout'">로그아웃</button>
				</div>						
			</c:when>
			
			<c:when test="${not empty sessionScope.loginMemberVo.name}">
				<div class="account-content" id="account-content">
					<button>메세지</button>
					<button onclick="location.href='/journey/book/list'">여행</button>
					<button onclick="location.href='/journey/wish/list'">위시리스트</button>
					<hr>
					<button onclick="location.href='/journey/member/my'">계정</button>
					<button onclick="location.href='/journey/member/review/list'">내가 작성한 후기</button>
					<button>호스트 추천하기</button>
					<hr>
					<button>도움말 센터</button>
					<button onclick="location.href='/journey/member/logout'">로그아웃</button>
				</div>				
			</c:when>
			
			<c:otherwise>
				<div class="account-content" id="account-content">
					<button id="join" onclick="showJoin()">회원가입</button>
					<button id="login" onclick="showLogin()">로그인</button>
					<hr>
					<button>당신의 공간을 여정하세요</button>
					<button>도움말 센터</button>
				</div>				
			</c:otherwise>
			
		</c:choose>
	</div>
			<!-- Member, Host, Admin 회원가입 선택하는 창 -->
	<div class="select-account" id="select-account-join">
		<div id="admin">
			<button>
				<img src="/journey/resources/img/header/admin.png" alt="관리자">
			</button>
			<button>관리자</button>
		</div>
		<div id="host">
			<!-- 포트번호 확인해서 바꾸기 -->
			<a href="http://127.0.0.1:8888/journey/host/join">
				<button>
					<img src="/journey/resources/img/header/host.png" alt="호스트">
				</button>
			</a>
			<button>호스트</button>
		</div>
		<div id="member">
			<button id="memberJoin" onclick="showMemberJoin()">
				<img src="/journey/resources/img/header/member.png" alt="회원">
			</button>
			<button>회원</button>
		</div>
		<button class="close-button" id="close-button-join">닫 기</button>
	</div>

	<!-- Member, Host, Admin 로그인 선택하는 창 -->
	<div class="select-account" id="select-account-login">
		<div id="admin">
			<button onclick="showAdminLogin()">
				<img src="/journey/resources/img/header/admin.png" alt="관리자">
			</button>
			<button>관리자</button>
		</div>
		<div id="host">
			<!-- 포트번호 확인해서 바꾸기 -->
			<button onclick="showHostLogin()">
				<img src="/journey/resources/img/header/host.png" alt="호스트">
			</button>
			<button>호스트</button>
		</div>
		<div id="member">
			<button id="memberLogin" onclick="showMemberLogin()">
				<img src="/journey/resources/img/header/member.png" alt="회원">
			</button>
			<button>회원</button>
		</div>
		<button class="close-button" id="close-button-login">닫 기</button>
	</div>

	<!-- Member 회원가입 창 -->
	<div class="join-content" id="join-content">
		<form action="/journey/member/join" method="post"
			enctype="multipart/form-data" class="join-box">
			<h3>회원가입 완료하기</h3>
			<hr>
			<h4>실명</h4>
			<input type="text" size="22" name="name"
				placeholder="신분증에 기재된 이름(예:길동)" required> <br>
			<h6>
				정부 발급 신분증에 기재된 이름과 일치해야 합니다. 평소 다른 이름을 사용하는 경우, <u>선호하는 이름</u>을
				입력하세요.
			</h6>
			<h4>생년월일</h4>
			<input type="text" name="birth-date" required>
			<h6>18세 이상인 성인만 회원으로 가입할 수 있습니다. 생일은 여행의 정석의 다른 회원에게 공개되지 않습니다.</h6>
			<h4>Contact Info</h4>
			전화번호 : <input type="tel" name="phone" placeholder="01012345678"
				required> <br> 이메일 : <input type="email" name="email"
				placeholder="kh11@gmail.com" required>
			<div class="id-checkDup">
				<h4>아이디</h4>
				<input type="text" name="id" required> <input type="button"
					value="중복 확인">
			</div>
			<h4>비밀번호</h4>
			<input type="password" name="pwd" required>
			<h4>비밀번호 확인</h4>
			<input type="password" name="pwd2" required>
			<h4>프로필 이미지</h4>
			<input type="file" name="profile"> <br>
			<hr>
			<br>
			<div class="checkbox-container">
				<h5>개인정보 수집 및 이용에 동의합니다.</h5>
				<input type="checkbox" required>
			</div>
			<div class="checkbox-container">
				<h5>마케팅 이메일 수신을 원합니다(선택).</h5>
				<input type="checkbox">
			</div>
			<br>
			<hr>
			<br>
			<h4>
				동의 및 계속하기를 선택하여 여행의 정석 <u>서비스 약관</u>, <u>결제 서비스 약관</u>, <u>위치기반서비스
					이용약관</u>, <u>차별 금지 정책</u>, <u>개인정보 처리방침</u>에 동의합니다.
			</h4>
			<input type="submit" value="동의 및 계속하기" class="join-submit-button">
			<button type="button" id="join-close-button">닫기</button>
		</form>
	</div>
	<!--  -->


	<!-- Member 로그인 창 -->
	<div class="login-content" id="login-member-content">
		<form action="/journey/member/login" method="post" class="login-box">
			<h3>로그인</h3>
			<hr>
			<h2>여행의 정석에 오신 것을 환영합니다.</h2>
			<br> <input id="login-id" type="text" name="id"
				placeholder="아이디" required> <br> <br> <input
				id="login-password" type="password" name="pwd" placeholder="비밀번호"
				required>
			<!-- 비밀번호 보기 -->
			<button type="button" class="show-password" onclick="showPassword()">비밀번호
				보기</button>
			<br> <br> <input type="submit" value="로그인"
				class="login-submit-button"> <br>
			<h4>
				<u>비밀번호를 잊으셨나요?</u>
			</h4>
			<button type="button" id="login-close-button">닫기</button>
		</form>
	</div>
	<!--  -->
	<!-- Host 로그인 창 -->
	<div class="login-content" id="login-host-content">
		<form action="/journey/host/login" method="post" class="login-box">
			<h3>로그인</h3>
			<hr>
			<h2>여행의 정석에 오신 것을 환영합니다.</h2>
			<br> <input id="login-id" type="text" name="id"
				placeholder="아이디" required> <br> <br> <input
				id="login-password" type="password" name="pwd" placeholder="비밀번호"
				required>
			<!-- 비밀번호 보기 -->
			<button type="button" class="show-password" onclick="showPassword()">비밀번호
				보기</button>
			<br> <br> <input type="submit" value="로그인"
				class="login-submit-button"> <br>
			<h4>
				<u>비밀번호를 잊으셨나요?</u>
			</h4>
			<button type="button" id="login-close-button">닫기</button>
		</form>
	</div>
	<!--  -->
	<!-- Admin 로그인 창 -->
	<div class="login-content" id="login-admin-content">
		<form action="/journey/admin/login" method="post" class="login-box">
			<h3>로그인</h3>
			<hr>
			<h2>여행의 정석에 오신 것을 환영합니다.</h2>
			<br> <input id="login-id" type="text" name="id"
				placeholder="아이디" required> <br> <br> <input
				id="login-password" type="password" name="pwd" placeholder="비밀번호"
				required>
			<!-- 비밀번호 보기 -->
			<button type="button" class="show-password" onclick="showPassword()">비밀번호
				보기</button>
			<br> <br> <input type="submit" value="로그인"
				class="login-submit-button"> <br>
			<h4>
				<u>비밀번호를 잊으셨나요?</u>
			</h4>
			<button type="button" id="login-close-button">닫기</button>
		</form>
	</div>
	<!--  -->
</header>