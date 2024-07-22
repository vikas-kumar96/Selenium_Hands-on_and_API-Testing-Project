# Selenium Hands-On Project

## Objective

To build a Selenium script that automates the following process on the given URL.

## Tools Required

- **Programming Language**: Java
- **Tool**: Selenium
- **Web Browser**: Chrome or Firefox
- **IDE/Text Editor**: Spring Tool Suite / Eclipse

## Pre-requisites

- Basic understanding of Java programming
- Knowledge of HTML elements (like id, class, name, etc.)

## Assignment Instructions

### Part 1: Setup Environment

1. **Install Java**: Ensure you have the latest JDK installed. [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Install Selenium**: Download the Selenium WebDriver for the browser you will be using (Chrome or Firefox). Add the WebDriver to your project dependencies.

3. **Setup Maven Project**:
    - Create a new Maven project in your IDE (Spring Tool Suite or Eclipse).
    - Add the necessary dependencies in the `pom.xml` file:

    ```xml
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.4.0</version>
        </dependency>
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.0.9</version>
        </dependency>
    </dependencies>
    ```

### Part 2: Writing the Script

1. **Create a new package**:
    - In `src/test/java`, create a package named `assessment`.

2. **Write Java classes inside the package**:
    - Create classes for Page Objects (LoginPage, HomePage, ProductPage, CartPage).
    - Create a test class using TestNG annotations.

### Part 3: Assignment Tasks

**Step-by-Step Implementation**:

1. **Page Object Model (POM)**:
    - `LoginPage.java`
    - `HomePage.java`
    - `ProductPage.java`

2. **Test Class with TestNG**:
    - `AssessmentTest.java`

3. **Property File**:
    - Create a `config.properties` file in `src/test/resources` to store URL and other properties.

4. **Reading Properties in Test**:
    - Use Java’s `Properties` class to read properties from the file.

5. **Implementing Waits and Assertions**:
    - Use WebDriverWait for synchronization.
    - Use TestNG assertions to validate the test steps.

6. **Generating Extent Reports**:
    - Add Extent Report library and configure it in your project.

### Part 4: Submission Guidelines

- **Code Comments**:
    - Ensure you comment on each section of your code explaining the purpose and logic.
  
- **Push to GitHub**:
    - Create a new repository on GitHub and push your project.

    ```bash
    git init
    git add .
    git commit -m "Initial commit"
    git remote add origin <your-repo-url>
    git push -u origin master
    ```




