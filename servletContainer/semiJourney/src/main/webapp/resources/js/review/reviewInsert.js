// 별점 라디오 변화주기
document.addEventListener('DOMContentLoaded', () => {
  const starRatingContainers = document.querySelectorAll('.star-rating');
  
  starRatingContainers.forEach(container => {
    const ratingInputs = container.querySelectorAll('input[type="radio"]');
    const ratingValue = container.nextElementSibling;
  
    ratingInputs.forEach(input => {
      input.addEventListener('change', () => {
        const selectedValue = input.value;
        ratingValue.textContent = selectedValue;
      });
    });
  });
});
