<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호스트 정보 수정</title>

<link rel="stylesheet" href="/journey/resources/css/ju.css">

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/ju/layout/left-aside.jsp" %>
    <div id="wrap">
    <%@ include file="/WEB-INF/views/ju/layout/header.jsp" %>
    <%@ include file="/WEB-INF/views/ju/layout/nav.jsp" %>
    
    <main>
        <h1>정보수정</h1>
        
        <form action="/journey/host/edit" method="post">
            <input type="hidden" name="no" value="${session.loginHostVo.no}">
            <br>
            <input type="password" name="pwd" placeholder="변경할 비밀번호" value="${sessionScope.loginHostVo.pwd}">
            <br>
            <input type="password" name="pwd2" placeholder="변경할 비밀번호 확인" value="${sessionScope.loginHostVo.pwd}">
            <br>
            <input type="text" name="phone" placeholder="전화 번호" value="${sessionScope.loginHostVo.phone}">
            <br>
            <input type="submit" value="수정하기">
            <input type="button" value="탈퇴하기" onclick="location.href='/journey/host/quit'">
        </form>
    </main>
    
    <%@ include file="/WEB-INF/views/ju/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/ju/layout/right-aside.jsp" %>
</body>
</html>
