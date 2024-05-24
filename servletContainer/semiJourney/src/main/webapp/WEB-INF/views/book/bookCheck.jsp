<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약결제완료</title>
<link rel="stylesheet" href="../resources/css/bookCheck.css">
<script defer src="../resources/js/bookCheck.js"></script>
</head>

<body>

	<header>
		<header>
			<img id="img-logo" src="../resources/img/airbnb.png" alt="">
			<div class="header-right">
				<div id="introduce">당신의 공간을 여정하세요</div>
				<div id="profile-icon" onclick="showAccountContent()">
					<img id="menu-icon" width="16" src="../resources/img/menu.svg"
						alt="메뉴 아이콘"> <img id="user-icon" width="30"
						src="../resources/img/profile.svg" alt="유저 아이콘">
				</div>
			</div>
		</header>
	</header>

	<main class="main">
		<section id="section">
			<div id="sectionInnerFront" class="flip-card-front">
				<div>
					<img id="roomImg" src="${reservation.roomImageUrl}"
						alt="Room Image">
				</div>
				<div style="font-weight: bold; font-size: 20px;">${reservation.hostName}의
					방</div>
				<div>${reservation.checkinDate}~${reservation.checkoutDate}</div>
				<div></div>
				<div>게스트 ${reservation.guestCount}명</div>
				<div>총가격 ${reservation.sum}</div>
			</div>
			<div id="sectionInnerBack" class="flip-card-back">
				<img id="backImg" src=" " alt="Map Image">
			</div>
		</section>

		<aside id="aside">
			<div id="rsvCompleteText">
				<h1 class="rsvCompleteText">예약이</h1>
				<h1 class="rsvCompleteText">확정되었습니다</h1>
			</div>
			<button id="nextBtn">다음</button>
		</aside>
	</main>
	<footer class="footer">
		<div class="footer-content">
			<div class="footer-column">
				<h4>에어비앤비 지원</h4>
				<ul>
					<li><a href="https://www.airbnb.co.kr/help">도움말 센터</a></li>
					<li><a href="https://www.airbnb.co.kr/help/article/3218">에어커버</a></li>
					<li><a href="https://www.airbnb.co.kr/against-discrimination">차별
							반대</a></li>
					<li><a href="https://www.airbnb.co.kr/accessibility">장애인
							지원</a></li>
					<li><a href="https://www.airbnb.co.kr/help/article/2701">예약
							취소 옵션</a></li>
					<li><a href="https://www.airbnb.co.kr/help/article/3290">이웃
							민원 신고</a></li>
				</ul>
			</div>
			<div class="footer-column">
				<h4>호스팅</h4>
				<ul>
					<li><a
						href="https://www.airbnb.co.kr/host/homes?from_footer=1">당신의
							공간을 여정하세요</a></li>
					<li><a
						href="https://www.airbnb.co.kr/host/homes?from_footer=1">호스트를
							위한 에어커버</a></li>
					<li><a href="https://www.airbnb.co.kr/resources/hosting-homes">호스팅
							자료</a></li>
					<li><a
						href="https://community.withairbnb.com/t5/custom/page/page-id/CommunityCenterNotFound">커뮤니티
							포럼</a></li>
					<li><a href="https://www.airbnb.co.kr/help/article/1387">책임감
							있는 호스팅</a></li>
					<li><a href="https://www.airbnb.co.kr/ambassadors/joinaclass">무료
							호스팅 클래스 참여하기</a></li>
				</ul>
			</div>
			<div class="footer-column">
				<h4>여정</h4>
				<ul>
					<li><a href="https://news.airbnb.com/">뉴스룸</a></li>
					<li><a href="https://www.airbnb.co.kr/release">새로운 기능</a></li>
					<li><a href="https://careers.airbnb.com/">채용정보</a></li>
					<li><a href="https://investors.airbnb.com/home/default.aspx">투자자
							정보</a></li>
					<li><a
						href="https://ko.airbnb.org/?_set_bev_on_new_domain=1715824984_ZWY5ZmRiZjk5MTg0">여정
							긴급 속보</a></li>
				</ul>
			</div>
		</div>
		<div class="footer-language">
			<span>한국어 (KR)</span> <span>₩ KRW</span>
		</div>
		<div class="footer-sns">
			<img src="../resources/img//facebook.png" alt="facebook"> <img
				src="../resources/img/twitter.png" alt="twitter"> <img
				src="../resources/img/instagram.png" alt="instagram"> <img
				src="../resources/img/blog.png" alt="blog">
		</div>
		<div class="footer-bottom">
			<span>© 2024 여정, Inc.</span>
			<div class="footer-link">
				<a href="">개인정보 처리방침</a> <a href="">이용약관</a> <a href="">사이트맵</a> <a
					href="">한국의 변경된 환불 정책</a> <a href="">회사 세부정보</a>
			</div>
		</div>
	</footer>
</body>

</html>