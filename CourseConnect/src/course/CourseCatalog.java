package course;

import java.util.ArrayList;

public class CourseCatalog {
    
    private ArrayList<Course> courseOfferings;

    public CourseCatalog() {
        this.courseOfferings = new ArrayList<Course>(0);
    }

    public ArrayList<Course> GetCourses() {
        return courseOfferings;
    }

    public void AddCourse(Course c) {
        this.courseOfferings.add(c);
    }
    public void RemoveCourse(Course c) {
        this.courseOfferings.remove(c);
    }

    public String toString() {

        String s = "";

        for(Course c: this.GetCourses()) {
            s += c.toString() + "\n";
        }

        return s;

    }

}
