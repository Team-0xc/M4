package course;

public class Meeting implements Comparable<Meeting> {

    public enum Day {
        Sun, Mon, Tue, Wed, Thu, Fri, Sat, NONE
    }
    
    private Integer startTime, endTime;
    private Day day;
    private MeetingType type;

    /**
     * Creates a new Meeting with default values.
     */
    public Meeting() {
        this.startTime = 0;
        this.endTime = 0;
        this.day = Day.NONE;
        this.type = MeetingType.NONE;
    }

    /**
     * Creates a new Meeting with the specified start time,
     * end time, day and type.
     * @param _startTime the start time of the meeting.
     * @param _endTime the end time of the meeting.
     * @param _day the day of the meeting.
     * @param _type the type of the meeting.
     */
    public Meeting(Integer _startTime, Integer _endTime, Day _day, MeetingType _type) {
        this();
        this.startTime = _startTime;
        this.endTime = _endTime;
        this.day = _day;
        this.type = _type;
    }

    /**
     * Returns the start time of the meeting.
     * @return the start time of the meeting.
     */
    public Integer GetStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the meeting.
     * @param startTime the start time of the meeting.
     */
    public void SetStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns the end time of the meeting.
     * @return the end time of the meeting.
     */
    public Integer GetEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the meeting.
     * @param endTime the end time of the meeting.
     */
    public void SetEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    /**
     * Returns the day of the meeting.
     * @return the day of the meeting.
     */
    public Day GetDay() {
        return day;
    }

    /**
     * Sets the day of the meeting.
     * @param day the day of the meeting.
     */
    public void SetDay(Day day) {
        this.day = day;
    }

    /**
     * Returns the type of the meeting.
     * @return the type of the meeting.
     */
    public MeetingType GetType() {
        return type;
    }

    /**
     * Sets the type of the meeting.
     * @param type the type of the meeting.
     */
    public void SetMeetingType(MeetingType type) {
        this.type = type;
    }

    /**
     * Returns a String representation of the Meeting object.
     * @return a String representation of the Meeting object.
     */
    public String toString() {
        return this.GetType().toString() + " Meeting: " + this.GetDay().toString() + " @ " + this.GetStartTime() + " - " + this.GetEndTime();
    }

    /**
     * Checks whether this meeting conflicts with another meeting.
     * @param other the meeting to compare with.
     * @return whether the two meetings conflict.
     */
    public boolean IsConflict(Meeting other) {

        if(this.GetDay() == other.GetDay()) {
            // Same day, check if other start/end time is in between this start/end time
            return (other.GetStartTime() >= this.GetStartTime() && other.GetStartTime() <= this.GetEndTime()) ||
                (other.GetEndTime() >= this.GetStartTime() && other.GetEndTime() <= this.GetEndTime());
        }

        return false;

    }

    /**
     * Compares this Meeting object with another Meeting object.
     * @param other the Meeting object to compare with.
     * @return an int value indicating the order of the two meetings.
     */
    public int compareTo(Meeting other) {

        if(this.GetDay() == other.GetDay()) {
            // Same day, Compare start times
            return this.GetStartTime() - other.GetStartTime();
        }

        return this.GetDay().compareTo(other.GetDay());
    }

}
