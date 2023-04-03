/**
 * The Credentials class implements the Hashable interface to provide credential-based security management.
 */
package utils;

public class Credentials implements Hashable {
    
    /**
     * The username of this Credentials instance.
     */
    private String username;

    /**
     * The password of this Credentials instance.
     */
    private String password;

    /**
     * Constructs a Credentials instance with the default values of "default" for the username and "hunter2" for the password.
     */
    public Credentials() {
        username = "default";
        password = "hunter2";
    }

    /**
     * Constructs a Credentials instance with the given values for the username and password.
     *
     * @param _username the username to be assigned
     * @param _password the password to be assigned
     */
    public Credentials(String _username, String _password) {
        this();
        this.username = _username;
        this.password = _password;
    }

    /**
     * Returns the hash code represented as a string of the multiplication of the hash codes of the username and password fields.
     *
     * @return the hash code of the credentials
     */
    public String GetHash() {
        return Integer.toString(username.hashCode() * password.hashCode());
    }
}