package users;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import course.*;
import main.CourseConnect;

public class StudentCounselor extends Person{
    private ArrayList<WaitlistRequest> counselorRequestList = new ArrayList<WaitlistRequest>(0);
    private ArrayList<WaitlistRequest> checkedRequests = new ArrayList<WaitlistRequest>(0);

    public StudentCounselor(String _firstName, String _lastName) {
        super(_firstName, _lastName);
    }

    private static void displayStudentCounselorMenu() {
        System.out.println("");
        System.out.println("Please input one of the following numbers");
        System.out.println("1. View Waitlist");
        System.out.println("4. Approve Requests");
        System.out.println("0. Exit Course Connect");
    }

    public void approveWaitlist(Student _student, Section _section) {
        counselorRequestList.add(new WaitlistRequest(_student, _section));
    }

    @Override
    public void Loop(CourseConnect cc) {
        // TODO Auto-generated method stub
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
                        System.out.println(currRequest.requestingStudent.GetTranscript().toString());
                        System.out.printf("Want to waitlist for %s\n y/n (Or exit to cancel and exit)", currRequest.requestingSection.toString());
                        String menuChoice2 = input.next();
                        
                        System.out.println(menuChoice2);

                        if (menuChoice2 == "exit") {
                            break;
                        } else if (menuChoice2 == "y") {
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
                    System.out.println(menuChoice + " is a invalid choice.");
                    break;
            }
        }
    }

    class WaitlistRequest {
        public Student requestingStudent;
        public Section requestingSection;

        WaitlistRequest(Student _student, Section _seection) {
            this.requestingStudent = _student;
            this.requestingSection = _seection;
        }
    }
    
}
