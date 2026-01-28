# University Course Registration System

A University course registration system that allows students to enroll and drop courses while managing their credit hours and course prerequisites. This system tries to demonstrate OOP concepts like inheritance, encapsulation, and exception handling.

## Student Profile
Full Name: **Yaseen Ayatullah Khan**  
Matric Number: **24216494/1**

## YouTube Link
https://youtu.be/7f2_FIk8fwE

## How It Works

### Student Enrollment
- Students can enroll in courses only if they meet the prerequisites and have available credit hours
- Students have a maximum credit hour limit
- The system prevents students from enrolling in the same course twice
- Students can drop courses and free up their credit hours (for courses they have taken)

### Courses
The system supports three types of courses:

**Regular Courses** - Basic course information with code, name, credit hours, and capacity  
*(parent class)*

**Online Courses** - Include meeting platform (e.g., Google Meet, Teams), recording availability, and a meeting link  
*(child class)*

**Physical Courses** - Include location details like specifying the Faculty Block, room name, and whether they have a lab class
*(child class)*

All courses track prerequisites (courses you need to complete before taking the current one) and include current enrollment numbers to prevent exceeding maximum capacity.

### Key Features
- **Capacity Management** - Courses have maximum capacity limits and track current enrollment
- **Prerequisites** - Courses can require students to complete other courses first
- **Credit Hour Tracking** - Students can't exceed their maximum credit hour limit
- **Error Handling** - The system validates all inputs and prevents invalid operations using exception handling
- **Course Management** - Instructors/admins can create, update, and display course information using the main class `Registration.java`

## What is included

- **Course.java** - Parent class for all course types with basic course properties
- **OnlineCourse.java** - Extends Course for online learning platforms
- **PhysicalCourse.java** - Extends Course for in-person classes
- **Student.java** - Represents a student with enrollment and credit hour tracking
- **Registration.java** - Main class that demonstrates the system in action with examples and test cases  
*(this is the file we run for showing all the output)*
