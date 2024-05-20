<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰작성</title>
</head>
<body>

	<h1>리뷰작성</h1>

	<form action="/app/review/insert" method="post">
		<br>
		<textarea name="content" placeholder="내용"></textarea>
			<p class="star">★★★★★</p>
		<br>
			<input type="number" name="accuracy" placeholder="accuracy" step="0.5" min="0.0" max="5.0">
		<br>
			<input type="number" name="clean" placeholder="clean" step="0.5" min="0.0" max="5.0">
		<br>
			<input type="number" name="checkin" placeholder="checkin" step="0.5" min="0.0" max="5.0">
		<br>
			<input type="number" name="location" placeholder="location" step="0.5" min="0.0" max="5.0">
		<br>
			<input type="number" name="communication" placeholder="communication" step="0.5" min="0.0" max="5.0">
		<br>

		<br>
		<input type="submit" value="작성하기">
	</form>
</body>
</html>