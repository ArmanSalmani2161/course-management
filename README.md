# 📚 Course Management System

## 📝 Overview
The **Course Management System** is a full-stack web application built with **Spring Boot**, **PostgreSQL**, and **Angular**.  
It provides a secure, role-based platform where administrators can manage courses, managers can approve users, and students can browse/enroll in courses.

## ✨ Features
- **Course Management (CRUD)**
  - Add, update, delete, and view courses.
  - Course attributes: *Course ID, Name, Instructor, Duration, Fee, Type (Online/Offline/Hybrid)*.

- **Role-Based Access Control (RBAC)**
  - **Admin** → Full course management (Add/Update/Delete/View).
  - **Manager** → Approve/reject newly registered users.
  - **Student** → Browse and enroll in courses.

- **Authentication & Security**
  - JWT-based authentication.
  - Login API returns token with user role info.
  - Protected REST APIs accessible only with valid JWT.

- **Frontend (Angular)**
  - Login & Registration forms.
  - Role-based UI (e.g., Admin sees Add/Delete buttons, Students see Enroll option).
  - Dynamic course listing.

## 🛠️ Tech Stack
- **Backend**: Spring Boot (Spring Data JPA, Spring Security, JWT)  
- **Frontend**: Angular  
- **Database**: PostgreSQL  
- **Authentication**: JSON Web Token (JWT)  
- **Build Tools**: Maven, npm  

## ⚙️ Installation & Setup

### 🔹 Backend (Spring Boot)
1. Clone the repository:
   ```bash
   git clone https://github.com/ArmanSalmani2161/course-management.git
   cd course-management
