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
        System.out.println("2. Approve Requests");
        System.out.println("0. Exit Course Connect");
    }

    public void approveWaitlist(Student _student, Waitlist _waitlist) {
        counselorRequestList.add(new WaitlistRequest(_student, _waitlist));
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

                case 2:
                    System.out.println("Process to approve waitlist requests");
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
        Student requestingStudent;
        Waitlist requestingWaitlist;

        WaitlistRequest(Student _student, Waitlist _waitlist) {
            this.requestingStudent = _student;
            this.requestingWaitlist = _waitlist;
        }
    }
    
}
