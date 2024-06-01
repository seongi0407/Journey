<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 관리</title>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/room/list.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
</head>
<body>
    
    <%@ include file="/WEB-INF/views/layout/header.jsp"%>
    
    <div class="main">
		<div class="image-container">
			<c:forEach var="vo" items="${voList}">
				<div class="home">
					<img src="/journey/resources/upload/room/${vo.img01}" onclick="location.href='/journey/room/detail?no=${vo.no}'" alt="숙소 사진">
					<div id="place-name">${vo.themeName}, ${vo.name}</div>
					<button class="btn" onclick="location.href='/journey/room/edit?no=${vo.no}'">수정</button>
					<button class="btn" onclick="location.href='/journey/room/delete?no=${vo.no}'">삭제</button>
					<div id="place-score">★ ${vo.grade}</div>
					<div id="place">${vo.address}</div>
					<div id="place-date">₩ ${vo.weekdayPrice} / 박</div>
				</div>
			</c:forEach>
		</div>

        <button id="roomInsertBtn" onclick="location.href='/journey/room/insert?accomNo='${accomNo}">객실 등록</button>
	</div>

        
    <%@ include file="/WEB-INF/views/layout/footer.jsp"%>
    
</body>
</html>
