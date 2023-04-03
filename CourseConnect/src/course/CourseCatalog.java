package course;

import java.util.Collection;
import java.util.HashMap;

public class CourseCatalog {    
    private HashMap<String, Section> sectionOfferings;

    public CourseCatalog() {
        this.sectionOfferings = new HashMap<String, Section>(0);
    }

    public Collection<Section> GetSections() {
        return sectionOfferings.values();
    }

    public void AddSection(Section s) {
        this.sectionOfferings.put(s.GetHash(), s);
    }
    public void RemoveSection(Section s) {
        this.sectionOfferings.remove(s.GetHash());
    }

    public Section GetSection(Subject subject, Integer courseNum, Integer sectionID) throws Exception {
        Section s = this.courseOfferings.get(new Section(new Course(subject, courseNum, 0.0f), sectionID, 0, null, null).GetHash());

        if(s == null) {
            throw new Exception("section does not exist");
        }

        return s;

    }

}
