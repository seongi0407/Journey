<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약 및 결제</title>
<link rel="stylesheet" href="../resources/css/bookList.css">
<script defer src="../resources/js/bookList.js"></script>

<link rel="stylesheet" href="/journey/resources/css/layout.css">
<script defer src="/journey/resources/js/layout.js"></script>
</head>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<main class="main">

		<div>
			<h1>여행</h1>
		</div>
		<div>
			<h2>예정된 예약</h2>
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
								src="https://cdn.travelview.co.kr/travelview/2021/01/21020223/post_41596968_30400772_4.jpg"
								alt="hostProfile">
							<div>${reservation.hostName}</div>
							<div id="place-date">Phone : ${reservation.hostPhone}</div>
						</div>
					</div>
					<img id="roomImg" class="room-image"
						src="https://cdn.travelview.co.kr/travelview/2021/01/21020223/post_41596968_30400772_4.jpg"
						alt="RoomImage">
				</div>
			</c:forEach>
		</div>
		<h2>이전 여행지</h2>
		</div>
		<div class="imageContainer">
			<c:forEach var="history" items="${historyList}">
				<div class="roomContainer">
					<div>
						<img
							src="https://cdn.travelview.co.kr/travelview/2021/01/21020223/post_41596968_30400772_4.jpg"
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
							src="https://cdn.travelview.co.kr/travelview/2021/01/21020223/post_41596968_30400772_4.jpg"
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

