package cs5500.project.web.repository;


import cs5500.project.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository class which extends the MongoRepository and queries the User
 * table in the database
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> { }