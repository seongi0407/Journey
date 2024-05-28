<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>숙소 목록</title>

<link rel="stylesheet" href="/journey/resources/css/accomList.css">
<script defer src="/journey/resources/js/accomStatusDelete.js"></script>

</head>
<body>
	<div class="accom-container">
		<h1>숙소 목록</h1>

		<!-- 숙소 삭제했을 때 삭제했다는 알림 띄우기 -->
		<c:if test="${not empty sessionScope.alertMsg}">
			<script type="text/javascript">
				alert("${sessionScope.alertMsg}");
			<%session.removeAttribute("alertMsg");%>
			</script>
		</c:if>

		<c:choose>
			<c:when test="${not empty voList}">
				<c:forEach var="vo" items="${voList}">
					<div id="${vo.no}" class="accom-list">
						<img src="/journey/resources/upload/${vo.imgUrl}" alt="숙소 사진">
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
</body>
</html>