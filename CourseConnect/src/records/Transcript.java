/**
 * This class represents a transcript of a student's academic record, which is a 
 * collection of CourseRecords. It keeps track of the student's courses, grades, 
 * and credits, and calculates the student's overall GPA.
 */

 package records;

 import java.util.Collection;
 import java.util.HashMap;
 
 import course.Course;
 
 public class Transcript {
     
     /**
      * The courseRecords HashMap stores the student's CourseRecord objects.
      */
     private HashMap<String, CourseRecord> courseRecords;
 
     /**
      * Constructs a Transcript object with an empty courseRecords HashMap.
      */
     public Transcript() {
         this.courseRecords = new HashMap<String, CourseRecord>(0);
     }
 
     /**
      * Constructs a Transcript object with a given collection of CourseRecord objects.
      * @param _courseRecords the collection of CourseRecord objects
      */
     public Transcript(Collection<CourseRecord> _courseRecords) {
         this();
         
         for(CourseRecord cr: _courseRecords) {
             this.courseRecords.put(cr.GetCourse().GetHash(), cr);
         }
     }
 
     /**
      * Adds a CourseRecord object to the courseRecords HashMap.
      * @param cr the CourseRecord object to be added
      */
     public void PutCourse(CourseRecord cr) {
         this.courseRecords.put(cr.GetCourse().GetHash(), cr);
     }
 
     /**
      * Removes a CourseRecord object from the courseRecords HashMap.
      * @param c the Course object to remove the CourseRecord for
      */
     public void RemoveCourse(Course c) {
         this.courseRecords.remove(c.GetHash());
     }
 
     /**
      * Returns true if the student has passed the given course, false otherwise.
      * @param c the Course object to check for pass status
      * @return true if passed, false otherwise
      */
     public boolean HasPassed(Course c) {
         return this.courseRecords.get(c.GetHash()).GetStatus() == CourseRecord.Status.COMPLETED;
     }
 
     /**
      * Returns a string representation of the Transcript object.
      * @return a string representation of the Transcript object
      */
     public String toString() {
         String str = "\n === TRANSCRIPT === \n";
         for (HashMap.Entry<String, CourseRecord> currRecord : this.courseRecords.entrySet()) {
             str += currRecord.getValue().toString();
         }
 
         return str;
     }
 
     /**
      * Returns the total number of credits the student has earned.
      * @return the total credits earned
      */
     public Float GetTotalCredits() {
 
         Float totalCredits = 0.0f;
 
         // Add all weights
         for(CourseRecord cr: this.courseRecords.values()) {
             totalCredits += cr.GetCourse().GetWeight();
         }
 
         return totalCredits;
 
     }
 
     /**
      * Calculates and returns the student's grade point average (GPA).
      * @return the GPA
      */
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
