/**
 * The UndergradStudent class represents an undergraduate student who extends the Student class.
 */
package users;

public class UndergradStudent extends Student {
    
    /**
     * Constructs an UndergradStudent object with the specified ID, first name, last name, and student counselor.
     * 
     * @param _ID the ID of the undergraduate student.
     * @param _firstName the first name of the undergraduate student.
     * @param _lastName the last name of the undergraduate student.
     * @param _studentCounselor the student counselor object of the undergraduate student.
     */
    public UndergradStudent(int _ID, String _firstName, String _lastName, StudentCounselor _studentCounselor) {
        super(_ID, _firstName, _lastName, _studentCounselor);
    }
}