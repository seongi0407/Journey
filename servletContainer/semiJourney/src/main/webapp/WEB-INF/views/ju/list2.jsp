<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세</title>
<link rel="stylesheet" href="../resources/css/reviewList.css">
<link rel="stylesheet" href="../resources/css/layout.css">
<script defer src="../resources/js/layout.js"></script>
<script defer src="../resources/js/reviewDetail.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>

</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	
	<main>
		<section class="review-section">
			<div class="review-container">
				<h2>최신 등록 객실 6개</h2>
				<hr>
				<table class="review-table">
					<thead>
						<tr>
							<th>주소</th>
							<th>이름</th>
							<th>가격</th>
							<th>평점</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${voList}" var="vo">
							<tr>
								<td>${vo.address}</td>
								<td>${vo.name}</td>
								<td>${vo.weekdayPrice}</td>
								<td>${vo.grade}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</main>
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>
</html>
