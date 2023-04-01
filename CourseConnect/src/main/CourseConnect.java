package main;
import java.util.Scanner;

import course.Course;
import users.Person;
import utils.CredentialsManager;

public class CourseConnect {
    private static int menuChoice;
    private static Scanner input = new Scanner(System.in);

    private CredentialsManager credentialsManager;
    private Person user;

    public CourseConnect() {
        this.credentialsManager = new CredentialsManager();
        this.user = null;

    }

    public Person GetUser() {
        return user;
    }
    public void SetUser(Person user) {
        this.user = user;
    }

    public void Run() {
        // I know this looks strange, but it prints Welcome to Course Connect! but in
        // bigger fancier words. Run it and you'll see.
        System.out.println(
                "                                                                                                                                                                               ,---. \n,--.   ,--.       ,--.                                    ,--.              ,-----.                                         ,-----.                                      ,--.  |   | \n|  |   |  | ,---. |  | ,---. ,---. ,--,--,--. ,---.     ,-'  '-. ,---.     '  .--./ ,---. ,--.,--.,--.--. ,---.  ,---.     '  .--./ ,---. ,--,--, ,--,--,  ,---.  ,---.,-'  '-.|  .' \n|  |.'.|  || .-. :|  || .--'| .-. ||        || .-. :    '-.  .-'| .-. |    |  |    | .-. ||  ||  ||  .--'(  .-' | .-. :    |  |    | .-. ||      \\|      \\| .-. :| .--''-.  .-'|  |  \n|   ,'.   |\\   --.|  |\\ `--.' '-' '|  |  |  |\\   --.      |  |  ' '-' '    '  '--'\\' '-' ''  ''  '|  |   .-'  `)\\   --.    '  '--'\\' '-' '|  ||  ||  ||  |\\   --.\\ `--.  |  |  `--'  \n'--'   '--' `----'`--' `---' `---' `--`--`--' `----'      `--'   `---'      `-----' `---'  `----' `--'   `----'  `----'     `-----' `---' `--''--'`--''--' `----' `---'  `--'  .--.\n                                                                                                                                                                               '--'  ");

        // main course connect loop
        credentialsManager.Loop(this);
        user.Loop(this);

        System.out.println("Thank you for using course connect");
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

    /**
     * The main loop if a user is a student
     */
    private static void studentLoop() {
        while (true) {
            displayStudentMenu();
            menuChoice = input.nextInt();

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
