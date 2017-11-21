package cs5500.project.spring;


import cs5500.project.db.Assignment;
import cs5500.project.db.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * UserRepository class which extends the MongoRepository and queries the User
 * table in the database
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, String>{

    /**
     * method to return all assignments
     * @return a list of assignments
     */
    List<User> findAll();

    /**
     * method to return user with the givenId
     * @param username user id to fetch
     * @return a User
     */
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}