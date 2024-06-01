/* 날짜 유효성 검사 */
function validateDates(){
    const inDate = document.querySelector("#inDate").value;
    const outDate = document.querySelector("#outDate").value;

    console.log(inDate, outDate);

    if(inDate === "" || outDate === ""){
        alert('체크인과 체크아웃 날짜를 모두 선택해주세요.');
        return false;
    }

    if(inDate >= outDate){
        alert("체크아웃 날짜는 체크인 날짜 이후여야 합니다.");
        document.querySelector("#outDate").value = "";
        return false;
    }

    return true;
}
/* 날짜 유효성 검사 */
