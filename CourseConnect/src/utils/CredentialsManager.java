package utils;

import java.util.HashMap;
import java.util.Scanner;

import io.Interactive;
import main.CourseConnect;
import users.Person;
import users.UndergradStudent;

// Class for holding instance of Person while program is running
public class CredentialsManager implements Interactive {

    private HashMap<String, Person> users;

    public CredentialsManager() {
        users = new HashMap<>();

        // Temp add until loading serialized file is implemented
        users.put(new Credentials().GetHash(), new UndergradStudent(0, "Joe", "Jones"));
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

    private Credentials GetUserCredentials(Scanner scanner) {

        String username, password;

        System.out.print("Enter username: ");
        username = scanner.next();
        System.out.print("Enter password: ");
        password = scanner.next();

        // scanner.close();

        return new Credentials(username, password);

    }

    @Override
    public void Loop(CourseConnect cc) {

        Scanner scanner = cc.GetScanner();
        
        Person user = null;

        while(user == null) {

            try {

                Credentials c = GetUserCredentials(scanner);
                user = Authenticate(c);
                
            } catch(Exception e) {
                System.out.println("Authentication Error: " + e.getMessage());
            }

        }

        cc.SetUser(user);

    }
    
}
