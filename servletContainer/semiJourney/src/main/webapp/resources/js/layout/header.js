// 프로필 클릭 시 창 나오도록
function showAccountContent() {
	document.getElementById('account-content').classList.toggle('show');
}

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
	document.getElementById('login-member-content').classList.toggle('show');
}
// 호스트의 로그인 창 나올 수 있도록
function showHostLogin() {
	document.getElementById('login-host-content').classList.toggle('show');
}
// 관리자의 로그인 창 나올 수 있도록
function showAdminLogin() {
	document.getElementById('login-admin-content').classList.toggle('show');
}
// 회원 닫기 버튼
document.getElementById('login-close-member-button').addEventListener('click', function() {
	document.getElementById('login-member-content').classList.remove('show');
});
// 호스트 닫기 버튼 
document.getElementById('login-close-host-button').addEventListener('click', function() {
	document.getElementById('login-host-content').classList.remove('show');
});
// 관리자 닫기 버튼
document.getElementById('login-close-admin-button').addEventListener('click', function() {
	document.getElementById('login-admin-content').classList.remove('show');
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
