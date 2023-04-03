package users;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import course.Section;
import main.CourseConnect;

public class Professor extends Person{
    private String credentials;
    private Queue<EnrollmentRequest> enrollRequests;

    public Professor(String _firstName, String _lastName, String _credentials) {
        super(_firstName, _lastName);

        credentials = _credentials;
        enrollRequests = new PriorityQueue<EnrollmentRequest>();
    }

    /**
     * Sets the professors credentials
     * 
     * @param _credentials String: the new credentials
     */
    public void setCredentials(String _credentials) {
        this.credentials = _credentials;
    }

    public void ApproveEnrollment(Section section, Student student) {
        enrollRequests.add(new EnrollmentRequest(section, student));
    }

    @Override
    public void Loop(CourseConnect cc) {

        Scanner scanner = cc.GetScanner();
        
        while(enrollRequests.size() > 0) {

            EnrollmentRequest currRequest = enrollRequests.poll();

            Student student = currRequest.GetStudent();
            Section section = currRequest.GetSection();

            System.out.println("Enrollment Request for:");
            System.out.println(student.getFirstName() + " " + student.getLastName());
            System.out.println(student.GetTranscript());

            System.out.println("Into Section: ");
            System.out.println(section);
            System.out.println("Current section enrollment: " + section.GetStudents().size() + "/" + section.GetCapacity());

            System.out.println("\n\n Approve Enrollment? (y/n)");

            boolean approved = scanner.next().equalsIgnoreCase("y");

            if(approved) {
                // Enroll student in section
                student.ForceRegister(section);
            }

        }

        System.out.println("No enrollment requests! Goodbye :)");

    }

    private class EnrollmentRequest implements Comparable<EnrollmentRequest> {

        private Section section;
        private Student student;
        
        public EnrollmentRequest(Section _section, Student _student) {
            this.section = _section;
            this.student = _student;
        }

        public Section GetSection() {
            return section;
        }
        public Student GetStudent() {
            return student;
        }

        @Override
        public int compareTo(EnrollmentRequest o) {
            return 0;
        }

    }
}

