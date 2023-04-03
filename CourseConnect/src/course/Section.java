package course;

import java.util.ArrayList;
import java.util.Collection;

import users.Professor;
import users.Student;
import utils.Hashable;

public class Section implements Hashable {

    private Course course;
    private Integer id, capacity;
    private Professor instructor;
    private ArrayList<Meeting> meetings;
    private ArrayList<Student> students;

    private Section() {
        this.id = 0;
        this.capacity = 0;
        this.instructor = null;
        this.course = null;
        this.meetings = new ArrayList<Meeting>(0);
        this.students = new ArrayList<Student>(0);
    }

    public Section(Course _course, Integer _id, Integer _capacity, Professor _instructor, Collection<Meeting> _meetings) {
        this();
        this.course = _course;
        this.id = _id;
        this.capacity = _capacity;
        this.instructor = _instructor;
        this.meetings.addAll(_meetings);
    }

    public Course GetCourse() {
        return course;
    }

    public void SetCourse(Course course) {
        this.course = course;
    }

    public Integer GetId() {
        return id;
    }

    public void SetId(Integer id) {
        this.id = id;
    }

    public Integer GetCapacity() {
        return capacity;
    }

    public void SetCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Professor GetInstructor() {
        return instructor;
    }

    public void SetInstructor(Professor instructor) {
        this.instructor = instructor;
    }

    public ArrayList<Meeting> GetMeetings() {
        return meetings;
    }

    public void SetMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

    public ArrayList<Student> GetStudents() {
        return this.students;
    }

    public void AddStudent(Student s) throws Exception {
        if(this.GetStudents().size() >= this.GetCapacity()) {
            throw new Exception("section is full");
        }

        this.students.add(s);
    }
    public void ForceAddStudent(Student s) {
        this.students.add(s);
    }
    public void RemoveStudent(Student s)  {
        this.students.remove(s);
    }

    public boolean IsMeetingConflict(Section other) {

        // Compare each meetings against eachother for conflict
        for(Meeting m1: this.GetMeetings()) {
            for(Meeting m2: other.GetMeetings()) {
                if(m1.IsConflict(m2)) {
                    // Return true if conflict exists
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return this.GetCourse().toString() + "*" + String.format("%04d", this.GetId());
    }

    public String GetHash() {
        return Integer.toString(this.toString().hashCode());
    }
    
}
