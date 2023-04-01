package users;

import java.util.Scanner;

import main.CourseConnect;

public class UndergradStudent extends Student {
    public UndergradStudent(int _ID, String _firstName, String _lastName) {
        super(_ID, _firstName, _lastName);
    }

    /**
     * Will display the menu for a student
     */
    private static void displayStudentMenu() {
        System.out.println("");
        System.out.println("Please input one of the following numbers");
        System.out.println("1. View Timetable");
        System.out.println("2. Regiseter Course");
        System.out.println("3. Drop Course");
        System.out.println("0. Exit Course Connect");
    }

    @Override
    public void Loop(CourseConnect cc) {

        Scanner input = cc.GetScanner();

        while (true) {
            displayStudentMenu();
            int menuChoice = input.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("Process to dispaly timetable");
                    break;

                case 2:
                    System.out.println("Process to register for a course");
                    break;

                case 3:
                    System.out.println("Process to drop a course");
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
