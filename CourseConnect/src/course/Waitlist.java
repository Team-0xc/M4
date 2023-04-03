package course;

import java.util.PriorityQueue;
import java.util.Queue;

import users.Student;

public class Waitlist {
    
    private Queue<Student> students;
    
    public Waitlist() {
        this.students = new PriorityQueue<Student>();
    }

    public Student[] GetStudents() {
        return (Student[])students.toArray();
    }

    public Student NextStudent() throws Exception {
        Student s = students.poll();

        if(s == null) {
            throw new Exception("waitlist is empty");
        }

        return s;
    }

    public void AddStudent(Student student) {
        this.students.add(student);
    }

    public void RemoveStudent(Student student) {
        this.students.remove(student);
    }

    public void requestWaitlist(Student student, Section section) {
        student.getStudentCounselor().approveWaitlist(student, section);
    }

}
