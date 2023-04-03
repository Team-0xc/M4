package users;

import course.Section;

public interface Registrate {
    
    /**
     * Register a Section object.
     * @param s the Section object to register
     * @throws Exception if there is an error during the registration process     
     */
    public void Register(Section s) throws Exception;

    /**
     * Forcefully register a Section object.
     * @param s the Section object to forcefully register
     */
    public void ForceRegister(Section s);
    
    /**
     * Drop a registered Section object.
     * @param s the Section object to drop
     */
    public void Drop(Section s);

}
