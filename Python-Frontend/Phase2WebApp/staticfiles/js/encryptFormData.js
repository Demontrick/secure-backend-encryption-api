function encryptTextAsFormData(event) {
    event.preventDefault();

    const textInput = document.getElementById('textInput').value;
    const choiceElement = document.querySelector('input[name="choice"]:checked');
    if (!choiceElement) {
        console.error('No choice selected.');
        return;
    }
    const choiceValue = choiceElement.value;

    const payload = new FormData();
    payload.append("text", textInput);
    payload.append("choice", choiceValue);

    const fileInput = document.getElementById('fileInput').files[0];
    if (fileInput) {
        payload.append("file", fileInput);
    }

    fetch('http://localhost:8080/api/encrypt', {
        method: 'POST',
        body: payload,  // No need to set Content-Type header for FormData; the browser handles it
        credentials: 'include'  // Include credentials if needed
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        console.log('Encrypted Data:', data.encryptedData);
        document.getElementById('encryptedOutput').innerText = data.encryptedData;  // Display the result
    })
    .catch(error => console.error('Error:', error));
}
