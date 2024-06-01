<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 등록</title>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/room/insert.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
<script defer src="/journey/resources/js/room/insert.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<div id="wrap">
		<form action="/journey/accom/insert" method="post" enctype="multipart/form-data">
			<h1>객실 등록</h1>
			<br>
			
			<div>
				<label for="name">객실명:</label> 
				<input type="text" id="name" name="name" required>
			</div>
			<div>
				<label for="address">테마명</label>
				<input type="text" id="address" name="address" required>
			</div>
			<div>
				<label for="swimYn">수영장 여부:</label> 
				<select id="swimYn" name="swimYn" required>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
			</div>
			<div>
				<label for="spaYn">스파 여부:</label> 
				<select id="spaYn" name="spaYn" required>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
			</div>
			<div>
				<label for="disabledYn">장애인 시설 여부:</label> 
				<select id="disabledYn" name="disabledYn" required>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
			</div>
			<div>
				<label for="parkingYn">주차장 여부:</label> 
				<select id="parkingYn" name="parkingYn" required>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
			</div>
			<div>
				<label for="elevatorYn">엘리베이터 여부:</label> 
				<select id="elevatorYn" name="elevatorYn" required>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
			</div>
			<div>
				<label for="breakfastYn">조식 제공 여부:</label> 
				<select id="breakfastYn" name="breakfastYn" required>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
			</div>
			<div>
				<label for="smokeYn">흡연 가능 여부:</label>
				<select id="smokeYn" name="smokeYn" required>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
			</div>
			<div>
				<label for="imgUrl">객실 이미지 업로드:</label> 
				<input type="file" id="imgUrl" name="imgUrl" required>
			</div>
			<button type="submit">객실등록</button>
		</form>
	</div>
	
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
		
</body>
</html>
