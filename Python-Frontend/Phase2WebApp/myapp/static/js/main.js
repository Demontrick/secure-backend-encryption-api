document.addEventListener('DOMContentLoaded', function() {
    console.log('Hello, Django!');

    const encryptButton = document.getElementById('encryptButton');
    const encryptForm = document.getElementById('encryptForm');

    if (encryptButton) {
        encryptButton.addEventListener('click', function(event) {
            event.preventDefault(); // Prevent any default action
            encryptTextAsFormData(event); // Call the encryption function
        });
    } else {
        console.error('Button with ID "encryptButton" not found.');
    }

    const copyButton = document.getElementById('copyButton');
    if (copyButton) {
        copyButton.addEventListener('click', copyToClipboard);
    } else {
        console.error('Button with ID "copyButton" not found.');
    }
});
