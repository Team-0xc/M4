package users;

public class GradStudent extends Student {
    private Professor Advisor = null;
    
    /**
    * Constructor for creating a GradStudent object with the given parameters.
    * @param _ID an integer representing the ID of the GradStudent
    * @param _firstName a string representing the first name of the GradStudent
    * @param _lastName a string representing the last name of the GradStudent
    * @param _Advisor a Professor object representing the advisor of the GradStudent
    * @param _studentCounselor a StudentCounselor object representing the student counselor of the GradStudent
    */
    public GradStudent(int _ID, String _firstName, String _lastName, Professor _Advisor, StudentCounselor _studentCounselor) {
        super(_ID, _firstName, _lastName, _studentCounselor);
        this.Advisor = _Advisor;
    }
    
    /**
     * Change the grad students current academic advisor
     * 
     * @param newAdvisor Professor: The new advisor name
     */
    public void SetProfessor(Professor newAdvisor) {
        this.Advisor = newAdvisor;
    }

    /**
     * Returns the grad students current academic advisor
     * 
     * @return Professor: Current advisor
     */
    public Professor GetProfessor() {
        return this.Advisor;
    }
    
}
