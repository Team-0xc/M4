package users;

public abstract class Person {
    private String firstName;
    private String lastName;

    /**
     * Create a new object of type Person
     * 
     * @param _firstName The first name of the person
     * @param _lastName  The last name of the person
     */
    public Person(String _firstName, String _lastName) {
        this.firstName = _firstName;
        this.lastName = _lastName;
    }

    /**
     * Return the first name of the person
     * 
     * @return String the first name of the person
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Return the last name of the person
     * 
     * @return Stringe the last name of the person
     */
    public String getLastName() {
        return this.lastName;
    }
}
