package users;

import course.*;
import java.util.List;

public abstract class Student extends Person {
    private int ID;
    // TODO: inplement and add transcript and timetable

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
     * Will return the ID of a student
     * 
     * @return int student's ID
     */
    public int GetID() {
        return this.ID;
    }

    /**
     * Will return a list of type course that is all the currently enrolled courses for the student
     * 
     * @return List<Course> all currently enrolled courses
     */
    public List<Course> getEnrCourses() {
        List<Course> currentlyEnrolled = null;

        //TODO: loop through timetable and look at currently enrolled courses (aka just the section but as a course)

        return currentlyEnrolled;
    }

    /**
     * Will return a list of type Section that is all the currently enrolled sections for the student
     * 
     * @return List<Course> all currently enrolled sections
     */
    public List<Section> getEnrSections() {
        List<Section> currentlyEnrolled = null;

        //TODO: loop through timetable and look at currently enrolled sections

        return currentlyEnrolled;
    }

    /**
     * Will return Ture/False depending on if the student has the pre-requstie courses for the given course ID
     * @param courseID The ID of the courses to check pre-requisites for
     * @return Boolean: true if the student has passed the required courses, false otherwise
     */
    public boolean hasPreqs(int courseID) {
        //TODO: find course based on ID, then loop through transcript to see if user has all required courses.

        return false;
    }
}
