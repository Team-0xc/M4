package utils;

public class Credentials implements Hashable {
    
    String username, password;

    public Credentials() {
        username = "default";
        password = "hunter2";
    }

    public String GetHash() {
        return Integer.toString(username.hashCode() * password.hashCode());
    }

}
