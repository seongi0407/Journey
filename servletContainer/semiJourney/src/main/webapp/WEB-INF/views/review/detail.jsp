<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세</title>
<link rel="stylesheet" href="../resources/css/reviewDetail.css">
</head>
<body>
	<header>
		<div class="header-inner">
			<img id="airbnbImg" src="../resources/img/airbnb.png"
				alt="Airbnb Logo">
			<h1>리뷰 상세</h1>
		</div>
	</header>
	<main>
		<section class="review-section">
			<div class="review-container">
				<h2>리뷰 상세</h2>
				<hr>
				<table class="review-table">
					<thead>
						<tr>
							<th>프로필</th>
							<th>작성자</th>
							<th>평점</th>
							<th>날짜</th>
							<th>내용</th>

							<th>
								<button onclick="deleteCheckedBoard();">❌</button>
							</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${voList}" var="vo">
							<tr>
								<td><img width="100px" height="100px" alt="profile"
									src="/app/resources/upload/${vo.profile}"></td>
								<td>${vo.writerName}</td>
								<td>${vo.starAvg}</td>
								<td>${vo.enrollDate}</td>
								<td>${vo.content}</td>

								<td><input type="checkbox" value="${vo.no}"></td>

							</tr>
						</c:forEach>
						<tr>
							<button onclick="deleteCheckedBoard();">삭제하기</button>
						</tr>
					</tbody>
				</table>
			</div>
		</section>
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
	<script src="../resources/js/reviewDetail.js"></script>
</body>
</html>
