<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세</title>
<link rel="stylesheet" href="/journey/resources/css/reviewList.css">
<script defer src="/journey/resources/js/reviewDelete.js"></script>

<link rel="stylesheet" href="/journey/resources/css/layout.css">
<script defer src="/journey/resources/js/layout.js"></script>
</head>
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
							<th><input type="checkbox" onclick="checkboxAll(this);"></th>
							<th>no</th>
							<th>프로필</th>
							<th>작성자</th>
							<th>평점</th>
							<th>날짜</th>
							<th>내용</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${voList}" var="vo">
							<tr>
								<td><input type="checkbox" name="reviewCheckbox"
									value="${vo.no}"></td>
								<td>${vo.no}</td>
								<td><img width="100px" height="100px" alt="profile"
									src="/journey/resources/upload/${vo.profile}"></td>
								<td>${vo.writerName}</td>
								<td>${vo.starAvg}</td>
								<td>${vo.enrollDate}</td>
								<td>${vo.content}</td>


							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<button class="deleteBtn" onclick="deleteCheckedBoard();">삭제하기</button>
			</div>
		</section>
	</main>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>
</html>
