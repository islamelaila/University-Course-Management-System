# 🎓 University Course Management System

A **Spring Boot** project designed to manage **students**, **courses**, and **instructors**, implementing relationships using **Spring Data JPA** and **Oracle Database**.

---

## 🚀 Tech Stack

- **Spring Boot** (Web, Data JPA)  
- **Oracle Database**  
- **Lombok** *(optional for boilerplate reduction)*  
- **Java 17+**

---

## 🧩 Project Overview

The system provides APIs to manage **Students**, **Courses**, and **Instructors**, including their relationships.

### 🔗 Relationships
- **Student ↔ Course** → Many-to-Many  
- **Course ↔ Instructor** → Many-to-One  
- **Instructor ↔ Course** → One-to-Many  

---

## 📦 Entities

### 🧑‍🎓 Student
| Field | Type | Description |
|--------|------|-------------|
| `id` | Long | Unique student ID |
| `name` | String | Student name |
| `email` | String | Student email |

**Relations:**
- Can register in **many courses** (Many-to-Many)

---

### 📚 Course
| Field | Type | Description |
|--------|------|-------------|
| `id` | Long | Unique course ID |
| `title` | String | Course title |
| `description` | String | Course description |

**Relations:**
- Can have **many students** (Many-to-Many with Student)  
- Is taught by **one instructor** (Many-to-One)

---

### 👨‍🏫 Instructor
| Field | Type | Description |
|--------|------|-------------|
| `id` | Long | Unique instructor ID |
| `name` | String | Instructor name |
| `email` | String | Instructor email |

**Relations:**
- Can teach **many courses** (One-to-Many)

---

## 🗃️ Repositories

- `StudentRepository`
- `CourseRepository`
- `InstructorRepository`

Each extends `JpaRepository<>` for CRUD and query operations.

---

## 🌐 API Endpoints

### 🧑‍🎓 Student APIs

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `POST` | `/api/students` | Create a new student |
| `GET` | `/api/students` | Get all students |
| `GET` | `/api/students/{id}` | Get student by ID (with enrolled courses & instructors) |
| `POST` | `/api/students/{studentId}/register/{courseId}` | Register a student to a course |

---

### 📚 Course APIs

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `POST` | `/api/courses` | Create a new course |
| `GET` | `/api/courses` | Get all courses |
| `GET` | `/api/courses/{id}` | Get course details (with instructor & enrolled students) |
| `POST` | `/api/courses/{courseId}/assign/{instructorId}` | Assign an instructor to a course |

---

### 👨‍🏫 Instructor APIs

| Method | Endpoint | Description |
|---------|-----------|-------------|
| `POST` | `/api/instructors` | Create a new instructor |
| `GET` | `/api/instructors` | Get all instructors |
| `GET` | `/api/instructors/{id}` | Get instructor details (with taught courses & enrolled students) |

---

## 🧠 API Specifications

### 🔹 Get Student by ID
**Method:** `GET`  
**Endpoint:** `/api/students/{id}`  
**Description:** Returns student info + enrolled courses + instructor info.

---

### 🔹 Get Course by ID
**Method:** `GET`  
**Endpoint:** `/api/courses/{id}`  
**Description:** Returns course info + instructor info + enrolled students.

---

### 🔹 Get Instructor by ID
**Method:** `GET`  
**Endpoint:** `/api/instructors/{id}`  
**Description:** Returns instructor info + taught courses + enrolled students per course.

---

## 🧰 Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/university-course-management.git
   cd university-course-management
   ```

2. Configure the **Oracle Database** connection in  
   `src/main/resources/application.properties`

   ```properties
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Run the project:
   ```bash
   mvn spring-boot:run
   ```

4. Access APIs via:
   ```
   http://localhost:8080/api/students
   http://localhost:8080/api/courses
   http://localhost:8080/api/instructors
   ```

---

## 🏗️ Future Enhancements
- Add pagination and sorting   
- Implement authentication and authorization (JWT)

---

## 🧑‍💻 Author
**Islam elaila**  
Java Backend Developer | Spring Boot Enthusiast  
