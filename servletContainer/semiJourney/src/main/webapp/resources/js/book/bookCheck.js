document.addEventListener('DOMContentLoaded', () => {
	const section = document.getElementById('section');
	let clickCount = 0;

	document.querySelector('#nextBtn').addEventListener('click', function() {
		clickCount++;
		if (clickCount === 1) {
			// 첫 번째 클릭
			document.body.style.backgroundColor = '#ffd147';
			document.querySelector('#rsvCompleteText').innerHTML =
				'<h1>여행정보를 공유하세요</h1><h6>모든 일행에게 체크인 정보 및 호스트와</h6><h6>주고받은 모든 메시지를 확인할 수 있는 권한을</h6><h6>부여하세요</h6>';
			document.querySelector('#rsvCompleteText').style.margin = '0';

			// 카드뒤집기
			section.classList.add("flipped");
			setTimeout(() => {
				section.classList.remove("flipped");
			}, 2000);
		} else if (clickCount === 2) {
			// 두 번째 클릭
			window.location.href = '/journey/book/list';
		}
	});

	// 카드를 눌러도 뒤집히기 기능
	section.addEventListener('click', () => {
		section.classList.toggle('flipped');
	});
});