# Saquib Job Portal

A Spring Boot web application for posting jobs, browsing available openings, searching by keyword, viewing job details, and submitting job applications.

The project uses Spring Boot MVC with Thymeleaf templates and Bootstrap styling. Job data is stored in memory, which keeps the app simple to run and easy to understand for learning, demos, and college project submissions.

## Features

- Home page with quick navigation
- View all available job posts
- Search jobs by role, description, or tech stack
- Add a new job post
- View full job details
- Apply for a job with applicant information
- Application success confirmation page
- Seeded sample jobs available on startup
- Responsive Bootstrap-based UI

## Tech Stack

- Java 25
- Spring Boot 4.0.6
- Spring Web MVC
- Thymeleaf
- Bootstrap 5
- Lombok
- Maven Wrapper

## Project Structure

```text
jobApp/
+-- mvnw.cmd
+-- pom.xml
+-- src/
    +-- main/
    |   +-- java/com/example/jobApp/
    |   |   +-- JobAppApplication.java
    |   |   +-- JobController.java
    |   |   +-- model/
    |   |   |   +-- JobApplication.java
    |   |   |   +-- JobPost.java
    |   |   +-- service/
    |   |       +-- JobService.java
    |   +-- resources/
    |       +-- application.properties
    |       +-- templates/
    |           +-- home.html
    |           +-- viewalljobs.html
    |           +-- addJob.html
    |           +-- success.html
    |           +-- apply.html
    |           +-- applicationSuccess.html
    +-- test/
        +-- java/com/example/jobApp/
            +-- JobAppApplicationTests.java
```

## Pages and Routes

| Page | URL | Description |
| --- | --- | --- |
| Home | `/home` or `/` | Landing page with navigation cards |
| View Jobs | `/viewalljobs` | Shows all jobs and search form |
| Search Jobs | `/viewalljobs?keyword=Java` | Filters jobs by keyword |
| Add Job | `/addjob` | Form to create a new job post |
| Job Details | `/job-details/{postId}` | Shows details for one job |
| Apply | `/apply/{postId}` | Application form for a selected job |
| Application Success | `/submitApplication` | Confirmation after application submission |

## How to Run

### 1. Open the project folder

```powershell
cd C:\Users\Saquib\Downloads\jobApp\jobApp
```

### 2. Start the application

```powershell
.\mvnw.cmd spring-boot:run
```

### 3. Open the app in your browser

```text
http://localhost:8083/home
```

The server port is configured in:

```text
src/main/resources/application.properties
```

```properties
server.port=8083
```

## How to Test

Run the test suite with:

```powershell
.\mvnw.cmd test
```

Expected result:

```text
BUILD SUCCESS
```

## How the App Works

`JobService` stores job posts in an in-memory list and adds a few sample jobs when the app starts. `JobController` handles page navigation, job search, job creation, job detail lookup, and application submission.

Because the app currently uses in-memory storage, newly added jobs are available while the application is running. If the server restarts, the app returns to the seeded sample jobs.

## Future Improvements

- Add database support with MySQL or PostgreSQL
- Add user login for applicants and recruiters
- Store submitted applications
- Add edit and delete job options
- Add form validation messages
- Add admin dashboard
- Add REST APIs for frontend or mobile clients

## Author

Saquib

## License

This project is for educational and learning purposes.
