package records;

import java.util.Collection;
import java.util.HashMap;

import course.Course;

public class Transcript {
    
    private HashMap<String, CourseRecord> courseRecords;

    public Transcript() {
        this.courseRecords = new HashMap<String, CourseRecord>(0);
    }

    public Transcript(Collection<CourseRecord> _courseRecords) {
        this();
        // this.courseRecords.addAll(_courseRecords);
        for(CourseRecord cr: _courseRecords) {
            this.courseRecords.put(cr.GetCourse().GetHash(), cr);
        }
    }

    public void PutCourse(CourseRecord cr) {
        this.courseRecords.put(cr.GetCourse().GetHash(), cr);
    }

    public void RemoveCourse(Course c) {
        this.courseRecords.remove(c.GetHash());
    }

    public boolean HasPassed(Course c) {
        return this.courseRecords.get(c.GetHash()).GetStatus() == CourseRecord.Status.COMPLETED;
    }

    public Float GetTotalCredits() {

        Float totalCredits = 0.0f;

        // Add all weights
        for(CourseRecord cr: this.courseRecords.values()) {
            totalCredits += cr.GetCourse().GetWeight();
        }

        return totalCredits;

    }

    public Float GetGPA() {

        // Check for potential divide by 0
        if(this.courseRecords.size() == 0) {
            return 0.0f;
        }

        Float totalGPA = 0.0f;

        for(CourseRecord cr: this.courseRecords.values()) {
            totalGPA += cr.GetGrade();
        }

        return totalGPA / this.courseRecords.size();
    }

}
