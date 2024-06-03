function refresh(no){

    $.ajax({
        url: '/journey/room/delete',
        type: 'get',
        data: {no: no},
        success: (data) => {
            location.reload();
        },
        error: () => {
            alert('아이디 중복 검사에 실패했습니다. 다시 시도해주세요.');
            return false;
        }
    });
}
