package course;

import java.util.PriorityQueue;
import java.util.Queue;

import javax.print.attribute.standard.RequestingUserName;

import users.Student;

public class Waitlist {
    
    private Section section;
    private Queue<Student> students;
    
    public Waitlist(Section _section) {
        this.section = _section;
        this.students = new PriorityQueue<Student>();
    }

    public Section GetSection() {
        return section;
    }

    public void SetSection(Section section) {
        this.section = section;
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

    public void requestWaitlist(Student student) {
        student.getStudentCounselor().approveWaitlist(student, this);
    }

}
