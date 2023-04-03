package users;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import course.Section;
import main.CourseConnect;

/**
 * This class represents a Professor who can approve enrollment requests for students. It extends the Person class.
 */
public class Professor extends Person {

    private String credentials;
    private Queue<EnrollmentRequest> enrollRequests;

    /**
     * Constructs a Professor object with first name, last name, and credentials.
     *
     * @param _firstName  String: the first name of the professor.
     * @param _lastName   String: the last name of the professor.
     * @param _credentials String: the credentials of the professor.
     */
    public Professor(String _firstName, String _lastName, String _credentials) {
        super(_firstName, _lastName);

        credentials = _credentials;
        enrollRequests = new PriorityQueue<EnrollmentRequest>();
    }

    /**
     * Sets the professors credentials to a new value.
     * 
     * @param _credentials String: the new credentials of the professor.
     */
    public void setCredentials(String _credentials) {
        this.credentials = _credentials;
    }

    /**
     * Returns the professor's credentials.
     *
     * @return credentials String: the professor's credentials.
     */
    public String getCredentials() {
        return credentials;
    }

    /**
     * Adds an enrollment request to the queue.
     *
     * @param section Section: the section being requested.
     * @param student Student: the student making the request.
     */
    public void ApproveEnrollment(Section section, Student student) {
        enrollRequests.add(new EnrollmentRequest(section, student));
    }

    /**
     * Processes enrollment requests, approves or denies them and enrolls the students in the appropriate sections.
     *
     * @param cc CourseConnect: the CourseConnect object to use for enrolling students.
     */
    @Override
    public void Loop(CourseConnect cc) {

        Scanner scanner = cc.GetScanner();
        
        while (enrollRequests.size() > 0) {

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

            if (approved) {
                // Enroll student in section
                student.ForceRegister(section);
            }

        }

        System.out.println("No enrollment requests! Goodbye :)");

    }

    /**
     * This class represents an Enrollment Request object, with the student and section being requested.
     */
    private class EnrollmentRequest implements Comparable<EnrollmentRequest> {

        private Section section;
        private Student student;
        
        /**
         * Constructs an Enrollment Request object with the student and section being requested.
         *
         * @param _section Section: the section being requested.
         * @param _student Student: the student making the request.
         */
        public EnrollmentRequest(Section _section, Student _student) {
            this.section = _section;
            this.student = _student;
        }

        /**
         * Returns the section being requested.
         *
         * @return section Section: the section being requested.
         */
        public Section GetSection() {
            return section;
        }

        /**
         * Returns the student making the request.
         *
         * @return student Student: the student making the request.
         */
        public Student GetStudent() {
            return student;
        }

        /**
         * Compares enrollment requests by returning 0.
         *
         * @param o EnrollmentRequest: the enrollment request to compare to.
         * @return 0 int: the result of the comparison.
         */
        @Override
        public int compareTo(EnrollmentRequest o) {
            return 0;
        }

    }
}