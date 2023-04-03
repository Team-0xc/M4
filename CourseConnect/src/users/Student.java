package users;

import course.*;
import main.CourseConnect;
import records.Timetable;
import records.Transcript;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public abstract class Student extends Person implements Registrate {
    private int ID;
    private Transcript transcript;
    private Timetable timetable;

    /**
     * Create a new object of type Student
     * 
     * @param _ID        The student ID
     * @param _firstName The first name of the student
     * @param _lastName  THe last name of the student
     */
    public Student(int _ID, String _firstName, String _lastName) {
        super(_firstName, _lastName);
        this.ID = _ID;
    }

    /**
     * Will return a list of type course that is all the currently enrolled courses for the student
     * 
     * @return ArrayList<Course> all currently enrolled courses
     */
    public ArrayList<Course> getEnrCourses() {
        ArrayList<Course> currentlyEnrolled = new ArrayList<Course>(0);
        ArrayList<Section> currentlyEnrolledSections = null;

        currentlyEnrolledSections = timetable.GetSections();

        // loop through all the sections, and get their respective course.
        for (Section currSection : currentlyEnrolledSections) {
            currentlyEnrolled.add(currSection.GetCourse());
        }

        // return the courses.
        return currentlyEnrolled;
    }

    /**
     * Will return a list of type Section that is all the currently enrolled sections for the student
     * 
     * @return ArrayList<Course> all currently enrolled sections
     */
    public ArrayList<Section> getEnrSections() {
        return this.timetable.GetSections();
    }

    /**
     * Will return True/False depending on if the student has the pre-requstie courses
     * @param prereqs 
     * @return Boolean: true if the student has passed the required courses, false otherwise
     */
    public boolean HasPreqs(Collection<Course> prereqs) {
        
        // For each course in the prereqs list
        for(Course c: prereqs) {
            // Check if not passed
            if(!transcript.HasPassed(c)) {
                // If not return false
                return false;
            }
        }

        // All courses passed
        return true;
    }

    /**
     * Will return the ID of a student
     * 
     * @return int student's ID
     */
    public int GetID() {
        return ID;
    }

    public void SetID(int iD) {
        ID = iD;
    }

    public Transcript GetTranscript() {
        return transcript;
    }

    public void SetTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Timetable GetTimetable() {
        return timetable;
    }

    public void SetTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public void Register(Section s) throws Exception {
        Course course = s.GetCourse();

        // Check prereqs
        ArrayList<Course> prereqs = course.GetPreReqs();
        if(!HasPreqs(prereqs)) {
            throw new Exception("missing prerequisite course(s)");
        }

        // Check timetable conflict
        if(this.GetTimetable().HasMeetingConflict(s)) {
            throw new Exception("section has a meeting conflict with another section in your timetable");
        }

        // Add student to section. Throw Exception if section is full
        s.AddStudent(this);

        timetable.AddSection(s);

    }
    public void ForceRegister(Section s) {
        timetable.AddSection(s);
        s.ForceAddStudent(this);
    }
    public void Drop(Section s) {
        timetable.RemoveSection(s);
        s.RemoveStudent(this);
    }

        /**
     * Will display the menu for a student
     */
    private static void displayStudentMenu() {
        System.out.println("");
        System.out.println("Please input one of the following numbers");
        System.out.println("1. View Course Catalog");
        System.out.println("2. View Timetable");
        System.out.println("2. Register Course");
        System.out.println("3. Drop Course");
        System.out.println("0. Log out");
    }

    // This loop may be able to be moved to Student if both Undergrad and Grad have same functionality?
    @Override
    public void Loop(CourseConnect cc) {

        Scanner scanner = cc.GetScanner();

        while (true) {
            displayStudentMenu();
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    break;
                case 2:
                    System.out.println(this.GetTimetable());
                    break;

                case 3:
                    // System.out.println("Process to register for a course");

                    String subjectArea;
                    Integer courseNum, sectionID;

                    System.out.print("Enter subject area: ");
                    subjectArea = scanner.next();
                    System.out.print("Enter course number: ");
                    courseNum = scanner.nextInt();

                    // Course 

                    break;

                case 4:
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
