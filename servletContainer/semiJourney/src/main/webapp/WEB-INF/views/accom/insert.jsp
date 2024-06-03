<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>숙소 등록</title>

<link rel="stylesheet"href="/journey/resources/css/accom/accomInsert.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
<script defer src="/journey/resources/js/accom/insert.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f1deaaca1522c6065545245daaba71a4&libraries=services"></script>
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<h1>숙소 등록</h1>

	<main class="main-container">
		<form class="form-container" action="/journey/accom/insert"
			method="post" enctype="multipart/form-data">
			<div>
				<label for="name">숙소 이름:</label> <input type="text" id="name"
					name="name" placeholder="포근한 산 속 독채" required>
			</div>
			<div>
				<label for="address">주소:</label> <input type="text" id="address"
					name="address" placeholder="강원 춘천시 소양로 567, 한국" required>
			</div>
			<div>
				<label for="swimYn">수영장 여부:</label> <select id="swimYn"
					name="swimYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="spaYn">스파 여부:</label> <select id="spaYn" name="spaYn"
					required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="disabledYn">장애인 시설 여부:</label> <select id="disabledYn"
					name="disabledYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="parkingYn">주차장 여부:</label> <select id="parkingYn"
					name="parkingYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="elevatorYn">엘리베이터 여부:</label> <select id="elevatorYn"
					name="elevatorYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="breakfastYn">조식 제공 여부:</label> <select id="breakfastYn"
					name="breakfastYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="smokeYn">흡연 가능 여부:</label> <select id="smokeYn"
					name="smokeYn" required>
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
			</div>
			<div>
				<label for="latitude">위도:</label> <input type="text" id="latitude"
					name="latitude" placeholder="37.713203">
			</div>
			<div>
				<label for="longitude">경도:</label> <input type="text" id="longitude"
					name="longitude" placeholder="126.8900751">
			</div>
			<div>
				<label for="imgUrl">이미지 업로드:</label> <input type="file" id="imgUrl"
					name="imgUrl" required>
			</div>
			<button type="submit">등 록</button>
		</form>

		<div class="map-container">
			<!-- 지도를 표시할 div 입니다 -->
			<div id="map"></div>
			<p><em>지도를 클릭해주세요!</em></p>
			<div id="clickLatlng"></div>
		</div>

	</main>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

</body>
</html>