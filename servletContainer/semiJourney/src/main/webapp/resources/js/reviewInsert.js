document.addEventListener('DOMContentLoaded', () => {
  const starRatingContainers = document.querySelectorAll('.star-rating');
  
  starRatingContainers.forEach(container => {
    const ratingInputs = container.querySelectorAll('input[type="radio"]');
    const ratingValue = container.nextElementSibling; // Get the next sibling for displaying the rating value
  
    ratingInputs.forEach(input => {
      input.addEventListener('change', () => {
        const selectedValue = input.value;
        ratingValue.textContent = selectedValue;
      });
    });
  });
});
