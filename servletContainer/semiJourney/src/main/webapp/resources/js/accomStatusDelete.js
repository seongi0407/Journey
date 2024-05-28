//ChatGpt 

function displayAlertAndChangeStatus(alertMessage, accomId, newStatus) {
    console.log("displayAlertAndChangeStatus 호출됨", alertMessage, accomId, newStatus);

    // 알람 표시
    alert(alertMessage);

    // 특정 상태 변경
    var statusElement = document.getElementById('status-' + accomId);
    console.log("statusElement", statusElement);
    if (statusElement) {
        statusElement.innerText = newStatus;
    }
}

function handleDelete(accomId) {
    var confirmation = confirm('정말로 삭제하시겠습니까?');
    if (confirmation) {
        // AJAX 요청을 사용하여 삭제
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/journey/accom/delete', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                displayAlertAndChangeStatus('삭제되었습니다.', accomId, '삭제');
            }
        };
        xhr.send('no=' + accomId);
    }
}