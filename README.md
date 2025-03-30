# Orangefy-Selenium_SkillDemo

## Overview
Orangefy-SkillDemo is a project designed to showcase QA Automation expertise in Java, Selenium automation, TestNG, CI/CD integration, and test design patterns.

## Features
- Built using **Selenium WebDriver** and **TestNG** for robust test automation.
- Integrated with **Maven Wrapper** for simplified build and dependency management.
- CI/CD integration using **GitHub Actions** to ensure continuous testing and deployment.
- Generates detailed test reports using **Allure Report**, which is automatically generated after test execution.

## Prerequisites
Before setting up the project, ensure you have the following installed:
- [Amazon Corretto JDK 17.0.14](https://aws.amazon.com/corretto/)
- [Maven](https://maven.apache.org/install.html) (if not using Maven Wrapper)
- [Git](https://git-scm.com/downloads)
- Selenium-Java and TestNG libraries (managed through Maven dependencies)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/DiegoPatcheco/Orangefy-SkillDemo.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Orangefy-SkillDemo
   ```
3. Install dependencies and build the project using Maven Wrapper:
   ```sh
   ./mvnw clean install
   ```

## Running Tests
To execute the automated tests, use the following command:
```sh
./mvnw clean test
```

You can also run a specific test suite using the `runSuite.sh` script:
```sh
./runSuite.sh
```

## Allure Reports
- The **Allure Report** is automatically generated after test execution.
- To view the report, run:
  ```sh
  allure serve target/allure-results
  ```
- Alternatively, you can open the Allure report using the `openAllure.sh` script:
  ```sh
  ./openAllure.sh
  ```

## CI/CD Integration
- The project is integrated with **GitHub Actions**, which automatically triggers the test suite on every push or pull request.
- Check the test results in the **Actions** tab on GitHub.
- **Allure Reports** are also generated and can be accessed after execution in the CI/CD pipeline.

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch (`feature-branch`).
3. Commit your changes.
4. Push to the branch and submit a pull request.

## Author
Developed by [Diego Patcheco](https://github.com/DiegoPatcheco).
