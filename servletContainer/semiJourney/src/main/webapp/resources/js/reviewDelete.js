// 리뷰 전체선택
function checkboxAll(source) {
	const checkboxes = document.querySelectorAll('input[name="reviewCheckbox"]');
	checkboxes.forEach(checkbox => checkbox.checked = source.checked);
}

// 선택한 리뷰가 없을 경우 
function deleteCheckedBoard() {
	const checkedBoxes = document.querySelectorAll('input[name="reviewCheckbox"]:checked');
	if (checkedBoxes.length === 0) {
		alert('삭제할 리뷰를 선택해주세요.');
		return;
	}

	// 선택한 리뷰 있을 경우
	const form = document.createElement('form');
	form.method = 'POST';
	form.action = '/journey/review/delete';

	checkedBoxes.forEach(box => {
		const input = document.createElement('input');
		input.type = 'hidden';
		input.name = 'reviewNo';
		input.value = box.value;
		form.appendChild(input);
	});

	document.body.appendChild(form);
	form.submit();

}



