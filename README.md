
# API Automation – ReqRes User Management

## 📌 Project Overview

This project demonstrates an **API Automation framework** using **Java, Rest Assured, TestNG**, and **Extent Reports** to validate a **User Management workflow** using the public **ReqRes API**.

The framework executes tests via **TestNG Runner XML** and generates an **HTML Extent Report** that can be opened in any browser.

---

## 🛠 Tools & Technologies

| Tool          | Purpose               |
| ------------- | --------------------- |
| Java          | Programming Language  |
| Rest Assured  | API Automation        |
| TestNG        | Test Framework        |
| Maven         | Dependency Management |
| Extent Report | HTML Test Reporting   |
| IntelliJ IDEA | IDE                   |

---

## 🧪 Test Scenarios Covered

1. **Create User**

   * `POST /users`
   * Capture user ID from response

2. **Update User**

   * `PUT /users/{id}`
   * Update job field

3. **Get User**

   * `GET /users/{id}`
   * Verify updated job

4. **Delete User**

   * `DELETE /users/{id}`

5. **Verify Deletion**

   * `GET /users/{id}`
   * Expect `404 Not Found`

---

## 📂 Project Structure

```
api-automated-task/
│
├── src/test/java
│   ├── base
│   │   ├── BaseTest.java
│   │   ├── ExtentReportManager.java
│   │   └── TestListener.java
│   │
│   └── AAIB_Task.java
│
├── extent-report
│   └── AAIB-report.html
│
├── testng-runner.xml
├── pom.xml
└── README.md
```

---

## ⚙️ How Tests Are Executed

* Tests are executed using **TestNG Runner XML**
* **Extent Report** is generated automatically after execution
* Test execution includes request chaining and assertions

---

## ▶️ How to Run the Tests

### Option 1️⃣ Run Using IntelliJ

1. Open `testng-runner.xml`
2. Right-click → **Run 'testng-runner.xml'**

---


## 📊 Extent Report (HTML)

### 📍 Report Location

```
extent-report/AAIB-report.html
```

### 🔎 How to Open the Report

1. Go to the `extent-report` folder
2. Right-click `AAIB-report.html`
3. **Copy Path**
4. Paste it into **any browser** (Chrome, Edge, Firefox)

✔️ The report opens as a full interactive HTML page

---

## 🔐 Headers Used

All API requests include:

```
Content-Type: application/json
x-api-key: reqres_366d4ca18b4342a2b77789cdbc39e6e0
```

---

## 📈 Reporting Features

* Test execution status (Pass / Fail)
* Step-by-step API flow
* Failure screenshots/logs (if added later)
* Execution time

---


## 👤 Author

**Abdelrhman Tawfik**
Software Test Engineer

---

## ✅ Conclusion

This project demonstrates a **professional, scalable API automation framework** using:

* TestNG Runner XML
* Rest Assured
* Extent HTML Reporting
