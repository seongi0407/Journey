<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 등록</title>
</head>
<body>
	<form action="/journey/room/insert" method="post" enctype="multipart/form-data">
	    <input type="text" name="name" placeholder="객실 이름">
	    <br>
	    <input type="text" name="themeCode" placeholder="테마 코드">
	    
	    <br>
	    
	    <input type="text" name="capacity" placeholder="최대 인원">
	    <br>
	    <input type="text" name="bathNum" placeholder="화장실 갯수">
	    <br>
	    <input type="text" name="roomNum" placeholder="방 갯수">
	    
	    <br>
	    
	    <input type="text" name="bedSingle" placeholder="싱글 침대 갯수">
	    <br>
	    <input type="text" name="bedDouble" placeholder="더블 침대 갯수">
	    <br>
	    <input type="text" name="bedQueen" placeholder="퀸 침대 갯수">
	    
	    <br>
	    
	    <input type="text" name="weekdayPrice" placeholder="평일 가격">
	    <br>
	    <input type="text" name="weekendPrice" placeholder="주말 가격">
	    
	    <br>
	    
	    <label for="towelYn">towelYn</label>
        <select name="towelYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="netflixYn">netflixYn</label>
        <select name="netflixYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="airconditionerYn">airconditionerYn</label>
        <select name="airconditionerYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="heatingYn">heatingYn</label>
        <select name="heatingYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="tvYn">tvYn</label>
        <select name="tvYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="firealarmYn">firealarmYn</label>
        <select name="firealarmYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="firstaidkitYn">firstaidkitYn</label>
        <select name="firstaidkitYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="wifiYn">wifiYn</label>
        <select name="wifiYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="frigerYn">frigerYn</label>
        <select name="frigerYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="ovenYn">ovenYn</label>
        <select name="ovenYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
	    <br>
	    <label for="hairdryerYn">hairdryerYn</label>
        <select name="hairdryerYn">
            <option value="Y">Y</option>
            <option value="N" selected>N</option>
        </select>
        
	    <br>
	    
	    <label>객실 사진</label> <input type="file" name="profile" multiple="multiple">
	    
	    <br>
	    
	    <input type="submit" value="객실 등록">
	</form>
</body>
</html>
