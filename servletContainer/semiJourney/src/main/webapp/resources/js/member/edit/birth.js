/* 제출 시, 생년월일 유효성 검사 */
function validate() {

    const date = document.querySelector('#birthDate').value;
    const selectedDate = new Date(date);
    const currentDate = new Date();

    selectedDate.setFullYear(selectedDate.getFullYear() + 19);

    if (selectedDate > currentDate) {
        alert('만 19세 이상만 이용 가능합니다.');
        return false;
    }

    return true;
}
/* 제출 시, 생년월일 유효성 검사 */
