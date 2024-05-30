<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>여행</title>
<link rel="stylesheet" href="/journey/resources/css/book/bookList.css">
<script defer src="/journey/resources/js/book/bookList.js"></script>

<link rel="stylesheet" href="/journey/resources/css/layout/header2.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
</head>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>

<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<main class="main">

		<div>
			<h1>여행</h1>
		</div>
		<div>
			<h2>예정된 여행</h2>
		</div>
		<div class="roomScheduleOutter">
			<c:forEach var="reservation" items="${reservationList}">
				<div class="roomSchedule">
					<div id="roomText">
						<div id="place-name" class="place-name">
							<h1>${reservation.roomName}</h1>
							<button class="cancelBtn"
								onclick="location.href='/journey/book/cancel?reserveNo=${reservation.reserveNo}'">예약취소</button>
						</div>
						<hr>
						<br>
						<p id="place-date">${reservation.inDate}~
							${reservation.outDate}</p>
						<p id="place-address">${reservation.address}</p>
						<p id="place-address">총 금액 : ${reservation.sum}</p>
						<br>
						<hr>
						<br>
						<div id="hostProfileDiv" class="hostInfo">
							<img id="hostProfile" class="hostProfile"
								src="/journey/resources/upload/host/${reservation.hostProfile}"
								alt="hostProfile">
							<div>${reservation.hostName}</div>
							<div id="place-date">Phone : ${reservation.hostPhone}</div>
						</div>
					</div>
					<img id="roomImg" class="room-image"
						src="/journey/resources/upload/room/${reservation.roomImg}"
						alt="RoomImage">
				</div>
			</c:forEach>
		</div>
		<h2>지난 여행</h2>
		</div>
		<div class="imageContainer">
			<c:forEach var="history" items="${historyList}">
				<div class="roomContainer">
					<div>
						<img
							src="/journey/resources/upload/room/${history.roomImg}"
							alt="RoomImage" class="room-image" />
					</div>
					<div id="historyText" class="historyText">
						<p id="place-name">${history.roomName}</p>
						<c:if test="${history.reviewNo == null}">
							<button class="reviewBtn"
								onclick="location.href='/journey/review/insert?reserveNo=${history.reserveNo}'">리뷰작성</button>
						</c:if>
						<c:if test="${history.reviewNo != null}">
							<button class="completedReviewBtn" disabled>작성완료</button>
						</c:if>
						<p id="stay-date">${history.inDate}~${history.outDate}</p>
					</div>
				</div>
			</c:forEach>
		</div>

		<div>
			<h2>취소된 여행</h2>
		</div>
		<div class="imageContainer">
			<c:forEach var="refund" items="${refundList}">
				<div class="roomContainer">
					<div>
						<img
							src="/journey/resources/upload/room/${refund.roomImg}"
							alt="RoomImage" class="room-image" />
					</div>
					<div id="roomText">
						<p id="place-name">${refund.roomName}</p>
						<p id="stay-date">${refund.inDate}~${refund.outDate}</p>
					</div>
				</div>
			</c:forEach>
		</div>

	</main>


	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>

</html>

