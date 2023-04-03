package main;
import java.util.Scanner;

import course.Course;
import course.CourseCatalog;
import course.Section;
import course.Subject;
import users.Person;
import utils.CredentialsManager;

public class CourseConnect {
    private Scanner scanner;

    private CredentialsManager credentialsManager;
    // The current user logged in
    private Person user;

    private CourseCatalog catalog;

    public CourseConnect() {
        this.credentialsManager = new CredentialsManager();
        this.user = null;

        this.catalog = new CourseCatalog();
        PopulateCatalog(catalog);
    }

    private void PopulateCatalog(CourseCatalog catalog) {
        Course c = new Course(Subject.CIS, 1300, 0.5f);
        // Section s = new Section(c, 1, 10, null, );
    }

    public Person GetUser() {
        return user;
    }
    public void SetUser(Person user) {
        this.user = user;
    }

    public Scanner GetScanner() {
        return scanner;
    }

    public void Run() {
        scanner = new Scanner(System.in);
        // I know this looks strange, but it prints Welcome to Course Connect! but in
        // bigger fancier words. Run it and you'll see.
        System.out.println(
                "                                                                                                                                                                               ,---. \n,--.   ,--.       ,--.                                    ,--.              ,-----.                                         ,-----.                                      ,--.  |   | \n|  |   |  | ,---. |  | ,---. ,---. ,--,--,--. ,---.     ,-'  '-. ,---.     '  .--./ ,---. ,--.,--.,--.--. ,---.  ,---.     '  .--./ ,---. ,--,--, ,--,--,  ,---.  ,---.,-'  '-.|  .' \n|  |.'.|  || .-. :|  || .--'| .-. ||        || .-. :    '-.  .-'| .-. |    |  |    | .-. ||  ||  ||  .--'(  .-' | .-. :    |  |    | .-. ||      \\|      \\| .-. :| .--''-.  .-'|  |  \n|   ,'.   |\\   --.|  |\\ `--.' '-' '|  |  |  |\\   --.      |  |  ' '-' '    '  '--'\\' '-' ''  ''  '|  |   .-'  `)\\   --.    '  '--'\\' '-' '|  ||  ||  ||  |\\   --.\\ `--.  |  |  `--'  \n'--'   '--' `----'`--' `---' `---' `--`--`--' `----'      `--'   `---'      `-----' `---'  `----' `--'   `----'  `----'     `-----' `---' `--''--'`--''--' `----' `---'  `--'  .--.\n                                                                                                                                                                               '--'  ");

        // main course connect loop

        // Log user in
        credentialsManager.Loop(this);

        // Run user control loop
        user.Loop(this);

        scanner.close();

        System.out.println("Thank you for using course connect");
    }

}
