// 리뷰 전체선택
function checkboxAll(source) {
	const checkboxes = document.querySelectorAll('input[name="reviewCheckbox"]');
	checkboxes.forEach(checkbox => checkbox.checked = source.checked);
}

function deleteReviews() {

	//체크박스 전부 가져오기
	const checkedBoxes = document.querySelectorAll('input[name="reviewCheckbox"]:checked');
	console.log("checkedBoxes : ", checkedBoxes);

	let reviewNos = [];
	for (let i = 0; i < checkedBoxes.length; ++i) {
		if (checkedBoxes[i].checked) {
			reviewNos.push(checkedBoxes[i].value);

		}

	}

	$.ajax({
		
		url: '/journey/review/delete',
		method: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(reviewNos),
		success: function(data) {
			alert('리뷰가 삭제되었습니다.');
			// 페이지 새로고침
			console.log(reviewNos);
			location.reload();
		},
		error: function(error) {
			alert('리뷰 삭제 중 오류가 발생하였습니다.');
		}
	});


}