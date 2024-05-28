<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약결제완료</title>
<link rel="stylesheet" href="/journey/resources/css/bookCheck.css">
<script defer src="/journey/resources/js/bookCheck.js"></script>
<link rel="stylesheet" href="/journey/resources/css/layout.css">
<script defer src="/journey/resources/js/layout.js"></script>
</head>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>
<body>
<head>
<div id="head">
	<img class="rogoImg" src="/journey/resources/img/airbnb.png">
</div>
</head>

<main class="main">
	<section id="section">
		<div id="sectionInnerFront" class="flip-card-front">
			<div>
				<img id="roomImg"
					src="https://yaimg.yanolja.com/v5/2021/12/27/11/1280/61c9a852b80a75.50854466.jpg"
					alt="Room Image">
			</div>
			<div style="font-weight: bold; font-size: 20px;">${newReservation.hostName}의
				방 ${newReservation.roomName}</div>
			<div>${newReservation.inDate}~${newReservation.outDate}</div>
			<div>${newReservation.address}</div>
			<div>게스트 ${newReservation.guestCount}명</div>
			<div>총가격 ${newReservation.sum}</div>
		</div>
		<div id="sectionInnerBack" class="flip-card-back">
			<c:choose>
				<c:when test="${fn:contains(newReservation.address, '서울')}">
					<img id="backImg" src="/journey/resources/img/map/seoul.jpg"
						alt="MapImage">
				</c:when>
				<c:when test="${fn:contains(newReservation.address, '제주')}">
					<img id="backImg" src="/journey/resources/img/map/jeju.jpg"
						alt="Map Image">
				</c:when>
				<c:when test="${fn:contains(newReservation.address, '강릉')}">
					<img id="backImg" src="/journey/resources/img/map/gangneung.jpg"
						alt="Map Image">
				</c:when>
				<c:when test="${fn:contains(newReservation.address, '대전')}">
					<img id="backImg" src="/journey/resources/img/map/daejeon.jpg"
						alt="Map Image">
				</c:when>
				<c:when test="${fn:contains(newReservation.address, '전주')}">
					<img id="backImg" src="/journey/resources/img/map/jeonju.jpg"
						alt="Map Image">
				</c:when>
				<c:when test="${fn:contains(newReservation.address, '여수')}">
					<img id="backImg" src="/journey/resources/img/map/yeosu.jpg"
						alt="Map Image">
				</c:when>
				<c:when test="${fn:contains(newReservation.address, '속초')}">
					<img id="backImg" src="/journey/resources/img/map/sokcho.jpg"
						alt="Map Image">
				</c:when>
				<c:when test="${fn:contains(newReservation.address, '부산')}">
					<img id="backImg" src="/journey/resources/img/map/busan.jpg"
						alt="Map Image">
				</c:when>
				<c:otherwise>
					<img id="backImg" src="/journey/resources/img/map/korea.jpg"
						alt="Map Image">
				</c:otherwise>
			</c:choose>

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

</body>


</html>