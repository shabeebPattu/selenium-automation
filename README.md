# Selenium Test Automation – Homepage Success Rate Validation

This project automates the testing of a web application's homepage using **Selenium WebDriver** and **TestNG** in Java.  
It focuses on verifying the **Success Rate** displayed on the homepage.

---

## 📌 Project Overview
The test script:
- Navigates to the homepage
- Retrieves the **Success Rate** message
- Extracts the percentage value
- Validates that it matches the expected range

This project is built using the **Page Object Model (POM)** for better maintainability.

---

## 📂 Project Structure
├── src
│ ├── main
│ │ └── java
│ │ └── pages
│ │ └── HomePage.java # Page class for homepage interactions
│ ├── test
│ │ └── java
│ │ └── tests
│ │ └── HomeTest.java # Test class for homepage success rate
├── pom.xml # Maven dependencies
└── README.md # Project documentation


---

## ⚙️ Technologies Used
- **Java 17** (or your installed version)
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **GitHub** for version control

---

## 🚀 Setup & Execution

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/YourUsername/YourRepoName.git
cd YourRepoName

mvn clean install

mvn test

📄 Sample Code Snippets
HomeTest.java
@Test
public void validateSuccessRate() {
    String successRateMessage = homePage.getSuccessRateMessage();
    int successRate = homePage.extractPercentage(successRateMessage);
    Assert.assertTrue(successRate >= 0 && successRate <= 100,
        "Success rate is out of expected range.");
}
HomePage.java
public String getSuccessRateMessage() {
    return driver.findElement(successRateLocator).getText();
}

public int extractPercentage(String message) {
    return Integer.parseInt(message.replaceAll("[^0-9]", ""));
}
Your Name – Mohammad Shabeeb BT
📧 Email: mohammedshabeeb1235@gmail.com
