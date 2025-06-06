📌 **Project Overview**

**Title:** Automated Functional Testing for "Online Food Delivery" Web Application

**Tech Stack:**

* **Frontend:** HTML, CSS, JavaScript
* **Testing Tools:** Java, Selenium WebDriver, TestNG
* **Browser:** Microsoft Edge (via EdgeDriver)
* **IDE:** Eclipse

---

### 🎯 **Testing Goals**

1. **Verify UI image display bug on home page**

   * Test whether background images (`Veg.jpg` and `Non-veg.jpg`) are correctly displayed on `Home.html`.
   * Identify visual/DOM-related bugs by checking image rendering.

2. **Validate cart count functionality**

   * Test that when an item is added to the cart, the navbar reflects the correct number of items.
   * Ensure cart logic (JavaScript + localStorage) is working as expected.

---

### ✅ **Test Case 1: Background Image Visibility Test**

**Purpose:**
To confirm whether the two promotional images meant for display on the sides of the homepage are visible or not.

**Logic Implemented:**

* Open the `Home.html` using Selenium WebDriver.
* Use XPath to locate `Veg.jpg` and `Non-veg.jpg` images.
* Use `isDisplayed()` method to confirm visibility.
* If images are missing or not rendered, print an error message and fail the test.

**Outcome:**

* If both images are present and displayed ➜ **Test passes.**
* If any image is not in DOM or hidden ➜ **Error logged, test fails.**

---

### ✅ **Test Case 2: Cart Count Update Verification**

**Purpose:**
To ensure the item count in the cart shown in the navbar updates correctly after a user adds an item.

**Logic Implemented:**

* Navigate to any menu page (e.g., `Menu_SpiceHub.html`).
* Click the "Add" button for a food item.
* Navigate to `Home.html`.
* Verify that the cart count (`#cart-count` span) reflects the added item using localStorage-based data.

**Outcome:**

* If count updates correctly ➜ **Test passes.**
* If count does not update ➜ **Test fails, indicating logic/UI sync issue.**
