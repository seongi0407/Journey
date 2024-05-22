<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약 및 결제</title>
<link rel="stylesheet" href="../resources/css/reservationPayment.css">
<script defer src="../resources/js/reservationPayment.js"></script>
</head>

<body>

	<header>
		<img id="img-logo" src="../resources/img/airbnb.png" alt="">
		<div class="header-right">
			<div id="introduce">당신의 공간을 여정하세요</div>
			<div id="profile-icon" onclick="showAccountContent()">
				<img id="menu-icon" width="16" src="../resources/img/menu.svg"
					alt="메뉴 아이콘"> <img id="user-icon" width="30"
					src="../resources/img/profile.svg" alt="유저 아이콘">
			</div>
		</div>
	</header>

	<nav class="rsv_inner" id="navText">
		<div id="backImgBox">
			<img src="../resources/img/뒤로가기.png">
		</div>
		<div>
			<h1>확인 및 결제</h1>
		</div>
	</nav>

	<main class="main">
		<form action="/app/book/new" method="post">
		
		<input type="hidden" name="roomNo" value="${vo.roomNo}">
        <input type="hidden" name="inDate" value="${vo.inDate}">
        <input type="hidden" name="outDate" value="${vo.outDate}">
        <input type="hidden" name="peopleCnt" value="${vo.peopleCnt}">
        <input type="hidden" name="sum" value="${vo.sum}">
        
			<section class="rsv_inner" id="section">
				<div id="sectionLeft">

					<div class="rsvInnerBox" id="reservationInformation">

						<div id="reservationInformationOutter">
							<h2>예약 정보</h2>
						</div>

						<div class="reservationInformationInner">
							<div>
								<div>
									<h3>날짜</h3>
								</div>
								<div>${vo.inDate}~ ${vo.outDate}</div>
							</div>
							<div id="modifyDate">
								<span id="modifyDateText" role="button">수정</span>
							</div>
						</div>

						<div class="reservationInformationInner">
							<div>
								<div>
									<h3>인원</h3>
								</div>
								<div>${vo.peopleCnt}명</div>
							</div>
							<div id="modifyCntPeople">
								<span id="modifyCntPeopleText" role="button">수정</span>
							</div>
						</div>
					</div>

					<div class="rsvInnerBox" id="billingInformation">
						<div class="billingInformation" id="billingInformationTitle">
							<h2>결제수단</h2>
							<div class="billingInformation" id="payimgoutter">
								<div class="payimg">
									<img src="../resources/img/visa.svg">
								</div>
								<div class="payimg">
									<img src="../resources/img/master.svg">
								</div>
								<div class="payimg">
									<img src="../resources/img/amaxs.svg">
								</div>
								<div class="payimg">
									<img src="../resources/img/npay.svg">
								</div>
							</div>
						</div>
						<section id="theme">
							<div class="select">
								<div class="text">선택</div>
								<ul class="option-list">
									<c:forEach var="card" items="${cardVoList}">
										<li class="option"><img src="../resources/img/visa.svg">
											${card.cardNick} ${card.cardNum}</li>
									</c:forEach>
									<li class="option"><img src="../resources/img/카드.png">
										결제수단 추가</li>
									<li class="option"><img src="../resources/img/무통장.png">
										무통장입금</li>
								</ul>
							</div>
						</section>
					</div>

					<div class="rsvInnerBox" id="sendMessageToHost">
						<div class="sendMessageToHost">
							<h2>호스트에게 메시지 보내기</h2>
						</div>
						<div class="sendMessageToHost">여행 목적, 동반 일행, 이 숙소를 선택한 이유 등을
							알려주세요.</div>
						<div class="sendMessageToHost">

							<div class="hostInformation">
								<div id="hostImgBox">
									<img id="hostImg" src="../resources/img/대표img.webp">
								</div>
								<div id="hostText">
									<div id="hostName">${host.name}</div>
									<div>에어비앤비 가입 : ${host.joinDate}</div>
								</div>
							</div>
						</div>
						<div class="sendMessageToHost">
							<textarea placeholder="안녕하세요. 숙소 도착 예정 시간은..."></textarea>
						</div>
					</div>
					<div class="rsvInnerBox" id="refundInfoText">
						<div class="refundInfoText">
							<h2>환불정책안내</h2>
						</div>
						<div class="refundInfoText">
							<span id="refundText">${refundPolicyText}</span> 그 이후에는 취소 시점에 따라
							환불액이 결정됩니다. <span id="refundPolicy" role="button"><a
								href="javascript:openPop()"> 자세히 알아보기</a></span>
						</div>
					</div>


					<div class="rsvInnerBox" id="rsvBtnText">
						아래 버튼을 선택하면 <span class="accommPolicy" role="button">호스트가
							설정한 숙소 이용규칙</span> , <span class="accommPolicy" role="button">게스트에게
							적용되는 기본 규칙</span> , <span class="accommPolicy" role="button">에어비앤비
							재예약 및 환불 정책</span> 에 동의하며, 피해에 대한 책임이 본인에게 있을 경우 에어비앤비가 <span
							class="accommPolicy" role="button">결제 수단으로 청구</span> 의 조치를 취할 수
						있다는 사실에 동의하는 것입니다. 호스트가 예약 요청을 수락하면 표시된 총액이 결제되는 데 동의합니다.
					</div>
					<div class="rsvInnerBox" id="rsvBtnBox">
						<button id="rsvBtn" type="submit">확인 및 결제</button>
					</div>
				</div>
			</section>
		</form>


		<aside id="aside">
			<div id="accommodationFeeDetails">
				<div id="paymentMethod">
					<div class="paymentMethod" id="roomInfo">
						<div id="roomImgBox">
							<img id="roomImg" src="../resources/img/대표img.webp">
						</div>
						<div id="roomText">
							<div id="roomName">${room.name}</div>
							<div>
								<span>${room.rating}</span> <span>슈퍼호스트</span>
							</div>
						</div>
					</div>
					<div class="paymentMethod">
						<h3>요금세부정보</h3>
						<div class="payInformation">
							<div>₩${room.price} x ${stayDuration}박</div>
						</div>
						<div id="totalPayInfo">
							<div>
								<h3>총합계</h3>
							</div>
							<div id="totalPayInfoRight">
								<span>₩${vo.sum}</span>
							</div>
						</div>
					</div>
				</div>
		</aside>
	</main>

	<footer class="footer">
		<div class="footer-content">
			<div class="footer-column">
				<h4>에어비앤비 지원</h4>
				<ul>
					<li><a href="https://www.airbnb.co.kr/help">도움말 센터</a></li>
					<li><a href="https://www.airbnb.co.kr/help/article/3218">에어커버</a></li>
					<li><a href="https://www.airbnb.co.kr/against-discrimination">차별
							반대</a></li>
					<li><a href="https://www.airbnb.co.kr/accessibility">장애인
							지원</a></li>
					<li><a href="https://www.airbnb.co.kr/help/article/2701">예약
							취소 옵션</a></li>
					<li><a href="https://www.airbnb.co.kr/help/article/3290">이웃
							민원 신고</a></li>
				</ul>
			</div>
			<div class="footer-column">
				<h4>호스팅</h4>
				<ul>
					<li><a
						href="https://www.airbnb.co.kr/host/homes?from_footer=1">당신의
							공간을 여정하세요</a></li>
					<li><a
						href="https://www.airbnb.co.kr/host/homes?from_footer=1">호스트를
							위한 에어커버</a></li>
					<li><a href="https://www.airbnb.co.kr/resources/hosting-homes">호스팅
							자료</a></li>
					<li><a
						href="https://community.withairbnb.com/t5/custom/page/page-id/CommunityCenterNotFound">커뮤니티
							포럼</a></li>
					<li><a href="https://www.airbnb.co.kr/help/article/1387">책임감
							있는 호스팅</a></li>
					<li><a href="https://www.airbnb.co.kr/ambassadors/joinaclass">무료
							호스팅 클래스 참여하기</a></li>
				</ul>
			</div>
			<div class="footer-column">
				<h4>여정</h4>
				<ul>
					<li><a href="https://news.airbnb.com/">뉴스룸</a></li>
					<li><a href="https://www.airbnb.co.kr/release">새로운 기능</a></li>
					<li><a href="https://careers.airbnb.com/">채용정보</a></li>
					<li><a href="https://investors.airbnb.com/home/default.aspx">투자자
							정보</a></li>
					<li><a
						href="https://ko.airbnb.org/?_set_bev_on_new_domain=1715824984_ZWY5ZmRiZjk5MTg0">여정
							긴급 속보</a></li>
				</ul>
			</div>
		</div>
		<div class="footer-language">
			<span>한국어 (KR)</span> <span>₩ KRW</span>
		</div>
		<div class="footer-sns">
			<img src="../resources/img//facebook.png" alt="facebook"> <img
				src="../resources/img/twitter.png" alt="twitter"> <img
				src="../resources/img/instagram.png" alt="instagram"> <img
				src="../resources/img/blog.png" alt="blog">
		</div>
		<div class="footer-bottom">
			<span>© 2024 여정, Inc.</span>
			<div class="footer-link">
				<a href="">개인정보 처리방침</a> <a href="">이용약관</a> <a href="">사이트맵</a> <a
					href="">한국의 변경된 환불 정책</a> <a href="">회사 세부정보</a>
			</div>
		</div>
	</footer>

	<!-- 팝업창 -->

	<section>
		<div class="popup_layer" id="popup_layer" style="display: none;">
			<div class="popup_box">
				<div>
					<a href="javascript:closePop();"><img id="closeImg"
						src="../resources/img/close.png"></a>
				</div>
				<!--팝업 컨텐츠 영역-->
				<div class="popup_cont">
					<div class="returnPopup">
						<h2>환불정책</h2>
						<div class="refundInformation">
							<div>
								<div>전</div>
								<div>5월15일</div>
								<div>오후3:00</div>
							</div>
							<div>
								<div>부분환불</div>
								<div>전체 숙박 요금 중 50%를 환불받으실 수 있습니다.</div>
								<div>서비스 수수료는 전액 환불됩니다.</div>
							</div>
						</div>
						<div class="refundInformation">
							<div>
								<div>전</div>
								<div>5월15일</div>
								<div>오후3:00</div>
							</div>
							<div>
								<div>부분환불</div>
								<div>전체 숙박 요금 중 50%를 환불받으실 수 있습니다.</div>
								<div>서비스 수수료는 전액 환불됩니다.</div>
							</div>
						</div>
					</div>
					<!--팝업 버튼 영역-->
					<div class="returnDetailBtn">
						<div>체크인 전에 예약을 취소하면 청소비는 언제나 환불됩니다.</div>
						<a href="">환불 정책 자세히 알아보기</a>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>


</html>

