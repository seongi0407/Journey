<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 상세 조회</title>

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<link rel="stylesheet" href="/journey/resources/css/room/detail/detail.css">
<link rel="stylesheet" href="/journey/resources/css/room/detail/calendar.css">
<link rel="stylesheet" href="/journey/resources/css/room/detail/map.css">

<%@ include file="/WEB-INF/views/layout/util.jsp" %>
<script defer src="/journey/resources/js/layout/header.js"></script>

<script defer src="/journey/resources/js/room/detail/date.js"></script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f1deaaca1522c6065545245daaba71a4&libraries=services"></script>
</head>
<body>

    <%@ include file="/WEB-INF/views/layout/header.jsp"%>
    
	<aside></aside>

    <div id="wrap">

        <main>

            <div id="room-info">
                <div id="room-name"><h1>${vo.accomName}</h1></div>

                <div id="room-photo">
                    <img id="first-img" src="/journey/resources/upload/room/${attVoList[0].changeName}" alt="img01">
                    <img class="room-img" src="/journey/resources/upload/room/${attVoList[1].changeName}" alt="img02">
                    <img class="room-img" src="/journey/resources/upload/room/${attVoList[2].changeName}" alt="img03">
                    <img class="room-img" src="/journey/resources/upload/room/${attVoList[3].changeName}" alt="img04">
                    <img class="room-img" src="/journey/resources/upload/room/${attVoList[4].changeName}" alt="img05">                	
                </div>
            </div>

            <div id="reservation">
                <div id="left">
                    <div id="room-explain">
                        <h1>${vo.themeName}, ${vo.name}, ${vo.hostName}의 집 전체</h1>
                        <h4>최대 인원 ${vo.capacity}명, 침대 ${vo.bedNum}개, 욕실 ${vo.bathNum}개</h4>
                        <h5>⭐ ${grade} 후기 ${count}개</h5>
                    </div>
                    <div id="host-short">
                        <img src="/journey/resources/upload/host/${vo.hostProfile}" alt="호스트 사진">
                        <div>
                            <h3>호스트: ${vo.hostName}님</h3>
                            <h4>슈퍼호스트 · 호스팅 경력 12년</h4>
                        </div>
                    </div>
                    <div id="room-short">
                        <img src="/journey/resources/img/room/ame01.png" alt="사진01">
                        <div>
                            <h3>셀프 체크인</h3>
                            <h4>열쇠 보관함을 이용해 체크인하세요.</h4>
                        </div>

                        <img src="/journey/resources/img/room/ame02.png" alt="사진02">
                        <div>
                            <h3>반려동물 환영</h3>
                            <h4>반려동물 동반이 허용되는 숙소입니다.</h4>
                        </div>

                        <img src="/journey/resources/img/room/ame03.png" alt="사진03">
                        <div>
                            <h3>무료 취소 가능</h3>
                            <h4>여행 계획이 변경되어도 전액 환불 받으실 수 있습니다.</h4>
                        </div>

                        <img src="/journey/resources/img/room/ame04.png" alt="사진04">
                        <div>
                            <h3>침실에 딸린 전용 욕실</h3>
                            <h4>방에 욕실이 딸려 있는 숙소입니다.</h4>
                        </div>
                    </div>
                </div>

                <div id="right">
                    <form onsubmit="return validateDates(${vo.no});" id="reserve-table" action="/journey/book/new" method="get">
                        <h2 id="price-per-day">￦${vo.weekdayPrice}/박</h2>
                        <input type="hidden" name="roomNo" value="${vo.no}">
                        <div id="reserve-select">
                            <div id="check-in">
                                <label for="inDate">체크인</label>
                                <br>
                                <input type="date" id="inDate" name="inDate">
                            </div>
                            <div id="check-out">
                                <label for="outDate">체크아웃</label>
                                <br>
                                <input type="date" id="outDate" name="outDate">
                            </div>
                            <div id="guest-num">
                                <label for="guestCount">게스트 인원</label>
                                <br>
                                <select name="guestCount">
                                	<c:forEach begin="1" end="${vo.capacity}" varStatus="i" >
                                		<option value="${i.index}">${i.index}명</option>
                                	</c:forEach>
                                </select>
                            </div>
                        </div>
                        <c:choose>
                        	<c:when test="${empty sessionScope.loginMemberVo}">
								<input id="reserve-btn" type="submit" value="예약하기" disabled>
                        	</c:when>
                        	<c:otherwise>
								<input id="reserve-btn" type="submit" value="예약하기">
                        	</c:otherwise>
                        </c:choose>
                    </form>
                </div>
            </div>

            <div id="review">
            	<c:forEach items="${reVoList}" var="reVoList">
	                <div>
	                    <img src="/journey/resources/upload/member/${reVoList.profile}" alt="리뷰01">
	                    <div>
	                        <h4>${reVoList.writerName}</h4>
	                        <h5>서울, 한국</h5>
	                    </div>
	                    <div class="review-zone">
	                        ⭐⭐⭐⭐⭐ · ${reVoList.enrollDate}
	                        <div>
	                            ${reVoList.content}
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
                <button onclick="location.href='/journey/review/list?roomNo=${vo.no}'">후기 모두 보기</button>
            </div>

            <div id="map-wrap">
                <!-- 지도를 표시할 div 입니다 -->
                <div id="map"></div>
            </div>
            
            <script>
				var mapContainer = document.getElementById('map'), // 지도의 중심좌표
				    mapOption = { 
				        center: new kakao.maps.LatLng(${vo.latitude}, ${vo.longitude}), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    }; 
				
				var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
				
				// 지도에 마커를 표시합니다 
				var marker = new kakao.maps.Marker({
				    map: map, 
				    position: new kakao.maps.LatLng(${vo.latitude}, ${vo.longitude})
				});
				
				// 커스텀 오버레이에 표시할 컨텐츠 입니다
				// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
				// 별도의 이벤트 메소드를 제공하지 않습니다 
				var content =
							'<div class="wrap">' +
							'	<div class="info">' +
							'		<div class="title">' +
							'			<div class="close" onclick="closeOverlay()" title="닫기"></div>' +
							'       </div>' +
							'       <div class="body">' +
							'           <div class="img">' +
							'				<img src="/journey/resources/upload/room/${vo.img01}"' +
							'				" width="73" height="70">' +
							'          	</div>' +
							'           <div class="desc">' +
							'               <div class="ellipsis">' +
							'					숙소명: ' +
							'					${vo.accomName}' +
							'					<br>' +
							'					객실명: ' +
							'					${vo.name}' +
							'					<br>' +
							'					주소: ' +
							'					${vo.address}' +
							'				</div>' +
							'               <div class="jibun ellipsis">' +
							'				</div>' +
							'               <div><a href="/journey/home" target="_blank" class="link">홈페이지</a></div>' + 
							'			</div>' +
							'		</div>' +
							'	</div>' +
				            '</div>';
				
				// 마커 위에 커스텀오버레이를 표시합니다
				// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
				var overlay = new kakao.maps.CustomOverlay({
				    content: content,
				    map: map,
				    position: marker.getPosition()       
				});
				            
				// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
				kakao.maps.event.addListener(marker, 'click', function() {
				    overlay.setMap(map);
				});
				
				// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
				function closeOverlay() {
				    overlay.setMap(null);     
				}
            </script>
            
            <div class = "calendar_container"> 
                
                <button class = "left_button"> &lt </button>
                
                <table class = "calendar">
                    <th class = "title">2월</th>
                    <tbody>
                        <tr class = "week">
                            <td class = "day">일</td>
                            <td class = "day">월</td>
                            <td class = "day">화</td>
                            <td class = "day">수</td>
                            <td class = "day">목</td>
                            <td class = "day">금</td>
                            <td class = "day">토</td>
                        </tr>
                        <tr>    <!-- 달력 첫 번째 줄-->
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                        </tr>
                        <tr>    <!-- 달력 두 번째 줄-->
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                        </tr>
                        <tr>    <!-- 달력 세 번째 줄-->
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                        </tr>
                        <tr>    <!-- 달력 네 번째 줄-->
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                        </tr>
                        <tr>    <!-- 달력 다섯 번째 줄-->
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                        </tr>
                        <tr>    <!-- 달력 여섯 번째 줄-->
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                            <td class = "calendar_days" roll = "button"> </td>
                        </tr>
                    </tbody>
                </table>
                
                <button class = "right_button"> > </button>
                <script src = "/journey/resources/js/room/detail/calendar.js"></script>
            </div>

        </main>

        

    </div>
    
    <%@ include file="/WEB-INF/views/layout/footer.jsp"%>

    <aside></aside>
</body>
</html>
