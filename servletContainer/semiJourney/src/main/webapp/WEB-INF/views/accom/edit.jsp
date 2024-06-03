<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>숙소 정보 수정</title>

<link rel="stylesheet" href="/journey/resources/css/accom/accomEdit.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<h1>숙소 정보 수정</h1>
	
	<main class="main-container">
		<form class="form-container" action="/journey/accom/edit" method="post" enctype="multipart/form-data">
			<input type="hidden" name="no" value="${vo.no}"> 
			<div>
				<label for="name">숙소 이름:</label> 
				<input type="text" id="name" name="name" value="${vo.name}" required>
			</div>
			<div>
				<label for="address">주소:</label> 
				<input type="text" id="address" name="address" value="${vo.address}" required>
			</div>
			<div>
				<label for="swimYn">수영장 여부:</label> 
				<select id="swimYn" name="swimYn" required>
					<option value="Y" <c:if test="${vo.swimYn == 'Y'}">selected</c:if>>Yes</option>
					<option value="N" <c:if test="${vo.swimYn == 'N'}">selected</c:if>>No</option>
				</select>
			</div>
			<div>
				<label for="spaYn">스파 여부:</label> 
				<select id="spaYn" name="spaYn" required>
					<option value="Y" <c:if test="${vo.spaYn == 'Y'}">selected</c:if>>Yes</option>
					<option value="N" <c:if test="${vo.spaYn == 'N'}">selected</c:if>>No</option>
				</select>
			</div>
			<div>
				<label for="disabledYn">장애인 시설 여부:</label> 
				<select id="disabledYn" name="disabledYn" required>
					<option value="Y" <c:if test="${vo.disabledYn == 'Y'}">selected</c:if>>Yes</option>
					<option value="N" <c:if test="${vo.disabledYn == 'N'}">selected</c:if>>No</option>
				</select>
			</div>
			<div>
				<label for="parkingYn">주차장 여부:</label> 
				<select id="parkingYn" name="parkingYn" required>
					<option value="Y" <c:if test="${vo.parkingYn == 'Y'}">selected</c:if>>Yes</option>
					<option value="N" <c:if test="${vo.parkingYn == 'N'}">selected</c:if>>No</option>
				</select>
			</div>
			<div>
				<label for="elevatorYn">엘리베이터 여부:</label> 
				<select id="elevatorYn" name="elevatorYn" required>
					<option value="Y" <c:if test="${vo.elevatorYn == 'Y'}">selected</c:if>>Yes</option>
					<option value="N" <c:if test="${vo.elevatorYn == 'N'}">selected</c:if>>No</option>
				</select>
			</div>
			<div>
				<label for="breakfastYn">조식 제공 여부:</label> 
				<select id="breakfastYn" name="breakfastYn" required>
					<option value="Y" <c:if test="${vo.breakfastYn == 'Y'}">selected</c:if>>Yes</option>
					<option value="N" <c:if test="${vo.breakfastYn == 'N'}">selected</c:if>>No</option>
				</select>
			</div>
			<div>
				<label for="smokeYn">흡연 가능 여부:</label> 
				<select id="smokeYn" name="smokeYn" required>
					<option value="Y" <c:if test="${vo.smokeYn == 'Y'}">selected</c:if>>Yes</option>
					<option value="N" <c:if test="${vo.smokeYn == 'N'}">selected</c:if>>No</option>
				</select>
			</div>
			<div>
				<label for="latitude">위도:</label> 
				<input type="text" id="latitude" name="latitude" value="${vo.latitude}" required>
			</div>
			<div>
				<label for="longitude">위도:</label> 
				<input type="text" id="longitude" name="longitude" value="${vo.longitude}" required>
			</div>
			<div>
				<label for="imgUrl">이미지 업로드:</label> 
				<input type="file" id="imgUrl" name="imgUrl"> 
				<img src="/journey/resources/upload/${vo.imgUrl}" alt="현재 이미지" width="100">
				<input type="hidden" name="existingImgUrl" value="${vo.imgUrl}">
			</div>
			<button type="submit">수정</button>
		</form>
		<div class="map-container">
		
		</div>

	</main>
	
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>
</html>