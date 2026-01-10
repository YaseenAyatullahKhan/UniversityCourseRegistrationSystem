public class OnlineCourse extends Course {
    //instance variables
    private String meetingPlatform;
    private boolean recordingAvailable;
    private String meetingLink;

    //constructor
    public OnlineCourse(String meetingPlatform, boolean recordingAvailable, String meetingLink) {
        super(courseCode, courseName, creditHours, maxCapacity, currentEnrollment);
        this.meetingPlatform = meetingPlatform;
        this.recordingAvailable = recordingAvailable;
        this.meetingLink = meetingLink;
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
        }
    }
    public void setRecordingAvailable(boolean recordingAvailable) {
        if (recordingAvailable == true || recordingAvailable == false) {
            this.recordingAvailable = recordingAvailable;
        }
    }
    public void setMeetingLink(String meetingLink) {
        if (meetingLink != null && !meetingLink.equals("")) {
            this.meetingLink = meetingLink;
        }
    }

    //display method
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Meeting Platform: " + meetingPlatform);
        System.out.println("Recording Available: " + recordingAvailable);
        System.out.println("Meeting Link: " + meetingLink);
}