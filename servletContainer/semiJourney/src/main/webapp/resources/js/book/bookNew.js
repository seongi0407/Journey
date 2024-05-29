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

//비밀번호 체크
function checkPassword() {
    const inputPassword = document.querySelector("#passwordInput").value;
    const selectedCard = document.querySelector(".option.selected");

    if (!selectedCard) {
        console.log('No card selected');
        return;
    }

    const selectedCardPwd = selectedCard.getAttribute('data-password');

    console.log(inputPassword);  // 사용자가 입력한 비밀번호
    console.log(selectedCardPwd);  // 선택된 카드의 비밀번호

    if (inputPassword === selectedCardPwd) {
        document.getElementById('rsvBtn').disabled = false;
        document.getElementById('passwordError').style.display = 'none';
    } else {
        document.getElementById('rsvBtn').disabled = true;
        document.getElementById('passwordError').style.display = 'block';
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

//비밀번호 확인........
function checkPassword() {
    const inputPassword = document.getElementById('passwordInput').value;
    const selectedCard = document.querySelector('.option.selected');
    const storedPassword = selectedCard ? selectedCard.getAttribute('data-pwd') : '';

    if (inputPassword === storedPassword) {
        document.getElementById('rsvBtn').disabled = false;
        document.getElementById('passwordError').style.display = 'none';
    } else {
        document.getElementById('rsvBtn').disabled = true;
        document.getElementById('passwordError').style.display = 'block';
    }
}

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
function saveDates() {
	const checkInDate = document.querySelector('#checkInDate').value;
	const checkOutDate = document.querySelector('#checkOutDate').value;
	const daysDiv = document.querySelector('#days');

	if (checkInDate && checkOutDate) {
		daysDiv.innerHTML = checkInDate + " ~ " + checkOutDate;
		close_editDate();
	} else {
		alert("날짜를 선택해주세요.");
	}
}

//날짜 유효성 검사
function validateDates() {
        const checkInDate = document.getElementById("checkInDate").value;
        const checkOutDate = document.getElementById("checkOutDate").value;

        if (checkInDate && checkOutDate) {
            if (checkOutDate <= checkInDate) {
                alert("체크아웃 날짜는 체크인 날짜보다 이후여야 합니다.");
                document.getElementById("checkOutDate").value = "";
            }
        }
    }


// 인원수정 팝업
document.addEventListener("DOMContentLoaded", function() {
	const modifyCntPeopleText = document.querySelector("#modifyCntPeopleText");
	const editPeoplePopup = document.querySelector("#editPeople_popup");
	const closeBtn = document.querySelector("#editPeople_popup .close-button");
	const savePeopleButton = document.querySelector("#savePeopleBtn"); // 변경된 ID
	const peopleCountDisplay = document.querySelector("#guestCount");
	const peopleCountInput = document.querySelector("#peopleCountInput");

	modifyCntPeopleText.addEventListener("click", function() {
		editPeoplePopup.style.display = "block";
	});

	closeBtn.addEventListener("click", function() {
		editPeoplePopup.style.display = "none";
	});

	savePeopleButton.addEventListener("click", function() {
		const newPeopleCount = peopleCountInput.value;
		if (newPeopleCount) {
			peopleCountDisplay.textContent = newPeopleCount + "명";
			editPeoplePopup.style.display = "none";
		} else {
			alert("인원 수를 입력하세요.");
		}
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
	document.querySelector("#popup_refundInfo").style.display = "none";
}


