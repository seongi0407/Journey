<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 상세 조회</title>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

<link rel="stylesheet" href="/journey/resources/css/room/detail.css">
<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
<script defer src="/journey/resources/js/room/map.js"></script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f1deaaca1522c6065545245daaba71a4&libraries=services"></script>
</head>
<body>

    <%@ include file="/WEB-INF/views/layout/header.jsp"%>
    
	<aside></aside>

    <div id="wrap">

        <main>

            <div id="room-info">
                <div id="room-name"><h1>${vo.themeName}</h1></div>

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
                        <h1>${vo.name}, ${vo.hostName}의 집 전체</h1>
                        <h4>최대 인원 ${vo.capacity}명, 침대 ${vo.bedNum}개, 욕실 ${vo.bathNum}개</h4>
                        <h5>⭐ 4.27 후기 209개</h5>
                    </div>
                    <div id="host-short">
                        <img src="/journey/resources/upload/host/${vo.hostProfile}" alt="호스트 사진">
                        <div>
                            <h3>호스트: ${vo.hostName}님</h3>
                            <h4>슈퍼호스트 · 호스팅 경력 ??년</h4>
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
                            <h3>6월 11일 전까지 무료 취소 가능</h3>
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
                    <form id="reserve-table" action="/journey/book/new" method="get">
                        <h2 id="price-per-day">￦${vo.weekdayPrice}/박</h2>
                        <input type="hidden" name="roomNo" value="${vo.no}">
                        <div id="reserve-select">
                            <div id="check-in">
                                <label for="inDate">체크인</label>
                                <br>
                                <input type="date" name="inDate">
                            </div>
                            <div id="check-out">
                                <label for="outDate">체크아웃</label>
                                <br>
                                <input type="date" name="outDate">
                            </div>
                            <div id="guest-num">
                                <label for="guestCount">게스트 인원</label>
                                <br>
                                <select name="guestCount">
                                    <option value="1">1명</option>
                                    <option value="2">2명</option>
                                    <option value="3">3명</option>
                                    <option value="4">4명</option>
                                    <option value="5">5명</option>
                                    <option value="6">6명</option>
                                    <option value="7">7명</option>
                                    <option value="8">8명</option>
                                    <option value="9">9명</option>
                                    <option value="10">10명</option>
                                </select>
                            </div>
                        </div>
                        <input id="reserve-btn" type="submit" value="예약하기">
                            
                        <h4 id="reserve-price">${vo.weekdayPrice} x ??(며칠) = **(총 얼마)</h4>
                            
                        <h4 id="reserve-price-sum">??(총합) = ??(얼마)</h4>
                    </form>
                </div>
            </div>

            <div id="review">
                <div id="review01">
                    <img src="/journey/resources/upload/member/${reVoList[0].profile}" alt="리뷰01">
                    <div>
                        <h4>${reVoList[0].writerName}</h4>
                        <h5>서울, 한국</h5>
                    </div>
                    <div class="review-zone">
                        ⭐⭐⭐⭐⭐ · ${reVoList[0].enrollDate}
                        <div>
                            ${reVoList[0].content}
                        </div>
                    </div>
                </div>
                <div id="review02">
                    <img src="/journey/resources/upload/member/${reVoList[1].profile}" alt="리뷰02">
                    <div>
                        <h4>${reVoList[1].writerName}</h4>
                        <h5>서울, 한국</h5>
                    </div>
                    <div class="review-zone">
                        ⭐⭐⭐⭐⭐ · ${reVoList[1].enrollDate}
                        <div>
                            ${reVoList[1].content}
                        </div>
                    </div>
                </div>
                <div id="review03">
                    <img src="/journey/resources/upload/member/${reVoList[2].profile}" alt="리뷰03">
                    <div>
                        <h4>${reVoList[2].writerName}</h4>
                        <h5>서울, 한국</h5>
                    </div>
                    <div class="review-zone">
                        ⭐⭐⭐⭐⭐ · ${reVoList[2].enrollDate}
                        <div>
                            ${reVoList[2].content}
                        </div>
                    </div>
                </div>
                <div id="review04">
                    <img src="/journey/resources/upload/member/${reVoList[3].profile}" alt="리뷰04">
                    <div>
                        <h4>${reVoList[3].writerName}</h4>
                        <h5>서울, 한국</h5>
                    </div>
                    <div class="review-zone">
                        ⭐⭐⭐⭐⭐ · ${reVoList[3].enrollDate}
                        <div>
                            ${reVoList[3].content}
                        </div>
                    </div>
                </div>
                <div id="review05">
                    <img src="/journey/resources/upload/member/${reVoList[4].profile}" alt="리뷰05">
                    <div>
                        <h4>${reVoList[4].writerName}</h4>
                        <h5>서울, 한국</h5>
                    </div>
                    <div class="review-zone">
                        ⭐⭐⭐⭐⭐ · ${reVoList[4].enrollDate}
                        <div>
                            ${reVoList[4].content}
                        </div>
                    </div>
                </div>
                <div id="review06">
                    <img src="/journey/resources/upload/member/${reVoList[5].profile}" alt="리뷰06">
                    <div>
                        <h4>${reVoList[5].writerName}</h4>
                        <h5>서울, 한국</h5>
                    </div>
                    <div class="review-zone">
                        ⭐⭐⭐⭐⭐ · ${reVoList[5].enrollDate}
                        <div>
                            ${reVoList[5].content}
                        </div>
                    </div>
                </div>
            </div>

            <div id="map-wrap">
                <!-- 지도를 표시할 div 입니다 -->
                <div id="map"></div>
                <p><em>지도를 클릭해주세요!</em></p>
                <div id="clickLatlng"></div>
            </div>
            
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
                <script src = "/journey/resources/js/room/calendar.js"></script>
            </div>

        </main>



  		<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

    </div>

    <aside></aside>
</body>
</html>
