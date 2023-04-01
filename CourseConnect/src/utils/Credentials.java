package utils;

public class Credentials implements Hashable {
    
    private String username, password;

    public Credentials() {
        username = "default";
        password = "hunter2";
    }

    public Credentials(String _username, String _password) {
        this();
        this.username = _username;
        this.password = _password;
    }

    public String GetHash() {
        return Integer.toString(username.hashCode() * password.hashCode());
    }

}
