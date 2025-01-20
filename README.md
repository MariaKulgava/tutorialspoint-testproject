# TutorialsPoint Testing Framework

This project is a modular automation testing framework designed to test the TutorialsPoint website. It is built using **Java**, **TestNG**, and **Selenide**, with additional tools for logging, configuration management, and data-driven testing.

---

## Features

- **Modular Design:** Includes reusable components for easy scalability.
- **Selenide Integration:** Simplifies browser interactions.
- **Data-Driven Testing:** Supports test parameterization using JSON.
- **Custom Logging:** Configured with Log4j for enhanced debugging and reporting.
- **Cross-Browser Testing:** Allows browser selection via configuration.

---

## Prerequisites

Ensure you have the following installed:

- **Java Development Kit (JDK)** 18 or higher
- **Maven** 3.8+
- A web browser (e.g., Chrome) with matching WebDriver installed

---

## Setup Instructions

1. Clone the repository:

   ```bash
   git clone <repository_url>
   cd tutorialspoint-project
   ```

2. Update configuration:
    - Modify `src/test/resources/properties/config.properties` to set your desired configuration values, such as `baseUrl`, `timeout`, and `browser`.

3. Install dependencies:

   ```bash
   mvn clean install
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

## Writing Tests

To add a new test:

1. Create a Page Object for the new page (if required) in `pageobject/pages`.
2. Add reusable components to `pageobject/components`.
3. Add a test class under `tests`.
4. Update or add test data in `src/test/resources/files/testdata.json`.
5. Define test methods using TestNG annotations like `@Test`.

Example:

```java
@Test
public void exampleTest() {
    homePage.assertHomePageTitle();
    headerShowComponent.navigateToSubcategory("DevOps", "Unix");
    unixTutorialPage.assertUnixTutorialPageHeader();
}
```

---

## Framework Documentation

### **Framework Components**

1. **DriverManager**
    - Manages browser setup and configurations.
    - Reads settings from `config.properties`.

2. **BasePage**
    - Contains common actions (e.g., navigation, click, assertions).

3. **Custom Components**
    - Encapsulates reusable UI elements like headers or menus.

4. **Test Classes**
    - Implements test cases using the Page Object Model (POM).

5. **LoggerUtil**
    - Provides custom logging methods for better debugging.

6. **Test Data Reader**
    - Supports property files and JSON for configuration and test data.

---

## Test Execution Workflow

1. **Before Suite:**
    - Initializes browser configuration using `DriverManager.setupDriver()`.

2. **Before Method:**
    - Prepares the test environment and logs the start of each test.

3. **Test Execution:**
    - Executes test steps defined in the test methods.

4. **After Method:**
    - Logs the completion of each test.

5. **After Suite:**
    - Cleans up and logs suite completion.

---

## Troubleshooting

- **Failed to load configuration:** Ensure `config.properties` is correctly set and accessible.
- **Browser not launching:** Verify the browser and driver versions match.
- **Test failures:** Check logs generated in the console for debugging.

---

## License

This project is licensed under the MIT License. Feel free to use and modify it as needed.

