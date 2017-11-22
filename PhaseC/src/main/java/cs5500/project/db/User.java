package cs5500.project.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User object in the system; namely, Student, Grader
 */
@Document(collection = "user")
public class User {

    @Id
    private String Id;
    private String name;
    private String email;
    private String username;
    private String password;
    private boolean grader;

    /**
     * @param id id
     * @param name name
     * @param email email
     * @param username username
     * @param password password
     * @param grader is the user a grader
     */
    public User(String id, String name, String email, String username, String password, boolean grader) {
        this.Id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.grader = grader;
    }

    /**
     * @param name name
     * @param email email
     * @param username username
     * @param password password
     * @param grader is the user a grader
     */
    public User(String name, String email, String username, String password, boolean grader) {
        System.out.println("User created");
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.grader = grader;
    }

    /**
     * Default constructor
     */
    public User() {}

    /**
     * @return the id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param id the id
     */
    public void setId(String id) {
        this.Id = id;
    }

    /**
     * @return name of user
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return if the user is a grader
     */
    public boolean isGrader() {
        return grader;
    }

    /**
     * @param grader if the user is a grader
     */
    public void setGrader(boolean grader) {
        this.grader = grader;
    }

}