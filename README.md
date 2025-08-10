<h1 align="center">Employee Management System</h1>

## Overview

A full-stack Employee Management System built with **Spring Boot** for backend and **React/Next.js + TypeScript** for frontend. This application allows for managing employee records, assigning them to departments, and handling CRUD operations.

---

## Features

- Employee Dashboard
- Add new employees
- Display all employees
- Update and delete employees
- Assign employees to departments
- Add new departments via a modal form

---

## Tech Stack

### Backend

- Spring Boot
- Spring Web
- Spring Data JPA
- H2  - to be integrated with MySQL or Postgres later
- Log4j2

### Frontend

- React/ Next.js
- TypeScript
- Axios
- Material UI
  
---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3+
- Node.js 22+
- NPM 10+
- IDEs: IntelliJ (backend) + VSCode (frontend)

### Run locally

1. Open backend directory.
    
    ```bash
    cd backend/employee_management_system
    ```
   
2. Run the backend.
    
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
    
	Backend will be available at:

    `http://localhost:8080/api/employees`
   
     `http://localhost:8080/api/departments`

     `http://localhost:8080/h2-console`	(H2 database console)
    

4. Open frontend directory.
    
    ```bash
    cd frontend/employee_dashboard
    ```
    
5. Install dependencies.
    
    ```bash
	npm install @mui/material @emotion/react @emotion/styled axios
    ```
    
6. Run the frontend.
    
    ```bash
    npm run dev    
    ```
    
	Frontend will be available at:
    `http://localhost:3000`
    
---

## Future Enhancements

- Access control- sign up, login
- Separate department feature to edit and display data
- Search option for data
- Separate feature to include salary management
    
---

## References

- [Spring Boot Project Setup with IntelliJ](https://www.geeksforgeeks.org/how-to-create-a-spring-boot-project-in-spring-initializr-and-run-it-in-intellij-idea/)

- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot)

- [Spring Logging](https://docs.spring.io/spring-boot/how-to/logging.html)

- [Spring Boot Logging with Log4j2](https://www.baeldung.com/spring-boot-logback-log4j2)

- [Spring Boot - Database Integration](https://www.geeksforgeeks.org/spring-boot-database-integration-jpa-hibernate-mysql-h2/)

- [Sample Employee Management System Project](https://www.geeksforgeeks.org/employee-management-system-using-spring-boot/)

- [Sample Employee Management System Project 2](https://www.javaguides.net/2021/07/spring-boot-tutorial-build-employee-management-project.html#google_vignette)

- [JpaRepository Methods](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)

- [Service Layer Design Pattern](https://java-design-patterns.com/patterns/service-layer/?utm_source=chatgpt.com#benefits-and-trade-offs-of-service-layer-pattern)

- [Spring JPA @joincolumn](https://codingnomads.com/spring-data-jpa-joincolumn-configuration)

- [TypeScript Cheatsheets](https://www.typescriptlang.org/cheatsheets/)

- [Next.js](https://nextjs.org/learn?utm_source=next-site&utm_medium=homepage-cta&utm_campaign=home)

- [Next.js with TypeScript](https://nextjs.org/docs/app/api-reference/config/typescript)

- [Next.js with Axios](https://sandeepbansod.medium.com/effortless-api-request-handling-in-next-js-with-axios-a-comprehensive-guide-8b424ce403c5)

- [Axios guide](https://www.geeksforgeeks.org/axios-in-react-a-guide-for-beginners/)

- [Material UI with Next.js](https://mui.com/material-ui/integrations/nextjs/)
