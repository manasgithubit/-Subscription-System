# Assignment Of Subscription-System Project
Spring Boot-based RESTful API to manage subscription billing for employees based on assigned plans (Per Employee / Per Team / Per Position). 
Data is stored in MongoDB, and billing is calculated using a PEPM (Per Employee Per Month) model.

🚀 Features:-
-------------
✅ Create and manage employees

✅ Create and manage subscription plans

✅ Assign plans to employees

✅ Automatically generate billing per employee based on months used

✅ MongoDB integration for persistent storage

✅ Simple and RESTful API endpoints

🛠 Tech Stack:-
---------------
1- Java 17

2- Spring Boot

3- Spring Data MongoDB

4- MongoDB

5- Lombok

6- Postman (for testing)

🗂️ Project Structure:-
----------------------
src/
├── controller/
│   └── EmployeeController.java
│   └── SubscriptionPlanController.java
│   └── BillingController.java
├── model/
│   └── Employee.java
│   └── SubscriptionPlan.java
│   └── BillingRecord.java
├── repository/
│   └── EmployeeRepository.java
│   └── SubscriptionPlanRepository.java
│   └── BillingRecordRepository.java
├── service/
│   └── EmployeeService.java
│   └── SubscriptionPlanService.java
│   └── BillingService.java

🧪 API Endpoints:-
------------------
👤 Employee APIs-
    = POST /api/employees – Add new employee
    = GET /api/employees – List all employees

📦 Plan APIs:-
    = POST /api/plans – Add new subscription plan
    = GET /api/plans – List all plans

💰 Billing API:-
     = POST /api/billing?monthsUsed=3 – Generate billing for all employees for X months

🧑‍💻 Sample Data (for testing):-
------------------------------
📦 Add Plan:-
     POST /api/plans
         {
            "name": "Pro Plan",
            "pricePerEmployeePerMonth": 25.0,
            "planType": "PerEmployee"
         }
👤 Add Employee
      POST /api/employees
        {
          "name": "Manas",
          "position": "Developer",
          "team": "Backend",
          "assignedPlanId": "PLAN_ID_FROM_ABOVE"
        }
💰 Generate Billing
      POST /api/billing?monthsUsed=3

🛠 Configuration:-
-----------------
MongoDB(in application.properties):-
   spring.application.name=83-SBMS-Subscription-System
   spring.data.mongodb.uri=mongodb://localhost:27017/subscription_system

🖥️ Run the App:-
----------------
# Run Spring Boot application
./mvnw spring-boot:run

MongoDB Commands:-
------------------
use subscription_system
db.employee.find().pretty()
db.subscription_plan.find().pretty()
db.billing_record.find().pretty()



