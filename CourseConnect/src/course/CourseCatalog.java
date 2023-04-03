package course;

import java.util.Collection;
import java.util.HashMap;

public class CourseCatalog {
    
    private HashMap<String, Section> courseOfferings;

    public CourseCatalog() {
        this.courseOfferings = new HashMap<String, Section>(0);
    }

    public Collection<Section> GetCourses() {
        return courseOfferings.values();
    }

    public void AddCourse(Section s) {
        this.courseOfferings.put(s.GetHash(), s);
    }
    public void RemoveCourse(Section s) {
        this.courseOfferings.remove(s.GetHash());
    }

    public Section GetSection(Subject subject, Integer courseNum, Integer sectionID) throws Exception {
        Section s = this.courseOfferings.get(new Section(new Course(subject, courseNum, 0.0f), sectionID, 0, null, null).GetHash());

        if(s == null) {
            throw new Exception("section does not exist");
        }

        return s;

    }

}
