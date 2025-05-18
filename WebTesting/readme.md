Selenium WebSite Testing for the small html website project **"Cusine In Paradise".**

Automated Testing for Restaurant Management Website using Selenium & TestNG (Java + EdgeDriver + Eclipse)

**Two test script:**
1. Booking functionality on the "Book.html" page.
2. Navigation functionality on the "Contact.html" page.

Used Selenium WebDriver with Microsoft EdgeDriver, integrated with the TestNG testing framework in Java using on the Eclipse IDE.

**Tools and Technologies Used:**

Selenium WebDriver for Browser automation.
EdgeDriver for Driver to automate on Microsoft Edge browser.
TestNG used as Testing framework for test control, grouping, and more.
Eclipse Java IDE for Programming
HTML (local website)

**Test A: Booking Form Validation – "Book.html"**

**Goals:**
- Form validation when fields are left empty.
- Form submission with valid inputs.
- Success alert on valid submission.

**Test 1:**
Open or load the local "Book.html" page on edge browser.
Clicks the Submit Booking button without entering any data.
Verifies that an alert is shown with validation messages.
Uses "Assert.assertTrue()" to ensure expected error message is shown.

**Test 2:**
Fills in valid data for:

  - Name
  - Phone
  - Email
  - Date (future)
  - Time
  - Number of persons (radio button)
  - Booking reason (dropdown)
Clicks submit and verifies a success alert is shown.
Confirms the alert contains "Booking submitted successfully".

**Expected Results:**

Test 1: Should show an alert about missing/invalid fields.
Test 2: Should show success alert and reset the form.


**Test B: Navigation from Contact Page – "Contact.html"**

**Goals:**
- Presence of the "Book Now" button.
- Correct redirection to the "Book.html" page on click.

**Test 1:**
Loads the local "Contact.html" page.
Verifies the presence of a button labeled "Book Now".
Clicks the button.
Waits for the redirection.
Validates that the new page URL ends in "Book.html" using "Assert.assertTrue()".

**Expected Results:**

- Button should be present.
- Clicking it should navigate the user to the booking page.

**Final Outcome**

All validation and navigation functionalities were successfully tested using Selenium + TestNG.
Bugs would be reported automatically through assertion failures.
Automated testing significantly improved reliability and confidence in the web app's behavior.
