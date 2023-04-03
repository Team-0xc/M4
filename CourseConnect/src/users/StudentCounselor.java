package users;

import java.util.ArrayList;
import java.util.Scanner;

import course.*;
import main.CourseConnect;

public class StudentCounselor extends Person{
    private ArrayList<WaitlistRequest> counselorRequestList;

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
                    break;

                case 4:
                    System.out.println("Process to approve waitlist requests");
                    for (WaitlistRequest currRequest : this.counselorRequestList) {
                        String menuChoice2 = input.nextLine();
                        System.out.println(currRequest.requestingStudent.GetTranscript());
                        System.out.printf("Want to waitlist for %s\n y/n (Or exit to cancel and exit)", currRequest.requestingSection.toString());

                        if (menuChoice2 == "exit") {
                            break;
                        } else if (menuChoice2 == "y") {
                            currRequest.requestingSection.GetWaitlist().AddStudent(currRequest.requestingStudent);
                        }

                        this.counselorRequestList.remove(currRequest);
                    }
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
