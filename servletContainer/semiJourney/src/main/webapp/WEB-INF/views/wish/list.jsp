<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>여행의 정석</title>

<link rel="stylesheet" href="/journey/resources/css/home.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">
<link rel="stylesheet" href="/journey/resources/css/wish/wish.css">

<script defer src="/journey/resources/js/home.js"></script>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>
<script>
	function deleteWish(no) {
		$
				.ajax({
					url : '/journey/wish/delete',
					type : 'GET',
					data : {
						no : no
					},
					success : function(response) {
						if (response.trim() === "로그인이 필요합니다.") {
							alert('로그인이 필요합니다.');
						} else if (response.trim() === "위시리스트가 성공적으로 삭제되었습니다.") {
							$('#wish-' + no).remove();
							alert(response);
						} else {
							alert('위시리스트 삭제에 실패했습니다. 메시지: ' + response);
						}
					},
					error : function(xhr, status, error) {
						console.error('위시리스트 삭제 중 오류가 발생했습니다. 상태:', status,
								'오류:', error);
						console.error('응답 내용:', xhr.responseText);
						alert('위시리스트 삭제 중 오류가 발생했습니다. 상태: ' + status + ', 오류: '
								+ error);
					}
				});
	}
</script>
</head>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<section>
		<div class="wishlist-letter">위시리스트</div>
	</section>

	<div class="main">
		<div class="image-container">
			<c:forEach var="room" items="${roomVoList}">
				<div class="accomodation">
					<img src="/journey/resources/upload/room/${room.img01}" alt="숙소 사진">
					<div id="place-name">${room.name}</div>
					<c:choose>
						<c:when test="${not empty sessionScope.loginMemberVo}">
							<button id="gym">해물찜</button>
						</c:when>
						<c:otherwise>
							<button id="gym">해물찜</button>
						</c:otherwise>
					</c:choose>
					<div id="place-score">★ ${room.grade}</div>
					<div id="place">${room.address}</div>
					<div id="place-date">₩ ${room.weekdayPrice} / 박</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<br>
	<br>
	<br>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
</body>
</html>