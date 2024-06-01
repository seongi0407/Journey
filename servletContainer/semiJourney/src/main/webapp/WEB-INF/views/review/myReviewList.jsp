<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 작성한 리뷰</title>
<link rel="stylesheet"
	href="/journey/resources/css/review/reviewList.css">
<script defer src="/journey/resources/js/review/reviewDelete.js"></script>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
</head>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>

<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<main>
		<section class="review-section">
			<div class="review-container">
				<h2>내가 작성한 리뷰</h2>
				<hr>
				<table class="review-table">
					<thead>
						<tr>
							<th><input type="checkbox" onclick="checkboxAll(this);"></th>
							<th>no</th>
							<th>숙소</th>
							<th>평점</th>
							<th>날짜</th>
							<th>내용</th>
							<th>수정</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${voList}" var="vo">
							<tr>
								<td><input type="checkbox" name="reviewCheckbox"
									value="${vo.no}"></td>
								<td>${vo.rownum}</td>
								<td class="room-info">
									<div>
										<img class="roomImg" alt="roomImg"
											src="/journey/resources/upload/room/${vo.roomImg}">
										<div class="roomName">${vo.roomName}</div>
									</div>
								</td>
								<td>${vo.starAvg}</td>
								<td>${vo.enrollDate}</td>
								<td>${vo.content}</td>
								<td><button
										onclick="location.href='/journey/review/edit?reviewNo=${vo.no}'"
										class="editBtn">수정</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<button class="deleteBtn" onclick="deleteReviews();">삭제하기</button>
			</div>
		</section>
	</main>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>
</html>
