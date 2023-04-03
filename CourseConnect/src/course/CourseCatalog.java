package course;

import java.util.Collection;
import java.util.HashMap;

public class CourseCatalog {
    
    private HashMap<String, Course> courseOfferings;

    public CourseCatalog() {
        this.courseOfferings = new HashMap<String, Course>(0);
    }

    public Collection<Course> GetCourses() {
        return courseOfferings.values();
    }

    public void AddCourse(Course c) {
        this.courseOfferings.put(c.GetHash(), c);
    }
    public void RemoveCourse(Course c) {
        this.courseOfferings.remove(c.GetHash());
    }

    public String toString() {

        String s = "";

        for(Course c: this.GetCourses()) {
            s += c.toString() + "\n";
        }

        return s;

    }

}
