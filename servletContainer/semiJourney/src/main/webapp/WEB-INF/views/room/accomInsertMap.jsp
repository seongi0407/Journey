<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙소 등록 지도</title>

<style type="text/css">
	#map-wrap {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	}
	
	#map {
		width: 75%;
		height: 75%;
	}
</style>

<script type="text/javascript" defer src="/journey/resources/js/room/detail/map.js"></script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f1deaaca1522c6065545245daaba71a4&libraries=services"></script>
</head>
<body>
	<div id="map-wrap">
	    <!-- 지도를 표시할 div 입니다 -->
	    <div id="map"></div>
	    <p><em>지도를 클릭해주세요!</em></p>
	    <div id="clickLatlng"></div>
	</div>
</body>
</html>
