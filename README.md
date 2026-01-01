# ReqRes API Automation Framework

## 📌 Project Overview

This project demonstrates an **automated API testing framework** for a **User Management workflow** using the public **ReqRes API** ([https://reqres.in/](https://reqres.in/)).

The framework validates the complete API lifecycle:

* Create User
* Update User
* Get User (Verify Update)
* Delete User
* Get User (Verify Deletion)

The solution is designed following **industry best practices** and is suitable for real-world API automation and CI/CD integration.

---

## 🛠 Tools & Technologies Used

| Tool / Technology | Purpose                       |
| ----------------- | ----------------------------- |
| Java              | Programming language          |
| Rest Assured      | API automation library        |
| TestNG            | Test execution & assertions   |
| Maven             | Build & dependency management |
| Allure Report     | Test execution reporting      |
| Git               | Version control               |

---

## 🧪 Test Scenarios Covered

### 1️⃣ Create User

* **Endpoint:** `POST /api/users`
* **Input:** Name & Job
* **Validation:**

  * Status code = 201
  * User ID is generated and stored for further requests

### 2️⃣ Update User

* **Endpoint:** `PUT /api/users/{id}`
* **Validation:**

  * Status code = 200
  * Job updated successfully

### 3️⃣ Get User (Verify Update)

* **Endpoint:** `GET /api/users/{id}`
* **Validation:**

  * Status code = 200
  * Updated job value is returned

### 4️⃣ Delete User

* **Endpoint:** `DELETE /api/users/{id}`
* **Validation:**

  * Status code = 204

### 5️⃣ Get User (Verify Deletion)

* **Endpoint:** `GET /api/users/{id}`
* **Validation:**

  * Status code = 404 (User not found)

> ⚠️ **Note:** ReqRes is a mock API. Some endpoints do not persist data, so validations focus on response contracts rather than real database persistence.

---

## 📂 Project Structure

```
api-automated-task/
│   ├── extent-report
 
├── src/test/java
│   ├── base
│   │   └── Extendreportmanager.java
        └── TestListener.java
│   ├── utils
│   │   └── AAIB-TASK.java
        └── BaseTest.java
│
├── pom.xml
└── README.md
```

---

## ⚙️ Framework Design

### 🔹 BaseTest

* Handles base URI configuration

### 🔹 Test Class

* Uses TestNG priorities to control execution order
* Uses dynamic data (userId) for request chaining
* Assertions validate both HTTP status codes and response content

---

## ▶️ How to Run the Tests

### Prerequisites

* Java 11 or higher
* Maven installed
* Allure CLI installed



## 📊 Test Reporting (Allure)


### Report Includes

* Test execution summary
* Passed / Failed test cases
* Request & response details
* Execution timeline

---

## 🔐 Headers Used

All requests include the following headers:

```
Content-Type: application/json
x-api-key: reqres_366d4ca18b4342a2b77789cdbc39e6e0
```
## 👤 Author

**Abdelrhman Tawfik**
Software Test Engineer (Manual & Automation)
