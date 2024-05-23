<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약 및 결제</title>
<link rel="stylesheet" href="../resources/css/reservationPayment.css">
<script defer src="../resources/js/reservationPayment.js"></script>
</head>

<body>

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

	<nav class="rsv_inner" id="navText">
		<div id="backImgBox">
			<img src="../resources/img/뒤로가기.png">
		</div>
		<div>
			<h1>확인 및 결제</h1>
		</div>
	</nav>

	<main class="main">
		<h1>예약 내역</h1>

		<c:if test="${not empty reservationList}">
			<table border="1">
				<tr>
					<th>예약 번호</th>
					<th>숙소 번호</th>
					<th>체크인 날짜</th>
					<th>체크아웃 날짜</th>
					<th>인원 수</th>
					<th>총 금액</th>
				</tr>
				<c:forEach var="reservation" items="${reservationList}">
					<tr>
						<td>${reservation.id}</td>
						<td>${reservation.roomNo}</td>
						<td>${reservation.inDate}</td>
						<td>${reservation.outDate}</td>
						<td>${reservation.peopleCnt}</td>
						<td>${reservation.sum}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${empty reservationList}">
			<p>예약 내역이 없습니다.</p>
		</c:if>
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

	<!-- 팝업창 -->

	<section>
		<div class="popup_layer" id="popup_layer" style="display: none;">
			<div class="popup_box">
				<div>
					<a href="javascript:closePop();"><img id="closeImg"
						src="../resources/img/close.png"></a>
				</div>
				<!--팝업 컨텐츠 영역-->
				<div class="popup_cont">
					<div class="returnPopup">
						<h2>환불정책</h2>
						<div class="refundInformation">
							<div>
								<div>전</div>
								<div>5월15일</div>
								<div>오후3:00</div>
							</div>
							<div>
								<div>부분환불</div>
								<div>전체 숙박 요금 중 50%를 환불받으실 수 있습니다.</div>
								<div>서비스 수수료는 전액 환불됩니다.</div>
							</div>
						</div>
						<div class="refundInformation">
							<div>
								<div>전</div>
								<div>5월15일</div>
								<div>오후3:00</div>
							</div>
							<div>
								<div>부분환불</div>
								<div>전체 숙박 요금 중 50%를 환불받으실 수 있습니다.</div>
								<div>서비스 수수료는 전액 환불됩니다.</div>
							</div>
						</div>
					</div>
					<!--팝업 버튼 영역-->
					<div class="returnDetailBtn">
						<div>체크인 전에 예약을 취소하면 청소비는 언제나 환불됩니다.</div>
						<a href="">환불 정책 자세히 알아보기</a>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>


</html>

