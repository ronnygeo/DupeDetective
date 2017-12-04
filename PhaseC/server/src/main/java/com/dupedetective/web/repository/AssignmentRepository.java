package com.dupedetective.web.repository;


import com.dupedetective.data.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * AssignmentRepository class which extends the MongoRepository and queries the Assignment
 * table in the database
 */
@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, String>{ }