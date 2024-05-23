//환불안내 팝업
function openPop() {
  document.getElementById("popup_layer").style.display = "block";
}
function closePop() {
  document.getElementById("popup_layer").style.display = "none";
}


//날짜수정 팝업
function editDate() {
  document.getElementById('editDate_popup').style.display = 'block';
}
function close_editDate() {
  document.getElementById('editDate_popup').style.display = 'none';
}


function saveDates() {
  const checkInDate = document.getElementById('checkInDate').value;
  const checkOutDate = document.getElementById('checkOutDate').value;
  const daysDiv = document.getElementById('days');

  if (checkInDate && checkOutDate) {
      daysDiv.innerHTML = checkInDate + " ~ " + checkOutDate;
      close_editDate();
  } else {
      alert("날짜를 선택해주세요.");
  }
}

// Close the modal if the user clicks outside of it
window.onclick = function(event) {
  const modal = document.getElementById('editDate_popup');
  if (event.target == modal) {
      modal.style.display = 'none';
  }
}


//인원수정 팝업
document.addEventListener("DOMContentLoaded", function() {
  var modifyCntPeopleText = document.getElementById("modifyCntPeopleText");
  var editPeoplePopup = document.getElementById("editPeople_popup");
  var closeBtn = document.querySelector(".close-button");
  var savePeopleButton = document.getElementById("savePeopleButton");
  var peopleCountDisplay = document.getElementById("peopleCount");
  var peopleCountInput = document.getElementById("peopleCountInput");

  // Show the popup when "수정" button is clicked
  modifyCntPeopleText.addEventListener("click", function() {
      editPeoplePopup.style.display = "block";
  });

  // Hide the popup when the close button is clicked
  closeBtn.addEventListener("click", function() {
      editPeoplePopup.style.display = "none";
  });

  // Save the new people count and update the display when "저장" button is clicked
  savePeopleButton.addEventListener("click", function() {
      var newPeopleCount = peopleCountInput.value;
      if (newPeopleCount) {
          peopleCountDisplay.textContent = newPeopleCount + "명";
          editPeoplePopup.style.display = "none";
      } else {
          alert("인원 수를 입력하세요.");
      }
  });

  // Hide the popup if the user clicks outside of the popup
  window.addEventListener("click", function(event) {
      if (event.target == editPeoplePopup) {
          editPeoplePopup.style.display = "none";
      }
  });
});


// Close the modal if the user clicks outside of it
window.onclick = function(event) {
  var modal = document.getElementById('editDate_popup');
  if (event.target == modal) {
      modal.style.display = 'none';
  }
}



/* 결제수단 */
function onClickSelect(e) {
  const isActive = e.currentTarget.className.indexOf("active") !== -1;
  if (isActive) {
    e.currentTarget.className = "select";
  } else {
    e.currentTarget.className = "select active";
  }
}
document.querySelector("#theme .select").addEventListener("click", onClickSelect);

function onClickOption(e) {
  const selectedValue = e.currentTarget.innerHTML;
  document.querySelector("#theme .text").innerHTML = selectedValue;
}

var optionList = document.querySelectorAll("#theme .option");
for (var i = 0; i < optionList.length; i++) {
  var option = optionList[i];
  option.addEventListener("click", onClickOption);
}