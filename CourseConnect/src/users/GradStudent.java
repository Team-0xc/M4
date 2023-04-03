package users;

public class GradStudent extends Student {
    private Professor Advisor = null;

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
