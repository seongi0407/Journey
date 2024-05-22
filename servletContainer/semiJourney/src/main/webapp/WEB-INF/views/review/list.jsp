<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL core 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 리스트</title>
<link rel="stylesheet" href="../resources/css/reviewList.css">
</head>
<body>
<header>
    <div class="header-inner">
        <img id="airbnbImg" src="/webapp/resources/img/airbnbImg.svg" alt="Airbnb Logo">
        <h1>최신 리뷰</h1>
    </div>
</header>
<main>
		<section class="review-section">
			<div class="review-container">
				<h2>최신 리뷰</h2>
				<hr>
				<table class="review-table">
					<thead>
						<tr>
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
								<td><img width="100px" height="100px" alt="profile"
									src="/app/resources/upload/${vo.profile}"></td>
								<td>${vo.writerName}</td>
								<td>${vo.starAvg}</td>
								<td>${vo.enrollDate}</td>
								<td>${vo.content}</td>
							</tr>
							<%--<c:if test="${vo.writerId == sessionScope.userId}"> --%>
								<tr>
									<td colspan="5">
										<form
											action="${pageContext.request.contextPath}/review/delete"
											method="post">
											<input type="hidden" name="reviewId"/>
											<button type="submit">삭제</button>
										</form>
									</td>
								</tr>
							<%--</c:if> --%>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</main>
<footer>
    <p>&copy; 2024 Airbnb</p>
</footer>
</body>
</html>
