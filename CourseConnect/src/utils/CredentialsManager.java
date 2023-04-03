/**
 * This class is responsible for managing user credentials for the CourseConnect system.
 * It stores registered users in a HashMap and provides authentication and addition of users.
 * It implements the Interactive interface to allow interactive login for users.
 */
package utils;

import java.util.HashMap;
import java.util.Scanner;

import io.Interactive;
import main.CourseConnect;
import users.*;

public class CredentialsManager implements Interactive {

    private HashMap<String, Person> users;

    /**
     * Constructor for CredentialsManager class that initializes a new HashMap of users.
     */
    public CredentialsManager() {
        users = new HashMap<>();
    }

    /**
     * Authenticate a user given a set of credentials.
     * @param creds The credentials of the user.
     * @return The corresponding user object.
     * @throws Exception Throws an exception if the login attempt fails.
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
     * Add a user to the user map.
     * @param user A Person object representing the new user.
     */
    public void AddUser(Person user) {
        // Put new user into user map
        users.put(user.GetCredentials().GetHash(), user);
    }

    /**
     * Prompt the user for input and get their credentials.
     * 
     * @param scanner A Scanner object used to read user input.
     * @return A Credentials object containing the user's entered credentials.
     */
    private Credentials GetUserCredentials(Scanner scanner) {
        String username, password;
        System.out.print("Enter username: ");
        username = scanner.next();
        System.out.print("Enter password: ");
        password = scanner.next();
        return new Credentials(username, password);
    }

    /**
     * Implementation of the Loop method from the Interactive interface.
     * This method handles the interactive login process for a user.
     * @param cc A CourseConnect object representing the current instance of the program.
     */
    @Override
    public void Loop(CourseConnect cc) {
        Scanner scanner = cc.GetScanner();
        Person user = null;
        // Loop until a user is authenticated
        while(user == null) {
            try {
                // Get credentials from input and attempt to log in user
                Credentials c = GetUserCredentials(scanner);
                user = Authenticate(c);
            } catch(Exception e) {
                // Credentials don't exist in system
                System.out.println("Authentication Error: " + e.getMessage());
            }
        }
        cc.SetUser(user);
        System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
    }
}