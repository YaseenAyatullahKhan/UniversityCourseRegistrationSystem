import java.util.ArrayList;

public class Registration {
    public static void main(String[] args) {
        //creating Course objects
        Course course1 = new Course("WIX1001", "Computing Mathematics 1", 3, 30, 27, null);
        Course course2 = new Course("WIX1002", "Fundamentals of Programming", 5, 50, 41, null);
        Course course3 = new Course("WIX1003", "Computer System and Organization", 3, 40, 39, null);
        //displaying course info for each course
        course1.displayCourseInfo();
        course2.displayCourseInfo();
        course3.displayCourseInfo();

        //Online Course objects
        OnlineCourse onlineCourse1 = new OnlineCourse("GIG1003", "Basic Entrepreneurship Enculturation", 2, 1000, 937, null, "Google Meet");
        OnlineCourse onlineCourse2 = new OnlineCourse("GLT1029", "Basic Arabic Language 1", 2, 15, 12, null, "Microsoft Teams");
        //displaying course info for online courses
        onlineCourse1.displayCourseInfo();
        onlineCourse2.displayCourseInfo();
        //using an online course setter method to update meeting link
        onlineCourse1.setMeetingLink("https://teams.microsoft.com/l/meetup-join/19%3ameeting_NmYyYzYzY2ItZGIxZi00Y2E3LWI3YzItY2E0ZTI3YjI0ZGI4%0598tu5grrjgr8H8rg");
        //displaying updated online course info
        onlineCourse1.displayCourseInfo();

        //Physical Course objects
        ArrayList<String> prerequisitesDS = new ArrayList<>();
        prerequisitesDS.add("WIX1002");
        PhysicalCourse physicalCourse1 = new PhysicalCourse("WIA1002", "Data Structures", 5, 50, 42, prerequisitesDS, "Lab 1");
        PhysicalCourse physicalCourse2 = new PhysicalCourse("WIA2005", "Network Technology Fundamentals", 4, 25, 25, null, "CCNA Lab");
        //displaying course info for physical courses
        physicalCourse1.displayCourseInfo();
        physicalCourse2.displayCourseInfo();
        //using a physical course setter method to update room name
        physicalCourse1.setRoomName("Makmal Mikro 6");
        //displaying updated physical course info
        physicalCourse1.displayCourseInfo();

        Student student1 = new Student("Ali Jasim Bin Abdul Ghani", "24217998/1", 12);
        Student student2 = new Student("Muhammad Ziqri Bin Muhammad Yunus", "20017337/1", 21);
        Student student3 = new Student("Nur Safiyyah Binti Muhammad Abdul Hakim", "20286145/2", 18);

        //enrolling student 1 in courses
        boolean st1Enroll1 = student1.enrollInCourse(course2);
        boolean st1Enroll2 = student1.enrollInCourse(onlineCourse1);
        boolean st1Enroll3 = student1.enrollInCourse(physicalCourse1);
        //trying to enroll student 1 in a full course
        boolean st1Enroll4 = student1.enrollInCourse(physicalCourse2);
        //result of trying to enroll student 1 in a full course:
        System.out.println("Can " + student1.getName() + " enroll in " + physicalCourse2.getCourseCode() + " ?  " + st1Enroll4);
        //trying to enroll student 1 in a course exceeding their max credit hours
        boolean st1Enroll5 = student1.enrollInCourse(course3);
        //result of trying to enroll student 1 in a course exceeding their max credit hours:
        System.out.println("Can " + student1.getName() + " enroll in " + course3.getCourseCode() + " now?  " + st1Enroll5);
        //displaying student 1 info and enrolled courses
        student1.displayStudentInfo();

        //dropping a course for student 1
        System.out.println(course2.getCourseName() + " current enrollment number: " + course2.getCurrentEnrollment());
        student1.dropCourse(course2);
        //displaying updated student 1 info and enrolled courses
        student1.displayStudentInfo();
        //displaying course enrollment updated
        System.out.println(course2.getCourseName() + " new enrollment number: " + course2.getCurrentEnrollment());

        //showing polymorphism
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(onlineCourse1);
        courseList.add(physicalCourse1);
        courseList.add(onlineCourse2);
        courseList.add(physicalCourse2);
        for (Course c : courseList) {
            c.displayCourseInfo();
            System.out.println();
        }

        System.out.println("\nTrying more invalid operations to check exception handling");

        //setting negative course capacity
        try {
            onlineCourse1.setMaxCapacity(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //creating an Online Course with null value for course code
        try {
            OnlineCourse invalidOnlineCourse = new OnlineCourse(null, "Invalid Course", 3, 30, 10, null, "Whatsapp Call");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //empty meeting platform
        try {
            onlineCourse2.setMeetingPlatform("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //creating a Physical Course with empty Block
        try {
            PhysicalCourse invalid = new PhysicalCourse("WWW3001", "Invalid Physical Course", 4, 40, 20, ' ', "Bilik Kuliah", true);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //creating a Physical Course with null room name
        try {
            PhysicalCourse invalid2 = new PhysicalCourse("WWE5001", "Invalid Physical Course", 4, 40, 20, 'B', null, false);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //setting invalid hasLab value
        try {
            physicalCourse1.setHasLab("Maybe");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //creating student with empty name
        try {
            Student invalidStudent1 = new Student("", "24323971/1", 15);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //creating student with null ID
        try {
            Student invalidStudent2 = new Student("Muhammad Mujahid bin Abdullah", null, 17);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //enrolling student1 in a course already enrolled in
        try {
            boolean doubleEnroll = student1.enrollInCourse(physicalCourse1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //dropping a course not enrolled in by student1
        try {
            student1.dropCourse(course3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}