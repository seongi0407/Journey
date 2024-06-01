<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 회원가입</title>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/member/join.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
<script defer src="/journey/resources/js/member/join.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
  
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<div id="wrap">
		<form onsubmit="return validate()" action="/journey/member/join" method="post" enctype="multipart/form-data">
			<h1>멤버 회원가입</h1>
			<input type="text" name="id" id="id" placeholder="아이디">
			<button type="button" onclick="checkDup();">중복검사</button>
			<br>
			<input type="password" name="pwd" id="pwd" placeholder="소문자, 숫자를 모두 포함하여 8자리 이상">
			<br>
			<input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인">
			<br>
			<input type="text" name="name" placeholder="이름">
			<br>
			<input type="text" name="email" placeholder="이메일">
			<br>
			<input type="text" name="phone" placeholder="전화번호">
			<br>
			<input type="date" name="birthDate" placeholder="생년월일">
			<br>
			<input type="file" name="profile" placeholder="프로필 이미지">
			<br>
			<input type="submit" value="회원가입">
		</form>
	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
  
</body>
</html>