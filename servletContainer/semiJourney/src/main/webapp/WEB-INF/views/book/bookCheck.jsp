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
		<div id="head">
			<img id="airbnbImg" src="../resources/img/airbnb.png"
				alt="Airbnb Logo">
		</div>
	</header>

	<main class="main">
		<section id="section">
			<div id="sectionInnerFront" class="flip-card-front">
				<div>
					<img id="roomImg" src="../resources/img/대표img.webp"
						alt="Room Image">
				</div>
				<div style="font-weight: bold; font-size: 20px;"><%=request.getAttribute("hostName")%>의
					방
				</div>
				<div><%=request.getAttribute("date")%></div>
				<div></div>
				<div>
					게스트
					<%=request.getAttribute("guestCount")%>명
				</div>
				<div>
					총가격:
					<%=request.getAttribute("totalPrice")%></div>
			</div>
			<div id="sectionInnerBack" class="flip-card-back">
				<img id="backImg" src="../resources/img/지도일러스트/seoul.jpg"
					alt="Map Image">
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