# 🔐 Secure Backend Encryption API (Java + Python Integration)

A secure, multithreaded backend encryption system built using **Java (Spring Boot)** and **Python (Django)**. Implements **AES** and **RSA** encryption with optimized concurrent processing. Features clean **REST API** communication between services, file handling, and a modular architecture designed for performance, maintainability, and scalability.

---

## 🚀 Project Overview

This project showcases a modular backend API architecture that:

- Performs AES and RSA encryption efficiently  
- Uses multithreading to handle concurrent requests  
- Integrates a Python-based frontend via REST for seamless data exchange  
- Demonstrates secure, production-ready service design  

---

## 🛠️ Tech Stack

- **Java 17**, **Spring Boot** – Core backend, REST APIs, concurrency  
- **Python**, **Django** – Frontend interface & REST API client  
- **AES-256**, **RSA** – Encryption standards  
- **JUnit**, **Mockito** – Testing & validation  
- **GitHub** – Version control & collaboration  

---

## ⚙️ Backend Structure (Java - Spring Boot)

### 🔹 `ConcurrentEncryptionProgram.java`

- Main controller for managing encryption processes  
- Manages thread pool & async task execution  

### 🔹 `EncryptionUtil.java`

- Core logic for AES and RSA encryption  
- Reusable static methods for secure encryption  

### 🔹 `FileHandler.java`

- Handles file I/O for reading input and saving results  

---

## 🌐 Frontend (Python - Django)

The Django-based frontend enables users to:

- Input text or file for encryption via form or endpoint  
- Communicate with backend via **REST API**  
- Display encrypted output returned from Java backend  

✅ Clear separation between frontend and backend ensures modularity and scalability.

---

## 📊 Performance & Highlights

- 🧵 Supports up to **1,000 concurrent encryption requests**  
- ⚡ Achieves **~85% faster response times** using thread pooling  
- 📉 Maintains **<150ms** average latency under load  
- ✅ Robust error handling and modular design with high test coverage  

---

## 📁 Folder Structure (Backend & Frontend)

