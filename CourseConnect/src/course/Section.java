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

   /**
     * Default constructor for Section, initializes instance variables to default values.
     */
    private Section() {
        this.id = 0;
        this.capacity = 0;
        this.instructor = null;
        this.course = null;
        this.meetings = new ArrayList<Meeting>(0);
        this.students = new ArrayList<Student>(0);
        this.waitlist = new Waitlist();
    }

    /**
     * Constructor for Section, initializes instance variables to provided values.
     * @param _course The course associated with the section
     * @param _id The id of the section
     * @param _capacity The capacity of the section
     * @param _instructor The instructor of the section
     * @param _meetings The list of meetings for the section
     */
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

    /**
     * Getter for the course associated with the section
     * @return The course associated with the section
     */
    public Course GetCourse() {
        return course;
    }

    /**
     * Setter for the course associated with the section
     * @param course The new course to associate with the section
     */
    public void SetCourse(Course course) {
        this.course = course;
    }

    /**
     * Getter for the id of the section
     * @return The id of the section
     */
    public Integer GetId() {
        return id;
    }

    /**
     * Setter for the id of the section
     * @param id The new id for the section
     */
    public void SetId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for the capacity of the section     
     * @return The capacity of the section
     */
    public Integer GetCapacity() {
        return capacity;
    }

    /**
     * Setter for the capacity of the section
     * @param capacity The new capacity for the section
     */
    public void SetCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter for the instructor of the section
     * @return The instructor of the section
     */
    public Professor GetInstructor() {
        return instructor;
    }

    /**
     * Getter for the waitlist of unenrolled students
     * @return The waitlist of unenrolled students
     */
    public Waitlist GetWaitlist() {
        return this.waitlist;
    }

    /**
     * Setter for the instructor of the section
     * @param instructor The new instructor for the section
     */
    public void SetInstructor(Professor instructor) {
        this.instructor = instructor;
    }

    /**
     * Getter for the list of meetings for the section
     * @return The list of meetings for the section
     */
    public ArrayList<Meeting> GetMeetings() {
        return meetings;
    }

    /**
     * Setter for the list of meetings for the section
     * @param meetings The new list of meetings for the section
     */
    public void SetMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

    /**
     * Getter for the list of students enrolled in the section
     * @return The list of students enrolled in the section
     */
    public ArrayList<Student> GetStudents() {
        return this.students;
    }

    /**
     * Adds a student to the section's list of students if there is space available.
     * If the section is already full, throws an exception.
     * @param s The student to add to the section
     * @throws Exception when the section is already full.
     */
    public void AddStudent(Student s) throws Exception {
        if(this.GetStudents().size() >= this.GetCapacity()) {
            throw new Exception("section is full");
        }
        this.students.add(s);
    }

    /**
     * Adds a student to the section's list of students without checking if there is space available.
     * Use with caution.
     * @param s The student to add to the section
     */
    public void ForceAddStudent(Student s) {
        this.students.add(s);
    }

    /**
     * Removes a student from the section's list of students, and checks the waitlist for any new students who can be enrolled.
     * @param s The student to remove from the section
     */
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

    /**
     * Checks if the section's meetings conflict with another section's meetings.
     * @param other The section to check for conflicts with
     * @return true if there is a conflict, false otherwise
     */
    public boolean IsMeetingConflict(Section other) {

        // Compare each meetings against each other for conflict
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

    /**
     * Returns a string representation of the section.
     * @return The string representation of the section
     */
    public String toString() {
        String str = this.GetCourse().toString() + "*" + String.format("%02d", this.GetId()) + "\n";
        for(Meeting m: this.GetMeetings()) {
            str += "\t" + m.toString() + "\n";
        }

        return str;
    }

    /**
     * Returns a unique hash based on the section's course and id.
     * @return A unique hash based on the section's course and id
     */
    public String GetHash() {
        return Integer.toString(this.GetCourse().toString().hashCode() * this.GetId().toString().hashCode());
    }

    /**
     * Requests enrollment of a student in the section, subject to instructor approval.
     * @param s The student requesting to be enrolled in the section
     */
    public void RequestEnrollment(Student s) {
        this.GetInstructor().ApproveEnrollment(this, s);
    }
    
}
