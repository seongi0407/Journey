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
		<form onsubmit="return validate();" action="/journey/room/insert" method="post" enctype="multipart/form-data">
			<h1>객실등록</h1>
			
			<input type="hidden" name="accomNo" value="${accomNo}">
			
			<br>
            <label>객실명</label>
            <input type="text" name="name" id="name" placeholder="객실명">
			<button type="button" onclick="checkDup();">중복검사</button>
			<br>
			<br>

            <label>테마명</label>
	        <select name="themeCode">
            	<c:forEach items="${thVoList}" var="thVoList">
	                <option value="${thVoList.themeCode}">${thVoList.themeName}</option>
	            </c:forEach>
            </select>
			<br>
			<br>

			<label>최대 이용 가능 인원</label>
			<input type="text" name="capacity" placeholder="최대 이용 가능 인원">
			<br>
			<label>화장실 갯수</label>
			<input type="text" name="bathNum" placeholder="화장실 갯수">
			<br>
			<label>방 갯수 (화장실 제외)</label>
			<input type="text" name="roomNum" placeholder="방 갯수 (화장실 제외)">
			<br>

			<label>싱글 사이즈 침대 갯수</label>
			<input type="text" name="bedSingle" placeholder="싱글 사이즈 침대 갯수">
			<br>
			<label>더블 사이즈 침대 갯수</label>
			<input type="text" name="bedDouble" placeholder="더블 사이즈 침대 갯수">
			<br>
			<label>퀸 사이즈 침대 갯수</label>
			<input type="text" name="bedQueen" placeholder="퀸 사이즈 침대 갯수">
			<br>

			<label>평일 가격</label>
			<input type="text" name="weekdayPrice" placeholder="평일 가격">
			<br>
			<label>주말 가격</label>
			<input type="text" name="weekendPrice" placeholder="주말 가격">
			<br>
			<br>
			
            <label>에어컨 여부</label>
            <select name="airconditionerYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>와이파이 여부</label>
            <select name="wifiYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>TV 여부</label>
            <select name="tvYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>타월 여부</label>
            <select name="towelYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>오븐 여부</label>
            <select name="ovenYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>화재 경보기 여부</label>
            <select name="firealarmYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>응급처치키트 여부</label>
            <select name="firstaidkitYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>넷플릭스 여부</label>
            <select name="netflixYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>냉장고 여부</label>
            <select name="frigerYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>히터 여부</label>
            <select name="heatingYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
            <label>헤어 드라이기 여부</label>
            <select name="hairdryerYn">
                <option value="Y">Y</option>
                <option value="N" selected>N</option>
            </select>
			<br>
			<br>

            <label>등록할 객실 사진 5장</label>
            <input type="file" name="file" multiple>
			<br>
			<br>

			<input type="submit" value="객실등록">
		</form>
	</div>
	
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
		
</body>
</html>
