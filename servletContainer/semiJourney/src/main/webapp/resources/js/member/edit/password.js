/* 제출했을 시, 비밀번호 유효성 검사 */
function validate() {

    const pwd = document.querySelector('#pwd').value;
    const pwd2 = document.querySelector('#pwd2').value;
    const regex = /^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$/;

    if (!regex.test(pwd)) {
        alert('비밀번호는 8자리 이상, 소문자와 숫자를 모두 포함해야 합니다.');
        return false;
    }

    if (pwd !== pwd2) {
        alert('비밀번호가 일치하지 않습니다.');
        return false;
    }

    return true;
}
/* 제출했을 시, 비밀번호 유효성 검사 */
