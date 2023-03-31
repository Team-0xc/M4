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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public ArrayList<Course> getPreReqs() {
        return preReqs;
    }

    public void setPreReqs(ArrayList<Course> preReqs) {
        this.preReqs = preReqs;
    }

    public String toString() {
        return subject.toString() + "*" + String.format("%04d", courseCode);
    }
    
}
