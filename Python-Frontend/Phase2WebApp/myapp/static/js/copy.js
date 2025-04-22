function copyToClipboard() {
    const encryptedOutput = document.getElementById('encryptedOutput').innerText;
    navigator.clipboard.writeText(encryptedOutput).then(() => {
        alert('Encrypted data copied to clipboard!');
    }).catch(err => {
        console.error('Failed to copy text: ', err);
    });
}
