// 프로필 클릭 시 창 나오도록
function showAccountContent() {
	document.getElementById('account-content').classList.toggle('show');
}

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

// 계정 선택할 수 있도록 (회원가입)
function showJoin() {
	document.getElementById('select-account-join').classList.toggle('show');
}
// 닫기 버튼
document.getElementById('close-button-join').addEventListener('click', function() {
	document.getElementById('select-account-join').classList.remove('show');
});

// 계정 선택할 수 있도록 (로그인)
function showLogin() {
	document.getElementById('select-account-login').classList.toggle('show');
}
// 닫기 버튼
document.getElementById('close-button-login').addEventListener('click', function() {
	document.getElementById('select-account-login').classList.remove('show');
});

// 회원의 회원가입 창 나올 수 있도록 
function showMemberJoin() {
	document.getElementById('join-content').classList.toggle('show');
}
// 닫기 버튼
document.getElementById('join-close-button').addEventListener('click', function() {
	document.getElementById('join-content').classList.remove('show');
});

// 회원의 로그인 창 나올 수 있도록
function showMemberLogin() {
	document.getElementById('login-content').classList.toggle('show');
}
// 닫기 버튼
document.getElementById('login-close-button').addEventListener('click', function() {
	document.getElementById('login-content').classList.remove('show');
});

// 비밀번호 보기, 숨기기
function showPassword() {
	const passwordField = document.getElementById('login-password');
	const showPasswordButton = document.querySelector('.show-password');

	if (passwordField.type === 'password') {
		passwordField.type = 'text';
		showPasswordButton.textContent = '비밀번호 숨기기';
	} else {
		passwordField.type = 'password';
		showPasswordButton.textContent = '비밀번호 보기';
	}
}


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
function clickHeart(element) {
	var roomNo = element.getAttribute('room_no');

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