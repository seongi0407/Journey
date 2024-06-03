<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>여행의 정석</title>

<link rel="stylesheet" href="/journey/resources/css/home.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/wish/wish.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
<script defer src="/journey/resources/js/home.js"></script>
<script defer src="/journey/resources/js/wish/delete.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<section>
		<div class="wishlist-letter">위시리스트</div>
	</section>

	<div class="main">
		<div class="image-container">
			<c:forEach var="room" items="${roomVoList}">
				<div class="accomodation">
					<img src="/journey/resources/upload/room/${room.img01}" alt="숙소 사진">
					<div id="place-name">${room.name}</div>
					<c:choose>
						<c:when test="${not empty sessionScope.loginMemberVo}">
							<button class="gym" id="gym" onclick="deleteWish('${room.wishNo}', '${sessionScope.loginMemberVo.no}')">취소</button>
						</c:when>
						<c:otherwise>
							<button class="gym" id="gym" onclick="clickNothing()">취소</button>
						</c:otherwise>
					</c:choose>
					<div id="place-score">★ ${room.grade}</div>
					<div id="place">${room.address}</div>
					<div id="place-date">₩ ${room.weekdayPrice} / 박</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<br>
	<br>
	<br>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
</body>
</html>