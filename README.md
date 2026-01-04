# Internship Finder – Java Application

Internship Finder is a Java-based desktop application designed to connect students with companies offering internship opportunities. The system allows internship seekers to search and view internships, employers to post internship opportunities, and administrators to review and approve internships.  
This project was converted and enhanced from an Online Job Portal into a complete Internship Finder system.

---

## Objectives

- Provide a centralized platform for internship opportunities
- Allow companies to post structured internship listings
- Enable admin approval for quality control
- Demonstrate clean Java architecture and OOP principles

---

## System Roles

### Internship Seeker (User)
- Register and log in
- Search available internships
- View complete internship details:
  - Duration
  - Stipend (Paid / Unpaid)
  - Internship Mode (Remote / Onsite / Hybrid)
  - Start Date
  - Required Skills
  - Eligibility Criteria

### Employer (Company / Internship Provider)
- Create and manage employer profile
- Post internship opportunities
- Define internship-specific information such as duration, stipend, skills, and eligibility

### Admin
- View all pending internship postings
- Approve or reject internships
- Maintain platform quality

---

## Key Features

- Role-based access (User, Employer, Admin)
- Internship-specific posting system
- Admin approval workflow
- Clean and modular Java codebase
- Easy to extend and maintain

---

## Technologies Used

- Java (JDK 8 or higher)
- Java-based UI (Swing / JavaFX style)
- Object-Oriented Programming (OOP)
- MVVM-style architecture (View / ViewModel)

---

## Project Structure

The project follows a clean and modular architecture. Utility classes are placed in a dedicated utils package to handle validation, email handling, and notifications. The core data structure of the application is defined in the model package, which contains the Internship entity. Data handling and in-memory storage logic are managed inside the repository package.

The user interface is organized under the view package and is further divided into admin, employer, and user sections to clearly separate responsibilities and workflows. Application logic and business rules are implemented in the viewmodel package, ensuring proper separation between UI and logic. The application execution starts from the Main class, which acts as the entry point of the system.

---

## Application Workflow

1. Application starts from `Main.java`
2. User logs in or registers
3. Employer posts internship
4. Admin reviews and approves internship
5. Approved internships become visible to users
6. Users search and view internship details

---

## How to Run the Project

### Using an IDE (Recommended)

1. Install **Java JDK 8 or later**
2. Open the project in **VS Code / IntelliJ IDEA / Eclipse**
3. Open `Main.java`
4. Run the project

## Notes

- Only `.java` source files are included in the `src` directory  
- `.class` files are generated automatically during compilation  
- The project currently uses in-memory data storage  

---

## Limitations

- No database integration  
- No internship application feature  
- Data is not persistent after application restart  

---

## Future Enhancements

- Internship application and applicant tracking system  
- Database integration (MySQL / SQLite)  
- Advanced search filters  
- Role-based authentication improvements  
- Web version using Spring Boot  

---

## Academic Use

This project is suitable for:

- University semester projects  
- Java OOP assignments  
- Software Engineering coursework  
- Internship project submissions  
