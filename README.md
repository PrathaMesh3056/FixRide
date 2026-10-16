# 🚗 FixRide - Vehicle Service Booking System

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A modern, full-stack vehicle service and repair appointment booking platform built with **Spring Boot 3**, **Spring Data JPA**, **Thymeleaf**, and **MySQL**.

---

## 📌 Table of Contents

* [About The Project](#about-the-project)
* [Key Features](#key-features)
* [Tech Stack](#tech-stack)
* [System Architecture](#system-architecture)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Database Setup](#database-setup)
  * [Configuration](#configuration)
  * [Running the Application](#running-the-application)
* [Application Routes & Pages](#application-routes--pages)
* [REST API Documentation](#rest-api-documentation)
* [Project Structure](#project-structure)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)

---

## 📖 About The Project

**FixRide** streamlines the vehicle maintenance process for both vehicle owners and service centers. Vehicle owners can schedule maintenance visits in seconds and track the real-time progress of their repair jobs. Service center administrators have a centralized, interactive dashboard to manage appointments, update repair stages, and organize garage workflow.

---

## ✨ Key Features

- **⚡ Instant Service Booking**: Customers can schedule a service appointment with their vehicle details and preferred date without complicated sign-up steps.
- **📡 Real-Time Status Tracking**: Look up active and past bookings by customer name to check current repair status (`Booked`, `In Progress`, `Completed`, `Cancelled`).
- **📊 Admin Dashboard**:
  - Live metric summary cards (Total Bookings, Booked, In Progress, Completed).
  - Search and filter records by customer name, vehicle registration number, or status.
  - In-place status updates with immediate feedback.
  - Secure deletion of completed/cancelled records.
- **🎨 Modern Responsive UI**: Sleek, accessible design styled with custom CSS, responsive navigation, status badge indicators, and dynamic feedback dialogs.
- **🔌 RESTful Architecture**: Exposes well-structured REST endpoints supporting JSON and form data.

---

## 🛠️ Tech Stack

- **Backend**: Java 21, Spring Boot 3.5.3
  - Spring Web MVC
  - Spring Data JPA (Hibernate)
- **Frontend**: HTML5, Vanilla CSS3 (Custom Design System with Plus Jakarta Sans), JavaScript (Fetch API), Thymeleaf Template Engine
- **Database**: MySQL
- **Build & Dependency Management**: Apache Maven

---

## 🚀 Getting Started

### Prerequisites

Ensure you have installed:
- **Java Development Kit (JDK 21 or higher)**
- **MySQL Server (8.0+)**
- **Git**
- *(Optional)* Apache Maven (a Maven wrapper `mvnw` is included in the project)

---

### Database Setup

1. Open your MySQL terminal or workbench:
   ```sql
   CREATE DATABASE VSBSProject;
   ```
2. The application is configured with `spring.jpa.hibernate.ddl-auto=update`, which will automatically create the required database tables upon startup.

---

### Configuration

Open `src/main/resources/application.properties` and verify your MySQL credentials and server port:

```properties
spring.application.name=VehicleServiceBookingSystem

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/VSBSProject
spring.datasource.username=root
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Server Port
server.port=1001
```

---

### Running the Application

1. **Clone the repository:**
   ```bash
   git clone https://github.com/PrathaMesh3056/FixRide.git
   cd FixRide
   ```

2. **Build and Run:**
   - **Using Maven Wrapper (Windows):**
     ```cmd
     mvnw.cmd spring-boot:run
     ```
   - **Using Maven Wrapper (Linux / macOS):**
     ```bash
     ./mvnw spring-boot:run
     ```
   - **Or with installed Maven:**
     ```bash
     mvn spring-boot:run
     ```

3. **Access the application in your browser:**
   ```
   http://localhost:1001/
   ```

---

## 🌐 Application Routes & Pages

| Page | URL Path | Description |
| :--- | :--- | :--- |
| **Home** | `http://localhost:1001/` | Landing page with service highlights and quick access buttons |
| **Book Service** | `http://localhost:1001/book` | Interactive service booking form with instant confirmation receipt |
| **Track Status** | `http://localhost:1001/status` | Search and monitor repair status by customer name |
| **Admin Dashboard** | `http://localhost:1001/admin-dashboard` | Administrative management console with metrics and status controls |

---

## 🔌 REST API Documentation

### User Endpoints (`/user`)
| Method | Endpoint | Description | Payload / Parameters |
| :--- | :--- | :--- | :--- |
| `POST` | `/user/book` | Book a vehicle service appointment | JSON body or Form data (`customerName`, `vehicleNumber`, `bookingDate`) |
| `GET` | `/user/mybookings` | Get bookings for a specific customer | Query param: `?customerName={name}` or `?name={name}` |

### Admin Endpoints (`/admin`)
| Method | Endpoint | Description | Payload / Parameters |
| :--- | :--- | :--- | :--- |
| `GET` | `/admin/all` | Retrieve all service bookings | None |
| `PUT` | `/admin/updateStatus/{id}` | Update booking status | Path param `id`, Query param `?status={status}` |
| `DELETE` | `/admin/delete/{id}` | Remove a booking record | Path param `id` |

---

## 📁 Project Structure

```
FixRide/
├── .mvn/wrapper/               # Maven wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/com/vsbs/project/
│   │   │   ├── VechileServiceBookingSystemApplication.java  # Main Spring Boot entry point
│   │   │   ├── controller/
│   │   │   │   ├── AdminController.java                     # REST Controller for admin operations
│   │   │   │   ├── BookingController.java                   # REST Controller for booking & lookup
│   │   │   │   └── ViewController.java                      # Thymeleaf page route mappings
│   │   │   ├── entities/
│   │   │   │   └── Booking.java                             # JPA Entity mapping table 'booking'
│   │   │   ├── repository/
│   │   │   │   └── BookingRepository.java                   # Spring Data JPA repository
│   │   │   └── service/
│   │   │       └── BookingService.java                      # Business logic layer
│   │   └── resources/
│   │       ├── application.properties                       # App & DB configuration
│   │       ├── static/
│   │       │   ├── images/                                  # Static media assets
│   │       │   └── style.css                                # Design system & responsive styles
│   │       └── templates/
│   │           ├── index.html                               # Home page
│   │           ├── book.html                                # Booking page
│   │           ├── status.html                              # Status tracker page
│   │           └── admin-dashboard.html                     # Admin management console
│   └── test/
│       └── java/com/vsbs/project/
│           └── VechileServiceBookingSystemApplicationTests.java
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml                                                  # Maven dependencies
├── LICENSE                                                  # MIT License
└── README.md
```

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

Distributed under the **MIT License**. See [`LICENSE`](LICENSE) for more details.

---

## 📬 Contact

- **Author**: Prathamesh Patil
- **GitHub**: [@PrathaMesh3056](https://github.com/PrathaMesh3056)
- **Email**: [prathameshpatil300804@gmail.com](mailto:prathameshpatil300804@gmail.com)
- **Project Link**: [https://github.com/PrathaMesh3056/FixRide](https://github.com/PrathaMesh3056/FixRide)
