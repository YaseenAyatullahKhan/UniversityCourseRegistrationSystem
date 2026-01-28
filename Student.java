import java.util.ArrayList;
public class Student {
    private String studentID;
    private String name;
    private ArrayList<Course> enrolledCourses;
    private int maxCredits;
    private static int totalCreditsEnrolled;

    //constructors
    public Student() {}
    public Student(String studentID, String name, int maxCredits) {
         this.name = name;
         this.studentID = studentID;
         this.maxCredits = maxCredits;
         enrolledCourses = new ArrayList<>();
         totalCreditsEnrolled = 0;
    }

    public String getStudentID() {
        return studentID;
    }
    public String getName() {
        return name;
    }
    public int getMaxCredits() {
        return maxCredits;
    }
    public int getTotalCreditsEnrolled() {
        return totalCreditsEnrolled;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMaxCredits(int maxCredits) {
        this.maxCredits = maxCredits;
    }

    //methods
    boolean hasPrerequisites;
    public boolean enrollInCourse(Course course) {
        if (course.getPrerequisites() != null) {
            //check if student has the prerequisite course(s)
            for (int x = 0; x < course.getPrerequisites().size(); x++) {
                hasPrerequisites = false;
                for (int y = 0; y < enrolledCourses.size(); y++) {
                    if (course.getPrerequisites().get(x).equals(enrolledCourses.get(y).getCourseCode())) {
                        hasPrerequisites = true;
                    }
                }
            }
        } else {
            hasPrerequisites = true;
        }
        //checking if student can enroll then adding the course
        if ((hasPrerequisites == true) && (totalCreditsEnrolled + course.getCreditHours() <= maxCredits) && (course.getCurrentEnrollment() < course.getMaxCapacity())) {
            enrolledCourses.add(course);
            totalCreditsEnrolled += course.getCreditHours();
            course.incrementEnrollment();
            return true;
        }
        return false;
    }
    public void dropCourse(Course course) {
        if (enrolledCourses.remove(course) == true) {
            totalCreditsEnrolled -= course.getCreditHours();
            course.decrementEnrollment();
        }
    }
    public void displayStudentInfo() {
        System.out.println("Student ID: " + this.studentID);
        System.out.println("Name: " + this.name);
        System.out.println("Maximum Credits Allowed: " + this.maxCredits);
        System.out.println("Total Credits Enrolled: " + totalCreditsEnrolled);
        System.out.println("Enrolled Courses: ");
        for (int i = 0; i < enrolledCourses.size(); i++) {
            Course course = enrolledCourses.get(i);
            System.out.println(course.getCourseCode() + " : " + course.getCourseName());
        }
    }
    //method to check if student can enroll in more courses
    public boolean noMoreCourses() {
        return (totalCreditsEnrolled > maxCredits);
    }
}