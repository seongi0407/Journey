<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<img id="img-logo" src="/journey/resources/img/airbnb.png" alt="">
	<div class="header-right">
		<div id="introduce">당신의 공간을 여정하세요</div>
		<div id="profile-icon" onclick="showAccountContent()">
			<img id="menu-icon" width="16" src="/journey/resources/img/menu.svg"
				alt="메뉴 아이콘"> <img id="user-icon" width="30"
				src="/journey/resources/img/profile.svg" alt="유저 아이콘">
		</div>
		<div class="account-content" id="account-content">
			<button id="join" onclick="showJoin()">회원가입</button>
			<button id="login" onclick="showLogin()">로그인</button>
			<hr>
			<button>당신의 공간을 여정하세요</button>
			<button>도움말 센터</button>
		</div>
	</div>
</header>