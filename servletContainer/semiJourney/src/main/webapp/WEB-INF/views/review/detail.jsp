<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL core 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰상세</title>

</head>
<body>

	<h1>리뷰상세</h1>

	<table border="1">
		<thead>
			<tr>
				<th>profile</th>
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
			</c:forEach>


		</tbody>
	</table>

	</div>

</body>
</html>