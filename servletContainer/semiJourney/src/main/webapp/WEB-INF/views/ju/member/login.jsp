<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link rel="stylesheet" href="/journey/resources/css/ju.css">

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/ju/layout/left-aside.jsp" %>
    <div id="wrap">
    <%@ include file="/WEB-INF/views/ju/layout/header.jsp" %>
    <%@ include file="/WEB-INF/views/ju/layout/nav.jsp" %>
    
    <main>
        <h1>로그인</h1>
        
        <form action="/journey/member/login" method="post">
          <input type="text" name="id" placeholder="아이디">
            <br>
            <input type="password" name="pwd" placeholder="비밀번호">
            <br>
            <input type="submit" value="로그인">
        </form>
    </main>
    
    <%@ include file="/WEB-INF/views/ju/layout/footer.jsp" %>
    </div>
    <%@ include file="/WEB-INF/views/ju/layout/right-aside.jsp" %>
</body>
</html>
