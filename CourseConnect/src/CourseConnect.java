import java.util.Scanner;

public class CourseConnect {
    private static int menuChoice;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
                "                                                                                                                                                                               ,---. \n,--.   ,--.       ,--.                                    ,--.              ,-----.                                         ,-----.                                      ,--.  |   | \n|  |   |  | ,---. |  | ,---. ,---. ,--,--,--. ,---.     ,-'  '-. ,---.     '  .--./ ,---. ,--.,--.,--.--. ,---.  ,---.     '  .--./ ,---. ,--,--, ,--,--,  ,---.  ,---.,-'  '-.|  .' \n|  |.'.|  || .-. :|  || .--'| .-. ||        || .-. :    '-.  .-'| .-. |    |  |    | .-. ||  ||  ||  .--'(  .-' | .-. :    |  |    | .-. ||      \\|      \\| .-. :| .--''-.  .-'|  |  \n|   ,'.   |\\   --.|  |\\ `--.' '-' '|  |  |  |\\   --.      |  |  ' '-' '    '  '--'\\' '-' ''  ''  '|  |   .-'  `)\\   --.    '  '--'\\' '-' '|  ||  ||  ||  |\\   --.\\ `--.  |  |  `--'  \n'--'   '--' `----'`--' `---' `---' `--`--`--' `----'      `--'   `---'      `-----' `---'  `----' `--'   `----'  `----'     `-----' `---' `--''--'`--''--' `----' `---'  `--'  .--.\n                                                                                                                                                                               '--'  ");

        studentLoop();

        System.out.println("Thank you for using course connect");
    }

    private static void displayMenu() {
        System.out.println("");
        System.out.println("Please input one of the following numbers");
        System.out.println("1. View Timetable");
        System.out.println("2. Regiseter Course");
        System.out.println("3. Drop Course");
        System.out.println("0. Exit Course Connect");
    }

    private static void studentLoop() {
        while (true) {
            displayMenu();
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
