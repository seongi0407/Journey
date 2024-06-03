// 결제수단 셀렉트 박스
function onClickSelect(e) {
	const selectElement = e.currentTarget;
	const isActive = selectElement.classList.contains("active");
	if (isActive) {
		selectElement.classList.remove("active");
	} else {
		selectElement.classList.add("active");
	}
}
// 카드 셀렉, 옵션 클릭 이벤트
document.addEventListener("DOMContentLoaded", function() {
	const selectElement = document.querySelector("#select_card .select");
	selectElement.addEventListener("click", onClickSelect);

	const optionList = document.querySelectorAll("#select_card .option");
	for (let i = 0; i < optionList.length; i++) {
		optionList[i].addEventListener("click", selectCard);
	}
});


// 비밀번호 체크 함수
function checkPassword() {
	const inputPassword = document.querySelector("#passwordInput").value; // 사용자가 입력한 비밀번호
	const selectedCard = document.querySelector(".option.selected"); // 선택된 카드

	if (!selectedCard) {
		console.log('No card selected');
		return;
	}

	const selectedCardPwd = selectedCard.getAttribute('data-pwd'); // 선택된 카드의 비밀번호

	if (inputPassword === selectedCardPwd) {
		document.querySelector('#rsvBtn').disabled = false;
		document.querySelector('#passwordError').style.display = 'none';
		document.querySelector('#passwordSuccess').style.display = 'block';
		alert('비밀번호 일치');
	} else {
		document.querySelector('#rsvBtn').disabled = true;
		document.querySelector('#passwordError').style.display = 'block';
		document.querySelector('#passwordSuccess').style.display = 'none';
		alert('비밀번호 불일치');
	}

}


//간편결제는 비밀번호 체크 없음
// 카드 선택 
function selectCard(e) {
	e.stopPropagation();
	const selectedOption = e.currentTarget;
	const selectedValue = selectedOption.innerHTML;
	const selectContainer = selectedOption.closest('.select');
	const displayText = selectContainer.querySelector('.text');
	displayText.innerHTML = selectedValue;
	selectContainer.classList.remove("active");

	const selectedCode = selectedOption.getAttribute('data-code');
	const cardNo = selectedOption.getAttribute('data-no');

	document.querySelector('input[name="payMethodCode"]').value = selectedCode;
	document.querySelector('input[name="cardNo"]').value = cardNo;

	// 결제 방법이 'p1'일때만 비번 입력창 나오기
	if (selectedCode === 'P1') {
		document.getElementById('passwordSection').style.display = 'block';
		document.getElementById('rsvBtn').disabled = true;
	} else {
		document.getElementById('passwordSection').style.display = 'none';
		document.getElementById('rsvBtn').disabled = false;
	}

	// 선택된 옵션에 'selected' 클래스 추가
	document.querySelectorAll('.option').forEach(option => {
		option.classList.remove('selected');
	});
	selectedOption.classList.add('selected');
}



document.addEventListener("DOMContentLoaded", () => {
	const tempFormEl = document.querySelector("#temp-form");
	const subBtn = document.querySelector("#rsvBtn");
	const kakaoPayEl = document.querySelector("#KAKAOPAY");
	const sum = document.querySelector("#sum").textContent.trim();

	tempFormEl.addEventListener("submit", (e) => {
		if (!kakaoPayEl.classList.contains("selected")) {
			return;
		}

		// form submit 막기
		e.preventDefault();

		let IMP = window.IMP;
		IMP.init("imp54410645");
		IMP.request_pay({
			// Store ID
			storeId: "store-ace42a29-d07d-4792-a9a1-1669939707a5",
			// 채널 키
			channelKey: "channel-key-d2cf9894-e4d8-44d1-98db-2b0f658a477e",
			pg: "kakaopay",
			pay_method: "card",
			merchant_uid: "IMP" + new Date().getTime(),
			name: "여행의 정석",
			amount: sum
		}, function(data) {
			console.log(data);
			if (data.status === "paid") {
				// 결제 성공 시 폼 제출
				tempFormEl.submit();
			} else {
				alert("결제에 실패하였습니다.");
			}
		});
	});

	console.log(tempFormEl, subBtn, kakaoPayEl);
});

// 초기화
document.addEventListener("DOMContentLoaded", function() {
	document.querySelectorAll('.option').forEach(option => {
		option.addEventListener('click', selectCard);
	});
});

//stay(박) day 계산
const checkInDate = '<%= request.getParameter("inDate") %>';
const checkOutDate = '<%= request.getParameter("outDate") %>';
const weekdayPrice = parseInt('<%= vo.getWeekdayPrice() %>');
const weekendPrice = parseInt('<%= vo.getWeekendPrice() %>');


//aside 위치 조정
document.addEventListener("DOMContentLoaded", function() {
	function adjustAsidePosition() {
		const aside = document.getElementById('accommodationFeeDetails');
		const footer = document.querySelector('footer');
		const footerRect = footer.getBoundingClientRect();
		const windowHeight = window.innerHeight;
		const asideHeight = aside.offsetHeight;

		if (footerRect.top < windowHeight) {
			aside.style.position = 'absolute';
			aside.style.top = (window.scrollY + footerRect.top - asideHeight - 120) + 'px';
		} else {
			aside.style.position = 'fixed';
			aside.style.top = '30%';
		}
	}

	window.addEventListener('scroll', adjustAsidePosition);
	window.addEventListener('resize', adjustAsidePosition);

	adjustAsidePosition();
});


// 날짜수정 팝업
function editDate() {
	document.querySelector('#editDate_popup').style.display = 'block';
}

function close_editDate() {
	document.querySelector('#editDate_popup').style.display = 'none';
}

//날짜칸 수정
document.addEventListener("DOMContentLoaded", function() {
	const checkInDateEl = document.querySelector("#checkInDate");
	const checkOutDateEl = document.querySelector("#checkOutDate");
	const roomNoEl = document.querySelector("#roomNo");
	const sumEl = document.querySelector("#sum");

	// 날짜 변경 시 가격 업데이트
	checkInDateEl.addEventListener("change", updatePrice);
	checkOutDateEl.addEventListener("change", updatePrice);

	// 날짜 수정 팝업 저장 버튼 클릭 시 동작
	document.querySelector("#saveDateBtn").addEventListener("click", function() {
		const checkInDate = checkInDateEl.value;
		const checkOutDate = checkOutDateEl.value;
		const daysDiv = document.querySelector("#days");

		if (checkInDate && checkOutDate) {
			daysDiv.innerHTML = checkInDate + " ~ " + checkOutDate;
			document.querySelector('input[name="inDate"]').value = checkInDate;
			document.querySelector('input[name="outDate"]').value = checkOutDate;
			updatePrice(); // 날짜 변경 후 가격 수정
			close_editDate();
		} else {
			alert("날짜를 선택해주세요.");
		}
	});

	// 날짜 변경 시 가격 수정
	function updatePrice() {
		const checkInDate = checkInDateEl.value;
		const checkOutDate = checkOutDateEl.value;
		const roomNo = roomNoEl.value;
		console.log("updatePrice");

		if (checkInDate && checkOutDate && roomNo) {
			console.log("ajax");
			$.ajax({
				url: '/journey/book/calculatePrice',
				method: 'POST',
				data: {
					roomNo: roomNo,
					inDate: checkInDate,
					outDate: checkOutDate
				},
				success: function(response) {
					const totalSum = response.totalSum;
					sumEl.textContent = totalSum + '원';
					document.querySelector('input[name="sum"]').value = totalSum;
				},
				error: function(err) {
					console.error('Error calculating price:', err);
				}
			});
		}
	}
});

function close_editDate() {
	document.querySelector('#editDate_popup').style.display = 'none';
}





//날짜 유효성 검사
function validateDates() {
	const checkInDate = document.getElementById("checkInDate").value;
	const checkOutDate = document.getElementById("checkOutDate").value;

	// 현재 날짜 YYYY-MM-DD
	const today = new Date();
	const year = today.getFullYear();
	const month = String(today.getMonth() + 1).padStart(2, '0');
	const day = String(today.getDate()).padStart(2, '0');
	const sysdate = `${year}-${month}-${day}`;

	if (checkInDate && checkOutDate) {
		if (checkInDate <= sysdate) {
			alert("예약 날짜는 오늘 이후여야 합니다.");
			document.querySelector("#checkInDate").value = "";
		}
		if (checkOutDate <= checkInDate) {
			alert("체크아웃 날짜는 체크인 날짜보다 이후여야 합니다.");
			document.querySelector("#checkOutDate").value = "";
		}
	}

}


// 인원 수정
document.addEventListener("DOMContentLoaded", function() {
	const modifyCntPeopleText = document.querySelector("#modifyCntPeopleText");
	const editPeoplePopup = document.querySelector("#editPeople_popup");
	const closeBtn = document.querySelector("#editPeople_popup .closeBtn");
	const savePeopleButton = document.querySelector("#savePeopleBtn");
	const peopleCountDisplay = document.querySelector("#guestCountDisplay");
	const peopleCountInput = document.querySelector("#peopleCountInput");

	modifyCntPeopleText.addEventListener("click", function() {
		editPeoplePopup.style.display = "block";
	});

	closeBtn.addEventListener("click", function() {
		editPeoplePopup.style.display = "none";
	});

	savePeopleButton.addEventListener("click", function() {
		const newPeopleCount = peopleCountInput.value;

		peopleCountDisplay.innerHTML = newPeopleCount + "명";
		document.querySelector('input[name="guestCount"]').value = newPeopleCount; // hidden input 업데이트
		editPeoplePopup.style.display = "none";

	});

	window.addEventListener("click", function(event) {
		if (event.target == editPeoplePopup) {
			editPeoplePopup.style.display = "none";
		}
	});
});

function close_editPeople() {
	document.querySelector('#editPeople_popup').style.display = 'none';
}



// 환불안내 팝업
function openPop() {
	document.querySelector("#popup_refundInfo").style.display = "block";
}

function closePop() {
	document.querySelector('#popup_refundInfo').style.display = 'none';
}
