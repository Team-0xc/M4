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
    private Waitlist waitlist;

    private Section() {
        this.id = 0;
        this.capacity = 0;
        this.instructor = null;
        this.course = null;
        this.meetings = new ArrayList<Meeting>(0);
        this.students = new ArrayList<Student>(0);
        this.waitlist = new Waitlist();
    }

    public Section(Course _course, Integer _id, Integer _capacity, Professor _instructor, Collection<Meeting> _meetings) {
        this();
        this.course = _course;
        this.id = _id;
        this.capacity = _capacity;
        this.instructor = _instructor;
        if(_meetings != null) {
            this.meetings.addAll(_meetings);
        }
        System.out.println(this);
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

    public Waitlist GetWaitlist() {
        return this.waitlist;
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

        try {
            Student nextStudent = null;
            while((nextStudent = this.waitlist.NextStudent()) != null) {
                nextStudent.ForceRegister(this);
            }
        } catch(Exception e) {
            
        }

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
        String str = this.GetCourse().toString() + "*" + String.format("%02d", this.GetId()) + "\n";
        for(Meeting m: this.GetMeetings()) {
            str += m.toString() + "\n";
        }

        return str;
    }

    public String GetHash() {
        return Integer.toString(this.GetCourse().toString().hashCode() * this.GetId().toString().hashCode());
    }
    
}
