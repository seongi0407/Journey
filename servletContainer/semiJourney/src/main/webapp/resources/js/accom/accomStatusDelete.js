function handleDelete(no) {
        $.ajax({
        url: 'http://127.0.0.1:8888/journey/accom/delete',
        method: 'GET',
        data: {
            no: no,
        },
        success: (data) => {
            if(data.result >= 1){
				alert("숙소 삭제 성공");
				location.reload();
			} else{
				alert("숙소 삭제 실패");
			}
			
			location.reload();
        },
        error: (error) => { 
            console.log("통신 실패");
            console.log(error);
        }
    });
}
