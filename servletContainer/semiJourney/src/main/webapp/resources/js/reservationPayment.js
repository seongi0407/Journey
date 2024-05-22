//팝업 띄우기
function openPop() {
  document.getElementById("popup_layer").style.display = "block";

}
//팝업 닫기
function closePop() {
  document.getElementById("popup_layer").style.display = "none";
}

/* 셀렉트박스 */
function onClickSelect(e) {
  const isActive = e.currentTarget.className.indexOf("active") !== -1;
  if (isActive) {
    e.currentTarget.className = "select";
  } else {
    e.currentTarget.className = "select active";
  }
}