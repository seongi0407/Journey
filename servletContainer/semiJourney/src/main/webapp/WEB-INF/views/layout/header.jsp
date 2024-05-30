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
					<button>예약</button>
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
					<button>여행</button>
					<button onclick="location.href='/journey/wish/list'">위시리스트</button>
					<hr>
					<button onclick="location.href='/journey/member/my'">계정</button>
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
</header>