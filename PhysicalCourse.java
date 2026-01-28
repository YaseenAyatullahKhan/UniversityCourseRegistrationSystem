import java.util.ArrayList;

public class PhysicalCourse extends Course {
    private char whichBlock;
    private String roomName;
    private boolean hasLab;

    //constructors
    public PhysicalCourse() {}
    public PhysicalCourse(String courseCode, String courseName, int creditHours, int maxCapacity, int currentEnrollment, ArrayList<String> prerequisites, char whichBlock, String roomName, boolean hasLab) {
        super(courseCode, courseName, creditHours, maxCapacity, currentEnrollment, prerequisites);
        this.whichBlock = whichBlock;
        this.roomName = roomName;
        this.hasLab = hasLab;
    }

    //getters and setters
    public char getWhichBlock() {
        return whichBlock;
    }
    public String getRoomName() {
        return roomName;
    }
    public boolean getHasLab() {
        return hasLab;
    }

    public void setWhichBlock(char whichBlock) {
        if (whichBlock != ' ') {
            this.whichBlock = whichBlock;
        } else {
            throw new IllegalArgumentException("Block cannot be empty!");
        }
    }
    public void setRoomName(String roomName) {
        if (roomName != null && !roomName.equals("")) {
            this.roomName = roomName;
        } else {
            throw new IllegalArgumentException("Room name cannot be null or empty!");
        }
    }
    public void setHasLab(boolean hasLab) {
        if (hasLab == true || hasLab == false) {
            this.hasLab = hasLab;
        } else {
            throw new IllegalArgumentException("Invalid input for hasLab: only true or false allowed!");
        }
    }
    
    //overriden display method
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Block: " + whichBlock);
        System.out.println("Room Name: " + roomName);
        if (hasLab == true) {
            System.out.println("Has Lab: Yes");
        } else {
            System.out.println("Has Lab: No");
        }
    }
}