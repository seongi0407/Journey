<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 수정</title>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/room/edit.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
<script defer src="/journey/resources/js/room/edit.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<div id="wrap">
		<form onsubmit="return validate();" action="/journey/room/edit" method="post">
			<h1>객실등록</h1>
			
			<input type="hidden" name="no" value="${no}">
			
			<br>
            <label>변경할 객실명</label>
            <input type="text" name="name" id="name" placeholder="변경할 객실명" value="${vo.name}">
			<button type="button" onclick="checkDup();">중복검사</button>
			<br>
			<br>

            <label>변경할 테마명</label>
	        <select name="themeCode">
            	<c:forEach items="${thVoList}" var="thVo">
            		<c:choose>
            			<c:when test="${thVo.themeName == vo.themeName}">
			                <option value="${thVo.themeCode}" selected>${thVo.themeName}</option>
            			</c:when>
            			<c:otherwise>
			                <option value="${thVo.themeCode}">${thVo.themeName}</option>            			
            			</c:otherwise>
            		</c:choose>
	            </c:forEach>
            </select>
			<br>
			<br>

			<label>변경할 최대 이용 가능 인원</label>
			<input type="text" name="capacity" placeholder="변경할 최대 이용 가능 인원" value="${vo.capacity}">
			<br>
			<label>변경할 화장실 갯수</label>
			<input type="text" name="bathNum" placeholder="변경할 화장실 갯수" value="${vo.bathNum}">
			<br>
			<label>변경할 방 갯수 (화장실 제외)</label>
			<input type="text" name="roomNum" placeholder="변경할 방 갯수 (화장실 제외)" value="${vo.roomNum}">
			<br>

			<label>변경할 싱글 사이즈 침대 갯수</label>
			<input type="text" name="bedSingle" placeholder="변경할 싱글 사이즈 침대 갯수" value="${vo.bedSingle}">
			<br>
			<label>변경할 더블 사이즈 침대 갯수</label>
			<input type="text" name="bedDouble" placeholder="변경할 더블 사이즈 침대 갯수" value="${vo.bedDouble}">
			<br>
			<label>변경할 퀸 사이즈 침대 갯수</label>
			<input type="text" name="bedQueen" placeholder="변경할 퀸 사이즈 침대 갯수" value="${vo.bedQueen}">
			<br>

			<label>변경할 평일 가격</label>
			<input type="text" name="weekdayPrice" placeholder="변경할 평일 가격" value="${vo.weekdayPrice}">
			<br>
			<label>변경할 주말 가격</label>
			<input type="text" name="weekendPrice" placeholder="변경할 주말 가격" value="${vo.weekendPrice}">
			<br>
			<br>
			
            <label>에어컨 여부</label>
            <select name="airconditionerYn">
            	<c:choose>
            		<c:when test="${vo.airconditionerYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.airconditionerYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>와이파이 여부</label>
            <select name="wifiYn">
            	<c:choose>
            		<c:when test="${vo.wifiYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.wifiYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>TV 여부</label>
            <select name="tvYn">
            	<c:choose>
            		<c:when test="${vo.tvYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.tvYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>타월 여부</label>
            <select name="towelYn">
            	<c:choose>
            		<c:when test="${vo.towelYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.towelYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>오븐 여부</label>
            <select name="ovenYn">
            	<c:choose>
            		<c:when test="${vo.ovenYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.ovenYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>화재 경보기 여부</label>
            <select name="firealarmYn">
            	<c:choose>
            		<c:when test="${vo.firealarmYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.firealarmYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>응급처치키트 여부</label>
            <select name="firstaidkitYn">
            	<c:choose>
            		<c:when test="${vo.firstaidkitYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.firstaidkitYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>넷플릭스 여부</label>
            <select name="netflixYn">
            	<c:choose>
            		<c:when test="${vo.netflixYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.netflixYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>냉장고 여부</label>
            <select name="frigerYn">
            	<c:choose>
            		<c:when test="${vo.frigerYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.frigerYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>히터 여부</label>
            <select name="heatingYn">
            	<c:choose>
            		<c:when test="${vo.heatingYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.heatingYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
            <label>헤어 드라이기 여부</label>
            <select name="hairdryerYn">
            	<c:choose>
            		<c:when test="${vo.hairdryerYn == 'Y'}">
		                <option value="Y" selected>Y</option>
		                <option value="N">N</option>            			
            		</c:when>
            		<c:when test="${vo.hairdryerYn == 'N'}">
		                <option value="Y">Y</option>
		                <option value="N" selected>N</option>            			
            		</c:when>
            	</c:choose>
            </select>
			<br>
			<br>

			<input type="submit" value="객실수정">
		</form>
	</div>
	
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
		
</body>
</html>
