package course;

public class Meeting implements Comparable<Meeting> {

    public enum Day {
        Sun, Mon, Tue, Wed, Thu, Fri, Sat, NONE
    }
    
    private Integer startTime, endTime;
    private Day day;
    private MeetingType type;

    public Meeting() {
        this.startTime = 0;
        this.endTime = 0;
        this.day = Day.NONE;
        this.type = MeetingType.NONE;
    }

    public Meeting(Integer _startTime, Integer _endTime, Day _day, MeetingType _type) {
        this();
        this.startTime = _startTime;
        this.endTime = _endTime;
        this.day = _day;
        this.type = _type;
    }

    public Integer GetStartTime() {
        return startTime;
    }

    public void SetStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer GetEndTime() {
        return endTime;
    }

    public void SetEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Day GetDay() {
        return day;
    }

    public void SetDay(Day day) {
        this.day = day;
    }

    public MeetingType GetType() {
        return type;
    }

    public void SetMeetingType(MeetingType type) {
        this.type = type;
    }

    public String toString() {
        return this.GetType().toString() + " Meeting: " + this.GetDay().toString();
    }

    public int compareTo(Meeting other) {

        if(this.GetDay() == other.GetDay()) {
            // Same day, Compare start times
            return this.GetStartTime() - other.GetStartTime();
        }

        return this.GetDay().compareTo(other.GetDay());

    }

}
