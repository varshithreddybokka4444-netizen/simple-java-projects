# Student Management System (Java)

A console-based **Student Management System** built using **core Java**, focusing on clean architecture, separation of concerns, and project-based learning.

This project is designed to strengthen Java fundamentals and prepare for larger open-source codebases.

---

##  Features

- Add a student with subject-wise marks
- Update student details and marks
- Delete a student by ID
- View marks of a single student
- View all students with grades
- Automatic grade calculation based on average marks
- Input validation with meaningful messages

---

##  Project Architecture

The project follows a **layered architecture** to ensure clean separation of concerns.

```
src/
└── com/
    └── studentmanagement/
        ├── app/
        │   └── StudentManagementApp.java
        │
        ├── model/
        │   └── Student.java
        │
        ├── repository/
        │   └── StudentRepository.java
        │
        └── service/
            ├── StudentService.java
            └── ServiceResult.java
```

### Layer Responsibilities

- **app**  
  Handles user interaction and menu-driven console input/output.

- **model**  
  Defines domain objects such as `Student`.

- **repository**  
  Manages in-memory storage of student data using collections.

- **service**  
  Contains business logic, validation, grade calculation, and returns structured results.

---

## 🛠 Technologies Used

- Java (Core Java)
- Java Collections Framework (`Map`, `List`, `ArrayList`, `HashMap`)
- Object-Oriented Programming (OOP)
- IntelliJ IDEA
- Command-line compilation (`javac`, `java`)

---

##  Concepts Covered

- Classes and Objects
- Packages and access control
- Encapsulation
- Constructors
- Collections Framework
- Layered architecture (App / Service / Repository / Model)
- Separation of concerns
- Validation logic
- Overriding `toString()`
- Manual compilation and classpath usage

---

## ▶ How to Run

### Compile
```
javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName })
```

### Run
```
java -cp out com.studentmanagement.app.StudentManagementApp
```

---

##  Learning Outcome

This project helped me understand how real Java applications are structured beyond simple programs, including:

- Designing scalable project structure
- Writing clean and maintainable code
- Applying separation of concerns
- Preparing for open-source contributions

---

##  Future Improvements

- File-based persistence
- Exception-based error handling
- Search and sorting functionality
- Unit testing
- Build tool integration (Maven / Gradle)

---

##  Author

Varshith Reddy  
Learning Java through project-based development with the goal of contributing to open source (GSoC).
