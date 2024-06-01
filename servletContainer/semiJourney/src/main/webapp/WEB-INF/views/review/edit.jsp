<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰수정</title>

<link rel="stylesheet" href="/journey/resources/css/review/reviewEdit.css">

<link rel="stylesheet" href="/journey/resources/css/layout/header.css">
<link rel="stylesheet" href="/journey/resources/css/layout/footer.css">

<script defer src="/journey/resources/js/layout/header.js"></script>
</head>

<%@ include file="/WEB-INF/views/layout/util.jsp"%>
<body>

	<%@ include file="/WEB-INF/views/layout/header.jsp"%>

		    <main>
        <section class="review-section">
            <div class="review-container">
                <h2>리뷰 수정</h2>
                <br>
                <hr>
                <br>
                <form id="reviewForm" action="/journey/review/edit" method="post">
                    <input type="hidden" name="id" value="${param.id}">
                    <c:forEach var="review" items="${review}">
                    
                    
                    <input type="hidden" name="no" value="${review.no}">
                        <div class="form-group">
                            <label for="cleanlinessRating">청결도</label>
                            <div class="star-rating" id="cleanlinessRating">
                                <c:forEach begin="1" end="5" var="i">
                                    <input type="radio" id="cleanliness${i}" name="clean" value="${i}" ${review.clean == i ? 'checked="checked"' : ''} disabled>
                                    <label class="star" for="cleanliness${i}" title="${i} stars"></label>
                                </c:forEach>
                            </div>
                            <div class="ratingValue" id="cleanlinessValue">${review.clean}</div>
                        </div>
                        <div class="form-group">
                            <label for="checkInRating">체크인</label>
                            <div class="star-rating" id="checkInRating">
                                <c:forEach begin="1" end="5" var="i">
                                    <input type="radio" id="checkIn${i}" name="checkin" value="${i}" ${review.checkin == i ? 'checked="checked"' : ''} disabled>
                                    <label class="star" for="checkIn${i}" title="${i} stars"></label>
                                </c:forEach>
                            </div>
                            <div class="ratingValue" id="checkInValue">${review.checkin}</div>
                        </div>
                        <div class="form-group">
                            <label for="communicationRating">의사소통</label>
                            <div class="star-rating" id="communicationRating">
                                <c:forEach begin="1" end="5" var="i">
                                    <input type="radio" id="communication${i}" name="communication" value="${i}" ${review.communication == i ? 'checked="checked"' : ''} disabled>
                                    <label class="star" for="communication${i}" title="${i} stars"></label>
                                </c:forEach>
                            </div>
                            <div class="ratingValue" id="communicationValue">${review.communication}</div>
                        </div>
                        <div class="form-group">
                            <label for="locationRating">위치</label>
                            <div class="star-rating" id="locationRating">
                                <c:forEach begin="1" end="5" var="i">
                                    <input type="radio" id="location${i}" name="location" value="${i}" ${review.location == i ? 'checked="checked"' : ''} disabled>
                                    <label class="star" for="location${i}" title="${i} stars"></label>
                                </c:forEach>
                            </div>
                            <div class="ratingValue" id="locationValue">${review.location}</div>
                        </div>
                        <div class="form-group">
                            <label for="valueRating">가격 대비 만족도</label>
                            <div class="star-rating" id="valueRating">
                                <c:forEach begin="1" end="5" var="i">
                                    <input type="radio" id="value${i}" name="accuracy" value="${i}" ${review.accuracy == i ? 'checked="checked"' : ''} disabled>
                                    <label class="star" for="value${i}" title="${i} stars"></label>
                                </c:forEach>
                            </div>
                            <div class="ratingValue" id="valueValue">${review.accuracy}</div>
                        </div>
                        <br>
                        <hr>
                        <br>
                        <div class="form-group">
                            <textarea id="reviewContent" name="content" rows="5" required>${review.content}</textarea>
                        </div>
                        <br>
                        <button type="submit" id="submitReviewBtn">수정</button>
                    </c:forEach>
                </form>
            </div>
        </section>
    </main>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
</body>
</html>