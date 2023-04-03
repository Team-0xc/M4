package course;

import java.util.ArrayList;
import java.util.Arrays;

import utils.Hashable;

public class Course implements Hashable {

    private Subject subject;
    private Integer courseCode;
    private Float weight;

    private ArrayList<Course> preReqs;

    /**
     * Blank constructor 
     */
    public Course() {
        this.subject = Subject.NULL;
        this.courseCode = 0;
        this.weight = 0.0f;
        this.preReqs = new ArrayList<Course>(0);
    }

    /**
     * General constructor for course
     * 
     * @param _subject Subject: the just the course will be (i.e CIS)
     * @param _courseCode Integer: the code of the course (i.e 1500)
     * @param _weight Float: The weight of the course (i.e. 0.5f)
     */
    public Course(Subject _subject, Integer _courseCode, Float _weight) {
        this();
        this.subject = _subject;
        this.courseCode = _courseCode;
        this.weight = _weight;
    }
    
    /**
     * General constructor for course with pre requisites
     * 
     * @param _subject Subject: the just the course will be (i.e CIS)
     * @param _courseCode Integer: the code of the course (i.e 1500)
     * @param _weight Float: The weight of the course (i.e. 0.5f)
     * @param _preReqs Course[]: A list of the required courses
     */
    public Course(Subject _subject, Integer _courseCode, Float _weight, Course[] _preReqs) {
        this(_subject, _courseCode, _weight);
        this.preReqs.addAll(Arrays.asList(_preReqs));
    }
    
    /**
     * Returns the subject of the course.
     *
     * @return subject of the course
     */
    public Subject GetSubject() {
        return subject;
    }

    /**
     * Sets the subject of the course.
     *
     * @param subject subject of the course
     */
    public void SetSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * Returns the course code.
     *
     * @return course code
     */
    public Integer GetCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code.
     *
     * @param courseCode course code
     */
    public void SetCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Returns the weight of the course.
     *
     * @return weight of the course
     */
    public Float GetWeight() {
        return weight;
    }

    /**
     * Sets the weight of the course.
     *
     * @param weight weight of the course
     */
    public void SetWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * Returns a list of prerequisites for the course.
     *
     * @return a list of prerequisites for the course
     */
    public ArrayList<Course> GetPreReqs() {
        return preReqs;
    }

    /**
     * Sets a list of prerequisites for the course.
     *
     * @param preReqs a list of prerequisites for the course
     */
    public void SetPreReqs(ArrayList<Course> preReqs) {
        this.preReqs = preReqs;
    }

    /**
     * Returns a string representation of the course.
     *
     * @return a string representation of the course
     */
    public String toString() {
        return this.GetSubject().toString() + "*" + String.format("%04d", this.GetCourseCode());
    }

    /**
     * Returns a hash value of the course.
     *
     * @return a hash value of the course
     */
    public String GetHash() {
        return Integer.toString(this.GetSubject().toString().hashCode() * String.format("%04d", this.GetCourseCode()).hashCode());
    }
}
