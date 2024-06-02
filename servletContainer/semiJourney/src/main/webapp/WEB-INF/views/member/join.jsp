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
			<br>
			
			<label>아이디</label>
			<input type="text" name="id" id="id" placeholder="아이디">
			<button type="button" onclick="checkDup();">중복검사</button>
			<br>
			
			<label>비밀번호</label>
			<input type="password" name="pwd" id="pwd" placeholder="비밀번호 (소문자, 숫자를 모두 포함하여 8자리 이상)">
			<br>
			
			<label>비밀번호 확인</label>
			<input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인">
			<br>
			
			<label>이름</label>
			<input type="text" name="name" placeholder="이름">
			<br>
			
			<label>이메일</label>
			<input type="text" name="email" placeholder="이메일">
			<br>
			
			<label>전화번호</label>
			<input type="text" name="phone" placeholder="전화번호">
			<br>
			
			<label>생년월일</label>
			<input type="date" id="birthDate" name="birthDate" placeholder="생년월일">
			<br>
			
			<label>프로필 이미지 1장</label>
			<input type="file" name="profile" placeholder="프로필 이미지">
			<br>
			
			<input type="submit" value="회원가입">
		</form>
	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
  
</body>
</html>