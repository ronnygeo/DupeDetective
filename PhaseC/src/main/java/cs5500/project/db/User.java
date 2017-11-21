package cs5500.project.db;

import org.springframework.data.annotation.Id;

/**
 * User object in the system; namely, Student, Grader
 */
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

    public User() {}

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGrader() {
        return grader;
    }

    public void setGrader(boolean grader) {
        this.grader = grader;
    }

}