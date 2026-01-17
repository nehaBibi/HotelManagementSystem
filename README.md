Hotel Management System
Software Construction – Complex Computing Problem (CCP)
📌 Project Overview
This project is a Hotel Management System developed as part of the Software Construction (CCP) assignment. The system is implemented by strictly following object-oriented design principles and clean code practices. It is based on a UML class diagram and demonstrates how a real-world hotel reservation system can be designed, implemented, and tested using Java.
The project focuses on:
•	Translating UML design into working code
•	Applying clean code and defensive programming principles
•	Writing structured and maintainable unit tests
•	Demonstrating core use cases through a main program
________________________________________
🛠 Technologies Used
•	Language: Java
•	IDE: Eclipse
•	Testing Framework: JUnit 4
•	Version Control: Git & GitHub
________________________________________
📂 Project Structure
Hotel-Management/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── model/
│   │       ├── service/
│   │       └── Main.java
│   │
│   └── test/
│       └── java/
│           └── unit tests
│
├── README.md
└── pom.xml / build.gradle
________________________________________
⚙️ How to Build and Run the Project
1.	Clone the repository:https://github.com/nehaBibi/HotelManagementSystem.git
git clone 
2.	Open the project in your IDE (IntelliJ IDEA or VS Code).
3.	Compile and run the project:
•	Run the Main.java file.
________________________________________
▶️ How to Execute Tests
1.	Navigate to the test directory:
src/test/java
2.	Run all test classes using:
•	IDE test runner
OR
mvn test
3.	All tests should pass successfully, confirming correct system behavior.
________________________________________
🧪 Testing Strategy
•	Unit tests are written for domain classes.
•	Tests follow the AAA (Arrange–Act–Assert) pattern.
•	Normal cases, boundary conditions, and invalid inputs are tested.
•	Parameterized tests are used where applicable.



________________________________________
🛡 Defensive Programming
•	All constructor parameters are validated.
•	Invalid inputs are handled using exceptions.
•	Illegal object states are prevented throughout the system lifecycle.
________________________________________
📸 Demonstration
The Main method demonstrates:
•	Creation of hotels, rooms, and customers
•	Interaction between objects
•	Room availability checks
•	Room booking operations
Screenshots of execution and test results are included in the submitted document.
________________________________________
👤 Author
Name: Neha Bibi
Program: BS Software Engineering
Course: Software Construction
