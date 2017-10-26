package cs5500.project.phaseb;

/**
 * Interface for Users in the system; namely, Student, Grader
 */
public interface User {

    /**
     * For a given username, password; returns the valid User object linked to those credentials
     *
     * @param username
     * @param pass
     * @return Student
     */
    public User login(String username, String pass);

    /**
     * For a user object, returns true if the User is created in the system, else; false.
     *
     * @param user
     * @return Boolean
     */
    public boolean register(User user);
}