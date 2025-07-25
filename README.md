# UI Automation Project

This repository contains UI automation tests written in Java using Selenium WebDriver and TestNG.

---

## 1. Prerequisites

* **Java 17** or newer (`java -version` to check).  
* **Git** (to clone the project).  
* **Chrome** and/or **Firefox** browser installed locally.  
  WebDriver binaries are managed automatically by **WebDriverManager**, so no manual driver setup is required if you have an active internet connection on the first run.

> **NOTE** : On macOSÅ]ARM (Apple Silicon) you may need Chrome ? 87 or Firefox ? 83.

---

## 2. Project Structure (high-level)

```
Ñ•ÑüÑü build.gradle / pom.xml   # Gradle & Maven build files
Ñ•ÑüÑü src
Ñ†   Ñ•ÑüÑü main/java           # Page objects & utilities
Ñ†   Ñ§ÑüÑü test/java           # Test classes (TestNG)
Ñ•ÑüÑü src/test/resources
Ñ†   Ñ§ÑüÑü testng.xml          # TestNG suite definition
Ñ§ÑüÑü build/ or target/       # Compiled classes, reports, allure-results, Åc
```

---

## 3. Build & Run with **Gradle** (recommended)

Gradle Wrapper is committed, so **_no local Gradle installation is required_**.

```bash
# ? Linux / ? macOS / ? Git-Bash
./gradlew clean test
```

The command will:
1. Resolve dependencies (`mavenCentral`).
2. Compile main & test sources.
3. Execute all TestNG tests defined in `testng.xml`.
4. Generate a HTML report under `build/reports/tests/test/index.html`.

### Run a single test class or method

```bash
./gradlew test --tests "tests.LoginTest"
# or a single method
./gradlew test --tests "tests.LoginTest.tc01_screenInitializesCorrectly"
```

---

## 4. Build & Run with **Maven**

If you prefer Maven:

```bash
mvn clean test
```

The `maven-surefire-plugin` is configured to use `testng.xml` and will drop test results under `target/surefire-reports`.

---

## 5. Allure Report (optional)

If you have **Allure CLI** installed, you can generate a beautiful report from the results folder:

```bash
# After tests executed (Gradle or Maven)
allure serve build/allure-results   # Gradle path
# OR
allure serve target/allure-results  # Maven path
```

---

## 6. Environment Variables & Customisation

| Variable            | Default  | Description                                  |
|---------------------|----------|----------------------------------------------|
| `browser`           | chrome   | Browser to use (`chrome` / `firefox`).        |
| `headless`          | false    | Run in headless mode (true/false).            |

Set them via JVM system properties, e.g.:

```bash
./gradlew test -Dbrowser=firefox -Dheadless=true
```

---

## 7. Troubleshooting

* **Driver not found / version mismatch** ? Delete the `~/.cache/selenium` (or `%USERPROFILE%\.cache\selenium`) folder and rerun tests so WebDriverManager can download the latest driver.
* **ElementNotFound / flaky waits** ? Increase wait times in `utils.WaitHelper.java` or check that the test site is reachable.

---

Happy testing! ? 