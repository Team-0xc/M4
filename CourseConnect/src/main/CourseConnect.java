package main;
import java.util.Scanner;

import course.*;
import users.*;
import utils.*;

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
        
        InitData();
    }

    private void InitData() {

        // Create user accounts;
        Professor prof = new Professor("Firstname", "Lastname", "Phd");
        prof.SetCredentials(new Credentials("prof", "password"));

        StudentCounselor stucon = new StudentCounselor("Firstname", "Lastname");
        stucon.SetCredentials(new Credentials("stucon", "password"));

        Student undergradStudent = new UndergradStudent(1234, "Firstname", "Lastname");
        undergradStudent.SetCredentials(new Credentials("student", "password"));

        Student gradStudent = new GradStudent(1234, "Firstname", "Lastname", prof);
        gradStudent.SetCredentials(new Credentials("grad", "password"));

        credentialsManager.AddUser(prof);
        credentialsManager.AddUser(stucon);
        credentialsManager.AddUser(undergradStudent);
        credentialsManager.AddUser(gradStudent);

        // TODO: Add courses for demo
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

    public CourseCatalog GetCatalog() {
        return this.catalog;
    }

}
