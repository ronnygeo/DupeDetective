package cs5500.project.spring.repository;


import cs5500.project.db.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * UserRepository class which extends the MongoRepository and queries the User
 * table in the database
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * method to return user with the givenId
     * @param username user id to fetch
     * @return a User
     */
    @Query("{ 'username' : ?0, 'password' }")
    User findFirstByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password);
}