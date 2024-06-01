function checkDup() {
    let result = confirm("정말 탈퇴하시겠습니까?");

    if (result) {
        location.href = '/journey/host/quit';
    } else {
        alert("회원 탈퇴가 취소되었습니다.");
    }
}
