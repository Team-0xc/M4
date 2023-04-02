package records;
import java.util.ArrayList;
import java.util.Collection;

import course.Course;
import course.Section;

import java.util.ArrayList;
import java.util.Collection;

import course.Section;

public class Timetable {
<<<<<<< HEAD
=======

>>>>>>> main
    private String semester;
    private ArrayList<Section> sections;
    
    public Timetable() {
        this.semester = "N/A";
        this.sections = new ArrayList<Section>(0);
    }

    public Timetable(String _semester, Collection<Section> _sections) {
        this();
        this.semester = _semester;
        this.sections.addAll(_sections);
    }

    public String GetSemester(){
        return semester;
    }

    public void SetSemester(String semester){
        this.semester = semester;
    }

    //additional methods as per the 'Classlist.pdf' from M3
    public ArrayList<Section>GetRegisteredCourses(){ //Same thing as GetSections though
        return sections;
    }

    public void AddSection(Section section){ 
        this.sections.add(section);
    }

    public void DropSection(Section section){
        this.sections.remove(section);
    }

    public ArrayList<Section> checkMeetingConflict(Section section){
        ArrayList<Section>conflicts = new ArrayList<Section>();

        for(Section s : this.sections){
            if(s.GetMeetings().equals(section.GetMeetings())){
                conflicts.add(s);
            }
        }
        return conflicts;
    }

    public int TotalCredits(){
        int totalCreds = 0;
        Course courseCode = null;

        for(Section s: this.sections){
            courseCode = s.GetCourse();
            totalCreds += courseCode.GetWeight();
        }

        return totalCreds;
    }

    //Bray's methods from previous version
    public ArrayList<Section> GetSections() {
        return sections;
    }

    public void SetSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public String toString() {
<<<<<<< HEAD
=======

>>>>>>> main
        String timetableString = "";

        // Get meetings list from each section
        for(Section s: sections) {
            timetableString += s.toString() + "\n";
        }

        return timetableString;
<<<<<<< HEAD
    }
=======

    }

>>>>>>> main
}

