<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>숙소 목록</title>

<link rel="stylesheet" href="/journey/resources/css/accom/accomList.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header2.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/accom/accomStatusDelete.js"></script>
<script defer src="/journey/resources/js/layout/header.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<div class="accom-container">
		<c:choose>
			<c:when test="${not empty voList}">
			
				<c:forEach var="vo" items="${voList}">
					<div class="accom-list">
						<img src="/journey/resources/upload/accom/${vo.imgUrl}"  alt="숙소 사진">
						<div class="accom-detail">
							<span id="status-${vo.no}" class="status">등록 중</span>
							<h3>${vo.name}</h3>
							<p>${vo.address}</p>

							<form action="/journey/accom/edit" method="get">
								<input type="hidden" name="no" value="${vo.no}">
								<button type="submit">수정하기</button>
							</form>

							<button type="button" onclick="handleDelete(${vo.no});">삭제</button>

						</div>
					</div>
				</c:forEach>
			</c:when>

			<c:otherwise>
				<p>등록된 숙소가 없습니다.</p>
			</c:otherwise>

		</c:choose>
	</div>
	
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	
</body>
</html>