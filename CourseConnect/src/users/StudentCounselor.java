/**
 * The StudentCounselor class is a subclass of the Person class.
 * The class is responsible for approving waitlist requests of a student for a course section.
 */
package users;

import java.util.ArrayList;
import java.util.Scanner;

import course.*;
import main.CourseConnect;

public class StudentCounselor extends Person{

    /**
     * ArrayList of waitlist requests to hold pending waitlist requests.
     */
    private ArrayList<WaitlistRequest> counselorRequestList = new ArrayList<WaitlistRequest>(0);

    /**
     * ArrayList of waitlist requests to hold approved waitlist requests.
     */
    private ArrayList<WaitlistRequest> checkedRequests = new ArrayList<WaitlistRequest>(0);

    /**
     * Constructor for the StudentCounselor class.
     * @param _firstName a String to initialize the student counselor's first name.
     * @param _lastName a String to initialize the student counselor's last name.
     */
    public StudentCounselor(String _firstName, String _lastName) {
        super(_firstName, _lastName);
    }

    /**
     * Displays user options for the student counselor.
     */
    private static void displayStudentCounselorMenu() {
        System.out.println("");
        System.out.println("Please input one of the following numbers");
        System.out.println("1. View Waitlist");
        System.out.println("4. Approve Requests");
        System.out.println("0. Exit Course Connect");
    }

    /**
     * Adds a waitlist request by a student for a course section to the counselorRequestList.
     * @param _student a Student object to represent the student who wants to join a section's waitlist.
     * @param _section a Section object to represent the waitlisted section the _student is trying to join.
     */
    public void approveWaitlist(Student _student, Section _section) {
        counselorRequestList.add(new WaitlistRequest(_student, _section));
    }

    /**
     * Overrides parent class method Loop() to display the StudentCounselor menu. 
     * Allows counselor to approve student waitlist requests for course sections, display existing waitlist requests, 
     * or exit the program.
     * @param cc a CourseConnect object to represent the program.
     */
    @Override
    public void Loop(CourseConnect cc) {
        Scanner input = cc.GetScanner();

        while (true) {
            displayStudentCounselorMenu();
            int menuChoice = input.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("Process to view waitlist requests");
                    System.out.println(this.counselorRequestList.toString());
                    break;

                case 4:
                    System.out.println("Process to approve waitlist requests");
                    checkedRequests.clear();
                    for (WaitlistRequest currRequest : this.counselorRequestList) {
                        System.out.println("Student: " + currRequest.requestingStudent.toString());
                        System.out.println(currRequest.requestingStudent.GetTranscript().toString());
                        System.out.printf("Want to waitlist for %s\n y/n (Or exit to cancel and exit)", currRequest.requestingSection.toString());
                        String menuChoice2 = input.next();

                        if (menuChoice2.equalsIgnoreCase("exit")) {
                            break;
                        } else if (menuChoice2.equalsIgnoreCase("y")) {
                            System.out.println("Approved!");
                            currRequest.requestingSection.GetWaitlist().AddStudent(currRequest.requestingStudent);
                        } else {
                            System.out.println("Denied");
                        }

                        checkedRequests.add(currRequest);
                    }
                    counselorRequestList.removeAll(checkedRequests);
                    break;

                case 0:
                    return;

                default:
                    System.out.println(menuChoice + " is an invalid choice.");
                    break;
            }
        }
    }

    /**
     * Inner class to represent a waitlist request by a student for a course section.
     */
    class WaitlistRequest {
        /**
        * A Student object to represent the student who wants to join a section's waitlist.
        */
        public Student requestingStudent;

        /**
        * A Section object to represent the waitlisted section the _student is trying to join.
        */
        public Section requestingSection;

        /**
        * Constructor for the WaitlistRequest class.
        * @param _student a Student object to represent the student who wants to join a section's waitlist.
        * @param _section a Section object to represent the waitlisted section the _student is trying to join.
        */
        WaitlistRequest(Student _student, Section _section) {
            this.requestingStudent = _student;
            this.requestingSection = _section;
        }

        /**
        * Overrides parent class method toString() to return a String representation of a WaitlistRequest object.
        */
        public String toString() {
            return this.requestingStudent.toString() + " " + this.requestingSection.toString();
        }
        
    }
    
}