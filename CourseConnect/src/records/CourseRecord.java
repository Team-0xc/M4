package records;

import course.Course;

public class CourseRecord {

    public enum Status {
        IN_PROGRESS, COMPLETED, FAILED
    }

    private Course course;
    private Status status;
    private Float grade;
    
    public CourseRecord(Course _course, Status _status, Float _grade) {
        this.course = _course;
        this.status = _status;
        this.grade = _grade;
    }

    public Course GetCourse() {
        return course;
    }

    public void SetCourse(Course course) {
        this.course = course;
    }

    public Status GetStatus() {
        return status;
    }

    public void SetStatus(Status status) {
        this.status = status;
    }

    public Float GetGrade() {
        return grade;
    }

    public void SetGrade(Float grade) {
        this.grade = grade;
    }

    public String toString() {
        String str = this.course.toString() + " " + this.status.toString() + " " + this.grade.toString();

        return str;
    }

}
