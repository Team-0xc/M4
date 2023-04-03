package course;

import java.util.Collection;
import java.util.HashMap;

/**
 * A course catalog that contains section offerings.
 */
public class CourseCatalog {
    
    /**
     * A map of section offerings indexed by their unique hash code.
     */
    private HashMap<String, Section> sectionOfferings;
    
    /**
     * Constructs a new course catalog with an empty section offerings map.
     */
    public CourseCatalog() {
        this.sectionOfferings = new HashMap<String, Section>(0);
    }

    /**
     * Returns a collection of all section offerings in the course catalog.
     *
     * @return a collection of all section offerings in the course catalog
     */
    public Collection<Section> GetSections() {
        return sectionOfferings.values();
    }

    /**
     * Adds a section offering to the course catalog.
     *
     * @param s the section offering to add to the course catalog
     */
    public void AddSection(Section s) {
        this.sectionOfferings.put(s.GetHash(), s);
    }

    /**
     * Removes a section offering from the course catalog.
     * 
     * @param s the section offering to remove from the course catalog
     */
    public void RemoveSection(Section s) {
        this.sectionOfferings.remove(s.GetHash());
    }
    
    /**
     * Retrieves a specific section offering from the course catalog by subject, course number, and section ID.
     *
     * @param subject the subject of the course the section offering belongs to
     * @param courseNum the course number of the course the section offering belongs to
     * @param sectionID the section ID of the section offering to retrieve
     * @return the section offering with the given subject, course number, and section ID
     * @throws Exception if the section offering cannot be found in the course catalog
     */
    public Section GetSection(Subject subject, Integer courseNum, Integer sectionID) throws Exception {
        Section s = this.sectionOfferings.get(new Section(new Course(subject, courseNum, 0.0f), sectionID, 0, null, null).GetHash());

        if(s == null) {
            throw new Exception("section does not exist");
        }

        return s;

    }
}
