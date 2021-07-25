package com.neo4j.example.springdataneo4jintroapp;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataNeo4jIntroAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataNeo4jIntroAppApplication.class, args);
	}

	@Autowired
	@Qualifier("userRepositoryOne")
	private com.neo4j.example.springdataneo4jintroapp.repo.one.UserRepository userRepositoryOne;
	@Autowired
	@Qualifier("userRepositoryTwo")
	private com.neo4j.example.springdataneo4jintroapp.repo.two.UserRepository userRepositoryTwo;

	@Override
	public void run(String... args) throws Exception {
		userRepositoryOne.save(com.neo4j.example.springdataneo4jintroapp.model.one.UserNode.builder()
				.name("Marcus 1")
				.build());
		userRepositoryTwo.save(com.neo4j.example.springdataneo4jintroapp.model.two.UserNode.builder()
				.name("Marcus 2")
				.build());

		var usersA = Lists.newArrayList(userRepositoryOne.findAll());
		var usersB = Lists.newArrayList(userRepositoryTwo.findAll());

		System.exit(0);
	}
}
