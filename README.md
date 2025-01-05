
<div>

<div align="center">

> **tunic** – A minimal setup for a Kotlin application using Gradle.

</div>

<div align="center">

![Kotlin](https://img.shields.io/badge/kotlin-1.9.0-blue.svg?logo=kotlin&logoColor=white)
![Gradle](https://img.shields.io/badge/gradle-8.4-%2302303A.svg?logo=gradle)
[![Last Commit](https://img.shields.io/github/last-commit/amaziahub/tunic.svg)](https://github.com/amaziahub/tunic/commits/main)
[![License](http://img.shields.io/:license-apache2.0-red.svg)](http://doge.mit-license.org)
![Made with ❤️](https://img.shields.io/badge/made%20with-%E2%9D%A4-red.svg)
</div>
</div>

---

## Prerequisites

Ensure the following are installed on your system:

- [Java Development Kit (JDK)](https://adoptopenjdk.net/) 8 or later
- [Gradle](https://gradle.org/install/)
- [Make](https://www.gnu.org/software/make/)

---

## Project Structure
```text
simple-gradle-kotlin-project/ 
├── build.gradle.kts # Gradle build script (Kotlin DSL) 
├── settings.gradle.kts # Gradle settings 
├── Makefile # Makefile for simplified task execution 
├── src/ 
│ ├── main/ 
│ │ └── kotlin/ 
│ │     └── Main.kt # Main application code 
│ └── test/ 
│   └── kotlin/ 
│       └── MainTest.kt # Unit tests 
└── build/ # Generated build files (ignored in VCS)
```

---

## Usage

To simplify project management, a `Makefile` is provided. Use the following commands to perform common tasks:

### Build the Project
Compiles the source code and generates the build artifacts.
```bash
  make build
```

### Run Tests
Executes the unit tests and generates a report.
```bash
  make test
```

### View Test Report
Opens the HTML test report in your default browser.
```bash
  make report
```

### Run the Application
Runs the main application.
```bash
  make run
```
---
Happy coding! 🎉
