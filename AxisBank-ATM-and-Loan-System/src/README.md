# Axis Bank ATM and Loan System (Java OOP Project)

## Project Overview
This is a console-based Java application that simulates basic banking operations such as ATM transactions and loan processing. The project demonstrates core Object-Oriented Programming (OOP) concepts by modeling real-world banking features like bank accounts, ATM services, and different types of loans.

---

## Features

### ATM System
- Deposit money with PIN verification
- Withdraw money with minimum balance constraint
- Check account balance securely
- Supports multiple bank accounts
- Menu-driven console interface

### Loan System
- Personal Loan
- Custom Personal Loan (user-defined interest rate)
- Home Loan
- Car Loan
- Education Loan
- EMI calculation based on loan type and duration

---

## Project Structure
````
src
│
└── com.axisbank
│
├── account
│ └── BankAccount.java
│
├── app
│ ├── ATMSystem.java
│ └── LoanDemo.java
│
└── loan
└── LoanSystem.java

````
---

## OOP Concepts Used
- Encapsulation
- Method Overloading
- Packages
- Object Interaction
- Data Hiding using access modifiers

---

## How the ATM System Works
1. User selects an option from the ATM menu
2. Account number and PIN are verified
3. Deposit, withdrawal, or balance enquiry is performed
4. Minimum balance rule (₹500) is enforced during withdrawal

---

## How the Loan System Works
1. User selects a loan type
2. Enters loan amount and repayment period
3. Interest rate is applied based on loan type
4. EMI is calculated and displayed

---

## Sample Output (ATM)
--Bank Menu--
1.Deposit
2.Withdraw
3.Print Balance
4.Exit
Enter your choice

yaml
Copy code

---

## Sample Output (Loan)
--Loans--
1.Personal Loan
2.Custom Personal Loan
3.Home Loan
4.Car Loan
5.Education Loan
6.Exit
Enter an option

yaml
Copy code

---

## Technologies Used
- Java
- Core Java (OOP Concepts)
- Console-based Application

---

## Learning Outcome
- Practical understanding of Java OOP concepts
- Implemented method overloading and encapsulation
- Learned to design menu-driven applications
- Simulated real-world banking logic

---

## Future Enhancements
- Add exception handling
- Store account and loan data using files or database
- Improve security with retry limits on PIN attempts
- Convert to GUI-based application

---

## Author
Varshith Reddy  
Undergraduate Student | Java & DSA Learner
