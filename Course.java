//parent class
public class Course {
    //instance variables
    private String courseCode;
    private String courseName;
    private int creditHours;
    private int maxCapacity;
    private int currentEnrollment;
    private ArrayList<String> prerequisites;
    
    //no-argument constructor
    public Course() {
        this.courseCode = "No course code";
        this.coureName = "Unnamed course";
        this.creditHours = 0;
        this.maxCapacity = 0;
        this.currentEnrollment = 0;
        this.prerequisites = new ArrayList<String>();
    }
    
    //parameterized constructor
    public Course(String courseCode, String courseName, int creditHours, int maxCapacity, int currentEnrollment, ArrayList<String> prerequisites) {
        if (courseCode != null && courseCode != "") {
            this.courseCode courseCode;
        } else {
            throw new IllegalArgumentException("Course Code cannot be empty!");
        }
        if (courseName != null && courseName != "") {
            this.coureName = courseName;
        } else {
            throw new IllegalArgumentException("Course Name cannot be empty!");
        }
        if (creditHours > 0) {
            this.creditHours = creditHours;
        } else {
            throw new IllegalArgumentException("Credit Hours cannot be negative or zero!");
        }
        if (maxCapacity > 0) {
            this.maxCapacity = maxCapacity;
        } else {
            throw new IllegalArgumentException("Maximum Capacity cannot be negative or zero!");
        }
        if (currentEnrollment > 0) {
            this.currentEnrollment = currentEnrollment;
        } else {
            throw new IllegalArgumentException("Current Enrollment cannot be negative or zero!");
        }
        if (prerequisites == this.prerequisites) {
            this.prerequisites = prerequisites;
        } else {
            throw new IllegalArgumentException("Not all prerequisites achieved!");
        }
    }
    
    //get and set methods
    public String getCourseCode() {
        return this.courseCode;
    }
    public String getCourseName() {
        return this.courseName;
    }
    public String getCreditHours() {
        return this.creditHours;
    }
    public String getMaxCapacity() {
        return this.maxCapacity;
    }
    public String getCurrentEnrollment() {
        return this.currentEnrollment;
    }
    
    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity > 0) {
            this.maxCapacity = maxCapacity;
        } else {
            throw new IllegalArgumentException("Maximum Capacity cannot be negative or zero!");
        }
    }
    public void setCurrentEnrollment(int currentEnrollment) {
        if (currentEnrollment > 0) {
            this.currentEnrollment = currentEnrollment;
        } else {
            throw new IllegalArgumentException("Current Enrollment cannot be negative or zero!");
        }
    }
    
    //methods
    public boolean courseFull() {
        if (this.currentEnrollment == this.maxCapacity) {
            return true;
        }
        return false;
    }
    public void incrementEnrollment() {
        this.currentEnrollment++;
    }
    public void decrementEnrollment() {
        this.currentEnrollment--;
    }
    public void displayCourseInfo() {
        System.out.println("Course Code:", this.courseCode);
        System.out.println("Course Name:", this.courseName);
        System.out.println("Credit Hours: " + this.creditHours);
        System.out.println("Maximum Capacity: " + this.maxCapacity);
        System.out.println("Current Enrollment: " + this.currentEnrollment);
    }
}
