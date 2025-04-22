from django import forms

class ContactForm(forms.Form):
    name = forms.CharField(label='Your Name', max_length=100)
    email = forms.EmailField(label='Your Email')
    message = forms.CharField(widget=forms.Textarea, label='Your Message')

class EncryptionForm(forms.Form):
    text = forms.CharField(label='Text to Encrypt', widget=forms.Textarea, required=False)
    file = forms.FileField(label='File to Encrypt', required=False)
