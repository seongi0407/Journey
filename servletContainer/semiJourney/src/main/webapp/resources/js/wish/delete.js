/*찜 취소 클릭시 db에 등록 + 로그인 안 하면 알림창 띄우기 */
function deleteWish(wishNo, memberNo) {
        $.ajax({
        url: 'http://127.0.0.1:8888/journey/wish/delete',
        method: 'GET',
        data: {
            wishNo: wishNo,
            memberNo: memberNo
        },
        success: (data) => {
            console.log("통신 성공");
            console.log(data);
            if(data.result >= 1){
				alert("위시리스트 삭제 성공");
			} else{
				alert("위시리스트 삭제 실패");
			}
			location.reload();
        },
        error: (error) => { 
            console.log("통신 실패");
            console.log(error);
        }
    });
}


function clickNothing() {
    alert("로그인 후 이용 가능합니다");
    $.ajax({
        url: 'http://127.0.0.1:8888/journey/home',
        method: 'get',
        data: {
            alerMsg: "로그인 후 이용 가능합니다"
        },
        success: (data) => {
            console.log("통신 성공");
            console.log(data);
        },
        error: (error) => { 
            console.log("통신 실패");
            console.log(error);
        }
    });
}