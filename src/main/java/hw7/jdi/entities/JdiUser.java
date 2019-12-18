package hw7.jdi.entities;

public class JdiUser {

    private final String login;
    private final String password;
    private final String fullName;

    public JdiUser(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

}
