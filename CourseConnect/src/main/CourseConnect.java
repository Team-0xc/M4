package main;
import java.util.Scanner;
import java.util.Arrays;

import course.*;
import course.Meeting.Day;
import records.*;
import records.CourseRecord.Status;
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

        Student undergradStudent = new UndergradStudent(1234, "Firstname", "Lastname", stucon);
        undergradStudent.SetCredentials(new Credentials("student", "password"));

        Student gradStudent = new GradStudent(1234, "Firstname", "Lastname", prof, stucon);
        gradStudent.SetCredentials(new Credentials("grad", "password"));

        credentialsManager.AddUser(prof);
        credentialsManager.AddUser(stucon);
        credentialsManager.AddUser(undergradStudent);
        credentialsManager.AddUser(gradStudent);

        // TODO: Add courses for demo
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CIS 1300 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Course CIS1300 = new Course(Subject.CIS, 1300, 0.5f);
        this.catalog.AddSection(new Section(CIS1300, 1, 50, prof, Arrays.asList(
            new Meeting(1300, 1350, Day.Mon, MeetingType.LECTURE),
            new Meeting(1300, 1350, Day.Wed, MeetingType.LECTURE), 
            new Meeting(1300, 1350, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1400, 1550, Day.Tue, MeetingType.LAB)
        )));

        this.catalog.AddSection(new Section(CIS1300, 2, 50, prof, Arrays.asList(
            new Meeting(1300, 1350, Day.Mon, MeetingType.LECTURE),
            new Meeting(1300, 1350, Day.Wed, MeetingType.LECTURE), 
            new Meeting(1300, 1350, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1400, 1550, Day.Thu, MeetingType.LAB)
        )));

        this.catalog.AddSection(new Section(CIS1300, 3, 1, prof, Arrays.asList(
            new Meeting(800, 850, Day.Mon, MeetingType.LECTURE),
            new Meeting(800, 850, Day.Wed, MeetingType.LECTURE), 
            new Meeting(800, 850, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1100, 1250, Day.Tue, MeetingType.LAB)
        )));

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CIS 1050 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Course CIS1050 = new Course(Subject.CIS, 1050, 0.5f);
        this.catalog.AddSection(new Section(CIS1050, 3, 50, prof, Arrays.asList(
            new Meeting(1300, 1350, Day.Mon, MeetingType.LECTURE),
            new Meeting(1300, 1350, Day.Wed, MeetingType.LECTURE), 
            new Meeting(1300, 1350, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1400, 1550, Day.Tue, MeetingType.LAB)
        )));

        this.catalog.AddSection(new Section(CIS1050, 2, 50, prof, Arrays.asList(
            new Meeting(1300, 1350, Day.Mon, MeetingType.LECTURE),
            new Meeting(1300, 1350, Day.Wed, MeetingType.LECTURE), 
            new Meeting(1300, 1350, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1400, 1550, Day.Thu, MeetingType.LAB)
        )));

        this.catalog.AddSection(new Section(CIS1050, 1, 50, prof, Arrays.asList(
            new Meeting(800, 850, Day.Mon, MeetingType.LECTURE),
            new Meeting(800, 850, Day.Wed, MeetingType.LECTURE), 
            new Meeting(800, 850, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1100, 1250, Day.Tue, MeetingType.LAB)
        )));

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CIS 2500 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Course CIS2500 = new Course(Subject.CIS, 2500, 0.5f, new Course[] {CIS1300});
        this.catalog.AddSection(new Section(CIS2500, 1, 50, prof, Arrays.asList(
            new Meeting(1300, 1350, Day.Mon, MeetingType.LECTURE),
            new Meeting(1300, 1350, Day.Wed, MeetingType.LECTURE), 
            new Meeting(1300, 1350, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1400, 1550, Day.Tue, MeetingType.LAB)
        )));

        this.catalog.AddSection(new Section(CIS2500, 2, 0, prof, Arrays.asList(
            new Meeting(1300, 1350, Day.Mon, MeetingType.LECTURE),
            new Meeting(1300, 1350, Day.Wed, MeetingType.LECTURE), 
            new Meeting(1300, 1350, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1400, 1550, Day.Thu, MeetingType.LAB)
        )));

        this.catalog.AddSection(new Section(CIS2500, 3, 1, prof, Arrays.asList(
            new Meeting(800, 850, Day.Mon, MeetingType.LECTURE),
            new Meeting(800, 850, Day.Wed, MeetingType.LECTURE), 
            new Meeting(800, 850, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1100, 1250, Day.Tue, MeetingType.LAB)
        )));

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CIS 2430 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Course CIS2430 = new Course(Subject.CIS, 2430, 0.5f, new Course[] {CIS2500});
        this.catalog.AddSection(new Section(CIS2430, 1, 50, prof, Arrays.asList(
            new Meeting(1300, 1350, Day.Mon, MeetingType.LECTURE),
            new Meeting(1300, 1350, Day.Wed, MeetingType.LECTURE), 
            new Meeting(1300, 1350, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1400, 1550, Day.Tue, MeetingType.LAB)
        )));

        this.catalog.AddSection(new Section(CIS2430, 2, 0, prof, Arrays.asList(
            new Meeting(1300, 1350, Day.Mon, MeetingType.LECTURE),
            new Meeting(1300, 1350, Day.Wed, MeetingType.LECTURE), 
            new Meeting(1300, 1350, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1400, 1550, Day.Thu, MeetingType.LAB)
        )));

        this.catalog.AddSection(new Section(CIS2430, 3, 50, prof, Arrays.asList(
            new Meeting(800, 850, Day.Mon, MeetingType.LECTURE),
            new Meeting(800, 850, Day.Wed, MeetingType.LECTURE), 
            new Meeting(800, 850, Day.Fri, MeetingType.LECTURE), 
            new Meeting(1100, 1250, Day.Tue, MeetingType.LAB)
        )));

        gradStudent.SetTranscript(new Transcript(Arrays.asList(
            new CourseRecord(CIS1300, Status.COMPLETED, 0.86f)
        )));

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

        boolean run = true;
        while(run) {
            // Log user in
            credentialsManager.Loop(this);

            // Run user control loop
            user.Loop(this);

            System.out.println("Thank you for using course connect");

            System.out.print("Exit system? (y/n) ");
            run = scanner.next().equalsIgnoreCase("n");
        }
        scanner.close();
        System.out.println("System shutdown!");
    }

    public CourseCatalog GetCatalog() {
        return this.catalog;
    }

}
