<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet"
	href="/journey/resources/css/review/reviewList.css">
<script defer src="/journey/resources/js/review/reviewDelete.js"></script>

<link rel="stylesheet" href="/journey/resources/css/layout/header2.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
</head>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>

<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<main>
		<section class="review-section">
			<div class="review-container">
				<h2>리뷰 상세</h2>
				<hr>
				<table class="review-table">
					<thead>
						<tr>

							<th>no</th>
							<th>작성자</th>
							<th>평점</th>
							<th>날짜</th>
							<th>내용</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${voList}" var="vo">
							<tr>
								<td>${vo.rownum}</td>
								<td class="writer-info">
									<div>
										<img class="memberProfile" alt="profile"
											src="/journey/resources/upload/member/${vo.profile}">
										<div class="writer-name">${vo.writerName}</div>
									</div>
								</td>
								<td>${vo.starAvg}</td>
								<td>${vo.enrollDate}</td>
								<td>${vo.content}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
			</div>
			
		</section>
	</main>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>
</html>
