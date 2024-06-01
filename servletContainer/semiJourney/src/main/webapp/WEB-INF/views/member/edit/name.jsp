<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 이름 수정</title>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/member/edit/name.css">

<script defer src="/journey/resources/js/layout/header.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
  
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<div id="wrap">
		<form action="/journey/member/edit/name" method="post">
			<h1>멤버 이름 수정</h1>
			<input type="text" name="name" placeholder="이름">
			<br>
			<input type="submit" value="이름 수정">
		</form>
	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
  
</body>
</html>