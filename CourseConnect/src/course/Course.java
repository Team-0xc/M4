package course;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {

    private Subject subject;
    private Integer courseCode;
    private Float weight;

    private ArrayList<Course> preReqs;

    public Course() {
        this.subject = Subject.NULL;
        this.courseCode = 0;
        this.weight = 0.0f;
        this.preReqs = new ArrayList<Course>(0);
    }

    public Course(Subject _subject, Integer _courseCode, Float _weight) {
        this();
        this.subject = _subject;
        this.courseCode = _courseCode;
        this.weight = _weight;
    }

    public Course(Subject _subject, Integer _courseCode, Float _weight, Course[] _preReqs) {
        this(_subject, _courseCode, _weight);
        this.preReqs.addAll(Arrays.asList(_preReqs));
    }

    public Subject GetSubject() {
        return subject;
    }

    public void SetSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer GetCourseCode() {
        return courseCode;
    }

    public void SetCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public Float GetWeight() {
        return weight;
    }

    public void SetWeight(Float weight) {
        this.weight = weight;
    }

    public ArrayList<Course> GetPreReqs() {
        return preReqs;
    }

    public void SetPreReqs(ArrayList<Course> preReqs) {
        this.preReqs = preReqs;
    }

    public String toString() {
        return this.GetSubject().toString() + "*" + String.format("%04d", this.GetCourseCode());
    }
    
}
