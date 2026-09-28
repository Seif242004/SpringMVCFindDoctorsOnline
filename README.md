# Find Doctors Online

A Java 8-compatible Spring MVC web application that searches doctor records in MySQL by exact name or registration number. It uses Spring JDBC, JSP/JSTL, and the MVC pattern.

## Requirements

- JDK 8 or newer
- Maven 3.6+
- MySQL 8+
- Apache Tomcat 9

## Setup

1. Run `src/main/resources/db/schema.sql` in MySQL to create the `geeksforgeeks` database, table, and sample records.
2. Set your local MySQL URL, username, and password in `src/main/resources/database.properties`.
3. Build the WAR with `mvn clean package`.
4. Deploy `target/SpringMVCFindDoctorsOnline.war` to Tomcat 9.
5. Open `http://localhost:8080/SpringMVCFindDoctorsOnline/`.

Searches are exact matches. Enter either a doctor name or a registration number, not both. Configure database credentials before deployment; do not commit production credentials.