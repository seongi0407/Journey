// 프로필 클릭 시 창 나오도록
function showAccountContent(){
    document.getElementById('account-content').classList.toggle('show');
}

//찜 기능
function clickHeart(element){
    element.classList.toggle('liked');
}

// 여행지 검색창 
function showPlaceSearch(){
    document.getElementById('search-place').classList.toggle('show');
}

// 회원가입 창 나오도록
function showJoin(){
    document.getElementById('join-content').classList.toggle('show');
}

// 로그인 창 나오도록
function showLogin(){
    document.getElementById('login-content').classList.toggle('show');
}

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

// ----------------------------------------------------
// Calendar 관련 함수
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
