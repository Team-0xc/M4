package utils;

import java.util.HashMap;

import users.Person;

// Class for holding instance of Person while program is running
public class CredentialsManager {

    private HashMap<String, Person> users;

    public CredentialsManager() {
        users = new HashMap<>();
    }

    /**
     * Obtain an instance of a Person by supplying credentials
     * @param creds The credentials of the user logging in
     * @return The user with the corresponding credentials
     * @throws Exception Throws exception on invalid login attempt
     */
    public Person Authenticate(Credentials creds) throws Exception {

        // Check if the specified credentials exist in the system
        if(users.containsKey(creds.GetHash()) == false) {
            throw new Exception("username or password is incorrect");
        }

        // Return user with corresponding credentials hash
        return users.get(creds.GetHash());

    }

    /**
     * Add a user to the credential manager
     * @param user The user to be added
     */
    public void AddUser(Person user) {

        // TODO: Add check for overlapping hash

        // Put new user into user map
        users.put(user.GetCredentials().GetHash(), user);

    }
    
}
