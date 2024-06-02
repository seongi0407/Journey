<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 비밀번호 수정</title>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/host/edit/password.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
<script defer src="/journey/resources/js/host/edit/password.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
  
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<div id="wrap">
		<form onsubmit="return validate()" action="/journey/host/edit/password" method="post">
			<h1>호스트 비밀번호 수정</h1>
			<br>
			
			<label>변경할 비밀번호</label>
			<input type="password" name="pwd" id="pwd" placeholder="변경할 비밀번호 (소문자, 숫자를 모두 포함하여 8자리 이상)">
			<br>
			
			<label>변경할 비밀번호 확인</label>
			<input type="password" name="pwd2" id="pwd2" placeholder="변경할 비밀번호 확인">
			<br>
			
			<input type="submit" value="비밀번호 수정">
		</form>
	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
  
</body>
</html>