# Prime Number Checker API (Spring Boot)

A simple and robust RESTful API built using **Spring Boot** that determines whether a given number is a prime number.

---

## 🔍 Features

- REST API to check if a number is prime.
- Lightweight and efficient logic.
- Built using modern Spring Boot architecture.
- Easy to test with Postman or `curl`.

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3.x
- Maven
- RESTful Web Services

---

## 📁 Project Structure

prime-number-checker/
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── example/
│ └── primechecker/
│ ├── PrimeCheckerApplication.java
│ └── controller/
│ └── PrimeController.java
└── pom.xml

yaml
Copy
Edit

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/prime-number-checker.git
cd prime-number-checker
2. Build & Run the Application
bash
Copy
Edit
mvn clean install
mvn spring-boot:run
Server will start at: http://localhost:8080

🌐 API Usage
Endpoint
swift
Copy
Edit
GET /api/is-prime
Query Parameter
Name	Type	Required	Description
number	Integer	Yes	The number to check for prime

Example Request
bash
Copy
Edit
GET http://localhost:8080/api/is-prime?number=17
Example Response
json
Copy
Edit
{
  "number": 17,
  "isPrime": true
}
🧪 Testing with Postman
Open Postman.

Select GET method.

Enter URL: http://localhost:8080/api/is-prime?number=19

Click Send.

You should see:

json
Copy
Edit
{
  "number": 19,
  "isPrime": true
}
🧪 Testing with Curl
bash
Copy
Edit
curl "http://localhost:8080/api/is-prime?number=19"
🧩 Maven Dependencies
Add this to your pom.xml:

xml
Copy
Edit



package com.example.primechecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeCheckerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrimeCheckerApplication.class, args);
    }
}





package com.example.primechecker.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PrimeController {

    @GetMapping("/is-prime")
    public Map<String, Object> isPrime(@RequestParam int number) {
        Map<String, Object> response = new HashMap<>();
        response.put("number", number);
        response.put("isPrime", isPrimeNumber(number));
        return response;
    }

    private boolean isPrimeNumber(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}


<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>prime-checker</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    <name>Prime Number Checker API</name>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.5</version>
    </parent>

    <dependencies>
        <!-- Spring Boot Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- For development purposes -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing (Optional) -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Spring Boot Maven Plugin -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
