package cs5500.project.db;

/**
 * Interface for Users in the system; namely, Student, Grader
 */
public interface User {

    /**
     * For a given username, password; returns the valid User object linked to those credentials
     *
     * @param username the username
     * @param pass password of user
     * @return User
     */
    public User login(String username, String pass);

    /**
     * For a user object, returns true if the User is created in the system, else; false.
     *
     * @param user User object
     * @return Boolean result of registering
     */
    public boolean register(User user);
}