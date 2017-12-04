package com.dupedetective.web.repository;


import com.dupedetective.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository class which extends the MongoRepository and queries the User
 * table in the database
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Find a user by username and password
     * @param username username
     * @param password password
     * @return the associated User
     */
    User findUserByUsernameAndPassword(String username, String password);
}