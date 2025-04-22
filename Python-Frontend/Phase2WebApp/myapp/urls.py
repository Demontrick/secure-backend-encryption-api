from django.urls import path
from . import views

urlpatterns = [
    path('', views.Home, name='home'),
    path('about/', views.About, name='about'),
    path('contact/', views.Contact, name='contact'),
    path('encrypt/', views.Encrypt, name='encrypt'),
    path('login/', views.login_page, name='login_page'),
    path('api/perform_login/', views.perform_login, name='perform_login'),
]
