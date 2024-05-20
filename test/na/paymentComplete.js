document.querySelector('#nextBtn').addEventListener('click', function() {
  // Change background color
  document.body.style.backgroundColor = '#ffd147';
  // Change text
  document.querySelector('#rsvCompleteText').innerHTML = 
    '<h1>여행정보를 공유하세요</h1><h6>모든 일행에게 체크인 정보 및 호스트와</h6><h6>주고받은 모든 메시지를 확인할 수 있는 권한을</h6><h6>부여하세요</h6>';
  // Set margin to 0
  document.querySelector('#rsvCompleteText').style.margin = '0';

  const section = document.querySelector("#section");
  section.classList.add("flipped");
    setTimeout(() => {
      section.classList.remove("flipped");
    }, 2000);
});




// document.addEventListener('DOMContentLoaded', () => {

//   const cards = document.querySelectorAll("#section")
//   for(const card of cards) {
//     card.addEventListener("click", flipper)
//   }
  
//     function flipper (event) {
//       const target = event.currentTarget
//       target.style.transform = "rotateY(0deg)"
//       target.addEventListener("click", innerFlipper)
//     }

//     function innerFlipper (event) {
//       const target = event.currentTarget
//       target.style.transform = "rotateY(0deg)"
//       target.addEventListener("click", flipper)
//       target.removeEventListener("click", innerFlipper)
//     }
// })

document.addEventListener('DOMContentLoaded', () => {
  const section = document.querySelector("#section");

  section.addEventListener("click", () => {
    section.classList.add("flipped");
    setTimeout(() => {
      section.classList.remove("flipped");
    }, 3000);
  });
});