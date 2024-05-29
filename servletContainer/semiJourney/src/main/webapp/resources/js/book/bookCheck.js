document.addEventListener('DOMContentLoaded', () => {
    const section = document.getElementById('section');

    section.addEventListener('click', () => {
        section.classList.toggle('flipped');
    });

    document.querySelector('#nextBtn').addEventListener('click', function() {
        // Change background color
        document.body.style.backgroundColor = '#ffd147';
        // Change text
        document.querySelector('#rsvCompleteText').innerHTML = 
            '<h1>여행정보를 공유하세요</h1><h6>모든 일행에게 체크인 정보 및 호스트와</h6><h6>주고받은 모든 메시지를 확인할 수 있는 권한을</h6><h6>부여하세요</h6>';
        // Set margin to 0
        document.querySelector('#rsvCompleteText').style.margin = '0';

        // Flip the card
        section.classList.add("flipped");
        setTimeout(() => {
            section.classList.remove("flipped");
        }, 2000);
    });
});
