package users;

import main.CourseConnect;

public class GradStudent extends Student {
    private Professor Advisor = null;

    public GradStudent(int _ID, String _firstName, String _lastName, Professor _Advisor) {
        super(_ID, _firstName, _lastName);
        this.Advisor = _Advisor;
    }
    
    /**
     * Change the grad students current academic advisor
     * 
     * @param newAdvisor Professor: The new advisor name
     */
    public void setProfessor(Professor newAdvisor) {
        this.Advisor = newAdvisor;
    }

    /**
     * Returns the grad students current academic advisor
     * 
     * @return Professor: Current advisor
     */
    public Professor getProfessor() {
        return this.Advisor;
    }

    @Override
    public void Loop(CourseConnect cc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Loop'");
    }
    
}
