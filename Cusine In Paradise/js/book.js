document.addEventListener('DOMContentLoaded', function() {
    const bookingForm = document.getElementById('bookingForm');

    if (bookingForm) {
        bookingForm.addEventListener('submit', function(event) {
            // Prevent default form submission to handle validation
            event.preventDefault();

            let isValid = true;
            const messages = [];

            // Get form elements
            const nameInput = document.getElementById('name');
            const phoneInput = document.getElementById('phone');
            const emailInput = document.getElementById('email');
            const dateInput = document.getElementById('date');
            const timeInput = document.getElementById('time');
            const personsRadios = document.querySelectorAll('input[name="persons"]');

            // Validate Name
            if (nameInput.value.trim() === '') {
                isValid = false;
                messages.push('Please enter your name.');
                nameInput.classList.add('error'); // Add error class for styling
            } else {
                nameInput.classList.remove('error');
            }

            // Validate Phone Number
            const phonePattern = /^[0-9]{10}$/; // Assumes 10-digit Indian phone number
            if (!phonePattern.test(phoneInput.value)) {
                isValid = false;
                messages.push('Please enter a valid 10-digit phone number.');
                phoneInput.classList.add('error');
            } else {
                phoneInput.classList.remove('error');
            }

            // Validate Email
            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(emailInput.value)) {
                isValid = false;
                messages.push('Please enter a valid email address.');
                emailInput.classList.add('error');
            } else {
                emailInput.classList.remove('error');
            }

            // Validate Date (ensure it's not in the past)
            const today = new Date();
            today.setHours(0, 0, 0, 0); // Reset time for comparison
            const selectedDate = new Date(dateInput.value);
            selectedDate.setHours(0, 0, 0, 0);

            if (dateInput.value === '') {
                isValid = false;
                messages.push('Please select a booking date.');
                dateInput.classList.add('error');
            } else if (selectedDate < today) {
                isValid = false;
                messages.push('Booking date cannot be in the past.');
                dateInput.classList.add('error');
            } else {
                dateInput.classList.remove('error');
            }

            // Validate Time
            if (timeInput.value.trim() === '') {
                isValid = false;
                messages.push('Please select a booking time.');
                timeInput.classList.add('error');
            } else {
                timeInput.classList.remove('error');
            }

            // Validate Number of Persons (at least one radio button selected)
            let personsSelected = false;
            for (const radio of personsRadios) {
                if (radio.checked) {
                    personsSelected = true;
                    break;
                }
            }
            if (!personsSelected) {
                isValid = false;
                messages.push('Please select the number of persons.');
                // You might want to style the radio group container if no selection
                document.getElementById('num-persons').classList.add('error-border');
            } else {
                document.getElementById('num-persons').classList.remove('error-border');
            }

            // If all validations pass
            if (isValid) {
                alert('Booking submitted successfully!\n\nDetails:\n' +
                      'Name: ' + nameInput.value + '\n' +
                      'Phone: ' + phoneInput.value + '\n' +
                      'Email: ' + emailInput.value + '\n' +
                      'Date: ' + dateInput.value + '\n' +
                      'Time: ' + timeInput.value + '\n' +
                      'Persons: ' + document.querySelector('input[name="persons"]:checked').value + '\n' +
                      'Booking For: ' + document.getElementById('booking-for').value);

                // In a real application, you would send this data to a server
                // For this project, you can redirect or reset the form
                bookingForm.reset(); // Clear the form
                window.location.href = 'Home.html'; // Redirect to home page
            } else {
                // Display validation messages
                alert('Please correct the following errors:\n\n' + messages.join('\n'));
            }
        });
    }
});