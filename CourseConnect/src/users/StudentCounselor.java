package users;

import java.util.Scanner;

import main.CourseConnect;

public class StudentCounselor extends Person{
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
    
}
