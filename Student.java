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
        if (studentID != null && !studentID.equals("")) {
            this.studentID = studentID;
        } else {
            throw new IllegalArgumentException("Student ID cannot be null or empty!");
        }
        if (name != null && !name.equals("")) { 
            this.name = name;
        } else {
            throw new IllegalArgumentException("Student name cannot be null or empty!");
        }
        if (maxCredits > 0) {
            this.maxCredits = maxCredits;
        } else {
            throw new IllegalArgumentException("Maximum credits must be greater than zero!");
        }
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
        if (studentID != null && !studentID.equals("")) {
            this.studentID = studentID;
        } else {
            throw new IllegalArgumentException("Student ID cannot be null or empty!");
        }
    }
    public void setName(String name) {
        if (name != null && !name.equals("")) { 
            this.name = name;
        } else {
            throw new IllegalArgumentException("Student name cannot be null or empty!");
        }
    }
    public void setMaxCredits(int maxCredits) {
        if (maxCredits > 0) {
            this.maxCredits = maxCredits;
        } else {
            throw new IllegalArgumentException("Maximum credits must be greater than zero!");
        }
    }

    boolean hasPrerequisites;
    //methods
    public boolean enrollInCourse(Course course) {
        //checking if student already enrolled in the course
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getCourseCode().equals(course.getCourseCode())) {
                throw new IllegalArgumentException("Student is already enrolled in this course!");
            }
        }
        //for prerequisites
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
        //adding the course if student can enroll
        if ((hasPrerequisites) && (totalCreditsEnrolled + course.getCreditHours() <= maxCredits) && (course.getCurrentEnrollment() < course.getMaxCapacity())) {
            enrolledCourses.add(course);
            totalCreditsEnrolled += course.getCreditHours();
            course.incrementEnrollment();
            return true;
        }
        return false;
    }
    public void dropCourse(Course course) {
        //checking if student is enrolled in the course before dropping
        for (Course c : enrolledCourses) {
            if (c.getCourseCode().equals(course.getCourseCode())) {
                break;
            } else {
                throw new IllegalArgumentException("Student is not enrolled in this course!");
            }
        }
        //dropping the specified course for student
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
        return (totalCreditsEnrolled >= maxCredits);
    }
}