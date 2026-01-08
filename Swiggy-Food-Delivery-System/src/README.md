# Swiggy App Demo (Java OOP Project)

## Project Overview
This is a console-based Java application that simulates a simplified food and grocery delivery system similar to Swiggy. The project is designed to demonstrate core Object-Oriented Programming (OOP) concepts such as inheritance, method overriding, polymorphism, and package structuring.

---

## Features
- Place Food Orders and Grocery Orders
- Display detailed order information
- Calculate bill amount including GST
- Assign delivery agents with different vehicle types
- Simulate delivery lifecycle:
    - Assign delivery
    - Start delivery
    - Complete delivery

---

## Project Structure
````
com.swiggy
│
├── app
│ └── SwiggyAppDemo.java
│
├── order
│ ├── Order.java
│ ├── FoodOrder.java
│ └── GroceryOrder.java
│
└── delivery
├── Delivery.java
└── DeliveryAgent.java

````

---

## OOP Concepts Used
- Inheritance
- Method Overriding
- Polymorphism
- Encapsulation
- Packages

---

## How It Works
1. A food or grocery order object is created
2. The order is placed and order details are displayed
3. The bill amount is calculated with 5% GST
4. A delivery agent is assigned to the order
5. Delivery is started and completed

---

## Sample Output
Food Order Placed Successfully !
Order ID: 101
Customer Name: Neha
Restaurant Name: Domino's
Item: Margherita Pizza
Amount: ₹551.25 (GST included)
Delivery Assigned: Rajesh (Bike)
Delivery Started
Delivery Completed

yaml
Copy code

---

## Technologies Used
- Java
- Core Java (Object-Oriented Programming)
- Console-based Application

---

## Learning Outcome
- Understood practical usage of Java OOP concepts
- Learned proper package organization
- Implemented inheritance and method overriding
- Gained experience in designing real-world class relationships

---

## Future Enhancements
- Introduce interfaces and abstraction
- Improve encapsulation using access modifiers
- Add exception handling
- Convert the application into a menu-driven program

---

## Author
Varshith Reddy  
Undergraduate Student | Java & DSA Learner