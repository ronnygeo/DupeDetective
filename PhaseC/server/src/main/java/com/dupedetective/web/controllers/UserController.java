package com.dupedetective.web.controllers;

import com.dupedetective.web.repository.UserRepository;
import com.dupedetective.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * User controller
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserRepository userRepository;

    /**
     * Get all users
     * @return list of users
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return userRepository.findAll(sortByCreatedAtDesc);
    }

    /**
     * Get user by username
     * @param username username
     * @param password password
     * @return User object
     */
    @GetMapping("/users/login")
    public User getUserByUsername(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

    /**
     * Create the given user
     * @param user a User
     * @return new User object
     */
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
            return userRepository.save(user);
    }

    /**
     * Get a user by Id
     * @param id user id
     * @return a User object
     */
    @GetMapping(value="/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        User user = userRepository.findOne(id);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    /**
     * Update the user
     * @param id user id
     * @param user a User object
     * @return a ReponseEntity with User
     */
    @PutMapping(value="/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id,
                                           @Valid @RequestBody User user) {
        User userData = userRepository.findOne(id);
        if(userData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userData.setName(user.getName());
        userData.setEmail(user.getEmail());
        userData.setUsername(user.getUsername());
        userData.setPassword(user.getPassword());
        userData.setGrader(user.isGrader());
        User updatedUser = userRepository.save(userData);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * Delete a user with given id
     * @param id user id
     */
    @DeleteMapping(value="/users/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userRepository.delete(id);
    }
}

