# Warehouse Management System (Java)

##  Overview
The Warehouse Management System is a console-based Java application used to manage products, inventory stock, and warehouse transactions.  
It follows a clean layered architecture using Model, Service, and App packages.

---
## Project Structure

```
Warehouse-Management-System/
├── README.md
└── src/
    └── com/
        └── warehouse/
            ├── app/
            │   └── WarehouseApp.java
            ├── model/
            │   ├── Product.java
            │   └── Transaction.java
            └── service/
                └── WarehouseService.java
```


---

##  Features

### Product Management
- Add new products
- Update existing products
- Delete products
- View product by ID
- Search products by name
- View all products

### Inventory Operations
- Receive stock (increase quantity)
- Ship stock (reduce quantity)
- Adjust stock (set new quantity)
- Automatic low-stock detection using reorder threshold

### Transaction Management
- Track RECEIVE, SHIP, and ADJUST operations
- View all transactions
- View transactions for a specific product

### Reports & Analytics
- View low stock products
- Calculate total inventory value
- Category-wise stock summary

---

## 🛠 Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Console-based UI
- LocalDateTime for timestamps

---

##  How to Run
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Navigate to:
com.warehouse.app.WarehouseApp
4. Run `WarehouseApp.java`

---

## 🧠 Key Concepts Demonstrated
- Encapsulation and data validation
- Separation of concerns (Model / Service / App)
- Business logic implementation
- Immutable IDs for products and transactions
- Inventory consistency checks

---

## 📈 Possible Enhancements
- Database or file persistence
- REST API using Spring Boot
- GUI version
- Role-based access control
- Unit testing with JUnit

---

##  Author
Varshith Reddy


