package course;

import java.util.ArrayList;

import users.Student;

public class Waitlist {
    
    private Section section;
    private ArrayList<Student> students;
    
    public Waitlist(Section _section) {
        this.section = _section;
        this.students = new ArrayList<Student>();
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student NextStudent() throws IndexOutOfBoundsException {
        return this.getStudents().get(0);
    }

    public void AddStudent(Student student) {
        this.students.add(student);
    }
    public void RemoveStudent(Student student) {
        this.students.remove(student);
    }

}
