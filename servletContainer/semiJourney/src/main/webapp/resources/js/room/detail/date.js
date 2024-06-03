/* 날짜 유효성 검사 */
function validateDates(no){
	
    const inDate = document.querySelector("#inDate").value;
    const outDate = document.querySelector("#outDate").value;
    
    if(inDate >= outDate){
        alert("체크아웃 날짜는 체크인 날짜 이후여야 합니다.");
        document.querySelector("#inDate").value = "";
        document.querySelector("#outDate").value = "";
        return false;
    }
    
    if(inDate === "" || outDate === ""){
	    alert('체크인과 체크아웃 날짜를 모두 선택해주세요.');
	    return false;
    }
    
    return true;
    
    /*
   	const iD = new Date(inDate);
    const iDDay = String(iD.getDate()).padStart(2, '0');
    const iDMonth = String(iD.getMonth() + 1).padStart(2, '0');
    const iDYear = iD.getFullYear();
    
    const iDDate = iDYear + iDMonth + iDDay;
    
    const oD = new Date(outDate);
    const oDDay = String(oD.getDate()).padStart(2, '0');
    const oDMonth = String(oD.getMonth() + 1).padStart(2, '0');
    const oDYear = oD.getFullYear();
    
    const oDDate = oDYear + oDMonth + oDDay;
    
    $.ajax({
		url: '/journey/room/checkDate',
        type: 'post',
        data: {
			iDDate: iDDate,
			oDDate: oDDate,
			no: no
		},
        success: (data) => {
			
			console.log(data.result);
			
            if(inDate === "" || outDate === ""){
		        alert('체크인과 체크아웃 날짜를 모두 선택해주세요.');
		        return false;
		    }
		    
		    if(inDate >= outDate){
		        alert("체크아웃 날짜는 체크인 날짜 이후여야 합니다.");
		        document.querySelector("#inDate").value = "";
		        document.querySelector("#outDate").value = "";
		        return false;
		    }
		    
		    if(data.result >= 1){
                alert('해당 날짜에 예약이 있습니다.');
                return false;
            }
            
            return true;
        },
        error: () => {
            alert(' 검사에 실패했습니다. 다시 시도해주세요.');
            return false;
        }
	});
	*/
}
/* 날짜 유효성 검사 */



/* 체크인 날짜 최소 설정 (당일 예약 금지) */
document.addEventListener('DOMContentLoaded', () => {
    const today = new Date();
    const day = String(today.getDate() + 1).padStart(2, '0');
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const year = today.getFullYear();
    
    const todayDate = year + '-' + month + '-' + day;
    document.querySelector('#inDate').setAttribute('min', todayDate);
});
/* 체크인 날짜 최소 설정 (당일 예약 금지) */



/* 체크아웃 날짜 최소 설정 (당일 예약 금지) */
document.addEventListener('DOMContentLoaded', () => {
    const today = new Date();
    const day = String(today.getDate() + 1).padStart(2, '0');
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const year = today.getFullYear();

    const todayDate = year + '-' + month + '-' + day;
    document.querySelector('#outDate').setAttribute('min', todayDate);
});
/* 체크아웃 날짜 최소 설정 (당일 예약 금지) */
