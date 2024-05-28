<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 상세 조회</title>

<%@ include file="/WEB-INF/views/layout/util.jsp" %>

<link rel="stylesheet" href="/journey/resources/css/detail2.css">

<script defer src="/journey/resources/js/detail2.js"></script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f1deaaca1522c6065545245daaba71a4&libraries=services"></script>
</head>
<body>
	<aside></aside>

    <div id="wrap">

        <header>

            <img id="img-logo" src="/journey/resources/img/airbnb.png" alt="로고">
            <div class="header-right">
                <div id="introduce">당신의 공간을 여정하세요</div>
                <div id="profile-icon" onclick="showAccountContent()">
                    <img id="menu-icon" width="16" src="/journey/resources/img/menu.svg" alt="메뉴 아이콘">
                    <img id="user-icon" width="30" src="/journey/resources/upload/member01.png" alt="유저 아이콘">
                </div>
                <div class="account-content" id="account-content">
                    <button id="join" onclick="showJoin()">회원가입</button>
                    <button id="login" onclick="showLogin()">로그인</button>
                    <hr>
                    <button>당신의 공간을 여정하세요</button>
                    <button>도움말 센터</button>
                </div>
            </div>

        </header>



        <main>

            <div id="room-info">
                <div id="room-name"><h1>${vo.themeName}</h1></div>

                <div id="room-photo">
                    <img id="first-img" src="/journey/resources/upload/${attVoList[0].changeName}" alt="img01">
                    <img class="room-img" src="/journey/resources/upload/${attVoList[1].changeName}" alt="img02">
                    <img class="room-img" src="/journey/resources/upload/${attVoList[2].changeName}" alt="img03">
                    <img class="room-img" src="/journey/resources/upload/${attVoList[3].changeName}" alt="img04">
                    <img class="room-img" src="/journey/resources/upload/${attVoList[4].changeName}" alt="img05">                	
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
                        <img src="/journey/resources/upload/host01.png" alt="호스트 사진">
                        <div>
                            <h3>호스트: ${vo.hostName}님</h3>
                            <h4>슈퍼호스트 · 호스팅 경력 ??년</h4>
                        </div>
                    </div>
                    <div id="room-short">
                        <img src="/journey/resources/img/ame01.png" alt="사진01">
                        <div>
                            <h3>셀프 체크인</h3>
                            <h4>열쇠 보관함을 이용해 체크인하세요.</h4>
                        </div>

                        <img src="/journey/resources/img/ame02.png" alt="사진02">
                        <div>
                            <h3>반려동물 환영</h3>
                            <h4>반려동물 동반이 허용되는 숙소입니다.</h4>
                        </div>

                        <img src="/journey/resources/img/ame03.png" alt="사진03">
                        <div>
                            <h3>6월 11일 전까지 무료 취소 가능</h3>
                            <h4>여행 계획이 변경되어도 전액 환불 받으실 수 있습니다.</h4>
                        </div>

                        <img src="/journey/resources/img/ame04.png" alt="사진04">
                        <div>
                            <h3>침실에 딸린 전용 욕실</h3>
                            <h4>방에 욕실이 딸려 있는 숙소입니다.</h4>
                        </div>
                    </div>
                </div>

                <div id="right">
                    <form id="reserve-table" action="/journey/book/new" method="post">
                        <h2 id="price-per-day">￦${vo.weekdayPrice}/박</h2>
                        <div id="reserve-select">
                            <div id="check-in">
                                <label for="check-in">체크인</label>
                                <br>
                                <input type="date" name="check-in">
                            </div>
                            <div id="check-out">
                                <label for="check-out">체크아웃</label>
                                <br>
                                <input type="date" name="check-out">
                            </div>
                            <div id="guest-num">
                                <label for="guest-num">게스트 인원</label>
                                <br>
                                <select name="guest-num">
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
                    <img src="/journey/resources/upload/member01.png" alt="리뷰01">
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
                    <img src="/journey/resources/upload/member01.png" alt="리뷰02">
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
                    <img src="/journey/resources/upload/member01.png" alt="리뷰03">
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
                    <img src="/journey/resources/upload/member01.png" alt="리뷰04">
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
                    <img src="/journey/resources/upload/member01.png" alt="리뷰05">
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
                    <img src="/journey/resources/upload/member01.png" alt="리뷰06">
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

        </main>



            <footer class="footer">

                <div class="footer-content">
                <div class="footer-column">
                    <h4>에어비앤비 지원</h4>
                    <ul>
                    <li><a href="https://www.airbnb.co.kr/help">도움말 센터</a></li>
                    <li><a href="https://www.airbnb.co.kr/help/article/3218">에어커버</a></li>
                    <li><a href="https://www.airbnb.co.kr/against-discrimination">차별 반대</a></li>
                    <li><a href="https://www.airbnb.co.kr/accessibility">장애인 지원</a></li>
                    <li><a href="https://www.airbnb.co.kr/help/article/2701">예약 취소 옵션</a></li>
                    <li><a href="https://www.airbnb.co.kr/help/article/3290">이웃 민원 신고</a></li>
                    </ul>
                </div>
                <div class="footer-column">
                    <h4>호스팅</h4>
                    <ul>
                    <li><a href="https://www.airbnb.co.kr/host/homes?from_footer=1">당신의 공간을 여정하세요</a></li>
                    <li><a href="https://www.airbnb.co.kr/host/homes?from_footer=1">호스트를 위한 에어커버</a></li>
                    <li><a href="https://www.airbnb.co.kr/resources/hosting-homes">호스팅 자료</a></li>
                    <li><a href="https://community.withairbnb.com/t5/custom/page/page-id/CommunityCenterNotFound">커뮤니티 포럼</a></li>
                    <li><a href="https://www.airbnb.co.kr/help/article/1387">책임감 있는 호스팅</a></li>
                    <li><a href="https://www.airbnb.co.kr/ambassadors/joinaclass">무료 호스팅 클래스 참여하기</a></li>
                    </ul>
                </div>
                <div class="footer-column">
                    <h4>여정</h4>
                    <ul>
                    <li><a href="https://news.airbnb.com/">뉴스룸</a></li>
                    <li><a href="https://www.airbnb.co.kr/release">새로운 기능</a></li>
                    <li><a href="https://careers.airbnb.com/">채용정보</a></li>
                    <li><a href="https://investors.airbnb.com/home/default.aspx">투자자 정보</a></li>
                    <li><a href="https://ko.airbnb.org/?_set_bev_on_new_domain=1715824984_ZWY5ZmRiZjk5MTg0">여정 긴급 속보</a></li>
                    </ul>
                </div>
                </div>
                <div class="footer-language">
                <span>한국어 (KR)</span>
                <span>₩ KRW</span>
                </div>
                <div class="footer-sns">
                <img src="/journey/resources/img/facebook.png" alt="facebook">
                <img src="/journey/resources/img/twitter.png" alt="twitter">
                <img src="/journey/resources/img/instagram.png" alt="instagram">
                <img src="/journey/resources/img/blog.png" alt="blog">
                </div>
                <div class="footer-bottom">
                <span>© 2024 여정, Inc.</span>
                <div class="footer-link">
                    <a href="">개인정보 처리방침</a>
                    <a href="">이용약관</a>
                    <a href="">사이트맵</a>
                    <a href="">한국의 변경된 환불 정책</a>
                    <a href="">회사 세부정보</a>
                </div>
                </div>

            </footer>

    </div>

    <aside></aside>
</body>
</html>
