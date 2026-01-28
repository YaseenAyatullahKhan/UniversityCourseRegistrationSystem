import java.util.ArrayList;

public class OnlineCourse extends Course {
    //instance variables
    private String meetingPlatform;
    private boolean recordingAvailable;
    private String meetingLink;

    //constructors
    public OnlineCourse() {}
    public OnlineCourse(String courseCode, String courseName, int creditHours, int maxCapacity, int currentEnrollment, ArrayList<String> prerequisites,String meetingPlatform, boolean recordingAvailable, String meetingLink) {
        super(courseCode, courseName, creditHours, maxCapacity, currentEnrollment, prerequisites);
        
        if (meetingPlatform != null && !meetingPlatform.equals("")) {
            this.meetingPlatform = meetingPlatform;
        } else {
            throw new IllegalArgumentException("Meeting platform cannot be null or empty!");
        }
        if (recordingAvailable == true || recordingAvailable == false) {
            this.recordingAvailable = recordingAvailable;
        } else {
            throw new IllegalArgumentException("Invalid value for recordingAvailable: only true or false allowed!");
        }
        if (meetingLink != null && !meetingLink.equals("")) {
            this.meetingLink = meetingLink;
        } else {
            throw new IllegalArgumentException("Meeting link cannot be null or empty!");
        }
    }

    //getters and setters
    public String getMeetingPlatform() {
        return meetingPlatform;
    }
    public boolean getRecordingAvailable() {
        return recordingAvailable;
    }
    public String getMeetingLink() {
        return meetingLink;
    }

    public void setMeetingPlatform(String meetingPlatform) {
        if (meetingPlatform != null && !meetingPlatform.equals("")) {
            this.meetingPlatform = meetingPlatform;
        } else {
            throw new IllegalArgumentException("Meeting platform cannot be null or empty!");
        }
    }
    public void setRecordingAvailable(boolean recordingAvailable) {
        if (recordingAvailable == true || recordingAvailable == false) {
            this.recordingAvailable = recordingAvailable;
        } else {
            throw new IllegalArgumentException("Invalid value for recordingAvailable: only true or false allowed!");
        }
    }
    public void setMeetingLink(String meetingLink) {
        if (meetingLink != null && !meetingLink.equals("")) {
            this.meetingLink = meetingLink;
        } else {
            throw new IllegalArgumentException("Meeting link cannot be null or empty!");
        }
    }

    //overriden display method
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Meeting Platform: " + meetingPlatform);
        System.out.println("Recording Available: " + recordingAvailable);
        System.out.println("Meeting Link: " + meetingLink);
    }
}