/**
 * The CourseRecord class represents a record of a Course, its status, and its grade.
 *
 * @author [Your Name]
 * @version [Version Number]
 * @since [Date Created]
 */
 
 package records;
 import course.Course;
 
 public class CourseRecord {
     
    /**
     * The possible Status values of a CourseRecord.
     */
    public enum Status {
        IN_PROGRESS, COMPLETED, FAILED
    }
     
    private Course course;
    private Status status;
    private Float grade;
    
    /**
     * Constructs a new CourseRecord object with given course, status, and grade.
     *
     * @param _course the course of the record
     * @param _status the status of the record
     * @param _grade the grade of the record
     */
    public CourseRecord(Course _course, Status _status, Float _grade) {
        this.course = _course;
        this.status = _status;
        this.grade = _grade;
    }

    /**
     * Returns the course of the record.
     *
     * @return the course
     */
        public Course GetCourse() {
        return course;
    }

    /**
     * Sets the course of the record.
     *
     * @param course the course to set
     */
    public void SetCourse(Course course) {
        this.course = course;
    }

    /**
     * Returns the status of the record.
     *
     * @return the status
     */
    public Status GetStatus() {
        return status;
    }

    /**
     * Sets the status of the record.
     *
     * @param status the status to set
     */
    public void SetStatus(Status status) {
        this.status = status;
    }

    /**
     * Returns the grade of the record.
     *
     * @return the grade
     */
    public Float GetGrade() {
        return grade;
    }

   /**
    * Sets the grade of the record.
    * 
    * @param grade the grade to set
    */
    public void SetGrade(Float grade) {
        this.grade = grade;
    }

   /**
    * Returns a String representation of the CourseRecord.
    *
    * @return the String representation
    */
    public String toString() {
        String str = this.course.toString() + " " + this.status.toString() + " " + this.grade.toString();

        return str;
    }

}