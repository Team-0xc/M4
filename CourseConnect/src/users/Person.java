package users;

import io.Interactive;
import utils.Credentials;

public abstract class Person implements Interactive {

    private Credentials credentials;

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

    /**
     * Retrieves the credentials object associated with this instance
     * @return the credentials object
     */
    public Credentials GetCredentials() {
        return this.credentials;
    }
    
    /**
     * Sets the credentials object associated with this instance
     * @param _credentials the new credentials object
     */
    public void SetCredentials(Credentials _credentials) {
        this.credentials = _credentials;
    }

}
