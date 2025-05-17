// cart.js

function getCart() {
  return JSON.parse(localStorage.getItem('cart')) || [];
}

function saveCart(cart) {
  localStorage.setItem('cart', JSON.stringify(cart));
  updateCartCount();
}

function addToCart(name, price) {
  let cart = getCart();
  const existingItem = cart.find(item => item.name === name);
  if (existingItem) {
    existingItem.qty += 1;
  } else {
    cart.push({ name, price, qty: 1 });
  }
  saveCart(cart);
  alert(`${name} added to cart`);
}

function updateCartCount() {
  const cart = getCart();
  const count = cart.reduce((acc, item) => acc + item.qty, 0);
  const cartCountEls = document.querySelectorAll('#cart-count');
  cartCountEls.forEach(el => el.textContent = count);
}

// Initialize cart count on page load
document.addEventListener('DOMContentLoaded', updateCartCount);
