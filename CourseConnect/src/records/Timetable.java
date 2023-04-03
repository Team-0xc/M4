/**
 * The Timetable class represents a collection of sections for a particular semester.
 * Contains methods for managing and manipulating the sections in the timetable.
 */
package records;

import java.util.ArrayList;
import java.util.Collection;

import course.Section;

public class Timetable {

    private String semester;
    private ArrayList<Section> sections;
    
    /**
     * Initializes a new instance of the Timetable class with default values.
     */
    public Timetable() {
        this.semester = "N/A";
        this.sections = new ArrayList<Section>(0);
    }

    /**
     * Initializes a new instance of the Timetable class with the specified semester and section collection.
     * @param _semester the semester for the timetable
     * @param _sections the collection of sections to add to the timetable
     */
    public Timetable(String _semester, Collection<Section> _sections) {
        this();
        this.semester = _semester;
        this.sections.addAll(_sections);
    }

    /**
     * Checks if the specified section has any meeting conflicts with existing sections in the timetable.
     * @param s the section to check for conflicts
     * @return true if there is a meeting conflict, false otherwise
     */
    public boolean HasMeetingConflict(Section s) {

        for(Section section: this.GetSections()) {
            if(section.IsMeetingConflict(s)) {
                return true;
            }
        }

        return false;

    }

    /**
     * Gets the semester of the timetable.
     * @return the semester of the timetable
     */
    public String GetSemester() {
        return semester;
    }

    /**
     * Sets the semester of the timetable.
     * @param semester the semester to set for the timetable
     */
    public void SetSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Gets the list of sections in the timetable.
     * @return the list of sections in the timetable
     */
    public ArrayList<Section> GetSections() {
        return sections;
    }

    /**
     * Sets the list of sections in the timetable.
     * @param sections the list of sections to set for the timetable
     */
    public void SetSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    /**
     * Adds a section to the timetable.
     * @param s the section to add
     */
    public void AddSection(Section s) {
        this.sections.add(s);
    }

    /**
     * Removes a section from the timetable.
     * @param s the section to remove
     */
    public void RemoveSection(Section s) {
        this.sections.remove(s);
    }

    /**
     * Returns the string representation of the timetable, including all section meetings.
     * @return the string representation of the timetable
     */
    public String toString() {

        String timetableString = "";

        // Get meetings list from each section
        for(Section s: sections) {
            timetableString += s.toString() + "\n";
        }

        return timetableString;

    }

}