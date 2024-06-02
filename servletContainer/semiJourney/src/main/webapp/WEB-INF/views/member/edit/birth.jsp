<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 생년월일 수정</title>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/member/edit/birth.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
<script defer src="/journey/resources/js/member/edit/birth.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
  
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<div id="wrap">
		<form onsubmit="return validate();" action="/journey/member/edit/birth" method="post">
			<h1>멤버 생년월일 수정</h1>
			<br>
			
			<label>변경할 생년월일</label>
			<input type="date" id="birthDate" name="birthDate">
			<br>
			
			<input type="submit" value="생일 수정">
		</form>
	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
  
</body>
</html>