package com.neo4j.example.springdataneo4jintroapp.repo.one;

import com.neo4j.example.springdataneo4jintroapp.model.one.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepositoryOne")
public interface UserRepository extends Neo4jRepository<UserNode, String> {
}
