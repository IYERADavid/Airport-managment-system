# Airport Management System

A comprehensive Java-based Airport Management System demonstrating Object-Oriented Programming principles for managing flights, passengers, staff, bookings, security, and airport operations.

## Assignment Overview

**Course:** Object-Oriented Programming (OOP)  
**Assignment:** Advanced Airport Management System  
**Group:** Sunday Group D

---

## Project Structure

```
airport/
├── AirportSystem.java          # Main application entry point with CLI menu
├── core/                       # Core OOP components
│   ├── AirportEntity.java      # Abstract base class for all entities
│   ├── AirportManager.java     # Manager implementation
│   ├── Payable.java            # Interface for payment operations
│   ├── Reservable.java         # Interface for reservation operations
│   └── Trackable.java          # Interface for tracking operations
├── airport/                    # Airport infrastructure
│   ├── Airport.java            # Airport entity
│   ├── Gate.java               # Gate management
│   └── Terminal.java           # Terminal operations
├── flight/                     # Flight management (Inheritance)
│   ├── Flight.java             # Base Flight class
│   ├── DomesticFlight.java     # Domestic flight type
│   ├── InternationalFlight.java# International flight type
│   ├── CargoFlight.java        # Cargo flight type
│   ├── CharterFlight.java      # Charter flight type
│   └── EmergencyFlight.java    # Emergency flight type
├── passenger/                  # Passenger management
│   ├── Passenger.java          # Passenger entity
│   ├── Reservation.java        # Reservation system
│   ├── Ticket.java             # Ticket management
│   └── BoardingPass.java       # Boarding pass generation
├── staff/                      # Staff management
│   ├── Staff.java              # Base Staff class
│   ├── Pilot.java              # Pilot role
│   ├── CabinCrew.java          # Cabin crew role
│   ├── GroundStaff.java        # Ground staff role
│   ├── SecurityOfficer.java    # Security officer role
│   └── MaintenanceStaff.java   # Maintenance staff role
├── operations/                 # Airport operations
│   ├── Payment.java            # Payment processing
│   ├── Schedule.java           # Flight scheduling
│   ├── Baggage.java            # Baggage handling
│   ├── SecurityCheck.java      # Security operations
│   └── Notification.java       # Notification system
└── utils/                      # Utility classes
    ├── FlightFactory.java      # Factory pattern for flight creation
    ├── InputValidator.java     # Input validation
    └── ReportGenerator.java    # Report generation
```

---

## OOP Principles Demonstrated

| Principle | Implementation |
|-----------|----------------|
| **Abstraction** | `AirportEntity` abstract class with abstract methods |
| **Encapsulation** | Private fields with public getters/setters throughout |
| **Inheritance** | `Staff` hierarchy, `Flight` hierarchy extending base classes |
| **Polymorphism** | `FlightFactory` creating different flight types; method overriding |
| **Interfaces** | `Payable`, `Reservable`, `Trackable` interfaces |
| **Factory Pattern** | `FlightFactory` for creating various flight types |

---

## Features

### Flight Management
- **5 Flight Types:** Domestic, International, Cargo, Charter, Emergency
- Flight scheduling with departure/arrival times
- Seat availability tracking
- Gate assignment

### Passenger Services
- Passenger registration with ID validation (Passport/National ID)
- Flight booking and reservation system
- Ticket generation with seat assignment
- Boarding pass creation
- Multiple class types (Economy, Business, First)

### Operations
- Payment processing with receipt generation
- Flight scheduling management
- Input validation for all user entries
- Report generation

### Airport Infrastructure
- Terminal and Gate management
- Airport information display
- Staff management (Pilots, Crew, Security, Ground, Maintenance)

---

## How to Run

### Option 1: Using Pre-built JAR (Recommended)

```bash
java -jar airport-system.jar
```

### Option 2: From Source Code

Compile and run:

```bash
# Compile all Java files
javac -d out airport/*.java airport/**/*.java

# Run the application
java -cp out airport.AirportSystem
```

Or using the compiled classes:

```bash
# Run from the out directory
java airport.AirportSystem
```

### Option 3: Using Docker

Build and run with Docker:

```bash
# Build Docker image
docker build -t airport-system .

# Run container
docker run -it airport-system
```

---

## Application Menu

```
===== AIRPORT MANAGEMENT SYSTEM =====
1. Book a Flight
2. View Available Flights
3. View My Reservations
4. Cancel Reservation
5. Generate Reports
6. Airport Information
0. Exit
=====================================
```

---

## Sample Flight Data (Pre-loaded)

The system initializes with 10 sample flights:

| Flight | Type | Route | Airline |
|--------|------|-------|---------|
| 1-2 | Domestic | New York ↔ Boston, Boston ↔ Chicago | SkyAir |
| 3-4 | International | New York → London, Chicago → Paris | GlobalWings, EuroAir |
| 5-6 | Cargo | Los Angeles ↔ Seattle, Miami → Houston | CargoExpress, CargoAir |
| 7-8 | Charter | Miami → Las Vegas, Los Angeles → Las Vegas | LuxuryAir, PrivateJet |
| 9-10 | Emergency | Houston → Dallas, Remote Area → Denver | MedEvac |

---

## Technical Requirements

- **Java Version:** 17 or higher
- **Build Tool:** None required (plain Java)
- **Docker:** Optional (for containerized deployment)

---

## Input Validation

The system includes validation for:
- Passport numbers (format: AB123456)
- National ID (8-12 digits)
- Phone numbers
- ID type selection
- Flight class types (Economy, Business, First)
- Menu choices

---

## File Manifest

| File | Description |
|------|-------------|
| `airport-system.jar` | Compiled executable JAR |
| `Dockerfile` | Docker build configuration |
| `MANIFEST.MF` | JAR manifest with Main-Class entry |
| `README.md` | This documentation file |

---