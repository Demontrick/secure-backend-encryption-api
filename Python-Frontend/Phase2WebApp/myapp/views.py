import requests
from django.shortcuts import render
from .forms import ContactForm, EncryptionForm
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
import json

def Home(request):
    return render(request, 'Home.html')

def About(request):
    return render(request, 'about.html')

def Contact(request):
    if request.method == 'POST':
        form = ContactForm(request.POST)
        if form.is_valid():
            print(form.cleaned_data)  # For now, just print to console
            return render(request, 'contact.html', {'form': form, 'success': 'Thank you for your message!'})
    else:
        form = ContactForm()
    return render(request, 'contact.html', {'form': form})

@csrf_exempt
def Encrypt(request):
    form = EncryptionForm()  # Ensure form is defined before any logic
    if request.method == 'POST':
        form = EncryptionForm(request.POST, request.FILES)
        if form.is_valid():
            text_to_encrypt = form.cleaned_data.get('text', '')
            file_to_encrypt = form.cleaned_data.get('file', None)

            # Debugging prints
            print("Text to Encrypt:", text_to_encrypt)
            print("File to Encrypt:", file_to_encrypt)

            # Prepare data for API call
            data = {'text': text_to_encrypt}
            files = {'file': file_to_encrypt} if file_to_encrypt else None

            java_backend_url = 'http://localhost:8080/api/encrypt'  # Example URL

            try:
                response = requests.post(java_backend_url, data=data, files=files)
                response.raise_for_status()  # Raise HTTPError for bad responses
                try:
                    encrypted_data = response.json().get('encryptedData')
                    print("Encrypted Data:", encrypted_data)  # Debug
                    return render(request, 'encrypt.html', {'form': form, 'encrypted_data': encrypted_data})
                except ValueError as json_err:
                    error_message = f"JSON decode error: {json_err}"
            except requests.exceptions.HTTPError as http_err:
                error_message = f"HTTP error occurred: {http_err}"
            except requests.exceptions.RequestException as err:
                error_message = f"Error occurred: {err}"

            print("Error Message:", error_message)  # Debug
            return render(request, 'encrypt.html', {'form': form, 'error_message': error_message})
    return render(request, 'encrypt.html', {'form': form})

def login_page(request):
    return render(request, 'login.html')

@csrf_exempt
def perform_login(request):
    if request.method == 'POST':
        data = json.loads(request.body)
        username = data.get('username')
        password = data.get('password')
        if username == 'admin' and password == 'admin123':
            return JsonResponse({'message': 'Login successful'})
        else:
            return JsonResponse({'message': 'Login failed'})
    return JsonResponse({'error': 'Invalid method'}, status=400)
