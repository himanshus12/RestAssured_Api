# Rest Assured API Automation Framework

This project demonstrates a complete API automation framework built using **Rest Assured**, **TestNG**, and the **Page Object Model (POM)** design pattern. It is structured to test RESTful APIs with high maintainability, reusability, and readability.

---

## 🔧 Tech Stack

- **Java 11+**
- **Rest Assured**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **Jackson / Gson (for JSON parsing)**
- **Faker (for generating fake test data)**
- **Extent Reports / Allure (optional for reporting)**

---

## 📁 Project Structure

RestAssured_Api/
│
├── src/main/java/
│ ├── api/endpoints/ # API route definitions
│ ├── api/payload/ # POJOs for request/response payloads
│ ├── api/testcases/ # TestNG test classes
│ ├── api/utils/ # Utility classes (e.g., Faker, ConfigReader)
│ └── api/base/ # Base classes and reusable methods
│
├── src/test/java/ # TestNG test runner or additional test files
│
├── testng.xml # TestNG suite file
├── pom.xml # Maven dependencies
└── README.md # Project documentation



---

## 🚀 Features

- Fully modularized API automation using Page Object Model
- CRUD operations (Create, Read, Update, Delete) for REST endpoints
- Centralized API route management via `Routes.java`
- Dynamic test data generation using Faker library
- Response validation using Rest Assured matchers
- Assertion management via TestNG
- Easily extensible for future APIs and endpoints
- Structured logging and reporting support

---

## 🔄 Supported Operations

The framework currently supports:

- **POST** - Create user
- **GET** - Retrieve user by username
- **PUT** - Update user data
- **DELETE** - Delete user by username

> All operations are tested against `https://petstore.swagger.io/v2/user` using path parameters and payloads.

---

## ✅ How to Run the Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/himanshus12/RestAssured_Api.git
   cd RestAssured_Api
