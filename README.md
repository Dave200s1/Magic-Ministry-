# Magic-Ministry-

![npm bundle size (version)](https://img.shields.io/badge/version-0.0.1-darkblue)  ![npm bundle size (version)](https://img.shields.io/badge/language-Java-red)  ![npm bundle size (version)](https://img.shields.io/badge/SpringBoot-lightgreen)

A Spring Boot REST API for managing the Ministry of Magic's wizard registry — departments, employees, wands, patronuses, security clearances, and case files. Built as a portfolio project to demonstrate layered Spring architecture, SQLite persistence with Flyway migrations, Bean Validation, and (soon) JWT-based authentication with role and clearance-based authorization.

> **Status:** Department module complete (CRUD + seed data). Other entities in progress — see [Roadmap](#roadmap).

---

## 🧙 Domain Model

The registry models the Ministry as a set of departments staffed by wizards, each with a wand (and its ownership history), an optional patronus, and a security clearance. Case files are opened by departments and led by employees.

```mermaid
erDiagram
    WIZARD ||--o| PATRONUS : "conjures"
    WIZARD ||--o{ WAND_OWNERSHIP : "has held"
    WAND   ||--o{ WAND_OWNERSHIP : "passed to"
    WIZARD ||--o| EMPLOYEE : "employed as"
    DEPARTMENT ||--o{ EMPLOYEE : "staffs"
    EMPLOYEE ||--o{ EMPLOYEE : "supervises"
    EMPLOYEE ||--o{ SECURITY_CLEARANCE : "holds"
    DEPARTMENT ||--o{ CASE_FILE : "handles"
    EMPLOYEE ||--o{ CASE_FILE : "leads"
    WIZARD ||--o| USER_ACCOUNT : "authenticates via"
    WIZARD ||--o{ WIZARD_SPELL : "knows"
    SPELL  ||--o{ WIZARD_SPELL : "known by"

    WIZARD {
        int wizard_id PK
        string first_name
        string last_name
        date date_of_birth
        string blood_status
        string hogwarts_house
        boolean animagus
        datetime registered_at
    }
    PATRONUS {
        int patronus_id PK
        int wizard_id FK
        string form
        boolean corporeal
        string memory_used
    }
    WAND {
        int wand_id PK
        string wood
        string core
        decimal length_inches
        string flexibility
        string maker
    }
    WAND_OWNERSHIP {
        int ownership_id PK
        int wand_id FK
        int wizard_id FK
        date acquired_on
        date released_on
    }
    DEPARTMENT {
        int department_id PK
        string name
        int floor
        string description
    }
    EMPLOYEE {
        int employee_id PK
        int wizard_id FK
        int department_id FK
        int manager_id FK
        string title
        date hired_on
        string salary_grade
    }
    SECURITY_CLEARANCE {
        int clearance_id PK
        int employee_id FK
        string level
        date granted_on
        date expires_on
        int granted_by_id FK
    }
    CASE_FILE {
        int case_id PK
        string case_number
        string title
        string status
        int department_id FK
        int lead_employee_id FK
        date opened_on
        date closed_on
    }
    SPELL {
        int spell_id PK
        string incantation
        string name
        string type
        string danger_level
    }
    WIZARD_SPELL {
        int wizard_id FK
        int spell_id FK
        int proficiency
        date learned_on
    }
    USER_ACCOUNT {
        int user_id PK
        int wizard_id FK
        string username
        string password_hash
        string role
        boolean enabled
        datetime created_at
    }
