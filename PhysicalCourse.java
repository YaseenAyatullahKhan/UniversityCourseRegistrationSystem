public class PhysicalCourse extends Course {
    private char whichBlock;
    private String roomName;
    private boolean hasLab;

    //constructors
    public PhysicalCourse() {}
    public PhysicalCourse(String courseCode, String courseName, int creditHours, int maxCapacity, int currentEnrollment, char whichBlock, String roomName, boolean hasLab) {
        super(courseCode, courseName, creditHours, maxCapacity, currentEnrollment);
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
        this.whichBlock = whichBlock;
    }
    public void setRoomName(String roomName) {
        if (roomName != null && !roomName.equals("")) {
            this.roomName = roomName;
        }
    }
    public void setHasLab(boolean hasLab) {
        if (hasLab == true || hasLab == false) {
            this.hasLab = hasLab;
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