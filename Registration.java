public class Registration {
    public static void main(String[] args) {
        //creating Course objects
        Course course1 = new Course("WIX1001", "Computing Mathematics 1", 3, 30, 27, null);
        Course course2 = new Course("WIX1002", "Fundamentals of Programming", 5, 50, 41, null);
        Course course3 = new Course("WIX1003", "Computer System and Organization", 5, 40, 39, null);
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

        //Physical Course objects
        ArrayList<String> prerequisitesDS = new ArrayList<>();
        prerequisitesDS.add("WIX1002");
        PhysicalCourse physicalCourse1 = new PhysicalCourse("WIA1002", "Data Structures", 5, 50, 42, prerequisitesDS, "Lab 1");
        PhysicalCourse physicalCourse2 = new PhysicalCourse("WIA2005", "Network Technology Fundamentals", 4, 25, 25, null, "CCNA Lab");
        //displaying course info for physical courses
        physicalCourse1.displayCourseInfo();
        physicalCourse2.displayCourseInfo();

        Student student1 = new Student("Ali Jasim Bin Abdul Ghani", "24217998/1", 12);
        Student student2 = new Student("Muhammad Ziqri Bin Muhammad Yunus", "20017337/1", 21);
        Student student3 = new Student("Nur Safiyyah Binti Muhammad Abdul Hakim", "20286145/2", 18);
        //enrolling student 1 in courses
        st1Enroll1 = student1.enrollInCourse(course2);
        st1Enroll2 = student1.enrollInCourse(onlineCourse1);
        st1Enroll3 = student1.enrollInCourse(physicalCourse1);

    }
}