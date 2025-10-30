# 🚗 Car Rental Management System  
### Group 16 — Daris Dervishaga, Art Lushaku, & Pascal Leon Çuni

# D3: Anticipated Design Risks & Applied Patterns

1. Car Type Complexity — Strategy Pattern

One anticipated design challenge is supporting multiple car types (Economy, Luxury, SUV), each with distinct pricing and features. This can complicate the class hierarchy and make maintenance harder as new types are added.
To address this, we plan to define a PricingStrategy interface with a calculatePrice() method and implement specific strategies for each car type.
Using the Strategy Pattern allows us to introduce new car types and pricing models without modifying existing code, maintaining flexibility and adhering to the Open/Closed Principle.

2. Optional Features (Add-ons) — Decorator Pattern

Another challenge is adding optional features such as GPS or a child seat to cars dynamically without duplicating code or modifying the base Car class.
To solve this, we use the Decorator Pattern by creating an abstract CarDecorator class that extends Car. Concrete decorators (like GPSDecorator or ChildSeatDecorator) can then wrap existing car objects to add functionality at runtime.
This approach keeps the core Car class simple while enabling scalable, flexible extensions.



A simple **Java-based skeleton** for managing cars, customers, and reservations.  
Implements basic **CRUD** operations with attention to **Single Responsibility Principle (SRP)** and **clean architecture** structure.

---

## 📘 Overview  
This project provides a foundation for a car rental management system, including:  
- Adding and editing car records  
- Creating customer profiles  
- Making and managing reservations  
- Handling availability and pricing logic  

It’s a **console-based prototype** designed to demonstrate core design patterns and application structure before GUI or database integration.

---

## 🧠 Design  
- **Language:** Java  
- **Pattern Focus:** SRP, MVC-inspired layering  
- **Scope:** Console prototype only (no DB or frontend yet)  
- **Future Additions:** GUI, database persistence, authentication

---

## 🧑‍💻 Authors  
**Group 16 — SWEN 383**  
- Art Lushaku  
- Daris Dervishaga  
- Pascal Leon Çuni