let result = false;
let inputId = '';

/* 아이디 중복 검사 */
function checkDup(){

    const id = document.querySelector('#id').value;

    $.ajax({
        url: '/journey/host/checkDup',
        type: 'post',
        data: {id: id},
        success: (data) => {
            if(data.result === 1) {
                result = false;
                alert('이미 존재하는 아이디입니다.');
                return false;
            } else {
                result = true;
                inputId = id;
                alert('사용 가능한 아이디입니다.');
                return true;
            }
        },
        error: () => {
            alert('아이디 중복 검사에 실패했습니다. 다시 시도해주세요.');
            return false;
        }
    });
}
/* 아이디 중복 검사 */



/* 제출했을 시, 아이디, 비밀번호 유효성 검사 */
function validate() {

    const id = document.querySelector('#id').value;
    const pwd = document.querySelector('#pwd').value;
    const pwd2 = document.querySelector('#pwd2').value;
    const regex = /^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$/;
    
    if(!result || inputId !== id){
        result = false;
        alert('아이디 중복 검사를 실시하세요.');
        return false;
    }

    if (!regex.test(pwd)) {
        alert('비밀번호는 8자리 이상, 소문자와 숫자를 모두 포함해야 합니다.');
        return false;
    }

    if (pwd !== pwd2) {
        alert('비밀번호가 일치하지 않습니다.');
        return false;
    }

    alert('회원가입 성공');
    return true;
}
/* 제출했을 시, 아이디, 비밀번호 유효성 검사 */
