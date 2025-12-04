# 🚗 Car Rental Management System
### Group 16 — Daris Dervishaga, Art Lushaku, & Pascal Leon Çuni

A **Java-based console application** for managing car rentals, customers, and reservations.  
Implements core design patterns (Singleton, Factory, MVC) with clean architecture and encapsulation.

---

## 📘 Overview
This project provides a complete car rental management system with:
- **Car Management**: Add and view cars with rental rates
- **Customer Management**: Register and view customers
- **Reservation System**: Rent and return cars with date validation
- **Console Interface**: User-friendly menu-driven interface

The system demonstrates **three key design patterns** to address common software design challenges and improve maintainability.

---

## 🏗️ Architecture & Design Patterns

### 1. **Singleton Pattern** - `RentalRepository`
**Problem Solved**: Multiple instances of the data repository would create separate data stores, causing data loss and inconsistency.

**Solution**: The `RentalRepository` class uses the Singleton pattern to ensure only one instance exists throughout the application lifecycle. All components access the same shared data store.

**Benefits**:
- Single source of truth for all data
- Prevents data duplication and loss
- Ensures consistency across the application

### 2. **Factory Pattern** - `CarFactory`
**Problem Solved**: Direct object creation scattered throughout the code makes it harder to modify creation logic and add validation.

**Solution**: The `CarFactory` class centralizes car creation logic. All cars are created through `CarFactory.createCar()`, separating object creation from business logic.

**Benefits**:
- Centralized creation logic (easy to modify)
- Future-proof for adding validation or special setup
- Cleaner, more maintainable code

### 3. **MVC Pattern** - Model-View-Controller
**Problem Solved**: Mixing business logic, data access, and display code makes the system hard to maintain and test.

**Solution**: 
- **Model**: `Car`, `Customer`, `Reservation`, `Payment` classes (data and business logic)
- **View**: `RentalView` class (all console output)
- **Controller**: `RentalController` class (coordinates between Model and View)

**Benefits**:
- Separation of concerns
- Easy to swap UI (console → GUI) without changing business logic
- Better testability and maintainability

---

## 🎯 Key Features

- ✅ **Flexible ID Input**: Accepts "C001", "001", or "1" for car/customer IDs
- ✅ **Validation**: Prevents renting already-rented cars
- ✅ **Date Validation**: Ensures end date is after start date
- ✅ **Automatic Cost Calculation**: Calculates total based on days and rate
- ✅ **Status Management**: Tracks car availability (AVAILABLE/BOOKED)

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE (IntelliJ, Eclipse, VS Code) or command line

### Running the Application

1. **Compile all Java files**:
   ```bash
   javac *.java
   ```

2. **Run the main class**:
   ```bash
   java Main
   ```

3. **Use the menu**:
   - Option 1: Rent a Car
   - Option 2: Return a Car
   - Option 3: View All Cars
   - Option 4: View All Customers
   - Option 5: View All Reservations
   - Option 6: Exit

### Sample Data
The system initializes with sample data:
- 3 cars (Toyota Camry, Honda Accord, Ford Mustang)
- 2 customers (John Doe, Jane Smith)

---

## 📁 Project Structure

```
g16-car-rental-management-system/
├── Main.java                 # Entry point, menu loop
├── RentalController.java     # MVC Controller - business logic
├── RentalView.java           # MVC View - console output
├── RentalRepository.java     # Singleton - data storage
├── CarFactory.java           # Factory - car creation
├── Car.java                  # Model - car entity
├── Customer.java             # Model - customer entity
├── Reservation.java          # Model - reservation entity
├── Payment.java              # Model - payment entity
└── README.md                 # This file
```

---

## 🧠 Design Principles Applied

- **Encapsulation**: Private fields with public getters/setters
- **Single Responsibility**: Each class has one clear purpose
- **Separation of Concerns**: MVC pattern separates logic, data, and display
- **DRY (Don't Repeat Yourself)**: Helper methods eliminate code duplication
- **Simple & Defensible**: No advanced features - easy to explain and understand

---

## 🧑‍💻 Authors
**Group 16 — Software Design**  
- Art Lushaku  
- Daris Dervishaga  
- Pascal Leon Çuni

---

## 📝 Notes
- All code includes comments explaining **WHY** design decisions were made
- Code is optimized for clarity and presentation
- No external dependencies required (pure Java)
