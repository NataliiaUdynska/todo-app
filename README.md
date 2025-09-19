# todo-app

A simple web application for managing tasks with the ability to set priorities and colour coding.

<img width="1834" height="823" alt="image" src="https://github.com/user-attachments/assets/961892a0-e206-46b1-95f0-bc623319cf17" />
<img width="1826" height="838" alt="image" src="https://github.com/user-attachments/assets/d17afc98-00a4-4dd9-96fd-3aa9f2767088" />


Features
-  Add, edit and delete tasks
- 🔴🟠🔵 Set priority: Urgent / Medium / Not urgent
- Colour coding of rows by priority
- Sorting: urgent first, then less important
- Completed tasks are automatically moved down
- Data storage in H2 database
- Web interface on Thymeleaf + Spring Boot

Technologies
- Java 21
- Spring Boot 3.5.5
- Thymeleaf — templating
- H2 Database — built-in database
- Maven — project build
- Bootstrap (optional) — beautiful design

How to run
There are two ways to run the application:
- To-Do App.exe — executable file with an icon
- launch.bat — alternative way to run

1. For the user
     1. Follow the link: https://github.com/NataliiaUdynska/todo-app/releases
     2. Find todo-app.rar at the bottom and download it
     3. Double-click on the file:To-Do App.exe — the application will start automatically
     4. Open in your browser: http://localhost:8080

2. For developers
If you want to build the project yourself:
bash
git clone https://github.com/NataliiaUdynska/todo-app.git
cd todo-app
mvn spring-boot:run
