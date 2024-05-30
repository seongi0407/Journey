//찜 기능
function clickHeart(element) {
	element.classList.toggle('liked');
}

// 여행지 검색창 
function showPlaceSearch() {
	document.getElementById('search-place').classList.toggle('show');
}

// 여행자 검색창
function showTravelerSearch() {
	document.getElementById('traveler').classList.toggle('show');
}

// 여행자 검색창 - 숫자 COUNT
document.querySelectorAll('.people-count').forEach(control => {

	const decreaseButton = control.querySelector('.decrease');
	const increaseButton = control.querySelector('.increase');
	const countSpan = control.querySelector('.count');
	let count = 0;

	decreaseButton.addEventListener('click', () => {
		if (count > 0) {
			count--;
			countSpan.textContent = count;
		}
	});

	increaseButton.addEventListener('click', () => {
		count++;
		countSpan.textContent = count;
	});
});

// 여행지 검색 
function updateSearchBar(value) {
	document.getElementById('search-destination').textContent = value;
}

function showPlaceSearch() {
	const searchPlace = document.getElementById('search-place');
	searchPlace.classList.toggle('show');
}

document.querySelectorAll('.search-place-name button').forEach(button => {
	button.addEventListener('click', () => {
		updateSearchBar(button.textContent);
		document.getElementById('search-place').classList.remove('show');
	});
});

document.querySelector('.search-place-button').addEventListener('click', () => {
	updateSearchBar('유연한 검색');
	document.getElementById('search-place').classList.remove('show');
});



//---------------------------------------------------------------------------------------
/*
function clickHeart(element) {
	var roomNo = element.getAttribute('room_no');
	var memNo = element.getAttribute('mem_no');

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/journey/wish/insert', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === XMLHttpRequest.DONE) {
			if (xhr.status === 200) {
				alert('위시리스트에 등록되었습니다.');
				element.querySelector('.heart-empty').style.display = 'none';
				element.querySelector('.heart-filled').style.display = 'inline';
			} else if (xhr.status === 401) {
				alert('로그인이 필요합니다.');
			} else {
				alert('위시리스트 등록 중 오류가 발생했습니다. ' + xhr.responseText);
			}
		}
	};
	xhr.send('roomNo=' + encodeURIComponent(roomNo));
}
*/



/*찜 클릭시 db에 등록 + 로그인 안 하면 알림창 띄우기 */
function clickHeart(roomNo, memberNo) {
    $.ajax({
        url: 'http://127.0.0.1:8888/journey/wish/insert',
        method: 'post',
        data: {
            memberNo: memberNo,
            roomNo: roomNo
        },
        success: (data) => {
            console.log("통신 성공");
            console.log(memberNo);
            console.log(roomNo);
            console.log(data);
            alert("위시리스트에 등록되었습니다.");
        },
        error: (error) => { 
            console.log("통신 실패");
            console.log(error);
        }
    });
}

function clickNothing() {
    alert("로그인 후 이용 가능합니다");
    $.ajax({
        url: 'http://127.0.0.1:8888/journey/home',
        method: 'get',
        data: {
            alerMsg: "로그인 후 이용 가능합니다"
        },
        success: (data) => {
            console.log("통신 성공");
            console.log(data);
        },
        error: (error) => { 
            console.log("통신 실패");
            console.log(error);
        }
    });
}
//---------------------------------------------------------------------------------------

// ----------------------------------------------------
// Calendar 관련 함수 -> ChatGPT
document.addEventListener('DOMContentLoaded', function() {
	const calendarModal = document.getElementById('calendar-modal');
	const calendarBody = document.getElementById('calendar-body');
	const currentMonthSpan = document.getElementById('current-month');
	const checkinButton = document.getElementById('checkin-button');
	const checkoutButton = document.getElementById('checkout-button');
	let currentMonth = new Date();
	let selectedDateType = 'checkin';

	// showCalendar 함수를 전역으로 노출
	window.showCalendar = function(type) {
		selectedDateType = type;
		console.log('showCalendar 호출됨, 타입:', type); // 디버깅용 로그
		calendarModal.style.display = 'flex';
		renderCalendar(currentMonth);
	}

	function closeCalendar() {
		calendarModal.style.display = 'none';
	}

	function renderCalendar(date) {
		calendarBody.innerHTML = '';
		const month = date.getMonth();
		const year = date.getFullYear();
		currentMonthSpan.textContent = `${year}년 ${month + 1}월`;

		const firstDay = new Date(year, month, 1).getDay();
		const daysInMonth = new Date(year, month + 1, 0).getDate();

		for (let i = 0; i < firstDay; i++) {
			const emptyCell = document.createElement('div');
			calendarBody.appendChild(emptyCell);
		}

		for (let day = 1; day <= daysInMonth; day++) {
			const dayCell = document.createElement('div');
			dayCell.className = 'calendar-day';
			dayCell.textContent = day;
			dayCell.addEventListener('click', function() {
				selectDate(year, month, day);
			});
			calendarBody.appendChild(dayCell);
		}
	}

	function selectDate(year, month, day) {
		const selectedDate = new Date(year, month, day);
		if (selectedDateType === 'checkin') {
			checkinButton.querySelector('span:nth-child(2)').textContent = `${month + 1}월 ${day}일`;
			selectedDateType = 'checkout';
		} else {
			checkoutButton.querySelector('span:nth-child(2)').textContent = `${month + 1}월 ${day}일`;
			closeCalendar();
		}
	}

	document.getElementById('prev-month').addEventListener('click', function() {
		currentMonth.setMonth(currentMonth.getMonth() - 1);
		renderCalendar(currentMonth);
	});

	document.getElementById('next-month').addEventListener('click', function() {
		currentMonth.setMonth(currentMonth.getMonth() + 1);
		renderCalendar(currentMonth);
	});

	document.getElementById('close-calendar').addEventListener('click', closeCalendar);
});