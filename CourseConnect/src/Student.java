public abstract class Student extends Person {
    private int ID;
    // TODO: inplement and add transcript and timetable

    /**
     * Create a new object of type Student
     * 
     * @param _ID        The student ID
     * @param _firstName The first name of the student
     * @param _lastName  THe last name of the student
     */
    public Student(int _ID, String _firstName, String _lastName) {
        super(_firstName, _lastName);
        this.ID = _ID;
    }

    /**
     * Will return the ID of a student
     * 
     * @return int student's ID
     */
    public int GetID() {
        return this.ID;
    }
}
