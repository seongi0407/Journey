
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('reviewForm').addEventListener('submit', function (event) {
        if (!validateReviewForm()) {
            event.preventDefault(); // 폼 제출 막기
        }
    });
});

function validateReviewForm() {
    const reviewContent = document.getElementById('reviewContent').value;
    const PROFANITY_LIST = ["존나", "18", "씨발", "시발","시팔","씨팔","빠가","개같"];
    const minLength = 10;
    const maxLength = 200;

    // 내용 비었는지 확인
    if (reviewContent == null || reviewContent.trim() === '') {
        alert("내용을 작성해주세요.");
        return false;
    }

    // 욕설 필터링
    for (let profanity of PROFANITY_LIST) {
        if (reviewContent.includes(profanity)) {
            alert("내용에 부적절한 단어가 포함되어 있습니다.");
            return false;
        }
    }

    // 내용 글자수 제한
    if (reviewContent.length < minLength) {
        alert("내용은 10자 이상 작성해주세요.");
        return false;
    }
    if (reviewContent.length > maxLength) {
        alert("내용은 200자 이하로 작성해주세요.");
        return false;
    }

    return true;
}
