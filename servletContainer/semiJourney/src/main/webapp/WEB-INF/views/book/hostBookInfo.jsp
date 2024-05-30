<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약관리-호스트</title>
<link rel="stylesheet" href="/journey/resources/css/book/hostBookInfo.css">

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<script defer src="/journey/resources/js/home.js"></script>
</head>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>

<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<main class="main">

		<div class="header">
			<h1>예약관리</h1>
		</div>
		<section class="reservation-section">
			<h2>예정된 예약</h2>
			<div class="imageContainer">
				<c:forEach var="reservation" items="${reservationList}">
					<div class="roomContainer">

						<p class="place-name">${reservation.roomName}</p>
						<p class="guestCount">게스트 : ${reservation.guestCount}</p>
						<p class="sum">총 금액: ${reservation.sum}</p>
						<p class="stay-date">${reservation.inDate}~${reservation.outDate}</p>
						<hr>
						<div class="guestInfo">
							<img id="guestProfile" class="guestProfile"
								src="/journey/resources/upload/member/${reservation.reservatorProfile}"
								alt="hostProfile">
							<p class="guestName">${reservation.reservatorName}</p>
							<p class="guestPhone">${reservation.reservatorPhone}</p>
							<p class="guestEmail">${reservation.reservatorEmail}</p>
						</div>
						<button class="cancelBtn"
							onclick="location.href='/journey/book/cancel?reserveNo=${reservation.reserveNo}'">예약취소</button>

					</div>
				</c:forEach>
			</div>
		</section>

		<section class="reservation-section">
			<h2>지난 예약</h2>
			<div class="imageContainer">
				<c:forEach var="history" items="${historyList}">
					<div class="roomContainer">

						<p class="place-name">${history.roomName}</p>
						<p class="guestCount">게스트 : ${history.guestCount}</p>
						<p class="sum">총 금액: ${history.sum}</p>
						<p class="stay-date">${history.inDate}~${history.outDate}</p>
						<hr>
						<div class="guestInfo">
							<img id="guestProfile" class="guestProfile"
								src="/journey/resources/upload/member/${history.reservatorProfile}"
								alt="hostProfile">
							<p class="guestName">${history.reservatorName}</p>
							<p class="guestPhone">${history.reservatorPhone}</p>
							<p class="guestEmail">${history.reservatorEmail}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>

		<section class="reservation-section">
			<h2>취소된 예약</h2>
			<div class="imageContainer">
				<c:forEach var="refund" items="${refundList}">
					<div class="roomContainer">

						<p class="place-name">${refund.roomName}</p>
						<p class="guestCount">게스트 : ${refund.guestCount}</p>
						<p class="sum">총 금액: ${refund.sum}</p>
						<hr>
						<div class="guestInfo">
							<img id="guestProfile" class="guestProfile"
								src="/journey/resources/upload/member/${refund.reservatorProfile}"
								alt="hostProfile">
							<p class="guestName">${refund.reservatorName}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</main>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>

</html>

