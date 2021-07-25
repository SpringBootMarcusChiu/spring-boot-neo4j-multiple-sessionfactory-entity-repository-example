package com.neo4j.example.springdataneo4jintroapp.config;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@EnableNeo4jRepositories(
        transactionManagerRef = "transactionManagerTwo",
        sessionFactoryRef = "sessionFactoryTwo",
        basePackages = "com.neo4j.example.springdataneo4jintroapp.repo.two")
@EntityScan(basePackages = Neo4jTwoConfiguration.MODEL_PACKAGE)
@org.springframework.context.annotation.Configuration
public class Neo4jTwoConfiguration {

    protected static final String MODEL_PACKAGE = "com.neo4j.example.springdataneo4jintroapp.model.two";

    @Bean
    public Configuration configurationTwo() {
        return new Configuration.Builder()
                .uri("bolt://localhost")
                .credentials("neo4j", "password")
//            .autoIndex("assert")
//            .generatedIndexesOutputDir("dir")
//            .generatedIndexesOutputFilename("filename")
//            .connectionPoolSize(200)
//            .encryptionLevel("REQUIRED")
//            .trustStrategy("TRUST_SIGNED_CERTIFICATES")
//            .trustCertFile("/tmp/cert")
//            .connectionLivenessCheckTimeout(1000)
                .build();
    }

    @Bean
    public SessionFactory sessionFactoryTwo() {
        return new SessionFactory(configurationTwo(), MODEL_PACKAGE);
    }

    @Bean
    public Neo4jTransactionManager transactionManagerTwo() {
        return new Neo4jTransactionManager(sessionFactoryTwo());
    }
}
