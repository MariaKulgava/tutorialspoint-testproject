# TutorialsPoint Testing Framework

This project is a basic automated testing framework designed to test the TutorialsPoint website: https://www.tutorialspoint.com/


It is built using Selenide with the Page Object Model, including:

- **Driver Manager:** Includes centralized WebDriver setup (Chrome, FireFox).
- **Utility Classes:** Uses for reusable functions.
- **Test Data Sources:** Supports using dynamic test data via JSON and config files.
- **Custom Logging:** Configured with Log4j for enhanced debugging and reporting.
- **Cross-Browser Testing:** Allows browser selection via configuration.

---

## **Environment**
> **Maven**: <em>3.9.2</em><br/>
> **Java**: <em>18 or higher</em><br/>
> **IDE**: <em>IntelliJ IDEA 2023.2.4(Community Edition)</em><br/>

## **Frameworks/Libraries**
> **Selenide**: <em>7.5.1 - Web Driver</em><br/>
> **TestNg**: <em>1.7.2 - Testing Framework</em><br/>
> **Apache Log4j Core**: <em>2.24.3 - Logging Frameworks</em><br/>
> **Apache Log4j API**: <em>2.24.3 - Logging Frameworks</em><br/>
> **Jackson Databind**: <em>2.17.2 - JSON Libraries</em><br/>

---

## Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/MariaKulgava/tutorialspoint-testproject.git
   ```

2. Update configuration:
    - Modify `src/test/resources/properties/config.properties` to set your desired configuration values, such as `browser`, and `timeout`.

---

## Running Tests

1. Run all tests:

   ```bash
   mvn test
   ```

2. Run a specific test suite:

   ```bash
   mvn test -DsuiteXmlFile=src/test/resources/runner/testng.xml
   ```

---

## Project Structure

### **Key Directories and Files**

- **`src/test/java`**:
   - `runner`:
      - `DriverManager.java`: Configures the browser and framework settings.
      - `BaseRunner.java`: Handles test setup and teardown operations.
   - `pageobject`:
      - `BasePage.java`: Provides common actions like navigation and assertions.
      - `components`:
         - Modular components for reusable UI elements.
      - `pages`:
         - `HomePage.java` and `UnixTutorialPage.java`: Page Object classes for specific pages.
   - `tests`:
      - Contains test classes like `UnixNavigationTest`.
   - `utils`:
      - Utilities for reading properties and JSON test data.

- **`src/test/resources`**:
   - **`properties/config.properties`**:
      - Stores configuration settings.
   - **`files/testdata.json`**:
      - Sample test data for parameterized testing.
   - **`log4j2.xml`**:
      - Log4j configuration file.
   - **`runner/testng.xml`**:
      - TestNG suite configuration file.

---
