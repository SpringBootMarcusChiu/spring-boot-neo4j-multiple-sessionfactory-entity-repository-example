package com.neo4j.example.springdataneo4jintroapp.repo.two;

import com.neo4j.example.springdataneo4jintroapp.model.two.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepositoryTwo")
public interface UserRepository extends Neo4jRepository<UserNode, String> {
}
