package course;

import java.util.PriorityQueue;
import java.util.Queue;

import users.Student;

public class Waitlist {
    
    private Queue<Student> students;
    
    /**
     * Constructor for a new Waitlist object. Initializes the priority queue of students.
     */
    public Waitlist() {
        this.students = new PriorityQueue<Student>();
    }

    /**
     * Gets an array of students in the waitlist.
     * 
     * @return an array of students in the waitlist
     */
    public Student[] GetStudents() {
        return (Student[])students.toArray();
    }

    /**
     * Removes the next student from the waitlist and returns it.
     * 
     * @return the next student in the waitlist
     * @throws Exception if the waitlist is empty
     */
    public Student NextStudent() throws Exception {
        Student s = students.poll();

        if(s == null) {
            throw new Exception("waitlist is empty");
        }

        return s;
    }

    /**
     * Adds a student to the waitlist.
     * 
     * @param student the student to add to the waitlist
     */
    public void AddStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Removes a student from the waitlist.
     * 
     * @param student the student to remove from the waitlist
     */
    public void RemoveStudent(Student student) {
        this.students.remove(student);
    }

    /**
     * Requests to be added to the waitlist for a particular section of a course.
     * 
     * @param student the student requesting to be added to the waitlist
     * @param section the section of the course the student wants to enroll in
     */
    public void requestWaitlist(Student student, Section section) {
        student.getStudentCounselor().approveWaitlist(student, section);
    }

}
