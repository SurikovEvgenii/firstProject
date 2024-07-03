function applyEmailMask(emailInput) {
    emailInput.addEventListener('input', function (e) {
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailPattern.test(emailInput.value)) {
            emailInput.setCustomValidity('Please enter a valid email address.');
        } else {
            emailInput.setCustomValidity('');
        }
    });
}

function applyTelMask(telInput) {
    telInput.addEventListener('input', function (e) {
        let cleaned = telInput.value.replace(/\D/g, '');
        let formatted = '+7 ';

        if (cleaned.length > 1) {
            formatted += '(' + cleaned.substring(1, 4);
        }
        if (cleaned.length >= 5) {
            formatted += ') ' + cleaned.substring(4, 7);
        }
        if (cleaned.length >= 8) {
            formatted += '-' + cleaned.substring(7, 9);
        }
        if (cleaned.length >= 10) {
            formatted += '-' + cleaned.substring(9, 11);
        }

        telInput.value = formatted;
    });
}

// Применение масок для первой формы
applyEmailMask(document.getElementById('email-user'));
applyTelMask(document.getElementById('tel-user'));

// Применение масок для второй формы
applyEmailMask(document.getElementById('email-designer'));
applyTelMask(document.getElementById('tel-designer'));