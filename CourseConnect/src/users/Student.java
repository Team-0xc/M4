package users;

import course.*;
import records.Timetable;
import records.Transcript;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Student extends Person implements Registrate {
    private int ID;
    private Transcript transcript;
    private Timetable timetable;
    
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
