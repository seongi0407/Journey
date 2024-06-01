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

<script defer src="/journey/resources/js/home.js"></script>
<script defer src="/journey/resources/js/layout/header.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<nav>
		<div class="search">
			<button class="search-item" onclick="showPlaceSearch()">
				<span>여행지</span> <span id="search-destination">여행지 검색</span>
			</button>
			<div class="divider"></div>
			<!-- 이 부분 캘린더 추가 -->
			<button class="search-item" id="checkin-button"
				onclick="showCalendar('checkin')">
				<span>체크인</span> <span>날짜 추가</span>
			</button>
			<div class="divider"></div>
			<!-- 이 부분 캘린더 추가 -->
			<button class="search-item" id="checkout-button"
				onclick="showCalendar('checkout')">
				<span>체크아웃</span> <span>날짜 추가</span>
			</button>
			<div class="divider"></div>
			<button class="search-item" onclick="showTravelerSearch()">
				<span>여행자</span> <span>게스트 추가</span>
			</button>
			<button type="submit" class="search-icon">
				<img src="/journey/resources/img/search.png" alt="검색 아이콘">
			</button>

			<div class="search-place" id="search-place">
				<h5 class="search-place-letter">지역으로 검색하기</h5>
				<button class="search-place-button">
					<img src="/journey/resources/img/home/place-search.png" alt="유연한 검색">
					<span>유연한 검색</span>
				</button>
				<br>
				<h5 class="search-place-letter">한국</h5>
				<br>
				<div class=search-place-name>
					<button onclick="updateSearchBar('서울')">서울</button>
					<button onclick="updateSearchBar('부산')">부산</button>
					<button onclick="updateSearchBar('속초')">속초</button>
					<button onclick="updateSearchBar('강릉')">강릉</button>
					<button onclick="updateSearchBar('전주')">전주</button>
					<button onclick="updateSearchBar('대구')">대구</button>
					<button onclick="updateSearchBar('경주')">경주</button>
					<button onclick="updateSearchBar('여수')">여수</button>
					<button onclick="updateSearchBar('서귀포')">전남</button>
					<button onclick="updateSearchBar('대전')">대전</button>
					<button onclick="updateSearchBar('제주도')">제주도</button>
					<button onclick="updateSearchBar('인천')">인천</button>
					<button onclick="updateSearchBar('경기')">경기</button>
					<button onclick="updateSearchBar('대전')">대전</button>
					<button onclick="updateSearchBar('충북')">충북</button>
					<button onclick="updateSearchBar('경남')">경남</button>
				</div>
			</div>
		</div>

		<div class="traveler" id="traveler">
			<div class="traveler-option">
				<span>성인</span> <span class="age-info">13세 이상</span>
				<div class="people-count">
					<button class="decrease">-</button>
					<span class="count">0</span>
					<button class="increase">+</button>
				</div>
			</div>
			<div class="traveler-option">
				<span>어린이</span> <span class="age-info">2~12세</span>
				<div class="people-count">
					<button class="decrease">-</button>
					<span class="count">0</span>
					<button class="increase">+</button>
				</div>
			</div>
			<div class="traveler-option">
				<span>유아</span> <span class="age-info">2세 미만</span>
				<div class="people-count">
					<button class="decrease">-</button>
					<span class="count">0</span>
					<button class="increase">+</button>
				</div>
			</div>
			<div class="traveler-option">
				<span>반려동물</span>
				<!-- <span class="age-info">보조동물을 동반하시나요?</span> -->
				<div class="people-count">
					<button class="decrease">-</button>
					<span class="count">0</span>
					<button class="increase">+</button>
				</div>
			</div>
		</div>
	</nav>


	<!-- <br><hr id="line"><br> -->

	<section>
		<div class="theme">
			<button id="theme-detail">
				<img src="/journey/resources/img/home/sea.svg" alt="테마"> <span
					id="theme-name">해변 바로 앞</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/hanok.svg" alt="테마"> <span
					id="theme-name">한옥</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/view.svg" alt="테마"> <span
					id="theme-name">최고의 전망</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/pool.svg" alt="테마"> <span
					id="theme-name">멋진 수영장</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/camping.svg" alt="테마"> <span
					id="theme-name">캠핑장</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/wierd.svg" alt="테마"> <span
					id="theme-name">기상천외한</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/world.png" alt="테마"> <span
					id="theme-name">속세를 벗어난</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/top.svg" alt="테마"> <span
					id="theme-name">세상의 꼭대기</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/farm.svg" alt="테마"> <span
					id="theme-name">농장</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/surfing.svg" alt="테마"> <span
					id="theme-name">서핑</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/cabin.svg" alt="테마"> <span
					id="theme-name">통나무집</span>
			</button>
			<button id="theme-detail">
				<img src="/journey/resources/img/home/countryside.png" alt="테마"> <span
					id="theme-name">한적한 시골</span>
			</button>
		</div>
	</section>

	<div class="main">
		<div class="image-container">
			<c:forEach var="vo" items="${voList}">
				<div class="home">
					<img src="/journey/resources/upload/room/${vo.img01}" onclick="location.href='/journey/room/detail?no=${vo.no}'" alt="숙소 사진">
					<div id="place-name">${vo.name}</div>
					<c:choose>
						<c:when test="${not empty sessionScope.loginMemberVo}">
							<button id="gym" onclick="clickHeart('${vo.no}', '${sessionScope.loginMemberVo.no}')">해물찜</button>
						</c:when>
						<c:otherwise>
							<button id="gym" onclick="clickNothing()">해물찜</button>
						</c:otherwise>
					</c:choose>
					<div id="place-score">★ ${vo.grade}</div>
					<div id="place">${vo.address}</div>
					<div id="place-date">₩ ${vo.weekdayPrice} / 박</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<br>
	<br>
	<br>

	<!-- -----------------캘린더------------------------------------ -->
	<div class="calendar-modal" id="calendar-modal">
		<div class="calendar-content">
			<div class="calendar-header">
				<button id="prev-month">&lt;</button>
				<span id="current-month"></span>
				<button id="next-month">&gt;</button>
			</div>
			<div class="calendar-body" id="calendar-body">
				<!-- Calendar grids will be dynamically inserted here -->
			</div>
			<div class="calendar-footer">
				<button id="close-calendar">닫기</button>
			</div>
		</div>
	</div>
	<!-- ----------------------------------------------------------------- -->

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>
</html>