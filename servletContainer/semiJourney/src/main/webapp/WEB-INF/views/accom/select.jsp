<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>숙소 관리</title>

<link rel="stylesheet" href="/journey/resources/css/accom/accomSelect.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	
	<div class="select-container">
		<h1>Host님, <br>어떤 걸 하고 싶으신가요?</h1>
		
		<main>
			<div class="container">
				<div class="box" onclick="location.href='/journey/accom/insert'">
					<img alt="신규숙소등록" src="/journey/resources/img/accom/newAccom.png">
					<h3>숙소 신규 등록</h3>
					<h4>새로운 숙소를 추가해 보세요!</h4>
				</div>
				<div class="box" onclick="location.href='/journey/accom/list'">
					<img alt="숙소관리목록" src="/journey/resources/img/accom/listAccom.png">
					<h3>숙소 관리</h3>
					<h4>숙소정보 수정, 삭제 가능합니다!</h4>
				</div>
			</div>
		</main>
	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	
</body>
</html>