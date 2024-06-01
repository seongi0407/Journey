<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약확인</title>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<link rel="stylesheet" href="/journey/resources/css/book/bookCheck.css">
<script defer src="/journey/resources/js/book/bookCheck.js"></script>

<script defer src="/journey/resources/js/layout/header.js"></script>
</head>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>
<body>

	<div id="head">
		<img class="rogoImg" src="/journey/resources/img/header/airbnb.png">
	</div>


	<main class="main">
		<section id="section">
			<div id="sectionInnerFront" class="flip-card-front">
				<div>
					<img id="roomImg"
						src="/journey/resources/upload/room/${newReservation.roomImg}"
						alt="Room Image">
				</div>
				<div>${newReservation.hostName}의
					방 ${newReservation.roomName}</div>
				<div>${newReservation.inDate}~${newReservation.outDate}</div>
				<div>${newReservation.address}</div>
				<div>게스트 ${newReservation.guestCount}명</div>
				<div>총가격 ${newReservation.sum}</div>
			</div>
			<div id="sectionInnerBack" class="flip-card-back">
				<c:choose>
					<c:when test="${fn:contains(newReservation.address, '서울')}">
						<img id="backImg" src="/journey/resources/img/book/map/seoul.jpg"
							alt="MapImage">
					</c:when>
					<c:when test="${fn:contains(newReservation.address, '제주')}">
						<img id="backImg" src="/journey/resources/img/book/map/jeju.jpg"
							alt="Map Image">
					</c:when>
					<c:when test="${fn:contains(newReservation.address, '강릉')}">
						<img id="backImg"
							src="/journey/resources/img/book/map/gangneung.jpg"
							alt="Map Image">
					</c:when>
					<c:when test="${fn:contains(newReservation.address, '대전')}">
						<img id="backImg"
							src="/journey/resources/img/book/map/daejeon.jpg" alt="Map Image">
					</c:when>
					<c:when test="${fn:contains(newReservation.address, '전주')}">
						<img id="backImg" src="/journey/resources/img/book/map/jeonju.jpg"
							alt="Map Image">
					</c:when>
					<c:when test="${fn:contains(newReservation.address, '여수')}">
						<img id="backImg" src="/journey/resources/img/book/map/yeosu.jpg"
							alt="Map Image">
					</c:when>
					<c:when test="${fn:contains(newReservation.address, '속초')}">
						<img id="backImg" src="/journey/resources/img/book/map/sokcho.jpg"
							alt="Map Image">
					</c:when>
					<c:when test="${fn:contains(newReservation.address, '부산')}">
						<img id="backImg" src="/journey/resources/img/book/map/busan.jpg"
							alt="Map Image">
					</c:when>
					<c:otherwise>
						<img id="backImg" src="/journey/resources/img/book/map/korea.jpg"
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