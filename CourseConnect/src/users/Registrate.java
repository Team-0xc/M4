package users;

import course.Section;

public interface Registrate {

    public void Register(Section s) throws Exception;
    public void ForceRegister(Section s);
    public void Drop(Section s);

}
