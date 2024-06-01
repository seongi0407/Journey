let result = false;
let inputName = '';

/* 객실명 중복 검사 */
function checkDup(){

    const name = document.querySelector('#name').value;

    $.ajax({
        url: '/journey/room/checkDup',
        type: 'post',
        data: {name: name},
        success: (data) => {
            if(data.result === 1) {
                result = false;
                alert('이미 존재하는 객실명입니다.');
                return false;
            } else {
                result = true;
                inputName = name;
                alert('사용 가능한 객실명입니다.');
                return true;
            }
        },
        error: () => {
            alert('객실명 중복 검사에 실패했습니다. 다시 시도해주세요.');
            return false;
        }
    });
}
/* 객실명 중복 검사 */



/* 제출했을 시, 객실명 유효성 검사 */
function validate() {

    const name = document.querySelector('#name').value;

    if(!result || inputName !== name){
        result = false;
        alert('객실명 중복 검사를 실시하세요.');
        return false;
    }

    alert('객실 등록 성공');
    return true;
}
/* 제출했을 시, 객실명 유효성 검사 */
