<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰수정</title>

<link rel="stylesheet"
	href="/journey/resources/css/review/reviewEdit.css">
<script defer src="/journey/resources/js/review/reviewEdit.js"></script>

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
				<h2>리뷰 수정</h2>
				<br>
				<hr>
				<br> <span class="disabledText">* 별점은 수정이 불가능합니다.</span> <br>
				<br>
				<form id="reviewForm" action="/journey/review/edit" method="post">
					<input type="hidden" name="id" value="${param.id}">
					<c:forEach var="review" items="${review}">

						<input type="hidden" name="no" value="${review.no}">
						<div class="form-group">
							<label for="cleanlinessRating">청결도</label>
							<div>
								<c:forEach begin="1" end="${review.clean}" var="star">
									<span>⭐</span>
								</c:forEach>
							</div>
						</div>
						<div class="form-group">
							<label for="checkInRating">체크인</label>
							<div>
								<c:forEach begin="1" end="${review.checkin}" var="star">
									<span>⭐</span>
								</c:forEach>
							</div>
						</div>
						<div class="form-group">
							<label for="communicationRating">의사소통</label>
							<div>
								<c:forEach begin="1" end="${review.communication}" var="star">
									<span>⭐</span>
								</c:forEach>
							</div>
						</div>
						<div class="form-group">
							<label for="locationRating">위치</label>
							<div>
								<c:forEach begin="1" end="${review.location}" var="star">
									<span>⭐</span>
								</c:forEach>
							</div>
						</div>
						<div class="form-group">
							<label for="valueRating">가격 대비 만족도</label>
							<div>
								<c:forEach begin="1" end="${review.accuracy}" var="star">
									<span>⭐</span>
								</c:forEach>
							</div>
						</div>
						<br>
						<hr>
						<br>
						<div class="form-group">
							<textarea id="reviewContent" name="content" rows="5" required>${review.content}</textarea>
						</div>
						<br>
						<button type="submit" id="submitReviewBtn">수정</button>
					</c:forEach>
				</form>
			</div>
		</section>
	</main>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
</body>
</html>