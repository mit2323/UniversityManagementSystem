 University Management System

A Java-based University Management System designed to streamline academic and administrative operations. The system manages student records, course details, attendance, and fee transactions using a structured relational database.

Tech Stack

- Java (Core Java, OOP Principles)
- MySQL Database
- JDBC Connectivity

Features

- Student registration and record management
- Faculty and course management
- Attendance tracking system
- Fee payment and transaction management
- Secure database interaction using JDBC
- Structured relational database design

 System Architecture

The application follows a layered structure:

1. Presentation Layer – Console-based user interface
2. Business Logic Layer – Handles validation and application logic
3. Data Access Layer – JDBC-based database interaction
4. Database Layer – MySQL relational database

Database Design

The system uses a normalized relational schema including:

- Students Table
- Faculty Table
- Courses Table
- Attendance Table
- Fees Table

Foreign keys and constraints are implemented to maintain data integrity.

How to Run

1. Clone the repository
2. Import the project into your IDE (Eclipse / IntelliJ)
3. Create the MySQL database
4. Update database credentials in the JDBC configuration file
5. Run the main Java file

Learning Outcomes

- Practical implementation of Object-Oriented Programming
- Hands-on experience with JDBC
- Database schema design and query optimization
- Understanding of real-world academic management workflows

Future Improvements

- Add GUI using JavaFX or Swing
- Implement role-based authentication
- Add reporting and analytics dashboard
- Deploy as a web-based application

