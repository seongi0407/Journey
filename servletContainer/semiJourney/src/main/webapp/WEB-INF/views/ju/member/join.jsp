<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<link rel="stylesheet" href="/journey/resources/css/ju.css">

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/ju/layout/left-aside.jsp" %>
    <div id="wrap">
    <%@ include file="/WEB-INF/views/ju/layout/header.jsp" %>
    <%@ include file="/WEB-INF/views/ju/layout/nav.jsp" %>
    
    <main>
        <h1>회원가입</h1>
        
        <form action="/journey/member/join" method="post" enctype="multipart/form-data">
            <input type="text" name="id" placeholder="아이디">
            <br>
            <input type="password" name="pwd" placeholder="비밀번호">
            <br>
            <input type="password" name="pwd2" placeholder="비밀번호 확인">
            <br>
            <input type="text" name="name" placeholder="이름">
            <br>
            <input type="text" name="email" placeholder="이메일">
            <br>
            <input type="text" name="phone" placeholder="전화번호">
            <br>
            <input type="text" name="birth-date" placeholder="생년월일">
            <br>
            <label>프로필 사진</label> <input type="file" name="profile">
            <input type="submit" value="회원가입">
        </form>
    </main>
    
    <%@ include file="/WEB-INF/views/ju/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/ju/layout/right-aside.jsp" %>
</body>
</html>
