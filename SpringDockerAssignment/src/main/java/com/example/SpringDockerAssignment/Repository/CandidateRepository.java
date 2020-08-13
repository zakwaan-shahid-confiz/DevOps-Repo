package com.example.SpringDockerAssignment.Repository;

import com.example.SpringDockerAssignment.Model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<Candidate, Integer> {

}
