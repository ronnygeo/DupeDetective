package cs5500.project.web.controllers;

import cs5500.project.data.User;
import cs5500.project.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Start analyze controller
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return userRepository.findAll(sortByCreatedAtDesc);
    }

    @GetMapping("/users/login")
    public User getUserByUsername(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
            return userRepository.save(user);
    }

    @GetMapping(value="/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        User user = userRepository.findOne(id);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

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

    @DeleteMapping(value="/users/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userRepository.delete(id);
    }
}

