<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>

<link rel="stylesheet" href="/journey/resources/css/ju.css">

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/ju/layout/left-aside.jsp" %>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/ju/layout/header.jsp" %>
        <%@ include file="/WEB-INF/views/ju/layout/nav.jsp" %>
		
        <main>
            <h1 align="center">환영합니다 ~ ^^</h1>
        </main>
        
        <%@ include file="/WEB-INF/views/ju/layout/footer.jsp" %>
	</div>
	<%@ include file="/WEB-INF/views/ju/layout/right-aside.jsp" %>
</body>
</html>
