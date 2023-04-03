package users;

import course.*;
import records.Timetable;
import records.Transcript;

import java.util.ArrayList;
import java.util.Collection;

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

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
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
        if(this.getTimetable().HasMeetingConflict(s)) {
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
}
